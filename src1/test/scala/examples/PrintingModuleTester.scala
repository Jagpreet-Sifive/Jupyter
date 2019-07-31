package examples

import java.io.File

import chisel3.iotesters
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}


class PrintingModuleTester(c: PrintingModule) extends PeekPokeTester(c) {
    poke(c.io.in, 3)
    step(5) 
    
    
}

class PrintingModuleTests extends ChiselFlatSpec {
  behavior of "Module Tests "
  backends foreach {backend =>
    it should s"correctly respond to inputs in $backend" in {
      Driver(() => new PrintingModule, backend)(c => new PrintingModuleTester(c)) should be (true)
    }
  }
}                                                                                                                                    

object PrintingModuleMain extends App{
   
iotesters.Driver.execute(args= Array("--backend-name","verilator")  , ()=> new PrintingModule){
 c=> new PrintingModuleTester(c)
  }
}

 