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



}
