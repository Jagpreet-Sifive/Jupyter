// Example:- Chisel can  connect to  the common subelements of the two Bundles . 

package examples

import chisel3._
import chisel3.util

class Bundle1 extends Bundle {
  val a = UInt(8.W)
  override def cloneType = (new Bundle1).asInstanceOf[this.type]
}

class Bundle2 extends Bundle1 {
  val b = UInt(16.W)
  override def cloneType = (new Bundle2).asInstanceOf[this.type]
}

class BadTypeModule extends Module {
  val io = IO(new Bundle {
    val c  = Input(Clock())
    val in = Input(UInt(2.W))
    val out = Output(Bool())

    val bundleIn = Input(new Bundle2)
    val bundleOut = Output(new Bundle1)
  })
  
 
  io.out := io.in

  io.bundleOut := io.bundleIn


}
