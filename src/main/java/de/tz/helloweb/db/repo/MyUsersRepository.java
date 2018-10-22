package de.tz.helloweb.db.repo;

import de.tz.helloweb.db.model.MyUsers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyUsersRepository extends CrudRepository<MyUsers, Long> {
    List<MyUsers> findByName(String name);
}
