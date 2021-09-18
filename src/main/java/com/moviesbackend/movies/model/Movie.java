package com.moviesbackend.movies.model;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Movie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column --> indica a la columna que una vez creada el id no puede ser actualizada
    @Column(nullable = false, updatable = false)
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String title;

    @Getter @Setter
    private String description;

    @Getter @Setter
    private String duration;

    @Getter @Setter
    private String imageUrl;

    public Movie(){}

    public Movie(Long id, String title, String description, String duration, String imageUrl) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.imageUrl = imageUrl;
    }
}
