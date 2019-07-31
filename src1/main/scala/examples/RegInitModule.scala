//Example: Initialized Register
package examples
import chisel3._
import chisel3.util

class RegInitModule extends Module {
  val io = IO(new Bundle {
    val in  = Input(UInt(12.W))
    val out = Output(UInt(12.W))
  })
  
  val register = RegInit(0.U(12.W))
  register := io.in + 1.U
  io.out := register
}

