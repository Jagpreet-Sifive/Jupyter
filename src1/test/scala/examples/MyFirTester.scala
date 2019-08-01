<<<<<<< HEAD
/*Special programme for firrtl topic*/
package examples

import chisel3._
import chisel3.util
import chisel3.iotesters.{PeekPokeTester, Driver, ChiselFlatSpec}
import scala.math.{pow, sin, Pi}
import breeze.signal.{filter, OptOverhang}
import breeze.signal.support.{CanFilter, FIRKernel1D}
import breeze.linalg.DenseVector


val length = 7
val bitwidth = 12 
val window = TriangularWindow



class MyFirTester (c:MyFir) extends PeekPokeTester(c){
    

    val n = 100 
    val sine_freq = 10
    val samp_freq = 100
    
   
    val max_value = pow(2, bitwidth)-1
    val sine = (0 until n).map(i => (max_value/2 + max_value/2*sin(2*Pi*sine_freq/samp_freq*i)).toInt)
   
    
   
    val coeffs = window(length, bitwidth)
   
    val expected = filter(DenseVector(sine.toArray), 
                          FIRKernel1D(DenseVector(coeffs.reverse.toArray), 1.0, ""), 
                          OptOverhang.None)
   

       reset(5)
    for (i <- 0 until n) {
      poke(c.io.in, sine(i))
      if (i >= length-1) { 
        expect(c.io.out, expected(i-length+1))
        
      }
      step(1)
    }
  }
}
}

class MyFirTests extends ChiselFlatSpec {
  behavior of "Module Tests "
  backends foreach {backend =>
    it should s"correctly respond to inputs in $backend" in {
      Driver(() => new MyFir, backend)(c => new MyFirTester(c)) should be (true)
    }
  }
}                                                                                                                                    

object MyFirMain extends App{
   
iotesters.Driver.execute(args= Array("--backend-name","verilator")  , ()=> new MyFir){
 c=> new MyFirTester(c)
  }
}
=======
/*Special programme for firrtl topic*/
package examples

import chisel3._
import chisel3.util
import chisel3.iotesters.{PeekPokeTester, Driver, ChiselFlatSpec}
import scala.math.{pow, sin, Pi}
import breeze.signal.{filter, OptOverhang}
import breeze.signal.support.{CanFilter, FIRKernel1D}
import breeze.linalg.DenseVector


val length = 7
val bitwidth = 12 
val window = TriangularWindow



class MyFirTester (c:MyFir) extends PeekPokeTester(c){
    

    val n = 100 
    val sine_freq = 10
    val samp_freq = 100
    
   
    val max_value = pow(2, bitwidth)-1
    val sine = (0 until n).map(i => (max_value/2 + max_value/2*sin(2*Pi*sine_freq/samp_freq*i)).toInt)
   
    
   
    val coeffs = window(length, bitwidth)
   
    val expected = filter(DenseVector(sine.toArray), 
                          FIRKernel1D(DenseVector(coeffs.reverse.toArray), 1.0, ""), 
                          OptOverhang.None)
   

       reset(5)
    for (i <- 0 until n) {
      poke(c.io.in, sine(i))
      if (i >= length-1) { 
        expect(c.io.out, expected(i-length+1))
        
      }
      step(1)
    }
  }
}
}

class MyFirTests extends ChiselFlatSpec {
  behavior of "Module Tests "
  backends foreach {backend =>
    it should s"correctly respond to inputs in $backend" in {
      Driver(() => new MyFir, backend)(c => new MyFirTester(c)) should be (true)
    }
  }
}                                                                                                                                    

object MyFirMain extends App{
   
iotesters.Driver.execute(args= Array("--backend-name","verilator")  , ()=> new MyFir){
 c=> new MyFirTester(c)
  }
}
>>>>>>> 2470b12e854267816f114c9310741525f95e858b
