package com.nitrousoxide.combinatorpattern;
import com.nitrousoxide.combinatorpattern.CustomRegistrationValidator.ValidationResult;

import static com.nitrousoxide.combinatorpattern.CustomRegistrationValidator.ValidationResult.SUCCESS;
import static com.nitrousoxide.combinatorpattern.CustomRegistrationValidator.isAnAdult;
import static com.nitrousoxide.combinatorpattern.CustomRegistrationValidator.isPhoneNumberValid;;

public class CombinatorPattern {
    public static void main(String[] args) {
        Customer customer = new Customer(
                "Alice",
                "alice@gmail.com",
                "+0898787879878",
                19
        );

        ValidationResult result = CustomRegistrationValidator.
                isEmailValid().
                and(isPhoneNumberValid()).
                and(isAnAdult()).
                apply(customer);

        if(result != SUCCESS) {
            throw new IllegalStateException(result.name());
        }
        else System.out.println("Validation passed.");
    }
}
