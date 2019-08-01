package examples

import chisel3._
import chisel3.util._
import chisel3.iotesters
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}

import chisel3.experimental._

class GrayCoderTester(c: GrayCoder) extends PeekPokeTester{
    def toBinary(i: Int, digits: Int = 8) =
      String.format("%" + digits + "s", i.toBinaryString).replace(' ', '0')

    
    for (i <- 0 until pow(2, bitwidth).toInt) {
      poke(c.io.in, i)
      poke(c.io.encode, true)
      step(1)
    
    }
    
    
    for (i <- 0 until pow(2, bitwidth).toInt) {
      poke(c.io.in, i)
      poke(c.io.encode, false)
      step(1)
     
    }
  }
}


 
class GrayCoderTests extends ChiselFlatSpec {
  behavior of "Module Tests "
  backends foreach {backend =>
    it should s"correctly respond to inputs in $backend" in {
      Driver(() => new GrayCoder, backend)(c => new GrayCoderTester(c)) should be (true)
    }
  }
}                                                                                                                                    

object GrayCoderMain extends App{
   
iotesters.Driver.execute(args= Array("--backend-name","verilator")  , ()=> new GrayCoder){
 c=> new GrayCoderTester(c)
  }
}

