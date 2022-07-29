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
    case Paper => SecondWins
    case Rock => Draw
    case Lizard => FirstWins
    case Spock => SecondWins
  }
}
object Scissors extends Gesture {
  override def compete(other: Gesture): RoundResult = other match {
     case Rock => SecondWins
     case Paper => FirstWins
     case Scissors => Draw
     case Spock => SecondWins
     case Lizard => FirstWins
  }
}

object Paper extends Gesture{
  override def compete(other: Gesture): RoundResult = other match {
    case Scissors => SecondWins
    case Rock => FirstWins
    case Paper => Draw
    case Lizard => SecondWins
    case Spock => FirstWins
  }
}

object Lizard extends Gesture{
  override def compete(other: Gesture): RoundResult = other match {
    case Lizard => Draw
    case Rock => SecondWins
    case Spock => FirstWins
    case Scissors => SecondWins
    case Paper => FirstWins
  }
}

object Spock extends Gesture{
  override def compete(other: Gesture): RoundResult = other match {
    case Spock => Draw
    case Lizard => SecondWins
    case Scissors => FirstWins
    case Paper => SecondWins
    case Rock => FirstWins
  }
}

trait RoundResult

object FirstWins extends RoundResult

object SecondWins extends RoundResult

object Draw extends RoundResult