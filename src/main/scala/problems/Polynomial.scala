/* Exercise: Polynomial Circuit */
package problems  
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
