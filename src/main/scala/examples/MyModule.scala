// Example: Scala and Chisel Operators Look the Same
package examples
import chisel3._
import chisel3.util



class MyModule extends Module {
  val io = IO(new Bundle {
    val in  = Input(UInt(4.W))
    val out = Output(UInt(4.W))
  })

  val two  = 1 + 1
  println(two)
  val utwo = 1.U + 1.U
  println(utwo)
  
  io.out := io.in

println(getVerilog(new MyModule))

}
 object MyModule extends App{
 	chisel3.Driver.execute(args , ()=> new MyModule)
 	
 }
