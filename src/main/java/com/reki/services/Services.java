package com.reki.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.reki.Player;

public class Services {
	static int randomPlayerNumber=1;
	
	@Autowired
	private static PlayerServices playServ;
	
	
	public static double getRandom(double min, double max){
	    double x = (Math.random()*((max-min)+1))+min;
	    return x;
	}
	
	public static Player createRandomPlayer() {
		String randomName= "random name "+ randomPlayerNumber;
		randomPlayerNumber ++;
		Player player=new Player(randomName,(int) getRandom(1,6));
		playServ.savePlayer(player);
		return player;
	}
	
}
