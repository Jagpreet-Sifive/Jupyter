// Example circuit using PriorityMux

package examples

import chisel3.util._
import chisel3._

class PriorMux extends Module{

    
    val io = IO(new Bundle {
      val in_sels = Input(Vec(2, Bool()))
      val in_bits = Input(Vec(2, UInt(8.W)))
      val out = Output(UInt(8.W))
    })
    io.out := PriorityMux(io.in_sels, io.in_bits)
  }


