package org.acme.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.acme.model.Post;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import io.quarkus.panache.common.Sort;

@ApplicationScoped
public class PostRepository implements PanacheMongoRepository<Post> {
    
    public Post findByTitle(String title) {
        return find("title", title).firstResult();
    }

    public List<Post> findOrderedTitle() {
        return listAll(Sort.by("title"));
    }

    public List<Post> listByTitle(String title) {
        return list("title", title);
    }

}
