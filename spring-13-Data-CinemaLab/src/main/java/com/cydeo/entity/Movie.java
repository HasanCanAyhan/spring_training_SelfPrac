package com.cydeo.entity;


import com.cydeo.enums.MovieState;
import com.cydeo.enums.MovieType;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
//@Data
@Getter
@Setter
@NoArgsConstructor
public class Movie extends BaseEntity {

    private String name;
    @Column(columnDefinition = "DATE")
    private LocalDate releaseDate;
    private Integer duration;
    @Column(columnDefinition = "text")
    private String summary;
    @Enumerated(EnumType.STRING)
    private MovieType type;
    @Enumerated(EnumType.STRING)
    private MovieState state;
    private BigDecimal price;

    //One Movie has many genre
    //A movie can have multiple genres and a genre can be applied to multiple movies too.
    //So it is a business logic
    @ManyToMany(fetch = FetchType.EAGER )
    @JoinTable(name = "movie_genre_rel",
    joinColumns = @JoinColumn(name = "movie_id"),
    inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genreList; // Set is better bcs set using not many query for data operations



    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", releaseDate=" + releaseDate +
                ", duration=" + duration +
                ", summary='" + summary + '\'' +
                ", type=" + type +
                ", state=" + state +
                ", price=" + price +
                ", genreList=" + genreList +
                '}';
    }
}
