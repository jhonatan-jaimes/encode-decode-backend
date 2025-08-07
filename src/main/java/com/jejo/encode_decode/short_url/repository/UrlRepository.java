package com.jejo.encode_decode.short_url.repository;

import com.jejo.encode_decode.short_url.entity.UrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlRepository extends JpaRepository<UrlEntity, Long> {
    Optional<UrlEntity> findByUrlShort(String urlShort);
    boolean existsByUrlShort(String urlShort);
}
