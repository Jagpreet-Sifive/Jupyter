
  package problem
  import chisel3._
  import chisel3.util._

class RegisterFile(readPorts: Int) extends Module {
    require(readPorts >= 0)
    val io = IO(new Bundle {
        val wen   = Input(Bool())
        val waddr = Input(UInt(5.W))
        val wdata = Input(UInt(32.W))
        val raddr = Input(Vec(readPorts, UInt(5.W)))
        val rdata = Output(Vec(readPorts, UInt(32.W)))
    })
    
    val reg = RegInit(VecInit(Seq.fill(32)(0.U(32.W))))
    
    
       when (io.wen) {
        reg(io.waddr) := io.wdata
    }
    for (i <- 0 until readPorts) {
        when (io.raddr(i) === 0.U) {
            io.rdata(i) := 0.U
        } .otherwise {
            io.rdata(i) := reg(io.raddr(i))
        }
    }

}
object RegisterFile extends App{
    chisel3.Driver.execute(args , ()=> new RegisterFile (2) )
}

