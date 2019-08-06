

package problem
import java.io.File
import chisel3.util._
import chisel3.iotesters
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}


class ParameterizedAdderTester(c: ParameterizedAdder, saturate: Boolean) extends PeekPokeTester(c) {
  // 100 random tests
  val cycles = 100
  import scala.util.Random
  import scala.math.min
  for (i <- 0 until cycles) {
    val in_a = Random.nextInt(16)
    val in_b = Random.nextInt(16)
    poke(c.io.in_a, in_a)
    poke(c.io.in_b, in_b)
    if (saturate) {
      expect(c.io.out, min(in_a+in_b, 15))
    } else {
      expect(c.io.out, (in_a+in_b)%16)
    }
  }
  
  // ensure we test saturation vs. truncation
  poke(c.io.in_a, 15)
  poke(c.io.in_b, 15)
  if (saturate) {
    expect(c.io.out, 15)
  } else {
    expect(c.io.out, 14)
  }

for (saturate <- Seq(true, false)) {
 Driver(() => new ParameterizedAdder(saturate)) {c => new ParameterizedAdderTester(c, saturate)}
}
}




class  ParameterizedAdderTests extends ChiselFlatSpec {
  behavior of "Module Tests "
  backends foreach {backend =>
    it should s"correctly respond to inputs in $backend" in {
      for (saturate <- Seq(true, false)) {
          Driver(() => new ParameterizedAdder(saturate),backend ) {c => new ParameterizedAdderTester(c, saturate)} should be (true)
    }
  }
}                                                                                                                                    

}
object ParameterizedAdderMain extends App{
   for(saturate <- Seq(true ,false)){
iotesters.Driver.execute(args= Array("--backend-name","verilator") ,()=>  new ParameterizedAdder(saturate)){
 c=> new  ParameterizedAdderTester(c, saturate)
  }
}

}

