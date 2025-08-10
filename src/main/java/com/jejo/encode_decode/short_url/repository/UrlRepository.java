package com.jejo.encode_decode.short_url.repository;

import com.jejo.encode_decode.short_url.entity.UrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlRepository extends JpaRepository<UrlEntity, Long> {

    // Creacion de busqueda de un hash en la base de datos.
    Optional<UrlEntity> findByUrlShort(String urlShort);

    // Metodo para ver si el hash ya existe en la base de datos.
    boolean existsByUrlShort(String urlShort);
}
