/* Exercise: Finite State Machine */

package problems

import chisel3._
import chisel3.util

class GradLife extends Module {
  val io = IO(new Bundle {
    val state = Input(UInt(2.W))
    val coffee = Input(Bool())
    val idea = Input(Bool())
    val pressure = Input(Bool())
    val nextState = Output(UInt(2.W))
  })
    
  val idle :: coding :: writing :: grad :: Nil = Enum(4)
  
  io.nextState := idle
  ???
}

object  GradLife extends App{
     chisel3.Driver.execute(args, ()=> new   GradLife)
}
