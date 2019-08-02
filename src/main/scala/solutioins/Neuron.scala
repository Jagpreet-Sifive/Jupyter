//solution for Neural Network Neuron: 
 package solutions
 import chisel3._
 import chisel3.util 
 

  class Neuron(inputs: Int, act: FixedPoint => FixedPoint) extends Module {
  val io = IO(new Bundle {
    val in      = Input(Vec(inputs, FixedPoint(16.W, 8.BP)))
    val weights = Input(Vec(inputs, FixedPoint(16.W, 8.BP)))
    val out     = Output(FixedPoint(16.W, 8.BP))
  })
  
 val mac = io.in.zip(io.weights).map{ case(a:FixedPoint, b:FixedPoint) => a*b}.reduce(_+_)
  io.out := act(mac)

}


solution for Tester :



Driver(() => new Neuron(2, Step)) {
  c => new PeekPokeTester(c) {
    
  