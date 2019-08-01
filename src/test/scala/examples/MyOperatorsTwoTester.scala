package examples

import java.io.File

import chisel3.iotesters
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}

class MyOperatorsTwoTester(c: MyOperatorsTwo) extends PeeKPokeTester(c){

    expect(c.io.out_mux, 3)
	expect(c.io.out_cat, 5)

}


class MyOperatorsTwoTests extends ChiselFlatSpec {
  behavior of "Module Tests "
  backends foreach {backend =>
    it should s"correctly respond to inputs in $backend" in {
      Driver(() => new MyOperatorsTwo, backend)(c => new MyOperatorsTwoTester(c)) should be (true)
    }
  }
}                                                                                                                                    

object MyOperatorsTwoMain extends App{
   
iotesters.Driver.execute(args= Array("--backend-name","verilator")  , ()=> new MyOperatorsTwo){
 c=> new MyOperatorsTwoTester(c)
  }
}

  