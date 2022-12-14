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

    "return 3 when input is 1,2" in {
      StringCalculator.add("1,2") shouldBe 3
    }
    
    "handle the unknown number of arguments" in {
      StringCalculator.add("1,2,3,4") shouldBe 10
      StringCalculator.add("1,2,3,4,5") shouldBe 15
    }
    
    "handle the newlines as separators" in {
      StringCalculator.add("1,2\n3,4") shouldBe 10
    }

    "handle invalid separators" in {
      assertThrows[Throwable](StringCalculator.add("1,2,\n3,4"))
    }
    
    "do not allow a separator at the end" in {
      assertThrows[Throwable](StringCalculator.add("1,2,3,"))
      assertThrows[Throwable](StringCalculator.add("1,2,3\n"))
    }

    "handle other delimiters as a separator" in {
      StringCalculator.add("//;\n1;3") shouldBe 4
      StringCalculator.add("//sep\n2sep5") shouldBe 7
      StringCalculator.add("//|\n1|2|3") shouldBe 6
    }
    
  }

}
