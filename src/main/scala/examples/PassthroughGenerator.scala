//Example: A Module Generator
package examples

import chisel3._
import chisel3.util._



class PassthroughGenerator(width: Int) extends Module { 
  val io = IO(new Bundle {
    val in = Input(UInt(width.W))
    val out = Output(UInt(width.W))
  })
  io.out := io.in
}
 object PassthroughGenerator  extends App{
     chisel3.Driver.execute(args, ()=> new PassthroughGenerator )
}



