package com.web.resources;

import java.util.Random;



public abstract class Ferramentas {

	static Random aleatorio = new Random();
	
	
	public static int randomInt() {
		return aleatorio.nextInt(1000);
	}
	
}
