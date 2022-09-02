package ice.mobbin.session

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class StringCalculatorSpec extends AnyWordSpec with Matchers{

  "String Calculator" should {
    "return 0 when input is empty string" in {
      StringCalculator.add("") shouldBe 0
    }
    
    "return 1 when input is 1" in {
      StringCalculator.add("1") shouldBe 1
    }
  }

}
