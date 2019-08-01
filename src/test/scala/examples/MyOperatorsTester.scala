package examples


import java.io.File

import chisel3.iotesters
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}

class MyOperatorsTester(c:MyOperators) extends PeekPokeTester{
	
   expect(c.io.out_add, 5)
  expect(c.io.out_sub, 1)
  expect(c.io.out_mul, 8)
}

class MyOperatorsTests extends ChiselFlatSpec {
  behavior of "Module Tests "
  backends foreach {backend =>
    it should s"correctly respond to inputs in $backend" in {
      Driver(() => new MyOperators, backend)(c => new MyOperatorsTester(c)) should be (true)
    }
  }
}                                                                                                                                    

object MyOperatorsMain extends App{
   
iotesters.Driver.execute(args= Array("--backend-name","verilator")  , ()=> new MyOperators){
 c=> new MyOperatorsTester(c)
  }
}
