 // Example circuit  UIntToOH  OneHot  chisel Utility. 
package examples

import chisel3.util.OntHOt
import chisel3.util

class Onehot extends Module{
   
    val io = IO(new Bundle {
      val in = Input(UInt(4.W))
      val out = Output(UInt(16.W))
    })
    io.out := UIntToOH(io.in)
  }
  
