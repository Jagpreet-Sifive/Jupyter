package examples


import java.io.File

import chisel3.iotesters
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}



class PassTester(c:Passthrough) extends PeekPokeTester{

val testResult = Driver(() => new Passthrough()) {
  c => new PeekPokeTester(c) {
    poke(c.io.in, 0)     
    expect(c.io.out, 0)  
    poke(c.io.in, 1)     
    expect(c.io.out, 1)  
    poke(c.io.in, 2)     
    expect(c.io.out, 2)  
  }
}



}
 
class PassTests extends ChiselFlatSpec {
  behavior of "Module Tests "
  backends foreach {backend =>
    it should s"correctly respond to inputs in $backend" in {
      Driver(() => new Pass, backend)(c => new PassTester(c)) should be (true)
    }
  }
}                                                                                                                                    

object PassMain extends App{
   
iotesters.Driver.execute(args= Array("--backend-name","verilator")  , ()=> new Pass){
 c=> new PassTester(c)
  }
}

  