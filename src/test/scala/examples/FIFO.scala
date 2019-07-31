/* Queue with Decoupled Interface */
 // Example circuit using a Queue
package examples
import chisel3._
import chisel3.util._

   

class FIFO extends Module{
    val io = IO(new Bundle {
      val in = Flipped(Decoupled(UInt(8.W)))
      val out = Decoupled(UInt(8.W))
    }) 
    val queue = Queue(io.in, 2) 
    io.out <> queue

  }

object FIFO extends App{
	 chisel3.Driver.execute(args, ()=> new FIFO)

}