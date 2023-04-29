package com.nitrousoxide.combinatorpattern;

import java.util.function.Function;

import static com.nitrousoxide.combinatorpattern.CustomRegistrationValidator.*;

public interface CustomRegistrationValidator extends Function<Customer, ValidationResult> {

    enum ValidationResult {
        SUCCESS,
        PHONE_NUMBER_NOT_VALID,
        EMAIL_NOT_VALID,
        IS_NOT_AN_ADULT
    }

    static CustomRegistrationValidator isEmailValid() {
        return customer -> customer.getEmail().contains("@") ?
                ValidationResult.SUCCESS : ValidationResult.EMAIL_NOT_VALID;
    }

    static CustomRegistrationValidator isPhoneNumberValid() {
        return customer -> customer.getPhoneNumber().startsWith("+0") ?
                ValidationResult.SUCCESS : ValidationResult.PHONE_NUMBER_NOT_VALID;
    }

    static CustomRegistrationValidator isAnAdult() {
        return customer -> customer.getAge() > 18 ?
                ValidationResult.SUCCESS : ValidationResult.IS_NOT_AN_ADULT;
    }

    default CustomRegistrationValidator and(CustomRegistrationValidator other) {
        return customer -> {
            ValidationResult result = this.apply(customer);
            return result.equals(ValidationResult.SUCCESS) ? other.apply(customer) : result;
        };
    }
}