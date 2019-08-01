/** Exercise: Parameterized Shift Register (Optional)

 Task: Write a shift register that is parameterized by its delay (n), its initial value (init), 
 and also has an enable input signal (en) */


package problems
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
 object MyOptionalShiftRegister  extends App{
     chisel3.Driver.execute(args, ()=> new MyOptionalShiftRegister)
}
