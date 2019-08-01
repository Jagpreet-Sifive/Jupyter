package examples

import java.io.File

import chisel3.iotesters
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}


class MyManyElementFirTester(c: MyManyElementFir) extends PeekPokeTester(c){ 
val goldenModel = new ScalaFirFilterTester(Seq(1, 1, 1, 1))

    for(i <- 0 until 100) {
      val input = scala.util.Random.nextInt(8)

      val goldenModelResult = goldenModel.poke(input)

      poke(c.io.in, input)

      expect(c.io.out, goldenModelResult, s"i $i, input $input, gm $goldenModelResult, ${peek(c.io.out)}")

      step(1)
    }
  }

class MyManyElementFirTests extends ChiselFlatSpec {
  behavior of "Module Tests "
  backends foreach {backend =>
    it should s"correctly respond to inputs in $backend" in {
      Driver(() => new MyManyElementFir, backend)(c => new MyManyElementFirTester(c)) should be (true)
    }
  }
}                                                                                                                                    

object MyManyElementFirMain extends App{
   
iotesters.Driver.execute(args= Array("--backend-name","verilator")  , ()=> new MyManyElementFir){
 c=> new MyManyElementFirTester(c)
  }
}

  