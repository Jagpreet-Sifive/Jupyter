package examples
import  chisel3.util.PopCount
import java.io.File

import chisel3.iotesters
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}




class PopCountBitTester(c:PopCountBit) extends PeekPokeTester(c){
    poke(c.io.in, Integer.parseInt("00000000", 2))
  
    poke(c.io.in, Integer.parseInt("00001111", 2))
  
    poke(c.io.in, Integer.parseInt("11001010", 2))
  
    poke(c.io.in, Integer.parseInt("11111111", 2))
} 
class PopCountBitTests extends ChiselFlatSpec {
  behavior of "Module Tests "
  backends foreach {backend =>
    it should s"correctly respond to inputs in $backend" in {
      Driver(() => new PopCountBit, backend)(c => new PopCountBitTester(c)) should be (true)
    }
  }
}                                                                                                                                    

object PopCountBitMain extends App{
   
iotesters.Driver.execute(args= Array("--backend-name","verilator")  , ()=> new PopCountBit){
 c=> new PopCountBitTester(c)
  }
}

