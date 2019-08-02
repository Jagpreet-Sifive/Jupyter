package solutions
import chisel3._
import chisel3.util._
import chisel3.experimental._
import chisel3.experimental.BundleLiterals._
import chisel3.tester._
import chisel3.tester.RawTester.test
import chisel3.iotesters
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}

class PassthroughGenerator2Tester(c:PassthroughGenerator) extends PeekPokeTester(c){

/* WITH-OUT CLOCK */

    c.io.in.poke(0.U)     
    c.io.out.expect(0.U)  
    c.io.in.poke(1.U)     
    c.io.out.expect(1.U)  
    c.io.in.poke(2.U)     
    c.io.out.expect(2.U)  



/* WITH- CLOCK*/
/*
    c.io.in.poke(0.U)    
    c.clock.step(1)    
    c.io.out.expect(0.U)  
    c.io.in.poke(1.U)     
    c.clock.step(1)    
    c.io.out.expect(1.U)  
    c.io.in.poke(2.U)     
    c.clock.step(1)    
    c.io.out.expect(2.U)  

}
*/

class PassthroughGenerator2Tests extends ChiselFlatSpec {
  behavior of "Module Tests "
  backends foreach {backend =>
    it should s"correctly respond to inputs in $backend" in {
      Driver(() => new PassthroughGenerator2, backend)(c => new PassthroughGenerator2Tester(c)) should be (true)
    }
  }
}                                                                                                                                    

object PassthroughGenerator2Main extends App{
   
iotesters.Driver.execute(args= Array("--backend-name","verilator")  , ()=> new PassthroughGenerator2){
 c=> new PassthroughGenerator2Tester(c)
  }
}

