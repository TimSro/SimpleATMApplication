package de.tz.helloweb.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MyBank {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = true)
    private String name;
    
    @Column(nullable = false)
    private String creditline;

	public long getId() {
		return id;
	}


	public String getName() {
		return name;
	}

	public String getCreditline() {
		return creditline;
	}
    
}
