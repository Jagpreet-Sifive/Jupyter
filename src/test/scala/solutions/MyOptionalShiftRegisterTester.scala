package solutions

import java.io.File

import chisel3.iotesters
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}

class MyOptionalShiftRegisterTester(c: MyOptionalShiftRegister) extends PeekPokeTester(c) {
  val inSeq = Seq(0, 1, 1, 1, 0, 1, 1, 0, 0, 1)
  var state = c.init
  var i = 0
  poke(c.io.en, 1)
  while (i < 10 * c.n) {
   
    val toPoke = inSeq(i % inSeq.length)
    poke(c.io.in, toPoke)
   
    state = ((state * 2) + toPoke) & BigInt("1"*c.n, 2)
    step(1)
    expect(c.io.out, state)

    i += 1
  }
}


class MyOptionalShiftRegisterTests extends ChiselFlatSpec {
  behavior of "Module Tests "
  backends foreach {backend =>
    it should s"correctly respond to inputs in $backend" in {
      Driver(() => new MyOptionalShiftRegister, backend)(c => new MyOptionalShiftRegisterTester(c)) should be (true)
    }
  }
}                                                                                                                                    

object MyOptionalShiftRegisterMain extends App{
   
iotesters.Driver.execute(args= Array("--backend-name","verilator")  , ()=> new MyOptionalShiftRegister){
 c=> new MyOptionalShiftRegisterTester(c)
  }
}

