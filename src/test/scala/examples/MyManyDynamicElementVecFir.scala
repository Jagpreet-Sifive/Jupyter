package examples

import java.io.File

import chisel3.iotesters
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}

import scala.collection._

class MyManyDynamicElementVecFirTester(c: MyManyDynamicElementVecFir) extends PeekPokeTester(c){
  

val goldenModel = new ScalaFirFilter(Seq(1, 1, 1, 1))

Driver(() => new MyManyDynamicElementVecFir(4)) {
  c => new PeekPokeTester(c) {
    poke(c.io.consts(0), 1)
    poke(c.io.consts(1), 1)
    poke(c.io.consts(2), 1)
    poke(c.io.consts(3), 1)
    for(i <- 0 until 100) {
      val input = scala.util.Random.nextInt(8)

      val goldenModelResult = goldenModel.poke(input)

      poke(c.io.in, input)

      expect(c.io.out, goldenModelResult, s"i $i, input $input, gm $goldenModelResult, ${peek(c.io.out)}")

      step(1)
    }
  }
}
}

class MyManyDynamicElementVecFirTests extends ChiselFlatSpec {
  behavior of "Module Tests "
  backends foreach {backend =>
    it should s"correctly respond to inputs in $backend" in {
      Driver(() => new MyManyDynamicElementVecFir, backend)(c => new MyManyDynamicElementVecFirTester(c)) should be (true)
    }
  }
}                                                                                                                                    

object MyManyDynamicElementVecFirMain extends App{
   
iotesters.Driver.execute(args= Array("--backend-name","verilator")  , ()=> new MyManyDynamicElementVecFir){
 c=> new MyManyDynamicElementVecFirTester(c)
  }
}

  
