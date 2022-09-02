package ice.mobbin.session

object StringCalculator {
  
  def add(input: String): Int = input match {
    case "" => 0
    case "1" => 1
    case _ => ???
  }

}
