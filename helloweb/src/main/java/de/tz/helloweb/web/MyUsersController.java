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

import de.tz.helloweb.db.model.MyUsers;
import de.tz.helloweb.db.repo.MyUsersRepository;
import de.tz.helloweb.web.exception.MyEntityIdMismatchException;
import de.tz.helloweb.web.exception.MyEntityNotFoundException;

@RestController
@RequestMapping("/api/myusers")
public class MyUsersController {
	
	@Autowired
    private MyUsersRepository usersRepository;

    @GetMapping
    public Iterable<MyUsers> findAll() {
        return usersRepository.findAll();
    }

    @GetMapping("/name/{name}")
    public List<MyUsers> findByName(@PathVariable String name) {
        return usersRepository.findByName(name);
    }

    @GetMapping("/{id}")
    public MyUsers findOne(@PathVariable Long id) {
        return usersRepository.findById(id)
                               .orElseThrow(MyEntityNotFoundException::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MyUsers create(@RequestBody MyUsers user) {
        return usersRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        usersRepository.findById(id)
                        .orElseThrow(MyEntityNotFoundException::new);
        usersRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public MyUsers updateUsers(@RequestBody MyUsers user, @PathVariable Long id) {
        if (user.getId() != id) {
            throw new MyEntityIdMismatchException();
        }
        usersRepository.findById(id)
                        .orElseThrow(MyEntityNotFoundException::new);
        return usersRepository.save(user);
    }
}
