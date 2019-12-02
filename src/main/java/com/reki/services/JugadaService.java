package com.reki.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reki.Jugada;
import com.reki.repository.JugadaRepository;

@Service
public class JugadaService {
	@Autowired
	private JugadaRepository jugRepo;
	
	public List<Jugada> getJugades() {
		List<Jugada> jugades = new ArrayList<>();
		jugRepo.findAll().forEach(jugades::add);
		return jugades;
		
	}

	public void deleteTiradas(int id) {
		jugRepo.deleteByPlayerId(id);
		
	}

	public List<Jugada> getTiradesByPlayerId(int id) {
		jugRepo.getAllByPlayerId(id);
		return null;
	}
	
	public void saveJugada(Jugada jugada) {
		//jugRepo.save(jugada);
	}
	
}
