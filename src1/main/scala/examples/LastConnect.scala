<<<<<<< HEAD
/**  Example: Reassignment*/
package examples
import chisel3._
import chisel3.util

class LastConnect extends Module {
  val io = IO(new Bundle {
    val in = Input(UInt(4.W))
    val out = Output(UInt(4.W))
  })
  io.out := 1.U
  io.out := 2.U
  io.out := 3.U
  io.out := 4.U
}
=======
/**  Example: Reassignment*/
package examples
import chisel3._
import chisel3.util

class LastConnect extends Module {
  val io = IO(new Bundle {
    val in = Input(UInt(4.W))
    val out = Output(UInt(4.W))
  })
  io.out := 1.U
  io.out := 2.U
  io.out := 3.U
  io.out := 4.U
}
>>>>>>> 2470b12e854267816f114c9310741525f95e858b
