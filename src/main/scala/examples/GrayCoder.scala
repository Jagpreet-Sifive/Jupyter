//Example: Gray Encoder and Decoder

package examples

import scala.math.pow
import chisel3._

class GrayCoder(bitwidth: Int) extends Module {
  val io = IO(new Bundle{
    val in = Input(UInt(bitwidth.W))
    val out = Output(UInt(bitwidth.W))
    val encode = Input(Bool()) 
  })
 
    io.out := io.in ^ (io.in >> 1.U)
  } .otherwise { 
    io.out := Seq.fill(log2Ceil(bitwidth))(Wire(UInt(bitwidth.W))).zipWithIndex.fold((io.in, 0)){
      case ((w1: UInt, i1: Int), (w2: UInt, i2: Int)) => {
        w2 := w1 ^ (w1 >> pow(2, log2Ceil(bitwidth)-i2-1).toInt.U)
        (w2, i1)
      }
    }._1
  }
}
object  GrayCoder extends App{
     chisel3.Driver.execute(args, ()=> new GrayCoder )
}
