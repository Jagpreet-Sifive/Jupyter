solution for Neural Network Neuron: 

 

  class Neuron(inputs: Int, act: FixedPoint => FixedPoint) extends Module {
  val io = IO(new Bundle {
    val in      = Input(Vec(inputs, FixedPoint(16.W, 8.BP)))
    val weights = Input(Vec(inputs, FixedPoint(16.W, 8.BP)))
    val out     = Output(FixedPoint(16.W, 8.BP))
  })
  
 val mac = io.in.zip(io.weights).map{ case(a:FixedPoint, b:FixedPoint) => a*b}.reduce(_+_)
  io.out := act(mac)

}


solution for Tester :



Driver(() => new Neuron(2, Step)) {
  c => new PeekPokeTester(c) {
    
    val inputs = Seq(Seq(-1, -1), Seq(-1, 1), Seq(1, -1), Seq(1, 1))
    
    
   val weights  = Seq(1.0, 1.0)

   
   
    reset(5)
    for (i <- inputs) {
      pokeFixedPoint(c.io.in(0), i(0))
      pokeFixedPoint(c.io.in(1), i(1))
      pokeFixedPoint(c.io.weights(0), weights(0))
      pokeFixedPoint(c.io.weights(1), weights(1))
      expectFixedPoint(c.io.out, if (i(0) + i(1) > 0) 1 else 0, "ERROR")
      step(1)
    }
  }
}