<<<<<<< HEAD
/** Example: Incompatible Operation ( we are adding two diff. type of literals 1+1.U */
package examples
import chisel3._
import chisel.util



class MyModuleTwo extends Module {
  val io = IO(new Bundle {
    val in  = Input(UInt(4.W))
    val out = Output(UInt(4.W))
  })

  val twotwo = 1.U + 1
  println(twotwo)
  
  io.out := io.in
}
println(getVerilog(new MyModule))

=======
/** Example: Incompatible Operation ( we are adding two diff. type of literals 1+1.U */
package examples
import chisel3._
import chisel.util



class MyModuleTwo extends Module {
  val io = IO(new Bundle {
    val in  = Input(UInt(4.W))
    val out = Output(UInt(4.W))
  })

  val twotwo = 1.U + 1
  println(twotwo)
  
  io.out := io.in
}
println(getVerilog(new MyModule))

>>>>>>> 2470b12e854267816f114c9310741525f95e858b
