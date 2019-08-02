package solutions
import chisel3._
import chisel3.iotesters
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}


class PolynomialTester(c: Polynomial) extends PeekPokeTester(c) {
  for(x <- 0 to 20) {
    for(select <- 0 to 2) {
      poke(c.io.select, select)
      poke(c.io.x, x)
      expect(c.io.fOfX, poly(select, x))
    }
  }
}


class PolynomialTests extends ChiselFlatSpec {
  behavior of "Module Tests "
  backends foreach {backend =>
    it should s"correctly respond to inputs in $backend" in {
      Driver(() => new Polynomial, backend)(c => new PolynomialTester(c)) should be (true)
    }
  }
}                                                                                                                                    

object PolynomialMain extends App{
   
iotesters.Driver.execute(args= Array("--backend-name","verilator")  , ()=> new Polynomial){
 c=> new PolynomialTester(c)
  }
}

