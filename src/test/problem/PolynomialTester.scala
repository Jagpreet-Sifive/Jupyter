package examples
import chisel3._
import chisel3.iotesters
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}


class PolynomialTester(c: Polynomial) extends PeekPokeTester(c) {
 
def poly0(x: Int): Int = x^x - 2^x + 1
def poly1(x: Int): Int = 2^x^x + 6^x + 3
def poly2(x: Int): Int = 4^x^x - 10^x - 5


  def poly(select: Int, x: Int): Int = {
  if(select == 0) {
    poly0(x)
  }
  else if(select == 1) {
    poly1(x)
  }
  else {
    poly2(x)
  }
}
/*
assert(poly(1, 0) == 3)
assert(poly(1, 1) == 11)
assert(poly(2, 1) == -11)
assert(poly0(0) == 1)
assert(poly1(0) == 3)
assert(poly2(0) == -5)

*/




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

