package ice.mobbin.session

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class RockPaperScissorsSpec extends AnyWordSpec with Matchers {

  var rockPaperScissors: RockPaperScissors = new RockPaperScissors
  "As a player" +
    "I want rock to beat scissors" +
    "So that I can play with rules I'm familiar with" in {
    rockPaperScissors.playRound(Rock, Scissors) shouldBe FirstWins
    rockPaperScissors.playRound(Scissors, Rock) shouldBe SecondWins

  }

}
