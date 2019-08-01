<<<<<<< HEAD
package examples

import java.io.File

import chisel3.iotesters
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}



class CounterTester(c:Counter) extends PeekPokeTester(c){
	

	    poke(c.io.count, 1)
  
    step(1)
  
    step(1)
  
    poke(c.io.count, 0)
    step(1)
  
    poke(c.io.count, 1)
    step(1)
} 

class CounterTests extends ChiselFlatSpec {
  behavior of "Module Tests "
  backends foreach {backend =>
    it should s"correctly respond to inputs in $backend" in {
      Driver(() => new Counter, backend)(c => new CounterTester(c)) should be (true)
    }
  }
}                                                                                                                                    

object CounterMain extends App{
   
iotesters.Driver.execute(args= Array("--backend-name","verilator")  , ()=> new Counter){
 c=> new CounterTester(c)
  }
}
=======
package examples

import java.io.File

import chisel3.iotesters
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}



class CounterTester(c:Counter) extends PeekPokeTester(c){
	

	    poke(c.io.count, 1)
  
    step(1)
  
    step(1)
  
    poke(c.io.count, 0)
    step(1)
  
    poke(c.io.count, 1)
    step(1)
} 

class CounterTests extends ChiselFlatSpec {
  behavior of "Module Tests "
  backends foreach {backend =>
    it should s"correctly respond to inputs in $backend" in {
      Driver(() => new Counter, backend)(c => new CounterTester(c)) should be (true)
    }
  }
}                                                                                                                                    

object CounterMain extends App{
   
iotesters.Driver.execute(args= Array("--backend-name","verilator")  , ()=> new Counter){
 c=> new CounterTester(c)
  }
}
>>>>>>> 2470b12e854267816f114c9310741525f95e858b
