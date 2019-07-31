//Exercise: Neural Network Neuron
/**Task:- Complete the following exercises to practice writing functions, using them as arguments to hardware generators,
 and avoiding mutable data
 */
package Example

import chisel3._
import chisel3.util._


class Neuron(inputs: Int, act: FixedPoint => FixedPoint) extends Module {
  val io = IO(new Bundle {
    val in      = Input(Vec(inputs, FixedPoint(16.W, 8.BP)))
    val weights = Input(Vec(inputs, FixedPoint(16.W, 8.BP)))
    val out     = Output(FixedPoint(16.W, 8.BP))
  })
  
  ???
}
