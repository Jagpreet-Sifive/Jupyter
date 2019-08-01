package examples

import chisel3.iotesters
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}


class RegisterModuleTester(c: RegisterModule) extends PeekPokeTester(c) {
  for(i <- 0 until 100) {
    poke(c.io.iRegisterModule  step(1)
    expect(c.io.out, i+1)
  }
}

class RegisterModuleTests extends ChiselFlatSpec {
  behavior of "Module Tests "
  backends foreach {backend =>
    it should s"correctly respond to inputs in $backend" in {
      Driver(() => new RegisterModule, backend)(c => new RegisterModuleTester(c)) should be (true)
    }
  }
}                                                                                                                                    

object RegisterModuleMain extends App{
   
iotesters.Driver.execute(args= Array("--backend-name","verilator")  , ()=> new RegisterModule){
 c=> new RegisterModuleTester(c)
  }
}

  