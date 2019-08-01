<<<<<<< HEAD
/* Exercise: Mac as Object */

/* Task: Implement an apply method in the Mac companion object below that implements 
        the Mac functionality */

package problems 

 import chisel3._
 import chisel3.util._



object Mac {
    def apply[T <: Data : Ring](a: T, b: T, c: T): T = {
    }
}

class MacTestModule extends Module {
    val io = IO(new Bundle {
        val uin = Input(UInt(4.W))
        val uout = Output(UInt())
        val sin = Input(SInt(4.W))
        val sout = Output(SInt())
        
    })
    
    io.uout := Mac(io.uin, io.uin, io.uin)
    io.sout := Mac(io.sin, io.sin, io.sin)
   
}

=======
/* Exercise: Mac as Object */

/* Task: Implement an apply method in the Mac companion object below that implements 
        the Mac functionality */

package problems 

 import chisel3._
 import chisel3.util._



object Mac {
    def apply[T <: Data : Ring](a: T, b: T, c: T): T = {
    }
}

class MacTestModule extends Module {
    val io = IO(new Bundle {
        val uin = Input(UInt(4.W))
        val uout = Output(UInt())
        val sin = Input(SInt(4.W))
        val sout = Output(SInt())
        
    })
    
    io.uout := Mac(io.uin, io.uin, io.uin)
    io.sout := Mac(io.sin, io.sin, io.sin)
   
}

>>>>>>> 2470b12e854267816f114c9310741525f95e858b
