package examples
import java.io.File

import chisel3.iotesters
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}


class RegNextModuleTester(c: RegNextModule) extends PeekPokeTester(c) {
  for (i <- 0 until 100) {
    poke(c.io.in, i)
    step(1)
    expect(c.io.out, i+1)
  }
}





class RegNextModuleTests extends ChiselFlatSpec {
  behavior of "Module Tests "
  backends foreach {backend =>
    it should s"correctly respond to inputs in $backend" in {
      Driver(() => new RegNextModule, backend)(c => new RegNextModuleTester(c)) should be (true)
    }
  }
}                                                                                                                                    

object RegNextModuleMain extends App{
   
iotesters.Driver.execute(args= Array("--backend-name","verilator")  , ()=> new RegNextModule){
 c=> new RegNextModuleTester(c)
  }
}

  