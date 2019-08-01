<<<<<<< HEAD
/** Exercise: Decoupled Arbiter*/
/** Task: The arbiter selects the lowest channel that is valid and forwards it to the output.*/
package Example
import chisel3._
import chisel3.util._


class MyRoutingArbiter(numChannels: Int) extends Module {
  val io = IO(new Bundle {
    val in = Vec(numChannels, Flipped(Decoupled(UInt(8.W))))
    val out = Decoupled(UInt(8.W))
  } )

 
  ???
}

=======
/** Exercise: Decoupled Arbiter*/
/** Task: The arbiter selects the lowest channel that is valid and forwards it to the output.*/
package Example
import chisel3._
import chisel3.util._


class MyRoutingArbiter(numChannels: Int) extends Module {
  val io = IO(new Bundle {
    val in = Vec(numChannels, Flipped(Decoupled(UInt(8.W))))
    val out = Decoupled(UInt(8.W))
  } )

 
  ???
}

>>>>>>> 2470b12e854267816f114c9310741525f95e858b
