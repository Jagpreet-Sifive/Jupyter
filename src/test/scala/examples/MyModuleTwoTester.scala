package examples

import java.io.File

import chisel3.iotesters
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}

class MyModuleTwoTester(c:MyModuleTwo) extends PeekPokeTester{
	poke(c.io.in, 2)
	step(1)
	expect(c.io.out, 2)


}

class MyModuleTwoTests extends ChiselFlatSpec {
  behavior of "Module Tests "
  backends foreach {backend =>
    it should s"correctly respond to inputs in $backend" in {
      Driver(() => new MyModuleTwo, backend)(c => new MyModuleTwoTester(c)) should be (true)
    }
  }
}                                                                                                                                    

object MyModuleTwoMain extends App{
   
iotesters.Driver.execute(args= Array("--backend-name","verilator")  , ()=> new MyModuleTwo){
 c=> new MyModuleTwoTester(c)
  }
}
