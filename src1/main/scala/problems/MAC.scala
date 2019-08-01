<<<<<<< HEAD
 /* Exercise: MAC -Create a Chisel module that implements the multiply accumulate function, 
    (A*B)+C, and passes the testbench. */
package Example
import chisel3._
import chisel3.util


class MAC extends Module {
  val io = IO(new Bundle {
    val in_a = Input(UInt(4.W))
    val in_b = Input(UInt(4.W))
    val in_c = Input(UInt(4.W))
    val out  = Output(UInt(8.W))
  })

   io.out := (io.in_a * io.in_b)+ io.in_c
}


object MAC extends App{
	 chisel3.Driver.execute(args, () => new MAC)
	 
}
=======
 /* Exercise: MAC -Create a Chisel module that implements the multiply accumulate function, 
    (A*B)+C, and passes the testbench. */
package Example
import chisel3._
import chisel3.util


class MAC extends Module {
  val io = IO(new Bundle {
    val in_a = Input(UInt(4.W))
    val in_b = Input(UInt(4.W))
    val in_c = Input(UInt(4.W))
    val out  = Output(UInt(8.W))
  })

   io.out := (io.in_a * io.in_b)+ io.in_c
}


object MAC extends App{
	 chisel3.Driver.execute(args, () => new MAC)
	 
}
>>>>>>> 2470b12e854267816f114c9310741525f95e858b
