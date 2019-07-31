package examples

import chisel3._
import java.io.File

import chisel3.iotesters
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}



class PriorMuxTester(c: PriorMux) extends PeekPokeTester(c){ 

    poke(c.io.in_bits(0), 10)
    poke(c.io.in_bits(1), 20)
  
    
    poke(c.io.in_sels(0), 0)
    poke(c.io.in_sels(1), 1)
    
  
    
    poke(c.io.in_sels(0), 1)
    poke(c.io.in_sels(1), 1)
    
  
    
    poke(c.io.in_sels(0), 1)
    poke(c.io.in_sels(1), 0)
    
}
class PriorMuxTests extends ChiselFlatSpec {
  behavior of "Module Tests "
  backends foreach {backend =>
    it should s"correctly respond to inputs in $backend" in {
      Driver(() => new PriorMux, backend)(c => new PriorMuxTester(c)) should be (true)
    }
  }
}                                                                                                                                    

object PriorMuxMain extends App{
   
iotesters.Driver.execute(args= Array("--backend-name","verilator")  , ()=> new PriorMux){
 c=> new PriorMuxTester(c)
  }
}

                                                                                                      

