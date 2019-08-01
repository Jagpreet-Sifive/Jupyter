<<<<<<< HEAD
/*Example: More Chisel Operators(addition , subtraction ,multiplication  */
package examples
import chisel3._
import chisel3.util


 class MyOperators extends Module {
  val io = IO(new Bundle {
    val in      = Input(UInt(4.W))
    val out_add = Output(UInt(4.W))
    val out_sub = Output(UInt(4.W))
    val out_mul = Output(UInt(4.W))
  })

  io.out_add := 1.U + 4.U
  io.out_sub := 2.U - 1.U
  io.out_mul := 4.U * 2.U
}

object MyOperators extends App{
	chisel3.Driver.execute(args , () => new MyOperators )
}
=======
/*Example: More Chisel Operators(addition , subtraction ,multiplication  */
package examples
import chisel3._
import chisel3.util


 class MyOperators extends Module {
  val io = IO(new Bundle {
    val in      = Input(UInt(4.W))
    val out_add = Output(UInt(4.W))
    val out_sub = Output(UInt(4.W))
    val out_mul = Output(UInt(4.W))
  })

  io.out_add := 1.U + 4.U
  io.out_sub := 2.U - 1.U
  io.out_mul := 4.U * 2.U
}

object MyOperators extends App{
	chisel3.Driver.execute(args , () => new MyOperators )
}
>>>>>>> 2470b12e854267816f114c9310741525f95e858b
