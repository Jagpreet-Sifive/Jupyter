package examples

import dspblocks._
import freechips.rocketchip.amba.axi4._
import freechips.rocketchip.amba.axi4stream._
import freechips.rocketchip.config._
import freechips.rocketchip.diplomacy._
import freechips.rocketchip.regmapper._


abstract class FIRBlock[D, U, EO, EI, B <: Data](val nFilters: Int, val nTaps: Int)(implicit p: Parameters){
extends DspBlock[D, U, EO, EI, B] with HasCSR {
    
    val streamNode = AXI4StreamIdentityNode()
    
    lazy val module = new LazyModuleImp(this) {
            val (in, _)  = streamNode.in(0)
        val (out, _) = streamNode.out(0)

        require(in.params.n >= nFilters,
                s"""AXI-4 Stream port must be big enough for all 
                   |the filters (need $nFilters,, only have ${in.params.n})""".stripMargin)

              val taps = Reg(Vec(nFilters, Vec(nTaps, UInt(8.W))))

        val mmap = Seq(
            RegField.r(64, nFilters.U, RegFieldDesc("nFilters", "Number of filter lanes"))
        ) ++ taps.flatMap(_.map(t => RegField(8, t, RegFieldDesc("tap", "Tap"))))

       
        regmap(mmap.zipWithIndex.map({case (r, i) => i * 8 -> Seq(r)}): _*)

       
        val outs = for (i <- 0 until nFilters) yield {
            val fir = Module(new MyManyDynamicElementVecFir(nTaps))
            
            fir.io.in := in.bits.data((i+1)*8, i*8)
            fir.io.valid := in.valid && out.ready
            fir.io.consts := taps(i)            
            fir.io.out
        }

        val output = if (outs.length == 1) {
            outs.head
        } else {
            outs.reduce((x: UInt, y: UInt) => Cat(y, x))
        }

        out.bits.data := output
        in.ready  := out.ready
        out.valid := in.valid
    }
}


abstract class AXI4FIRBlock(nFilters: Int, nTaps: Int)(implicit p: Parameters) extends FIRBlock[AXI4MasterPortParameters, AXI4SlavePortParameters, AXI4EdgeParameters, AXI4EdgeParameters, AXI4Bundle](nFilters, nTaps) with AXI4DspBlock with AXI4HasCSR {
    override val mem = Some(AXI4RegisterNode(
        AddressSet(0x0, 0xffffL), beatBytes = 8
    ))
}



object FIRBlock extends App{
     chisel3.Driver.execute(args, ()=> new FIRBlock)
}

