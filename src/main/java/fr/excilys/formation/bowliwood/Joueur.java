package fr.excilys.formation.bowliwood;

import java.util.Scanner;

public class Joueur {
	private String nom;
	private String prenom;
	private int score;
	private int numCoup;

	public int saisirNombreJoueur(Scanner sc) {
		int nombreJoueur;
		do {
			System.out.println("Saisir le nombre de joueurs");
			nombreJoueur = sc.nextInt();
			sc.nextLine();
		} while (nombreJoueur <= 0);
		return nombreJoueur;
	}

	public void saisirNomJoueur(int nombreJoueur, String[] nomJoueur, Scanner sc) {
		String playerName;
		for (int i = 0; i < nombreJoueur; i++) {
			boolean verifNom = false;
			do {
				System.out.println("Saisir le nom du joueur numéro " + (i + 1) + " : ");
				playerName = sc.nextLine();
				System.out.println("Voulez vous valider " + playerName + " ?");
				System.out.println("Oui = o / Non = n");
				String reponse = sc.nextLine();
				if (reponse.equals("o")) {
					verifNom = true;
				}
			} while (verifNom == false);
			nomJoueur[i] = playerName;
		}
	}

	public void saisirScore(int[] tableauScore,Scanner sc) {
		tableauScore[0]=tableauScore[1]=0;
		int nombreQuilles;
		String reponse;
		for (int i=1; i<3 ;i++){
		boolean test = false;
		System.out.println("Saisir le nombre de quilles tombées au lancer "+i);
		nombreQuilles = sc.nextInt();
		sc.nextLine();
		while (test == false) {
			if (nombreQuilles < 0 || nombreQuilles > 10 ||tableauScore[0]+tableauScore[1]>10) {
				System.err.println("Le nombre de quilles doit etre entre 0 et 10");
				nombreQuilles = sc.nextInt();
				sc.nextLine();
			} else {
				System.out.println("Voulez vous valider le nombre de quilles : " + nombreQuilles + " ?");
				System.out.println("Oui = o / Non = n");
				reponse = sc.nextLine();
				if (reponse.equals("o")){
					test = true;
					tableauScore[i-1]=nombreQuilles;
				}
				else {
					System.out.println("Saisir le nouveau nombre de quilles tombées au lancer "+i);
					nombreQuilles = sc.nextInt();
					sc.nextLine();
				}
			}
		}
		}
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getNumCoup() {
		return numCoup;
	}

	public void setNumCoup(int numCoup) {
		this.numCoup = numCoup;
	}

}
