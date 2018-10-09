package com.stack.jspdemo.controller;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class WelomeControllerTest {
	
	@Test
	public void testWelcomeController() {
		WelcomeController welcomeController = new WelcomeController();
		String result = welcomeController.showMenuPage();
		assertTrue(result.equals("menu"));
		
	}
	

}
