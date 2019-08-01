<<<<<<< HEAD
// Example : - My FIRRTL compiler . 
package examples

import chisel3._


import chisel3.util

class MyFir(length: Int, bitwidth: Int, window: (Int, Int) => Seq[Int]) extends Module {
  val io = IO(new Bundle {
    val in = Input(UInt(bitwidth.W))
    val out = Output(UInt((bitwidth*2+length-1).W)) 
  })

 
  val coeffs = window(length, bitwidth).map(_.U)
  
  val delays = Seq.fill(length)(Wire(UInt(bitwidth.W))).scan(io.in)( (prev: UInt, next: UInt) => {
    next := RegNext(prev)
    next
  })
  
 
  val mults = delays.zip(coeffs).map{ case(delay: UInt, coeff: UInt) => delay * coeff }
  
 
  val result = mults.reduce(_+&_) 
 
  io.out := result
}
=======
// Example : - My FIRRTL compiler . 
package examples

import chisel3._


import chisel3.util

class MyFir(length: Int, bitwidth: Int, window: (Int, Int) => Seq[Int]) extends Module {
  val io = IO(new Bundle {
    val in = Input(UInt(bitwidth.W))
    val out = Output(UInt((bitwidth*2+length-1).W)) 
  })

 
  val coeffs = window(length, bitwidth).map(_.U)
  
  val delays = Seq.fill(length)(Wire(UInt(bitwidth.W))).scan(io.in)( (prev: UInt, next: UInt) => {
    next := RegNext(prev)
    next
  })
  
 
  val mults = delays.zip(coeffs).map{ case(delay: UInt, coeff: UInt) => delay * coeff }
  
 
  val result = mults.reduce(_+&_) 
 
  io.out := result
}
>>>>>>> 2470b12e854267816f114c9310741525f95e858b
