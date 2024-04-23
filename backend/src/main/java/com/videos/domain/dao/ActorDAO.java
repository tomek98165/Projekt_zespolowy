package com.videos.domain.dao;

import com.videos.domain.Entity.Actor;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ActorDAO extends JpaRepository<Actor, Integer>{
}
