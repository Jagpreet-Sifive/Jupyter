package examples
import chisel3._



object HalfAdderMain extends App{

iotesters.Driver.execute(args, ()=> new HalfAdder{
 c=> new HalfAdderTester(c)
  }
}
