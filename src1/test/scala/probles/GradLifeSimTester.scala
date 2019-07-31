package problems

import java.io.File

import chisel3.iotesters
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}


class GradLifeSimTester(c: GradLife) extends PeekPokeTester(c) {
  for (state <- 0 to 3) {
    for (coffee <- List(true, false)) {
      for (idea <- List(true, false)) {
        for (pressure <- List(true, false)) {
          poke(c.io.state, state)
          poke(c.io.coffee, coffee)
          poke(c.io.idea, idea)
          poke(c.io.pressure, pressure)
          expect(c.io.nextState, gradLife(state, coffee, idea, pressure))
        }
      }
    }
  }
}


class GradLifeSimTests extends ChiselFlatSpec {
  behavior of "Module Tests "
  backends foreach {backend =>
    it should s"correctly respond to inputs in $backend" in {
      Driver(() => new GradLifeSim, backend)(c => new GradLifeSimTester(c)) should be (true)
    }
  }
}                                                                                                                                    

object GradLifeSimMain extends App{
   
iotesters.Driver.execute(args= Array("--backend-name","verilator")  , ()=> new GradLifeSim){
 c=> new GradLifeSimTester(c)
  }
}