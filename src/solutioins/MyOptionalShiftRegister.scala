solution for  Parameterized Shift Register (Optional):
 
 / init state to init
class MyOptionalShiftRegister(val n: Int, val init: BigInt = 1) extends Module {
  val io = IO(new Bundle {
    val en  = Input(Bool())
    val in  = Input(Bool())
    val out = Output(UInt(n.W))
  })

  val state = RegInit(init.U(n.W))

   val nextState = (state << 1) | io.in
  when (io.en) {
    state  := nextState
  }
  io.out := state
}
