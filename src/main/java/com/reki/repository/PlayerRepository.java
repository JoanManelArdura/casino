package com.reki.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reki.Player;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Integer>{

}
