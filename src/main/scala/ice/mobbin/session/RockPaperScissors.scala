package ice.mobbin.session

class RockPaperScissors {

  def playRound(g1: Gesture, g2: Gesture): RoundResult = g1.compete(g2)
}

sealed trait Gesture {
  def compete(other: Gesture): RoundResult
}

object Rock extends Gesture {
  override def compete(other: Gesture): RoundResult = other match {
    case Scissors => FirstWins
  }
}
object Scissors extends Gesture {
  override def compete(other: Gesture): RoundResult = other match {
     case Rock => SecondWins
     case Paper => FirstWins
  }
}

object Paper extends Gesture{
  override def compete(other: Gesture): RoundResult = other match {
    case Scissors => SecondWins
  }
}

trait RoundResult

object FirstWins extends RoundResult

object SecondWins extends RoundResult
