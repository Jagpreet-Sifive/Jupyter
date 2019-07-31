// 
 /*Task: Implement an integrator as pictured( in jupyter notebook ) below. 
     𝑛1  is the width of genReg and  𝑛2  is the width of genIn.*/
package Example
import chisel3._
import chisel3.util

class Integrator[T <: Data : Ring](genIn: T, genReg: T) extends Module {
    val io = IO(new Bundle {
        val in  = Input(genIn.cloneType)
        val out = Output(genReg.cloneType)
    })
    
    val reg = RegInit(genReg, Ring[T].zero) 
    reg := reg + io.in
    io.out := reg
}

