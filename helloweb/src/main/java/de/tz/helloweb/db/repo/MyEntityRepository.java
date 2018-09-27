package de.tz.helloweb.db.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.tz.helloweb.db.model.MyEntity;

@Repository
public interface MyEntityRepository extends CrudRepository<MyEntity, Long> {
    List<MyEntity> findByName(String name);
}