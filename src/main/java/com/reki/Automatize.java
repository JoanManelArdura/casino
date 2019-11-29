package com.reki;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

import com.reki.services.Services;

public class Automatize implements ApplicationListener<ApplicationReadyEvent>{
	
	@Autowired
	private Services service;
	
	private void dale(Services service) {
		System.out.println("proba en automatize");
		Player player = service.createRandomPlayer();
		System.out.println(player.getPlayerName());
		System.out.println(player.getCash());
		System.out.println(player.getId());
	}
	
	
	
	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		dale(service);
		return;
		
	}

}
