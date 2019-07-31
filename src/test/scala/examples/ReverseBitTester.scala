package examples
import chisel3._
import chisel3.util._
import  chisel3.util.Reverse
import chisel3.iotesters
import chisel3.iotesters.{PeekPokeTester, Driver, ChiselFlatSpec}

class ReverseBitTester(c: ReverseBit) extends PeekPokeTester(c){
	  
    
    poke(c.io.in, Integer.parseInt("01010101", 2))
    
  
    poke(c.io.in, Integer.parseInt("00001111", 2))
  
    poke(c.io.in, Integer.parseInt("11110000", 2))
  
    poke(c.io.in, Integer.parseInt("11001010", 2))
} 
class ReverseBitTests extends ChiselFlatSpec {
  behavior of "Module Tests "
  backends foreach {backend =>
    it should s"correctly respond to inputs in $backend" in {
      Driver(() => new ReverseBit, backend)(c => new ReverseBitTester(c)) should be (true)
    }
  }
}                                                                                                                                    

object ReverseBitMain extends App{
   
iotesters.Driver.execute(args= Array("--backend-name","verilator")  , ()=> new ReverseBit){
 c=> new ReverseBitTester(c)
  }
}
