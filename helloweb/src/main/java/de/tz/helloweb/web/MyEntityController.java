package de.tz.helloweb.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import de.tz.helloweb.db.model.MyEntity;
import de.tz.helloweb.db.repo.MyEntityRepository;
import de.tz.helloweb.web.exception.MyEntityIdMismatchException;
import de.tz.helloweb.web.exception.MyEntityNotFoundException;

@RestController
@RequestMapping("/api/myentities")
public class MyEntityController {

    @Autowired
    private MyEntityRepository entityRepository;

    @GetMapping
    public Iterable<MyEntity> findAll() {
        return entityRepository.findAll();
    }

    @GetMapping("/name/{name}")
    public List<MyEntity> findByName(@PathVariable String name) {
        return entityRepository.findByName(name);
    }

    @GetMapping("/{id}")
    public MyEntity findOne(@PathVariable Long id) {
        return entityRepository.findById(id)
                               .orElseThrow(MyEntityNotFoundException::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MyEntity create(@RequestBody MyEntity entity) {
        return entityRepository.save(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        entityRepository.findById(id)
                        .orElseThrow(MyEntityNotFoundException::new);
        entityRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public MyEntity updateEntity(@RequestBody MyEntity entity, @PathVariable Long id) {
        if (entity.getId() != id) {
            throw new MyEntityIdMismatchException();
        }
        entityRepository.findById(id)
                        .orElseThrow(MyEntityNotFoundException::new);
        return entityRepository.save(entity);
    }
}