;buildInfoPackage: chisel3, version: 3.1.8, scalaVersion: 2.11.12, sbtVersion: 1.1.1, builtAtString: 2019-07-08 17:44:42.884, builtAtMillis: 1562607882884
circuit MyModule : 
  module MyModule : 
    input clock : Clock
    input reset : UInt<1>
    output io : {flip in : UInt<4>, out : UInt<4>}
    
    node _T_11 = add(UInt<1>("h01"), UInt<1>("h01")) @[MyModule.scala 16:18]
    node utwo = tail(_T_11, 1) @[MyModule.scala 16:18]
    io.out <= io.in @[MyModule.scala 19:10]
    
