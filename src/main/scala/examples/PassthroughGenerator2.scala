package examples

import chisel3._
import chisel3.util
import chisel3.experimental._
import chisel3.experimental.BundleLiterals._
import chisel3.tester._
import chisel3.tester.RawTester.test

class PassthroughGenerator(width: Int) extends Module { 
  val io = IO(new Bundle {
    val in = Input(UInt(width.W))
    val out = Output(UInt(width.W))
  })
  io.out := io.in
}
object  PassthroughGenerator2 extends App{
	  chisel3.Driver.execute(args, ()=> new PassthroughGenerator2)
}

