
package problem

import java.io.File

import chisel3.iotesters
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}

class My4ElementFirTester(c: My4ElementFir) extends PeekPokeTester(c){
    poke(c.io.in, 1)
    expect(c.io.out, 1)  
    step(1)
    poke(c.io.in, 4)
    expect(c.io.out, 6) 
    step(1)
    poke(c.io.in, 3)
    expect(c.io.out, 14) 
    step(1)
    poke(c.io.in, 2)
    expect(c.io.out, 24)  
    step(1)
    poke(c.io.in, 7)
    expect(c.io.out, 36)  
    step(1)
    poke(c.io.in, 0)
    expect(c.io.out, 32)  
  }




class My4ElementFirTests extends ChiselFlatSpec {
  behavior of "Module Tests "
  backends foreach {backend =>
    it should s"correctly respond to inputs in $backend" in {
      Driver(() => new My4ElementFir(1,1,1,1) , backend)(c => new My4ElementFirTester(c)) should be (true)
    }
  }
}                                                                                                                                    

object My4ElementFirMain extends App{
   
iotesters.Driver.execute(args= Array("--backend-name","verilator")  , ()=> new My4ElementFir(1,1,1,1)){
 c=> new My4ElementFirTester(c)
  }
}

