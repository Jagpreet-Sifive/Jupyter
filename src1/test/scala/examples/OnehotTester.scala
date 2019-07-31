package examples

import java.io.File

import chisel3.iotesters
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}


class OnehotTester(c: Onehot) extends PeekPokeTester(c){ 

    poke(c.io.in, 0)

    poke(c.io.in, 1)
  
    poke(c.io.in, 8)
  
    poke(c.io.in, 15)
} 
class  OnehotTests extends ChiselFlatSpec {
  behavior of "Module Tests "
  backends foreach {backend =>
    it should s"correctly respond to inputs in $backend" in {
      Driver(() => new  Onehot, backend)(c => new  OnehotTester(c)) should be (true)
    }
  }
}                                                                                                                                    

object  OnehotMain extends App{
   
iotesters.Driver.execute(args= Array("--backend-name","verilator")  , ()=> new  Onehot){
 c=> new  OnehotTester(c)
  }
}

  