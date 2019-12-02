package com.reki;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.reki.services.JugadaService;
import com.reki.services.PlayerServices;
import com.reki.services.Services;
import com.reki.services.TransactionService;

@Component
public class Automatize implements ApplicationListener<ApplicationReadyEvent>{
	
	@Autowired
	private PlayerServices playServ;
	@Autowired
	private Services service;
	@Autowired 
	TransactionService transServ;
	@Autowired
	JugadaService jugServ;
	
	private void dale(Services service) {
		Player player = service.createRandomPlayer(playServ);
    	(new Thread(new GoLive(player, transServ, jugServ))).start();
		Timer timer = new Timer (10000, new ActionListener ()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		    	Player player = service.createRandomPlayer(playServ);
		    	(new Thread(new GoLive(player, transServ, jugServ))).start();
		     }
		}); 
		
		timer.start();
		
		
	}
	
	
	
	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		System.out.println("arranque");
		dale(service);
		return;
		
	}

}
