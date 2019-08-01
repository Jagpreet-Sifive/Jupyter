<<<<<<< HEAD
// PopCount-: PopCount returns the number of high (1) bits in the input as a UInt.
package examples

import chisel3._
import chisel3.util._

import  chisel3.util.PopCount

class PopCountBit extends Module{
Driver(() => new Module {
    val io = IO(new Bundle {
      val in = Input(UInt(8.W))
      val out = Output(UInt(8.W))
    })
    io.out := PopCount(io.in)
    
}
=======
// PopCount-: PopCount returns the number of high (1) bits in the input as a UInt.
package examples

import chisel3._
import chisel3.util._

import  chisel3.util.PopCount

class PopCountBit extends Module{
Driver(() => new Module {
    val io = IO(new Bundle {
      val in = Input(UInt(8.W))
      val out = Output(UInt(8.W))
    })
    io.out := PopCount(io.in)
    
}
>>>>>>> 2470b12e854267816f114c9310741525f95e858b
