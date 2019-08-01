<<<<<<< HEAD
// Example: Type Casting in Chisel.

package examples 

import chisel3._

class TypeConvertDemo extends Module {
    val io = IO(new Bundle {
        val in  = Input(UInt(4.W))
        val out = Output(SInt(4.W))
    })
    io.out := io.in //.asTypeOf(io.out)
}

=======
// Example: Type Casting in Chisel.

package examples 

import chisel3._

class TypeConvertDemo extends Module {
    val io = IO(new Bundle {
        val in  = Input(UInt(4.W))
        val out = Output(SInt(4.W))
    })
    io.out := io.in //.asTypeOf(io.out)
}

>>>>>>> 2470b12e854267816f114c9310741525f95e858b
