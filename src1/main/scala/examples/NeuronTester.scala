<<<<<<< HEAD
package examples

import chisel3._
import chisel3.util._
import chisel3.experimental._
import chisel3.internal.firrtl.KnownBinaryPoint

class NeuronTester(c:Neuron) extends PeekPokeTester{

    val inputs = Seq(Seq(-1, -1), Seq(-1, 1), Seq(1, -1), Seq(1, 1))
    
   val weights = ???

   
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




=======
package examples

import chisel3._
import chisel3.util._
import chisel3.experimental._
import chisel3.internal.firrtl.KnownBinaryPoint

class NeuronTester(c:Neuron) extends PeekPokeTester{

    val inputs = Seq(Seq(-1, -1), Seq(-1, 1), Seq(1, -1), Seq(1, 1))
    
   val weights = ???

   
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




>>>>>>> 2470b12e854267816f114c9310741525f95e858b
