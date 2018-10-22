package de.tz.helloweb.validation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
 
import javax.validation.Constraint;
import javax.validation.Payload;

/**
* Created by TimZapka on 06.02.18.
*/

 
@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = { PostleitzahlValidator.class })
@Repeatable(value = Postleitzahl.Postleitzahlen.class)
public @interface Postleitzahl {

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

    @Target({ METHOD, FIELD, ANNOTATION_TYPE })
    @Retention(RUNTIME)
    @interface Postleitzahlen {
        Postleitzahl[] value();
    }
}