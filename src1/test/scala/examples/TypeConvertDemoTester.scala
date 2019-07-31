
 package examples 

import java.io.File

import chisel3.iotesters
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}
 

 class TypeConvertDemoTester(c: TypeConverDemo) extends PeekPokeTester(c)
{
	  poke(c.io.in, 3)
      expect(c.io.out, 3)
      poke(c.io.in, 15)
      expect(c.io.out, -1)
  }



class TypeConvertDemoTests extends ChiselFlatSpec {
  behavior of "Module Tests "
  backends foreach {backend =>
    it should s"correctly respond to inputs in $backend" in {
      Driver(() => new TypeConvertDemo, backend)(c => new TypeConvertDemoTester(c)) should be (true)
    }
  }
}                                                                                                                                    

object TypeConvertDemoMain extends App{
   
iotesters.Driver.execute(args= Array("--backend-name","verilator")  , ()=> new TypeConvertDemo){
 c=> new TypeConvertDemoTester(c)
  }
}

