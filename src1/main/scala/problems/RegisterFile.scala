<<<<<<< HEAD
/* Exercise: 32-bit RISC-V Processor ..*/
/**  Task:Implement a register file for RV32I with a single write port and a paramterized number of read ports.
         Writes will only be performed when wen (write enable) is asserted. */

package problems

import chisel3._
import chisel3.util._


class RegisterFile(readPorts: Int) extends Module {
    require(readPorts >= 0)
    val io = IO(new Bundle {
        val wen   = Input(Bool())
        val waddr = Input(UInt(5.W))
        val wdata = Input(UInt(32.W))
        val raddr = Input(Vec(readPorts, UInt(5.W)))
        val rdata = Output(Vec(readPorts, UInt(32.W)))
    })
    
  
    val reg = RegInit(VecInit(Seq.fill(32)(0.U(32.W))))

}

=======
/* Exercise: 32-bit RISC-V Processor ..*/
/**  Task:Implement a register file for RV32I with a single write port and a paramterized number of read ports.
         Writes will only be performed when wen (write enable) is asserted. */

package problems

import chisel3._
import chisel3.util._


class RegisterFile(readPorts: Int) extends Module {
    require(readPorts >= 0)
    val io = IO(new Bundle {
        val wen   = Input(Bool())
        val waddr = Input(UInt(5.W))
        val wdata = Input(UInt(32.W))
        val raddr = Input(Vec(readPorts, UInt(5.W)))
        val rdata = Output(Vec(readPorts, UInt(32.W)))
    })
    
  
    val reg = RegInit(VecInit(Seq.fill(32)(0.U(32.W))))

}

>>>>>>> 2470b12e854267816f114c9310741525f95e858b
