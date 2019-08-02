    // Example testsequence showing the use and behavior of Queue
package solutions
import chisel3._
import chisel3.util._
import chisel3.experimental._
import chisel3.experimental.BundleLiterals._
import chisel3.tester._
import chisel3.tester.RawTester.test
import chisel3.iotesters
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}


class QueueModuleTester(c: QueueModule) extends PeekPokeTester(c){
	test(QueueModule(UInt(9.W), entries = 200)) { c =>
    c.in.initSource()
    c.in.setSourceClock(c.clock)
    c.out.initSink()
    c.out.setSinkClock(c.clock)
    
    val testVector = Seq.tabulate(200){ i => i.U }

    testVector.zip(testVector).foreach { case (in, out) =>
      c.in.enqueueNow(in)
      c.out.expectDequeueNow(out)
    }
}
}

class QueueModuleTests extends ChiselFlatSpec {
  behavior of "Module Tests "
  backends foreach {backend =>
    it should s"correctly respond to inputs in $backend" in {
      Driver(() => new QueueModule, backend)(c => new QueueModuleTester(c)) should be (true)
    }
  }
}                                                                                                                                    

object QueueModuleMain extends App{
   
iotesters.Driver.execute(args= Array("--backend-name","verilator")  , ()=> new QueueModule){
 c=> new QueueModuleTester(c)
  }
}

