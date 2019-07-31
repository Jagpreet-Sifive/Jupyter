package examples

import java.io.File

import chisel3.iotesters
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}



class MyModuleTester(c:MyModule) extends PeekPokeTester(c){
poke(c.io.in, 2)
 step(1)
 expect(c.io.out ,2)

}


class MyModuleTests extends ChiselFlatSpec {
  behavior of "Module Tests "
  backends foreach {backend =>
    it should s"correctly respond to inputs in $backend" in {
      Driver(() => new MyModule, backend)(c => new MyModuleTester(c)) should be (true)
    }
  }
}                                                                                                                                    

object MyModuleMain extends App{
   
iotesters.Driver.execute(args= Array("--backend-name","verilator")  , ()=> new MyModule){
 c=> new MyModuleTester(c)
  }
}

  }