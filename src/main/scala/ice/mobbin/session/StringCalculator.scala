package ice.mobbin.session

import java.security.InvalidParameterException

object StringCalculator {

  private val inputPattern = "(//)(.*)(\\n)(.*)".r
  
  def add(input: String): Int = input match {
    case "" => 0
    case invalid if invalid.matches(".*[,|\n]") => throw new InvalidParameterException()
    case inputPattern(_, separator, _, theRest) => 
      theRest.split(separator).filterNot(_ == separator).map(_.toInt).sum
    case _ => input.split("[,\n]").map(_.toInt).sum
  }

}
