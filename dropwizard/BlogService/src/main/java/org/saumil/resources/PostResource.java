package org.saumil.resources;

/**
 * Created by saumil on 2014/04/25.
 */

import com.google.inject.Inject;
import org.saumil.models.Post;
import org.saumil.repository.PostDao;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/post")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PostResource {

    private final PostDao postDao;

    @Inject
    public PostResource(final PostDao dao){
        this.postDao = dao;
    }

    @GET
    @Path("/{id}")
    public Post getPost(@PathParam("id")long id){
        return postDao.getById(id);
    }

    @POST
    public Post addPost(@Valid Post post){
        return postDao.save(post);
    }
}
