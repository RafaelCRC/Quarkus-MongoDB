package org.acme.endpoint;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.Produces;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


import org.acme.model.Post;
import org.acme.repository.PostRepository;
import org.acme.service.PostService;
import org.bson.types.ObjectId;

@Path("/posts")
public class PostEndpoint {
    
    @Inject
    PostRepository repository;

    @Inject
    PostService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        return Response.status(Status.OK).entity(repository.listAll()).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") String id) {
        Post post = repository.findById(new ObjectId(id));
        return post != null ? Response.status(Response.Status.OK).entity(post).build()
        : Response.status(Status.NOT_FOUND).build();
    }

    @GET
    @Path("/search/{title}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response search(@PathParam("title") String title) {
        List<Post> posts = repository.listByTitle(title);
        return posts != null ? Response.status(Response.Status.OK).entity(posts).build()
                : Response.status(Status.NOT_FOUND).entity(repository.listAll()).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Post newPost) throws URISyntaxException {
        Post post = service.addNewPost(newPost);
        return Response.status(Response.Status.CREATED).entity(post).build();
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") String id, Post post) {
        post.id = new ObjectId(id);
        repository.update(post);
        return Response.status(Response.Status.OK).entity(post).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") String id) {
        Post post = repository.findById(new ObjectId(id));
        repository.delete(post);
        return Response.status(Status.OK).entity(post).build();
    }

}
