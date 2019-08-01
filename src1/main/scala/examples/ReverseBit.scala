<<<<<<< HEAD
//Reverse: Reverse returns the bit-reversed input.*/

package examples


import chisel3._
import chisel3.util._
import  chisel3.util.Reverse

 class ReverseBit extends Module{
   
    val io = IO(new Bundle {
      val in = Input(UInt(8.W))
      val out = Output(UInt(8.W))
    })
    io.out := Reverse(io.in)
  }
  
  
=======
//Reverse: Reverse returns the bit-reversed input.*/

package examples


import chisel3._
import chisel3.util._
import  chisel3.util.Reverse

 class ReverseBit extends Module{
   
    val io = IO(new Bundle {
      val in = Input(UInt(8.W))
      val out = Output(UInt(8.W))
    })
    io.out := Reverse(io.in)
  }
  
  
>>>>>>> 2470b12e854267816f114c9310741525f95e858b
