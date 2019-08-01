// PopCount-: PopCount returns the number of high (1) bits in the input as a UInt.
package examples

import chisel3._
import chisel3.util._

import  chisel3.util.PopCount

class PopCountBit extends Module{

    val io = IO(new Bundle {
      val in = Input(UInt(8.W))
      val out = Output(UInt(8.W))
    })
    io.out := PopCount(io.in)
    
}
object  PopCountBit extends App{
     chisel3.Driver.execute(args, ()=> new PopCountBit )
}

