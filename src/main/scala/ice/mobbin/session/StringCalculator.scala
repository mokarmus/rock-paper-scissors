package ice.mobbin.session

import java.security.InvalidParameterException

object StringCalculator {
  
  type Delimiter = String
  type InputString = String

  private val inputPattern = "(//)(.*)(\\n)(.*)".r
  
  def add(input: String): Int = {
    
    
    
    
    
    input match {
      case "" => 0
      case invalid if invalid.matches(".*[,|\n]") => throw new InvalidParameterException()
      case inputPattern(_, separator, _, theRest) =>
        theRest.split(separator).filterNot(_ == separator).map(_.toInt).sum
      case _ => input.split("[,\n]").map(_.toInt).sum
    }
  }
  

  private def findDelimiter(input: String): (Delimiter, InputString) = input match {
    case inputPattern(_, separator, _, theRest) => (separator, theRest)
    case _ => ("[,\n]", input)
  }
  
  
}
