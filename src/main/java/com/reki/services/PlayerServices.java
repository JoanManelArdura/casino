package com.reki.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reki.Player;
import com.reki.repository.PlayerRepository;

@Service
public class PlayerServices {
	
	@Autowired
	private PlayerRepository playRepo;

	public PlayerServices(PlayerRepository playRepo) {
		this.playRepo=playRepo;
	}
	
	public Optional<Player> getPlayer(int playerId) {
		return playRepo.findById(playerId);
	}
	
	public boolean checkPlayer(int playerId) {
		return playRepo.existsById(playerId);
	}
	
	public void savePlayer(Player player) {
		playRepo.save(player);
	}
	
}
