/*Exercise: Sign-magnitude Numbers*/
/* Task Fill in implementations for + ,-, ^ and *  */

package problems
import chisel3._
import chisel3.util

class SignMagnitude(val magnitudeWidth: Option[Int] = None) extends Bundle {
    val sign = Bool()
    val magnitude = magnitudeWidth match {
        case Some(w) => UInt(w.W)
        case None    => UInt()
    }
    def +(that: SignMagnitude): SignMagnitude = {
        
    }
    def -(that: SignMagnitude): SignMagnitude = {
        this.+(-that)
    }
    def unary_-(): SignMagnitude = {
        val result = Wire(new SignMagnitude())
        result.sign := !this.sign
        result.magnitude := this.magnitude
        result
    }
    def *(that: SignMagnitude): SignMagnitude = {
        
    }
    override def cloneType: this.type = new SignMagnitude(magnitudeWidth).asInstanceOf[this.type]
}
trait SignMagnitudeRing extends Ring[SignMagnitude] {
    def plus(f: SignMagnitude, g: SignMagnitude): SignMagnitude = {
        f + g
    }
    def times(f: SignMagnitude, g: SignMagnitude): SignMagnitude = {
        f * g
    }
    def one: SignMagnitude = {
        val one = Wire(new SignMagnitude(Some(1)))
        one.sign := false.B
        one.magnitude := 1.U
        one
    }
    def zero: SignMagnitude = {
        val zero = Wire(new SignMagnitude(Some(0)))
        zero.sign := false.B
        zero.magnitude := 0.U
        zero
    }
    def negate(f: SignMagnitude): SignMagnitude = {
        -f
    }
    
    
    def minusContext(f: SignMagnitude, g: SignMagnitude): SignMagnitude = ???
    def negateContext(f: SignMagnitude): SignMagnitude = ???
    def plusContext(f: SignMagnitude,g: SignMagnitude): SignMagnitude = ???
    def timesContext(f: SignMagnitude,g: SignMagnitude): SignMagnitude = ???

implicit object SignMagnitudeRingImpl extends SignMagnitudeRing
}

object SignMagnitude  extends App{
     chisel3.Driver.execute(args, ()=> new  SignMagnitude)
}
