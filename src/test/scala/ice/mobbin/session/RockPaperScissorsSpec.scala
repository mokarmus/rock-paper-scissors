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
      rockPaperScissors.playRound(Lizard, Lizard) shouldBe Draw
      rockPaperScissors.playRound(Spock, Spock) shouldBe Draw
    }

    "Rock crushes Lizard" in {
      rockPaperScissors.playRound(Rock, Lizard) shouldBe FirstWins
      rockPaperScissors.playRound(Lizard, Rock) shouldBe SecondWins
    }

    "Lizard poisons Spock" in {
      rockPaperScissors.playRound(Spock, Lizard) shouldBe SecondWins
      rockPaperScissors.playRound(Lizard, Spock) shouldBe FirstWins
    }

    "Spock smashes Scissors" in {
      rockPaperScissors.playRound(Spock, Scissors) shouldBe FirstWins
      rockPaperScissors.playRound(Scissors, Spock) shouldBe SecondWins
    }

    "Scissors decapitates Lizard" in {
      rockPaperScissors.playRound(Lizard, Scissors) shouldBe SecondWins
      rockPaperScissors.playRound(Scissors, Lizard) shouldBe FirstWins
    }

    "Lizard eats Paper" in {
      rockPaperScissors.playRound(Lizard, Paper) shouldBe FirstWins
      rockPaperScissors.playRound(Paper, Lizard) shouldBe SecondWins
    }

    "Paper disproves Spock" in {
      rockPaperScissors.playRound(Spock, Paper) shouldBe SecondWins
      rockPaperScissors.playRound(Paper, Spock) shouldBe FirstWins
    }

    "Spock vaporizes Rock" in {
      rockPaperScissors.playRound(Rock, Spock) shouldBe SecondWins
      rockPaperScissors.playRound(Spock, Rock) shouldBe FirstWins
    }
    
  }

}
