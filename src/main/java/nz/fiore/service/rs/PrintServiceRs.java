package nz.fiore.service.rs;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@Path("/print")
public class PrintServiceRs {

    @ConfigProperty(name = "flower.name")
    Optional<String> name;

    @ConfigProperty(name = "flower.message")
    Optional<String> message;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return message.orElse("hello") + " " + name.orElse("print");
    }
}
