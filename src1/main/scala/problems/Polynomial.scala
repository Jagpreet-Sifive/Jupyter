<<<<<<< HEAD
/* Exercise: Polynomial Circuit */
package Example
import chisel3._
import chisel3.util

class Polynomial extends Module {
  val io = IO(new Bundle {
    val select = Input(UInt(2.W))
    val x = Input(SInt(32.W))
    val fOfX = Output(SInt(32.W))
  })
    
  val result = Wire(SInt(32.W))  
  val square = Wire(SInt(32.W))  
  
  ???

  io.fOfX := result  
}
object  Polynomial extends App{
   chisel3.Driver.execute(args, ()= new   Polynomial)
}
=======
/* Exercise: Polynomial Circuit */
package Example
import chisel3._
import chisel3.util

class Polynomial extends Module {
  val io = IO(new Bundle {
    val select = Input(UInt(2.W))
    val x = Input(SInt(32.W))
    val fOfX = Output(SInt(32.W))
  })
    
  val result = Wire(SInt(32.W))  
  val square = Wire(SInt(32.W))  
  
  ???

  io.fOfX := result  
}
object  Polynomial extends App{
   chisel3.Driver.execute(args, ()= new   Polynomial)
}
>>>>>>> 2470b12e854267816f114c9310741525f95e858b
