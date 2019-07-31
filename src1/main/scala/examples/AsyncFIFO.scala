// Asynchronous interfaces is connected to Gray_Coder using interfaces.

package examples

import chisel3._
import chisel3.util._

class AsyncFIFO(depth: Int = 16) extends Module {
  val io = IO(new Bundle{
  
    val write_clock = Input(Clock())
    val write_enable = Input(Bool())
    val write_data = Input(UInt(32.W))
    
    
    val read_clock = Input(Clock())
    val read_enable = Input(Bool())
    val read_data = Output(UInt(32.W))
    
    
    val full = Output(Bool())
    val empty = Output(Bool())
  })
   
  assert(isPow2(depth), "AsyncFIFO needs a power-of-two depth!")
  val write_counter = withClock(io.write_clock) { Counter(io.write_enable && !io.full, depth*2)._1 }
  val read_counter = withClock(io.read_clock) { Counter(io.read_enable && !io.empty, depth*2)._1 }
  

  val encoder = new GrayCoder(write_counter.getWidth)
  encoder.io.in := write_counter
  encoder.io.encode := true.B
  
  
  val sync = withClock(io.read_clock) { ShiftRegister(encoder.io.out, 2) }
  
  
  val decoder = new GrayCoder(read_counter.getWidth)
  decoder.io.in := sync
  decoder.io.encode := false.B
  

  
}
