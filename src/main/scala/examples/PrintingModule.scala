//The following code block shows different styles of printing.

package examples 
import chisel3._
import chisel3.util

class PrintingModule extends Module {
    val io = IO(new Bundle {
        val in = Input(UInt(4.W))

        val out = Output(UInt(4.W))
    })
    io.out := io.in

 
}

}
