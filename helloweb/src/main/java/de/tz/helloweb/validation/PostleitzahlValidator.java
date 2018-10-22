package de.tz.helloweb.validation;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Validator;

public class PostleitzahlValidator implements ConstraintValidator<Postleitzahl, String> {
	
	Validator validator;

    private static Collection<String> plzs = new Vector<>();

    @Override
    public void initialize(Postleitzahl constraintAnnotation) {
    	
    }

    private static void initializePlzVektor() {
        plzs.add("[0-9]{3,8}");
        plzs.add("[A-Z]{1,2}[0-9]{3}");
        plzs.add("[A-Z]{2}[0-9]{4}");
        plzs.add("[0-9]{2,4}[//-][0-9]{3}");
        plzs.add("[0-9]{3}[//-][0-9]{4}");
        plzs.add("[0-9]{5}[//-][0-9]{3}");
        plzs.add("[0-9]{3}[ ][0-9]{2}");
        plzs.add("[0-9]{4}[ ][A-Z]{2}");
        plzs.add("[A-Z][0-9][ ][0-9][A-Z]{2}");
        plzs.add("[A-Z][0-9][A-Z][ ][0-9][A-Z][0-9]?");
        plzs.add("[A-Z][0-9][A-Z][ ][0-9][A-Z]{2}");
        plzs.add("[A-Z][0-9]{2}[ ][0-9][A-Z]{2}");
        plzs.add("[A-Z]{2}[0-9][ ][0-9][A-Z]{2}");
        plzs.add("[A-Z]{2}[0-9]{1,2}[ ][0-9][A-Z]{2}");
        plzs.add("[A-Z]{2}[0-9][A-Z][ ][0-9][A-Z]{2}");
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