<<<<<<< HEAD
//Exercise: Shift Register
// Task: build a module that implements a shift register for a LFSR Using "RegNext".
package Example
import chisel3._
import chisel3.util


class MyShiftRegister(val init: Int = 1) extends Module {
  val io = IO(new Bundle {
    val in  = Input(Bool())
    val out = Output(UInt(4.W))
  })

  val state = RegInit(UInt(4.W), init.U)

  ???
}

=======
//Exercise: Shift Register
// Task: build a module that implements a shift register for a LFSR Using "RegNext".
package Example
import chisel3._
import chisel3.util


class MyShiftRegister(val init: Int = 1) extends Module {
  val io = IO(new Bundle {
    val in  = Input(Bool())
    val out = Output(UInt(4.W))
  })

  val state = RegInit(UInt(4.W), init.U)

  ???
}

>>>>>>> 2470b12e854267816f114c9310741525f95e858b
