<<<<<<< HEAD
//Example: RegNext
package examples
import chisel3._
import chisel3`.util
class RegNextModule extends Module {
  val io = IO(new Bundle {
    val in  = Input(UInt(12.W))
    val out = Output(UInt(12.W))
  })
  
  
  
  io.out := RegNext(io.in + 1.U)
}
=======
//Example: RegNext
package examples
import chisel3._
import chisel3`.util
class RegNextModule extends Module {
  val io = IO(new Bundle {
    val in  = Input(UInt(12.W))
    val out = Output(UInt(12.W))
  })
  
  
  
  io.out := RegNext(io.in + 1.U)
}
>>>>>>> 2470b12e854267816f114c9310741525f95e858b
