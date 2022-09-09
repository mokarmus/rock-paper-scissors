package ice.mobbin.session

object PasswordValidator {

  def validate(input: String): ValidationResult = ???
  
  
}

case class ValidationResult(isValid:Boolean, validationError: Option[String])
