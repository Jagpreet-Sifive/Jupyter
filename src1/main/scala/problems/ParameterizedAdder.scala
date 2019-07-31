/*Exercise: Parameterized Adder (Optional) */
// Task : pass Parameter to adder.
package Example
import chisel3._
import chisel3.util._


class ParameterizedAdder(saturate: Boolean) extends Module {
  val io = IO(new Bundle {
    val in_a = Input(UInt(4.W))
    val in_b = Input(UInt(4.W))
    val out  = Output(UInt(4.W))
  })

  ???
}
