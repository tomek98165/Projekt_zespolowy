package com.videos.domain.dao;

import com.videos.domain.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieDAO extends JpaRepository<Movie, Integer> {


}
