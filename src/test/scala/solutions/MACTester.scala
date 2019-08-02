
package solutions

import java.io.File

import chisel3.iotesters
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}

import scala.util.Random


class MACTester(c:MAC) extends PeeKPokeTester(c){
 val cycle = 50
   for( i <- cycle){
   	  val in_a =Random.nextInt(4)
   	  val in_b =Random.nextInt(4)
   	  val in_c =Random.nextInt(4)
    
    poke(c.io.in_a , in_a)

    poke(c.io.in_b , in_b)
    
    poke(c.io.in_c , in_c)

    step(1)
    expect(c.io.out , (in_a * in_b)+in_c)  
   } 


}
class MACTests extends ChiselFlatSpec {
  behavior of "Module Tests "
  backends foreach {backend =>
    it should s"correctly respond to inputs in $backend" in {
      Driver(() => new MAC, backend)(c => new MACTester(c)) should be (true)
    }
  }
}                                                                                                                                    

object MACMain extends App{
   
iotesters.Driver.execute(args= Array("--backend-name","verilator")  , ()=> new MAC){
 c=> new MACTester(c)
  }
}

  