<<<<<<< HEAD
package examples

import java.io.File

import chisel3.iotesters
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}



class LastConnectTester(c: LastConnect) extends PeekPokeTester(c) {
  expect(c.io.out, 4)  
}

class LastConnectTests extends ChiselFlatSpec {
  behavior of "Module Tests "
  backends foreach {backend =>
    it should s"correctly respond to inputs in $backend" in {
      Driver(() => new LastConnect, backend)(c => new LastConnectTester(c)) should be (true)
    }
  }
}                                                                                                                                    

object LastConnectMain extends App{
   
iotesters.Driver.execute(args= Array("--backend-name","verilator")  , ()=> new LastConnect){
 c=> new LastConnectTester(c)
  }
}

  


=======
package examples

import java.io.File

import chisel3.iotesters
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}



class LastConnectTester(c: LastConnect) extends PeekPokeTester(c) {
  expect(c.io.out, 4)  
}

class LastConnectTests extends ChiselFlatSpec {
  behavior of "Module Tests "
  backends foreach {backend =>
    it should s"correctly respond to inputs in $backend" in {
      Driver(() => new LastConnect, backend)(c => new LastConnectTester(c)) should be (true)
    }
  }
}                                                                                                                                    

object LastConnectMain extends App{
   
iotesters.Driver.execute(args= Array("--backend-name","verilator")  , ()=> new LastConnect){
 c=> new LastConnectTester(c)
  }
}

  


>>>>>>> 2470b12e854267816f114c9310741525f95e858b
