<<<<<<< HEAD
/* Exercise: Finite State Machine */

package Example
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
=======
/* Exercise: Finite State Machine */

package Example
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
>>>>>>> 2470b12e854267816f114c9310741525f95e858b
