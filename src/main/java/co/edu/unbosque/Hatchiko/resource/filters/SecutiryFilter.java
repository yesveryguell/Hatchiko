/**
 * Connection resource co.edu.unbosque with bundle and filters
 */
package co.edu.unbosque.Hatchiko.resource.filters;

import co.edu.unbosque.Hatchiko.services.UserAppService;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import java.io.IOException;
import java.util.*;

/**
 * This class filters and authenticates any user
 */

/**
 * is used for anything that is of interest to the JAX-RS runtime, such as MessageBodyReader and MessageBodyWriter.
 */
@Provider
/**
 * you can annotate any class with a record annotation to allow lombok to generate a record field.
 */
@Logged
//@PreMatching
/**
 * The security filter class is initialized, which implements the container request filter.
 */
public class SecutiryFilter implements ContainerRequestFilter {
    /**
     * String type attribute of name Authorization private static final int is created which will remain in memory for the life of that application
     */
    private static final String AUTHORIZATION_HEADER_KEY = "Authorization";
    /**
     * String type attribute of name Basic private static final int is created which will remain in memory for the life of that application
     */
    private static final String AUTHORIZATION_HEADER_PREFIX = "Basic ";

    /**
     * informs the compiler that the element is meant to override an element declared in a superclass.
     * @param requestContext requestContext!= null, requestContext!=" "
     * @throws IOException
     */
    @Override
    /**
     * It is responsible for filtering the information according to the role of each user
     */
    public void filter(ContainerRequestContext requestContext) throws IOException {

        try {

            List<String> authHeader = requestContext.getHeaders().get(AUTHORIZATION_HEADER_KEY);

            if (authHeader.size() > 0) {

                // Extracting credentials from header
                String authToken = authHeader.get(0);
                authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");
                String decodedString = new String(Base64.getDecoder().decode(authToken));
                StringTokenizer tokenizer = new StringTokenizer(decodedString, ":");
                String username = tokenizer.nextToken();
                String password = tokenizer.nextToken();

                // Validating credentials
                Optional<String> role = new UserAppService().validateUser(username, password);
                if(role.isPresent()) {
                    requestContext.getHeaders().add("role", role.get());
                    return;
                } else {
                    requestContext.abortWith(Response
                            .status(Response.Status.UNAUTHORIZED)
                            .entity("Invalid credentials")
                            .build());
                }

            } else {

            }

        } catch (NullPointerException e) {
            requestContext.abortWith(Response
                    .status(Response.Status.UNAUTHORIZED)
                    .entity("Credentials not provided")
                    .build());
        }

    }

}
