<<<<<<< HEAD
package examples

/**Example: Comb Filter
The following example shows a comb filter 
*/

import chisel3._
import chisel3.util
class Comb extends Module {
  val io = IO(new Bundle {
    val in  = Input(SInt(12.W))
    val out = Output(SInt(12.W))
  })

  val delay: SInt = Reg(SInt(12.W))
  delay := io.in
  io.out := io.in - delay
}
=======
package examples

/**Example: Comb Filter
The following example shows a comb filter 
*/

import chisel3._
import chisel3.util
class Comb extends Module {
  val io = IO(new Bundle {
    val in  = Input(SInt(12.W))
    val out = Output(SInt(12.W))
  })

  val delay: SInt = Reg(SInt(12.W))
  delay := io.in
  io.out := io.in - delay
}
>>>>>>> 2470b12e854267816f114c9310741525f95e858b
