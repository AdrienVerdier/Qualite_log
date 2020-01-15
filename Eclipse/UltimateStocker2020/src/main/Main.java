package main;

import controler.Connexion;
import view.appInterface;

public class Main {

	public static void main(String[] args) {
		Connexion.modification();
		appInterface Application = new appInterface();
	}

}
