package de.tz.helloweb.db.model;

import javax.persistence.*;

@Entity
public class MyUsers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String password;
    
    public long getId() {
        return id;
    }
}
