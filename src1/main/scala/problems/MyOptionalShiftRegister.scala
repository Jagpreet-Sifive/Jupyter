<<<<<<< HEAD
/** Exercise: Parameterized Shift Register (Optional)

 Task: Write a shift register that is parameterized by its delay (n), its initial value (init), 
 and also has an enable input signal (en) */


package Example
import chisel3._
import chisel3.util



class MyOptionalShiftRegister(val n: Int, val init: BigInt = 1) extends Module {
  val io = IO(new Bundle {
    val en  = Input(Bool())
    val in  = Input(Bool())
    val out = Output(UInt(n.W))
  })

  val state = RegInit(init.U(n.W))

  ???
}

=======
/** Exercise: Parameterized Shift Register (Optional)

 Task: Write a shift register that is parameterized by its delay (n), its initial value (init), 
 and also has an enable input signal (en) */


package Example
import chisel3._
import chisel3.util



class MyOptionalShiftRegister(val n: Int, val init: BigInt = 1) extends Module {
  val io = IO(new Bundle {
    val en  = Input(Bool())
    val in  = Input(Bool())
    val out = Output(UInt(n.W))
  })

  val state = RegInit(init.U(n.W))

  ???
}

>>>>>>> 2470b12e854267816f114c9310741525f95e858b
