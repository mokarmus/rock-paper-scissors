package ice.mobbin.session

import java.security.InvalidParameterException

object StringCalculator {
  
  def add(input: String): Int = input match {
    case "" => 0
    case invalid if invalid.matches(".*[,|\n]") => throw new InvalidParameterException()
    case _ => input.split(",|\n").map(_.toInt).sum
  }

}
