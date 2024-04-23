package com.videos.domain.Entity;

import jakarta.persistence.*;
import lombok.Builder;

import java.util.List;

@Entity
@Table(name="actor")
public class Actor{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        String id;
        @Column(name = "first_name")
        String first_name;
        @Column(name = "last_name")
        String last_name;
        @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE,
                CascadeType.PERSIST, CascadeType.REFRESH})
        @JoinTable(
                name = "actor_movie",
                joinColumns = @JoinColumn(name = "actor_id"),
                inverseJoinColumns = @JoinColumn(name = "movie_id")

        )
        List<Movie> movies;
        public Actor() {

        }

        public String getFirst_name() {
                return first_name;
        }

        public void setFirst_name(String first_name) {
                this.first_name = first_name;
        }

        public String getLast_name() {
                return last_name;
        }

        public void setLast_name(String last_name) {
                this.last_name = last_name;
        }

        public List<Movie> getMovies() {
                return movies;
        }

        public void setMovies(List<Movie> movies) {
                this.movies = movies;
        }
}
