package ice.mobbin.session

object StringCalculator {
  
  def add(input: String): Int = input match {
    case "" => 0
    case _ => input.split(",").map(_.toInt).sum
  }

}
