package main.java.org.acme.knight;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import io.quarkus.panache.common.Sort;

import main.java.org.acme.Knight;

@ApplicationScoped
public class KnightRepository implements PanacheMongoRepository<Knight> {
    
    public Knight findByName(String name) {
        return find("name", name).firstResult();
    }

    public List<Knight> findOrderedName() {
        return listAll(Sort.by("name"));
    }

}
