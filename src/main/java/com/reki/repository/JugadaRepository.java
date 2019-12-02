package com.reki.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reki.Jugada;

@Repository
public interface JugadaRepository extends CrudRepository<Jugada, Long>{

	public void deleteByPlayerId(int id);

	public List<Jugada> getAllByPlayerId(int id);

}
