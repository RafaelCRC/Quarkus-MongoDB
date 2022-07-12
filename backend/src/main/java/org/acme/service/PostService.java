package org.acme.service;

import org.acme.model.Post;
import io.quarkus.mongodb.panache.PanacheMongoRepository;

import javax.enterprise.context.RequestScoped;

//this will not be used by front, but by the endpoints
//this can communicate with db?
//maybe getting user id in endpoint and putting here...
@RequestScoped
public class PostService implements PanacheMongoRepository<Post> {
    
    public Post addNewPost(Post newPost) {
        newPost.setDate((java.time.LocalDate.now()).toString());
        newPost.setActive(true);

        persist(newPost);
        return newPost;
    }

}
