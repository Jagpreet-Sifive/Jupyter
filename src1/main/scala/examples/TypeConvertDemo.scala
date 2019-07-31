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

