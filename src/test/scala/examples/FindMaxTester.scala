import chisel3._
import chisel3.iotesters.{PeeKPokeTester, Driver, ChiselFlatSpec }



class FindMaXTester(c:FindMaX) extends PeeKPokeTester(c) {
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
      Driver(() => new FindMaX, backend)(c => new FindMaXTester(c)) should be (true)
    }
  }
}                                                                                                                                    

object FindMaXMain extends App{
   
iotesters.Driver.execute(args= Array("--backend-name","verilator")  , ()=> new FindMaX){
 c=> new FindMaXTester(c)
  }
}


