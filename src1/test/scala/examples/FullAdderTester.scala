package examples

import java.io.File

import chisel3.iotesters
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}


class FullAdderTester(c: HalfFullAdder) extends PeekPokeTester(c) {
  require(c.hasCarry, "DUT must be half adder")
  poke(c.io.carryIn.get, 0)

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

  poke(c.io.carryIn.get, 1)

  poke(c.io.a, 0)
  poke(c.io.b, 0)
  expect(c.io.s, 1)
  expect(c.io.carryOut, 0)

  poke(c.io.b, 1)
  expect(c.io.s, 0)
  expect(c.io.carryOut, 1)

  poke(c.io.a, 1)
  expect(c.io.s, 1)
  expect(c.io.carryOut, 1)

  poke(c.io.b, 0)
  expect(c.io.s, 0)
  expect(c.io.carryOut, 1)
}

class FullAdderTests extends ChiselFlatSpec {
  behavior of "Module Tests "
  backends foreach {backend =>
    it should s"correctly respond to inputs in $backend" in {
      Driver(() => new FullAdder, backend)(c => new FullAdderTester(c)) should be (true)
    }
  }
}                                                                                                                                    

object FullAdderMain extends App{
   
iotesters.Driver.execute(args= Array("--backend-name","verilator")  , ()=> new FullAdder){
 c=> new FullAdderTester(c)
  }
}

  