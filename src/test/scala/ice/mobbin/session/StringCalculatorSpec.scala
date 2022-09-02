package ice.mobbin.session

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class StringCalculatorSpec extends AnyWordSpec with Matchers{

  "String Calculatro" should {
    "return 0 when input in empty string" in {
      StringCalculator.add("") shouldBe 0
    }
  }

}
