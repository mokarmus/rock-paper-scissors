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

    "I want paper to beat rock" in {
      rockPaperScissors.playRound(Paper, Rock) shouldBe FirstWins
      rockPaperScissors.playRound(Rock, Paper) shouldBe SecondWins
    }
    
    "I want the same moves to draw" in {
      rockPaperScissors.playRound(Paper, Paper) shouldBe Draw
      rockPaperScissors.playRound(Rock, Rock) shouldBe Draw
      rockPaperScissors.playRound(Scissors, Scissors) shouldBe Draw
    }
    
  }

}
