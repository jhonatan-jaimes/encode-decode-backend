package com.jejo.encode_decode.short_url.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "urls")
public class UrlEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    private String hashShort;
    private String urlOrigin;

    public UrlEntity() {
    }

    public UrlEntity(Long id, String hashShort, String urlOrigin) {
        this.id = id;
        this.hashShort = hashShort;
        this.urlOrigin = urlOrigin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHashShort() {
        return hashShort;
    }

    public void setHashShort(String hashShort) {
        this.hashShort = hashShort;
    }

    public String getUrlOrigin() {
        return urlOrigin;
    }

    public void setUrlOrigin(String urlOrigin) {
        this.urlOrigin = urlOrigin;
    }

    
}
