package problem

import chisel3._
import chisel3.util._
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}
import chisel3.experimental._
import chisel3.internal.firrtl.KnownBinaryPoint



class Neuron(inputs: Int, act: FixedPoint => FixedPoint) extends Module {
  val io = IO(new Bundle {
    val in      = Input(Vec(inputs, FixedPoint(16.W, 8.BP)))
    val weights = Input(Vec(inputs, FixedPoint(16.W, 8.BP)))
    val out     = Output(FixedPoint(16.W, 8.BP))
  })
val Step: FixedPoint => FixedPoint = x => Mux(x <= 0.F(8.BP), 0.F(8.BP), 1.F(8.BP))
//val ReLU: FixedPoint => FixedPoint = x => Mux(x <= 0.F(8.BP), 0.F(8.BP), x)
val mac = io.in.zip(io.weights).map{ case(a:FixedPoint, b:FixedPoint) => a*b}.reduce(_+_)
  io.out := act(mac)

}

 object Neuron  extends App{

  val Step: FixedPoint => FixedPoint = x => Mux(x <= 0.F(8.BP), 0.F(8.BP), 1.F(8.BP))
 //val ReLU: FixedPoint => FixedPoint = x => Mux(x <= 0.F(8.BP), 0.F(8.BP), x) 
   chisel3.Driver.execute(args , ()=> new Neuron(1,Step))
}

