

package problem

import java.io.File

import chisel3.iotesters
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}

class ArbiterTester(c: Arbiter) extends PeekPokeTester(c) {
  import scala.util.Random
  val data = Random.nextInt(65536)
  poke(c.io.fifo_data, data)
  
  for (i <- 0 until 8) {
    poke(c.io.fifo_valid, (i>>0)%2)
    poke(c.io.pe0_ready,  (i>>1)%2)
    poke(c.io.pe1_ready,  (i>>2)%2)

    expect(c.io.fifo_ready, i>1)
    expect(c.io.pe0_valid,  i==3 || i==7)
    expect(c.io.pe1_valid,  i==5)
    
    if (i == 3 || i ==7) {
      expect(c.io.pe0_data, data)
    } else if (i == 5) {
      expect(c.io.pe1_data, data)
    }
  }
}

class ArbiterTests extends ChiselFlatSpec {
  behavior of "Module Tests "
  backends foreach {backend =>
    it should s"correctly respond to inputs in $backend" in {
      Driver(() => new Arbiter, backend)(c => new ArbiterTester(c)) should be (true)
    }
  }
}                                                                                                                                    

object ArbiterMain extends App{
   
iotesters.Driver.execute(args= Array("--backend-name","verilator")  , ()=> new Arbiter){
 c=> new ArbiterTester(c)
  }
}
