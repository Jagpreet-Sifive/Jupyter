<<<<<<< HEAD
//Example: A Module -Declare a new module definition.
package examples 
import chisel3._



class Passthrough extends Module {
  val io = IO(new Bundle {
    val in = Input(UInt(4.W))
    val out = Output(UInt(4.W))
  })
  io.out := io.in



}
=======
//Example: A Module -Declare a new module definition.
package examples 
import chisel3._



class Passthrough extends Module {
  val io = IO(new Bundle {
    val in = Input(UInt(4.W))
    val out = Output(UInt(4.W))
  })
  io.out := io.in



}
>>>>>>> 2470b12e854267816f114c9310741525f95e858b
