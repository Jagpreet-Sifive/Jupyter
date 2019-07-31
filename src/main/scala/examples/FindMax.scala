//Example: Register Control Flow
package examples
import chisel3._


class FindMax extends Module {
  val io = IO(new Bundle {
    val in  = Input(UInt(10.W))
    val max = Output(UInt(10.W))
  })

  val max = RegInit(0.U(10.W))
  when (io.in > max) {
    max := io.in
  }
  io.max := max
}

