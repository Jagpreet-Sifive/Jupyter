//Example: Parameterized FIR Generator

package examples


import chisel3._
import chisel3.util._

class MyManyElementFir(consts: Seq[Int], bitWidth: Int) extends Module {
  val io = IO(new Bundle {
    val in = Input(UInt(bitWidth.W))
    val out = Output(UInt(bitWidth.W))
  })

  val regs = mutable.ArrayBuffer[UInt]()
  for(i <- 0 until consts.length) {
      if(i == 0) regs += io.in
      else       regs += RegNext(regs(i - 1), 0.U)
  }
  
  val muls = mutable.ArrayBuffer[UInt]()
  for(i <- 0 until consts.length) {
      muls += regs(i) * consts(i).U
  }

  val scan = mutable.ArrayBuffer[UInt]()
  for(i <- 0 until consts.length) {
      if(i == 0) scan += muls(i)
      else scan += muls(i) + scan(i - 1)
  }

  io.out := scan.last
}
object MyManyElementFir  extends App{
     chisel3.Driver.execute(args, ()=> new MyManyElementFir )
}
