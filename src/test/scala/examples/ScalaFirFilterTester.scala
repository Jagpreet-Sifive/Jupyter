
package examples
import chisel3._
import chisel3.iotesters
import chisel3.util._
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}
import scala.collection._

class ScalaFirFilterTester(c:ScalaFirFilter) extends PeekPokeTester(c){



val filter = new ScalaFirFilter(Seq(1, 1, 1, 1))

var out = 0

out = filter.poke(1)
println(s"out = $out")
assert(out == 1)  

out = filter.poke(4)
assert(out == 5)  
println(s"out = $out")

out = filter.poke(3)
assert(out == 8)  
println(s"out = $out")

out = filter.poke(2)
assert(out == 10)  
println(s"out = $out")

out = filter.poke(7)
assert(out == 16)  
println(s"out = $out")

out = filter.poke(0)
assert(out == 12)  
println(s"out = $out")


}class ScalaFirFilterTests extends ChiselFlatSpec {
  behavior of "Module Tests "
  backends foreach {backend =>
    it should s"correctly respond to inputs in $backend" in {
      Driver(() => new ScalaFirFilter, backend)(c => new ScalaFirFilterTester(c)) should be (true)
    }
  }
}                                                                                                                                    

object ScalaFirFilterMain extends App{
   
iotesters.Driver.execute(args= Array("--backend-name","verilator")  , ()=> new ScalaFirFilter){
 c=> new ScalaFirFilterTester(c)
  }
}
