package examples

import java.io.File

import chisel3.iotesters
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}


class HalfAdderTester(c: HalfFullAdder) extends PeekPokeTester(c) {
  require(!c.hasCarry, "DUT must be half adder")
 
  poke(c.io.a, 0)
  poke(c.io.b, 0)
  expect(c.io.s, 0)
  expect(c.io.carryOut, 0)
   poke(c.io.b, 1)
  expect(c.io.s, 1)
  expect(c.io.carryOut, 0)
 
  poke(c.io.a, 1)
  expect(c.io.s, 0)
  expect(c.io.carryOut, 1)
 
  poke(c.io.b, 0)
  expect(c.io.s, 1)
  expect(c.io.carryOut, 0)
}
class HalfAdderTests extends ChiselFlatSpec {
  behavior of "Module Tests "
  backends foreach {backend =>
    it should s"correctly respond to inputs in $backend" in {
      Driver(() => new HalfAdder, backend)(c => new HalfAdderTester(c)) should be (true)
    }
  }
}                                                                                                                                    

object HalfAdderMain extends App{
   
iotesters.Driver.execute(args= Array("--backend-name","verilator")  , ()=> new HalfAdder){
 c=> new HalfAdderTester(c)
  }
}

  