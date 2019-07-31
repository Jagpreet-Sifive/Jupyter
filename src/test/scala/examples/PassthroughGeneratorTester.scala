package examples

import java.io.File

import chisel3.iotesters
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}


class PassthroughGeneratorTester(c: PassthroughGenerator) extends PeekPokeTester(c){
	

	test(new PassthroughGenerator(16)) { c =>
    c.io.in.poke(0.U)     
    c.io.out.expect(0.U)  
    c.io.in.poke(1.U)     
    c.io.out.expect(1.U)  
    c.io.in.poke(2.U)     
    c.io.out.expect(2.U)  
}
}
class PassthroughGeneratorTests extends ChiselFlatSpec {
  behavior of "Module Tests "
  backends foreach {backend =>
    it should s"correctly respond to inputs in $backend" in {
      Driver(() => new PassthroughGenerator, backend)(c => new PassthroughGeneratorTester(c)) should be (true)
    }
  }
}                                                                                                                                    

object PassthroughGeneratorMain extends App{
   
iotesters.Driver.execute(args= Array("--backend-name","verilator")  , ()=> new PassthroughGenerator){
 c=> new PassthroughGeneratorTester(c)
  }
}

  