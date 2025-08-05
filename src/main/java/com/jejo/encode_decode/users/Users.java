package com.jejo.encode_decode.users;

import com.jejo.encode_decode.short_url.entity.UrlEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    private String username;
    private String password;

    @OneToMany
    @JoinColumn(name = "tipo_id")
    private UrlEntity urlEntity;

    public Users() {
    }

    public Users(Long id, String username, String password, UrlEntity urlEntity) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.urlEntity = urlEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UrlEntity getUrlShort() {
        return urlEntity;
    }

    public void setUrlShort(UrlEntity urlEntity) {
        this.urlEntity = urlEntity;
    }
}
