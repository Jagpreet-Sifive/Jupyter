<<<<<<< HEAD
package examples

import java.io.File

import chisel3.iotesters
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}


class Max3Tester(c: Max3) extends PeekPokeTester(c) {
  poke(c.io.in1, 6)
  poke(c.io.in2, 4)  
  poke(c.io.in3, 2)  
  expect(c.io.out, 6)  
  poke(c.io.in2, 7)  
  expect(c.io.out, 7)  
  poke(c.io.in3, 11)  
  expect(c.io.out, 11) 
  poke(c.io.in3, 3)  
  expect(c.io.out, 7)  
}


class Max3Tests extends ChiselFlatSpec {
  behavior of "Module Tests "
  backends foreach {backend =>
    it should s"correctly respond to inputs in $backend" in {
      Driver(() => new Max3, backend)(c => new Max3Tester(c)) should be (true)
    }
  }
}                                                                                                                                    

object Max3Main extends App{
   
iotesters.Driver.execute(args= Array("--backend-name","verilator")  , ()=> new Max3){
 c=> new Max3Tester(c)
  }
}

                                                                                                      
=======
package examples

import java.io.File

import chisel3.iotesters
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}


class Max3Tester(c: Max3) extends PeekPokeTester(c) {
  poke(c.io.in1, 6)
  poke(c.io.in2, 4)  
  poke(c.io.in3, 2)  
  expect(c.io.out, 6)  
  poke(c.io.in2, 7)  
  expect(c.io.out, 7)  
  poke(c.io.in3, 11)  
  expect(c.io.out, 11) 
  poke(c.io.in3, 3)  
  expect(c.io.out, 7)  
}


class Max3Tests extends ChiselFlatSpec {
  behavior of "Module Tests "
  backends foreach {backend =>
    it should s"correctly respond to inputs in $backend" in {
      Driver(() => new Max3, backend)(c => new Max3Tester(c)) should be (true)
    }
  }
}                                                                                                                                    

object Max3Main extends App{
   
iotesters.Driver.execute(args= Array("--backend-name","verilator")  , ()=> new Max3){
 c=> new Max3Tester(c)
  }
}

                                                                                                      
>>>>>>> 2470b12e854267816f114c9310741525f95e858b
