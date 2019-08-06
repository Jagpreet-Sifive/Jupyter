
  package problem
import java.io.File

import chisel3.iotesters
import chisel3._
import chisel3.util._
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}
import chisel3.experimental._
import chisel3.internal.firrtl.KnownBinaryPoint

 //  val Step: FixedPoint => FixedPoint = x => Mux(x <= 0.F(8.BP), 0.F(8.BP), 1.F(8.BP))
   //val ReLU: FixedPoint => FixedPoint = x => Mux(x <= 0.F(8.BP), 0.F(8.BP), x)



class NeuronTester(c: Neuron) extends PeekPokeTester(c) {

    val inputs = Seq(Seq(-1, -1), Seq(-1, 1), Seq(1, -1), Seq(1, 1))
    
//   val Step: FixedPoint => FixedPoint = x => Mux(x <= 0.F(8.BP), 0.F(8.BP), 1.F(8.BP))
  // val ReLU: FixedPoint => FixedPoint = x => Mux(x <= 0.F(8.BP), 0.F(8.BP), x)


    // make this a sequence of two values
  val weights  = Seq(1.0, 1.0)

    // push data through our Neuron and check the result (AND gate)
    reset(5)
    for (i <- inputs) {
      pokeFixedPoint(c.io.in(0), i(0))
      pokeFixedPoint(c.io.in(1), i(1))
      pokeFixedPoint(c.io.weights(0), weights(0))
      pokeFixedPoint(c.io.weights(1), weights(1))
      expectFixedPoint(c.io.out, if (i(0) + i(1) > 0) 1 else 0, "ERROR")
      step(1)
    }
  }


class NeuronTests extends ChiselFlatSpec {
     val Step: FixedPoint => FixedPoint = x => Mux(x <= 0.F(8.BP), 0.F(8.BP), 1.F(8.BP))
  // val ReLU: FixedPoint => FixedPoint = x => Mux(x <= 0.F(8.BP), 0.F(8.BP), x)


  behavior of "Module Tests "
  backends foreach {backend =>
    it should s"correctly respond to inputs in $backend" in {
      Driver(() => new Neuron(2, Step), backend)(c => new NeuronTester(c)) should be (true)
    }
  }
}                                                                                                                                    

object NeuronMain extends App{
     val Step: FixedPoint => FixedPoint = x => Mux(x <= 0.F(8.BP), 0.F(8.BP), 1.F(8.BP))
//   val ReLU: FixedPoint => FixedPoint = x => Mux(x <= 0.F(8.BP), 0.F(8.BP), x)
   
 iotesters.Driver.execute(args= Array("--backend-name","verilator")  , ()=>  new Neuron(2, Step)){
 c=> new NeuronTester(c)
  }
}
