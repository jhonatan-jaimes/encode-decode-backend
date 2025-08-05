package com.jejo.encode_decode.short_url.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "urls")
public class UrlEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    private String urlShort;
    private String urlOrigin;

    public UrlEntity() {
    }

    public UrlEntity(Long id, String urlShort, String urlOrigin) {
        this.id = id;
        this.urlShort = urlShort;
        this.urlOrigin = urlOrigin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrlShort() {
        return urlShort;
    }

    public void setUrlShort(String urlShort) {
        this.urlShort = urlShort;
    }

    public String getUrlOrigin() {
        return urlOrigin;
    }

    public void setUrlOrigin(String urlOrigin) {
        this.urlOrigin = urlOrigin;
    }
}
