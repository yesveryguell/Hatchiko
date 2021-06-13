/**
 * Connection resource co.edu.unbosque with bundle and filters
 */
package co.edu.unbosque.Hatchiko.resource.filters;

import javax.ws.rs.NameBinding;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * Refers to authenticating and updating a user
 */

/**
 * Meta-annotation used to create name binding annotations for filters and interceptors.
 */
@NameBinding
/**
 * Indicates the contexts in which an annotation type is applicable
 */
@Target({ ElementType.TYPE, ElementType.METHOD })
/**
 * Indicates how long annotations with the annotated type are to be retained
 */
@Retention(value = RetentionPolicy.RUNTIME)
/**
 * A public interface called log is created (the @interface element is used to declare an annotation)
 */
public @interface Logged {
}
