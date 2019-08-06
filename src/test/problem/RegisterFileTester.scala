
package problem
import java.io.File

import chisel3.iotesters
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}

class  RegisterFileTester(c:  RegisterFile) extends PeekPokeTester(c) {

  def readExpect(addr: Int, value: Int, port: Int = 0): Unit = {
        poke(c.io.raddr(port), addr)
        expect(c.io.rdata(port), value)
    }
    def write(addr: Int, value: Int): Unit = {
        poke(c.io.wen, 1)
        poke(c.io.wdata, value)
        poke(c.io.waddr, addr)
        step(1)
        poke(c.io.wen, 0)
    }
    // everything should be 0 on init
    for (i <- 0 until 32) {
        readExpect(i, 0, port = 0)
        readExpect(i, 0, port = 1)
    }

    // write 5 * addr + 3
    for (i <- 0 until 32) {
        write(i, 5 * i + 3)
    }

    // check that the writes worked
    for (i <- 0 until 32) {
        readExpect(i, if (i == 0) 0 else 5 * i + 3, port = i % 2)
    }

}



class  RegisterFileTests extends ChiselFlatSpec {
  behavior of "Module Tests "
  backends foreach {backend =>
    it should s"correctly respond to inputs in $backend" in {
      Driver(() => new  RegisterFile(2), backend)(c => new  RegisterFileTester(c)) should be (true)
    }
  }
}                                                                                                                                    

object  RegisterFileMain extends App{
   
iotesters.Driver.execute(args= Array("--backend-name","verilator")  , ()=>  new RegisterFile(2)){
 c=> new  RegisterFileTester(c)
  }
}
