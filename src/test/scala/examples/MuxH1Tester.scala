package examples

import java.io.File

import chisel3.iotesters
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}


class MuxH1Tester(c: MuxH1) extends PeekPokeTester{
	  poke(c.io.in_bits(0), 10)
    poke(c.io.in_bits(1), 20)
  
      poke(c.io.in_sels(0), 0)
    poke(c.io.in_sels(1), 1)
   
  
       poke(c.io.in_sels(0), 1)
    poke(c.io.in_sels(1), 0)
    
  
    
    poke(c.io.in_sels(0), 0)
    poke(c.io.in_sels(1), 0)
    
    poke(c.io.in_sels(0), 1)
    poke(c.io.in_sels(1), 1)
    
} 

class MuxH1Tests extends ChiselFlatSpec {
  behavior of "Module Tests "
  backends foreach {backend =>
    it should s"correctly respond to inputs in $backend" in {
      Driver(() => new MuxH1 backend)(c => new MuxH1Tester(c)) should be (true)
    }
  }
}                                                                                                                                    

object MuxH1Main extends App{
   
iotesters.Driver.execute(args= Array("--backend-name","verilator")  , ()=> new MuxH1){
 c=> new MuxH1Tester(c)
  }
}
