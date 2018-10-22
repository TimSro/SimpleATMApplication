package de.tz.helloweb.validation;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Validator;

public class EmailValidator implements ConstraintValidator<Postleitzahl, String> {
	
	Validator validator;

    private static Collection<String> plzs = new Vector<>();

    @Override
    public void initialize(Postleitzahl constraintAnnotation) {
    	
    }

    private static void initializePlzVektor() {
        plzs.add("^[_A-Za-z0-9-+]+(.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(.[A-Za-z0-9]+)*(.[A-Za-z]{2,})$"); 
    }

 

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        initializePlzVektor();
        return Optional.ofNullable(plzs)
                       .orElse(Collections.emptySet())
                       .stream()
                       .anyMatch(e -> Pattern.matches(e, Optional.ofNullable(value).orElse("")));
    }
 
}
