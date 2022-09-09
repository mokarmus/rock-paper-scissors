package ice.mobbin.session

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class PasswordValidatorSpec extends AnyWordSpec with Matchers {
  
  "password validator" should {
    "state invalid when password is not 8 characters long" in {
      val samplePassword = "1234567"
      
      val expected = ValidationResult(isValid = false, Some("Password must be at least 8 characters"))
      
      PasswordValidator.validate(samplePassword) shouldBe expected
    }
    
    "state valid password when it meets all requirements" in {
      val samplePassword = "12345678"

      val expected = ValidationResult(isValid = true, None)

      PasswordValidator.validate(samplePassword) shouldBe expected
    }
  }
}
