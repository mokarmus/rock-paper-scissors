package ice.mobbin.session

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class PasswordValidatorSpec extends AnyWordSpec with Matchers {
  
  "password validator" should {
    "state invalid when password is not 8 characters long" in {
      val samplePassword = "1234567"
      
      val expected = Invalid(isValid = false, "Password must be at least 8 characters")
      
      PasswordValidator.validate(samplePassword) shouldBe expected
    }
    
    "state valid password when it meets all requirements" in {
      val samplePassword = "12345678"

      val expected = Valid

      PasswordValidator.validate(samplePassword) shouldBe expected
    }

    "state invalid when password does not contain at least 2 digits" in {
      val samplePassword = "abcdefgh"

      val expected = Invalid(isValid = false, "The password must contain at least 2 numbers")

      PasswordValidator.validate(samplePassword) shouldBe expected
    }

    "state invalid and provide multiple errors when multiple requirements not met" in {
      val samplePassword = "abcdefg"

      val expected = Invalid(isValid = false,"Password must be at least 8 characters\nThe password must contain at least 2 numbers")

      PasswordValidator.validate(samplePassword) shouldBe expected
    }
  }
}
