package ice.mobbin.session

import ice.mobbin.session.ValidationResult.{invalid, valid}

object PasswordValidator {

  def validate(input: String): ValidationResult = 
    Seq(inputLengthValidation, digitValidation)
      .map(validation => validation(input))
      .foldLeft(valid)(_ + _)
  
  val inputLengthValidation: String => ValidationResult = input => if(input.length < 8) invalid("Password must be at least 8 characters") else Valid
  
  val digitValidation: String => ValidationResult = input => if (input.count(_.isDigit) < 2) invalid("The password must contain at least 2 numbers") else Valid
  
}


trait ValidationResult {
  def +(other: ValidationResult): ValidationResult = (this, other) match {
    case (Valid, Valid) => Valid
    case (Invalid(_, message), Valid) => invalid(message)
    case (Valid, Invalid(_, message)) => invalid(message)
    case (Invalid(_, message1), Invalid(_, message2)) => invalid(s"$message1\n$message2")
  }
}

object Valid extends ValidationResult
case class Invalid(isValid:Boolean, validationError: String) extends ValidationResult


object ValidationResult {
  def invalid(validationError: String): ValidationResult = Invalid(isValid = false, validationError)
  
  def valid: ValidationResult = Valid
  
}



