package com.reki.services;

import org.springframework.stereotype.Service;

import com.reki.Player;

@Service
public class Services {
	static int randomPlayerNumber=1;
	
	public static double getRandom(double min, double max){
	    double x = (Math.random()*((max-min)+1))+min;
	    return x;
	}
	
	public static Player createRandomPlayer(PlayerServices playServ) {
		//this.playServ=playServ;
		String randomName= "randomName"+ randomPlayerNumber;
		randomPlayerNumber ++;
		Player player=new Player(randomName,(int) getRandom(1,6));
		playServ.savePlayer(player);
		player.setTime(300);
		return player;
	}
	
}
