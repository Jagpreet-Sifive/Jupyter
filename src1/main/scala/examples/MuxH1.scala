<<<<<<< HEAD
// Example circuit using Mux1H.

package examples

import chisel3._
import chisel3.util._


class MuxH1 extends Module{
	  val io = IO(new Bundle {
      val in_sels = Input(Vec(2, Bool()))
      val in_bits = Input(Vec(2, UInt(8.W)))
      val out = Output(UInt(8.W))
    })
    io.out := Mux1H(io.in_sels, io.in_bits)
}
=======
// Example circuit using Mux1H.

package examples

import chisel3._
import chisel3.util._


class MuxH1 extends Module{
	  val io = IO(new Bundle {
      val in_sels = Input(Vec(2, Bool()))
      val in_bits = Input(Vec(2, UInt(8.W)))
      val out = Output(UInt(8.W))
    })
    io.out := Mux1H(io.in_sels, io.in_bits)
}
>>>>>>> 2470b12e854267816f114c9310741525f95e858b
