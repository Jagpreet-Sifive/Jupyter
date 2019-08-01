<<<<<<< HEAD
/**Counter: That can be incremented once every cycle, up to some specified limit,
 at which point it overflows
*/
package examples

import chisel3._
import chisel3.util

class Counter extends Module{
	     val io = IO(new Bundle {
      val count = Input(Bool())
      val out = Output(UInt(2.W))
    })
    val counter = Counter(3)  
    when(io.count) {
      counter.inc()
    }
    io.out := counter.value

}

=======
/**Counter: That can be incremented once every cycle, up to some specified limit,
 at which point it overflows
*/
package examples

import chisel3._
import chisel3.util

class Counter extends Module{
	     val io = IO(new Bundle {
      val count = Input(Bool())
      val out = Output(UInt(2.W))
    })
    val counter = Counter(3)  
    when(io.count) {
      counter.inc()
    }
    io.out := counter.value

}

>>>>>>> 2470b12e854267816f114c9310741525f95e858b
