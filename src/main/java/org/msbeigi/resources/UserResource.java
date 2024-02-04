package org.msbeigi.resources;

import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.ResponseStatus;
import org.msbeigi.model.User;
import org.msbeigi.services.UserService;

import java.util.List;


@Path("/api/v1/users")
public class UserResource {

  @Inject
  private UserService userService;

  @GET
  public Uni<List<User>> get() {
    return userService.list();
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @ResponseStatus(201)
  public Uni<User> create(User user) {
    return userService.create(user);
  }

  @GET
  @Path("{id}")
  public Uni<User> get(@PathParam("id") long id) {
    return userService.findById(id);
  }

  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Path("{id}")
  public Uni<User> update(@PathParam("id") long id, User user) {
    user.id = id;
    return userService.update(user);
  }

  @DELETE
  @Path("{id}")
  public Uni<Void> delete(@PathParam("id") long id) {
    return userService.delete(id);
  }

  @GET
  @Path("self")
  public Uni<User> getCurrentUser() {
    return userService.getCurrentUser();
  }

}