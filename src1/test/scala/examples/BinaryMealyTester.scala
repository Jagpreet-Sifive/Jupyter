package examples

import java.io.File

import chisel3.iotesters
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}

class BinaryMealyTester(c: BinaryMealy) extends PeekPokeTester(c) {
  poke(c.io.in, false)
  expect(c.io.out, 0)
  step(1)
  poke(c.io.in, false)
  expect(c.io.out, 0)
  step(1)
  poke(c.io.in, false)
  expect(c.io.out, 0)
  step(1)
  poke(c.io.in, true)
  expect(c.io.out, 1)
  step(1)
  poke(c.io.in, true)
  expect(c.io.out, 0)
  step(1)
  poke(c.io.in, false)
  expect(c.io.out, 1)
  step(1)
  poke(c.io.in, true)
  expect(c.io.out, 1)
  step(1)
  poke(c.io.in, false)
  expect(c.io.out, 1)
  step(1)
  poke(c.io.in, true)
  expect(c.io.out, 1)
}


class BinaryMealyTests extends ChiselFlatSpec {
  behavior of "Module Tests "
  backends foreach {backend =>
    it should s"correctly respond to inputs in $backend" in {
      Driver(() => new BinaryMealy, backend)(c => new BinaryMealyTester(c)) should be (true)
    }
  }
}                                                                                                                                    

object BinaryMealyMain extends App{
   
iotesters.Driver.execute(args= Array("--backend-name","verilator")  , ()=> new BinaryMealy){
 c=> new BinaryMealyTester(c)
  }
}
