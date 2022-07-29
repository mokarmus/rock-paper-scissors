package ice.mobbin.session

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class RockPaperScissorsSpec extends AnyWordSpec with Matchers {

  var rockPaperScissors: RockPaperScissors = new RockPaperScissors
  "As a player" should {
    
    "I want rock to beat scissors" in {
    rockPaperScissors.playRound(Rock, Scissors) shouldBe FirstWins
    rockPaperScissors.playRound(Scissors, Rock) shouldBe SecondWins
  } 
    
  "I want scissors to beat paper" in {
    rockPaperScissors.playRound(Scissors, Paper) shouldBe FirstWins
    rockPaperScissors.playRound(Paper, Scissors) shouldBe SecondWins
  }
  }

}
