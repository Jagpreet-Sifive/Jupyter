package examples



import java.io.File
import chisel3.util
import chisel3.iotesters
import org.scalatest.{Matchers , FlatSpec}
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}

class FindMaxTester(c:FindMax) extends PeekPokeTester(c) {
    expect(c.io.max, 0)
    poke(c.io.in, 1)
    step(1)
    expect(c.io.max, 1)
    poke(c.io.in, 3)
    step(1)
    expect(c.io.max, 3)
    poke(c.io.in, 2)
    step(1)
    expect(c.io.max, 3)
    poke(c.io.in, 24)
    step(1)
    expect(c.io.max, 24)
  }


class FindMaXTests extends ChiselFlatSpec {
  behavior of "Module Tests "
  backends foreach {backend =>
    it should s"correctly respond to inputs in $backend" in {
      Driver(() => new FindMax, backend)(c => new FindMaxTester(c)) should be (true)
    }
  }
}                                                                                                                                    

object FindMaxMain extends App{
   
iotesters.Driver.execute(args= Array("--backend-name","verilator")  , ()=> new FindMax){
 c=> new FindMaxTester(c)
  }
}


