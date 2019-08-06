/** Example: Mux and Concatenation
      Cat :  ordering is MSB then LSB 
      Mux  : select, value if true, value if false
*/

package examples
 import chisel3._
 import chisel3.util.Cat

class MyOperatorsTwo extends Module {
  val io = IO(new Bundle {
    val in      = Input(UInt(4.W))
    val out_mux = Output(UInt(4.W))
    val out_cat = Output(UInt(4.W))
  })

  val s = true.B
  io.out_mux := Mux(s, 3.U, 0.U) 
  io.out_cat := Cat(2.U, 1.U)    
}

object MyOperatorsTwo extends App{
		chisel3.Driver.execute(args ,()=> new MyOperatorsTwo)
}
