package ice.mobbin.session

object PasswordValidator {

  def validate(input: String): ValidationResult = {
    if(input.length < 8) return ValidationResult(false, Some("Password must be at least 8 characters"))
    ValidationResult(true, None)
  }
  
  
}

case class ValidationResult(isValid:Boolean, validationError: Option[String])
