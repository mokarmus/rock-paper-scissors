package ice.mobbin.session

class RockPaperScissors {

  def playRound(g1: Gesture, g2: Gesture): RoundResult = ???
}

trait Gesture

object Rock extends Gesture

object Scissors extends Gesture

trait RoundResult

object FirstWins extends RoundResult

object SecondWins extends RoundResult
