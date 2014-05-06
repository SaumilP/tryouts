package org.saumil.models;

import org.hibernate.validator.constraints.URL;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by saumil on 2014/04/25.
 */
@Entity
public class User {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 45)
    private String name;

    @Size(max = 50)
    private String email;

    @Size(max = 200)
    private String description;

    @Size(max = 100)
    @URL
    private String webAddr;

    public User(long id, String name, String email, String description,
                String webAddr){
        this.id = id;
        this.name = name;
        this.email = email;
        this.description = description;
        this.webAddr = webAddr;
    }

    public String getWebAddr() {
        return webAddr;
    }

    public void setWebAddr(String webAddr) {
        this.webAddr = webAddr;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
