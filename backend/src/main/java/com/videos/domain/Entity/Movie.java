package com.videos.domain.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.List;

@Entity
@Table(name="movie")
@AllArgsConstructor
public class Movie{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        int id;
        @Column(name = "title")
        String title;
        @Column(name = "director")
        String director;
        @Column(name = "description")
        String description;
        @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE,
                CascadeType.PERSIST, CascadeType.REFRESH})
        @JoinTable(
                name = "actor_movie",
                joinColumns = @JoinColumn(name = "movie_id"),
                inverseJoinColumns = @JoinColumn(name = "actor_id")

        )
        List<Actor> actors;

    public Movie() {

    }

        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public String getDirector() {
                return director;
        }

        public void setDirector(String director) {
                this.director = director;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public List<Actor> getActors() {
                return actors;
        }

        public void setActors(List<Actor> actors) {
                this.actors = actors;
        }
}
