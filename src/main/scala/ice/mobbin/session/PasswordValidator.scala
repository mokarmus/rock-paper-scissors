package ice.mobbin.session

object PasswordValidator {

  def validate(input: String): ValidationResult = {
    val validationResult = Seq(inputLengthValidation, digitValidation).flatMap(validation => validation(input)).mkString("\n")
    
    validationResult match {
      case "" => ValidationResult.valid
      case errors => ValidationResult.invalid(errors)
    }
  }
  
  val inputLengthValidation: String => Option[String] = input => if(input.length < 8) Some("Password must be at least 8 characters") else None
  
  val digitValidation: String => Option[String] = input => if (input.count(_.isDigit) < 2) Some("The password must contain at least 2 numbers") else None
  
}

case class ValidationResult(isValid:Boolean, validationError: Option[String])

object ValidationResult {
  
  def valid: ValidationResult = ValidationResult(isValid = true, None)
  
  def invalid(validationError: String): ValidationResult = ValidationResult(isValid = false, Some(validationError))
  
}



