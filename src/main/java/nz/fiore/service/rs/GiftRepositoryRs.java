package nz.fiore.service.rs;

import nz.fiore.model.Gift;
import nz.fiore.repository.GiftRepository;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/gifts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GiftRepositoryRs {

    @Inject
    GiftRepository giftRepository;


    @Inject
    Event<Gift> giftEventFire;


    @GET
    @Path("/{id}")
    public Gift get(@PathParam("id") @NotNull Long id) {
        return giftRepository.find(id);
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") @NotNull Long id) {
        giftRepository.delete(id);
        return Response.ok().build();
    }

    @GET
    public Response list() {
        List<Gift> list = giftRepository.list();
        return Response.ok(list).build();
    }

    @POST
    @Path("/")
    public Gift create(Gift gift) {
        giftEventFire.fire(gift);
        return giftRepository.persist(gift);
    }

    @PUT
    @Path("/{id}")
    public Gift update(@PathParam("id") @NotNull Long id, Gift gift) throws Exception {
        if (id.equals(gift.id)) {
            return giftRepository.update(gift);
        }
        throw new Exception("id is different from gift id");
    }


}
