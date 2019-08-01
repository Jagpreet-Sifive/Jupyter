<<<<<<< HEAD
/*Example: Optional Reset Matching*/
package examples

import chisel3._
import chisel3.util._ 

class DelayBy1RM(resetValue: Option[UInt] = None) extends Module {
    val io = IO(new Bundle {
        val in  = Input( UInt(16.W))
        val out = Output(UInt(16.W))
    })
    val reg = if (resetValue.isDefined) {
        RegInit(resetValue.get)
    } else { 
        Reg(UInt())
    }
    reg := io.in
    io.out := reg
}

=======
/*Example: Optional Reset Matching*/
package examples

import chisel3._
import chisel3.util._ 

class DelayBy1RM(resetValue: Option[UInt] = None) extends Module {
    val io = IO(new Bundle {
        val in  = Input( UInt(16.W))
        val out = Output(UInt(16.W))
    })
    val reg = if (resetValue.isDefined) {
        RegInit(resetValue.get)
    } else { 
        Reg(UInt())
    }
    reg := io.in
    io.out := reg
}

>>>>>>> 2470b12e854267816f114c9310741525f95e858b
