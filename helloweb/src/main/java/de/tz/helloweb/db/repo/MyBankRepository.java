package de.tz.helloweb.db.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.tz.helloweb.db.model.MyBank;

@Repository
public interface MyBankRepository extends CrudRepository<MyBank, Long> {
    List<MyBank> findByName(String name);

}
