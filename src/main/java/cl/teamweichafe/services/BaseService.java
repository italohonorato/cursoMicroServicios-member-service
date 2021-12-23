package cl.teamweichafe.services;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface BaseService<T, ID extends Serializable> {

    default T save(T entity) {

        return getRepository().save(entity);
    }

    default void delete(ID id) {

        getRepository().deleteById(id);
    }

    default T get(ID id) {
        Optional<T> obj = getRepository().findById(id);

        if (obj.isPresent()) {
            return obj.get();
        }

        return null;
    }

    default List<T> getAll() {

        return getRepository().findAll();
    }

    MongoRepository<T, ID> getRepository();
}
