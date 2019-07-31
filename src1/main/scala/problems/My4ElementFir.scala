/** Task:  Build a 4-element FIR filter where the four filter coefficients are parameters */

package problems
import chisel3._
import chisel3.util



class My4ElementFir(b0: Int, b1: Int, b2: Int, b3: Int) extends Module {
  val io = IO(new Bundle {
    val in = Input(UInt(8.W))
    val out = Output(UInt(8.W))
  })

  ???
}

