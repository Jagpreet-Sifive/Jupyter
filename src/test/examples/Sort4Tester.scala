package examples


import java.io.File
import chisel3.util
import chisel3.iotesters
import org.scalatest.{Matchers , FlatSpec}
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}



class Sort4Tester(c: Sort4) extends PeekPokeTester(c) {
  poke(c.io.in0, 3)
  poke(c.io.in1, 6)
  poke(c.io.in2, 9)
  poke(c.io.in3, 12)
  expect(c.io.out0, 3)
  expect(c.io.out1, 6)
  expect(c.io.out2, 9)
  expect(c.io.out3, 12)

  poke(c.io.in0, 13)
  poke(c.io.in1, 4)
  poke(c.io.in2, 6)
  poke(c.io.in3, 1)
  expect(c.io.out0, 1)
  expect(c.io.out1, 4)
  expect(c.io.out2, 6)
  expect(c.io.out3, 13)
    
  poke(c.io.in0, 13)
  poke(c.io.in1, 6)
  poke(c.io.in2, 4)
  poke(c.io.in3, 1)
  expect(c.io.out0, 1)
  expect(c.io.out1, 4)
  expect(c.io.out2, 6)
  expect(c.io.out3, 13)
}



class Sort4Tests extends ChiselFlatSpec {
  behavior of "Module Tests "
  backends foreach {backend =>
    it should s"correctly respond to inputs in $backend" in {
      Driver(() => new Sort4, backend)(c => new Sort4Tester(c)) should be (true)
    }
  }
}                                                                                                                                    

object Sort4Main extends App{
   
iotesters.Driver.execute(args= Array("--backend-name","verilator")  , ()=> new Sort4){
 c=> new Sort4Tester(c)
  }
}




