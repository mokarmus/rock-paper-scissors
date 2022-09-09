package ice.mobbin.session

object PasswordValidator {

  def validate(input: String): ValidationResult = {
    val result = Seq(inputLengthValidation, digitValidation ).flatMap(validation => validation(input)).mkString("\n")
    
    if (result.isEmpty) ValidationResult(true, None)
    else ValidationResult(false, Some(result))
  }
  
  val inputLengthValidation: String => Option[String] = input =>  if(input.length < 8) Some("Password must be at least 8 characters") else None
  
  val digitValidation: String => Option[String] = input => if (input.count(_.isDigit) < 2) Some("The password must contain at least 2 numbers") else None
}



case class ValidationResult(isValid:Boolean, validationError: Option[String])



