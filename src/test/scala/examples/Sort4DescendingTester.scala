package examples
import chisel3._
import chisel3.util.
import chisel3.iotesters
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}


class Sort4DescendingTester(c: Sort4) extends PeekPokeTester(c) {
  poke(c.io.in0, 3)
  poke(c.io.in1, 6)
  poke(c.io.in2, 9)
  poke(c.io.in3, 12)
  expect(c.io.out0, 12)
  expect(c.io.out1, 9)
  expect(c.io.out2, 6)
  expect(c.io.out3, 3)

  poke(c.io.in0, 13)
  poke(c.io.in1, 4)
  poke(c.io.in2, 6)
  poke(c.io.in3, 1)
  expect(c.io.out0, 13)
  expect(c.io.out1, 6)
  expect(c.io.out2, 4)
  expect(c.io.out3, 1)
    
  poke(c.io.in0, 1)
  poke(c.io.in1, 6)
  poke(c.io.in2, 4)
  poke(c.io.in3, 13)
  expect(c.io.out0, 13)
  expect(c.io.out1, 6)
  expect(c.io.out2, 4)
  expect(c.io.out3, 1)

}

class Sort4DescendingTests extends ChiselFlatSpec {
  behavior of "Module Tests "
  backends foreach {backend =>
    it should s"correctly respond to inputs in $backend" in {
      Driver(() => new Sort4Descending, backend)(c => new Sort4DescendingTester(c)) should be (true)
    }
  }
}                                                                                                                                    

object Sort4DescendingMain extends App{
   
iotesters.Driver.execute(args= Array("--backend-name","verilator")  , ()=> new Sort4Descending){
 c=> new Sort4DescendingTester(c)
  }
}
