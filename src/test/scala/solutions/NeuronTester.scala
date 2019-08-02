package solutions

import java.io.File
import chisel3.util
import chisel3.iotesters
import org.scalatest.{Matchers , FlatSpec}
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}


import scala.collection._

class NeuronTester(c: Neuron) extends PeekPokeTester(c)
{

  val inputs = Seq(Seq(-1, -1), Seq(-1, 1), Seq(1, -1), Seq(1, 1))
    
    
   val weights  = Seq(1.0, 1.0)

   
   
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



class NeuronTests extends FlatSpec with Matchers {
  behavior of "Module Tests"
    it should s"correctly respond to inputs"  in {
	 val  args =Array ("--backend-name"  , "verilator")
     iotesters.Driver.execute(args, () => new Neuron) {c => new NeuronTester(c)
     }  should be (true)
     
    }
  }      
 
   
       