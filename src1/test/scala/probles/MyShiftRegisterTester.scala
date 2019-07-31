package problems

import java.io.File

import chisel3.iotesters
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}


class MyShiftRegisterTester(c: MyShiftRegister) extends PeekPokeTester(c) {
  var state = c.init
  for (i <- 0 until 10) {

    poke(c.io.in, i % 2)

    state = ((state * 2) + (i % 2)) & 0xf
    step(1)
    expect(c.io.out, state)
  }
}


class MyShiftRegisterTests extends ChiselFlatSpec {
  behavior of "Module Tests "
  backends foreach {backend =>
    it should s"correctly respond to inputs in $backend" in {
      Driver(() => new MyShiftRegister, backend)(c => new MyShiftRegisterTester(c)) should be (true)
    }
  }
}                                                                                                                                    

object MyShiftRegisterMain extends App{
   
iotesters.Driver.execute(args= Array("--backend-name","verilator")  , ()=> new MyShiftRegister){
 c=> new MyShiftRegisterTester(c)
  }
}

