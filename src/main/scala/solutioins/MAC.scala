//solution for Mac as Object:

 package solutions
 import chisel3._
 import chisel3.util 

object Mac {
    def apply [T <: Data : Ring](a: T, b: T, c: T): T = {
    }
}

class MacTestModule extends Module {
    val io = IO(new Bundle {
        val uin = Input(UInt(4.W))
        val uout = Output(UInt())
        val sin = Input(SInt(4.W))
        val sout = Output(SInt())
        val fin = Input(FixedPoint(16.W, 12.BP))
        val fout = Output(FixedPoint())
    })
    // for each IO pair, do out = in * in + in
    io.uout := Mac(io.uin, io.uin, io.uin)
    io.sout := Mac(io.sin, io.sin, io.sin)
    io.fout := Mac(io.fin, io.fin, io.fin)
}
