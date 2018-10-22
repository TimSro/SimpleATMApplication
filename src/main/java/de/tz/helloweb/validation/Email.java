package de.tz.helloweb.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = { EmailValidator.class })
public @interface Email {

    /**
     * Die Standardfehlermeldung.
     */
    String message() default "Die eingegebenen Zeichen sind in unserem Zeichensatz nicht zulässig. Bitte verwenden Sie nur zulässige Zeichen.";


    /**
     * Die Gruppen, in der die Validierung läuft.
     */
    Class<?>[] groups() default {};

    /**
     * Payload.
     */
    Class<? extends Payload>[] payload() default {};

}
