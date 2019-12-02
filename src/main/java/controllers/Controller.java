package controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reki.Jugada;
import com.reki.Player;
import com.reki.services.JugadaService;
import com.reki.services.PlayerServices;
import com.reki.services.Services;
import com.reki.services.TransactionService;

import games.BlackJack;


	@RestController
	public class Controller {

		@Autowired
		private PlayerServices playServ;
		@Autowired
		private TransactionService transServ;
		@Autowired 
		private JugadaService jugServ;
		BlackJack black = new BlackJack();

		@RequestMapping(method = RequestMethod.POST, value = "/players")
		public void updatePlayer(Player player) {
			playServ.savePlayer(player);
		}
	// fer una tirada de blackjack de 2000 amb la id d'un jugador
		@RequestMapping(method = RequestMethod.POST, value = "/players/{id}/blackjack/")
		public void tiraDaus(@PathVariable("id") int id) {
			if(playServ.getPlayer(id).isPresent()) {
			new Jugada(playServ.getPlayer(id).orElse(Services.createRandomPlayer(playServ)), 2000, black, transServ);
			}
		}
		//torna totes les tirades
		@RequestMapping("/plays")
		public List<Jugada> getTirades() {
			return jugServ.getJugades();
		}
		

//		DELETE /players/{id} elimina el jugador. 
		@DeleteMapping(value = "/players/{id}")
		public void deletePlayer(@PathVariable("id") int id) {
			playServ.deletePlayer(id);
		}

//		DELETE /players/{id}/games: elimina les tirades del jugador.
		@DeleteMapping(value = "/players/{id}/games")
		public void deleteTiradas(@PathVariable("id") int id) {
			jugServ.deleteTiradas(id);
		}

//		GET /players/{id}/games: retorna el llistat de jugades per un jugador.
		@RequestMapping("/players/{id}/games")
		public List<Jugada> getTiradesByPlayerId(@PathVariable("id") int id ) {	
			return jugServ.getTiradesByPlayerId(id);
		}

}