<<<<<<< HEAD
/*Hardware Collections
Example: Add run-time configurable taps to our FIR  */

package examples

import chisel3._
import chisel3.util._
import scala.collection._

class MyManyDynamicElementVecFir(length: Int) extends Module {
  val io = IO(new Bundle {
    val in = Input(UInt(8.W))
    val out = Output(UInt(8.W))
    val consts = Input(Vec(length, UInt(8.W)))
  })


  val regs = RegInit(VecInit(Seq.fill(length - 1)(0.U(8.W))))
  for(i <- 0 until length - 1) {
      if(i == 0) regs(i) := io.in
      else       regs(i) := regs(i - 1)
  }
  
  val muls = Wire(Vec(length, UInt(8.W)))
  for(i <- 0 until length) {
      if(i == 0) muls(i) := io.in * io.consts(i)
      else       muls(i) := regs(i - 1) * io.consts(i)
  }

  val scan = Wire(Vec(length, UInt(8.W)))
  for(i <- 0 until length) {
      if(i == 0) scan(i) := muls(i)
      else scan(i) := muls(i) + scan(i - 1)
  }

  io.out := scan(length - 1)
}

=======
/*Hardware Collections
Example: Add run-time configurable taps to our FIR  */

package examples

import chisel3._
import chisel3.util._
import scala.collection._

class MyManyDynamicElementVecFir(length: Int) extends Module {
  val io = IO(new Bundle {
    val in = Input(UInt(8.W))
    val out = Output(UInt(8.W))
    val consts = Input(Vec(length, UInt(8.W)))
  })


  val regs = RegInit(VecInit(Seq.fill(length - 1)(0.U(8.W))))
  for(i <- 0 until length - 1) {
      if(i == 0) regs(i) := io.in
      else       regs(i) := regs(i - 1)
  }
  
  val muls = Wire(Vec(length, UInt(8.W)))
  for(i <- 0 until length) {
      if(i == 0) muls(i) := io.in * io.consts(i)
      else       muls(i) := regs(i - 1) * io.consts(i)
  }

  val scan = Wire(Vec(length, UInt(8.W)))
  for(i <- 0 until length) {
      if(i == 0) scan(i) := muls(i)
      else scan(i) := muls(i) + scan(i - 1)
  }

  io.out := scan(length - 1)
}

>>>>>>> 2470b12e854267816f114c9310741525f95e858b
