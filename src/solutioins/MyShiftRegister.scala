solution for ShiftRegister: 

class MyShiftRegister(val init: Int = 1) extends Module {
  val io = IO(new Bundle {
    val in  = Input(Bool())
    val out = Output(UInt(4.W))
  })

  val state = RegInit(UInt(4.W), init.U)
 
  val nextState = (state << 1) | io.in
  state := nextState
  io.out := state
  

}
