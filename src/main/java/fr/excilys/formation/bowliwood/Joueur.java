package fr.excilys.formation.bowliwood;

import java.util.Scanner;

public class Joueur {
	private String nom;
	private String prenom;
	private int score;
	private int numCoup;
	
	public int saisirNombreJoueur(){
		Scanner sc = new Scanner(System.in);
		int nombreJoueur;
		do{
		System.out.println("Saisir le nombre de joueurs");
		nombreJoueur = sc.nextInt();
		}while(nombreJoueur<=0);
		return nombreJoueur;
	}
	
	public void saisirNomJoueur (int nombreJoueur, String[] nomJoueur){
		String playerName;
		for(int i = 0; i<nombreJoueur ; i++){
			Scanner sc = new Scanner(System.in);
			boolean verifNom = false;
			do{
				System.out.println("Saisir le nom du joueur numéro "+(i+1)+" : ");
				playerName = sc.nextLine();
				System.out.println("Voulez vous valider "+playerName+" ?");
				System.out.println("Oui = o / Non = n");
				String reponse = sc.nextLine();
				if (reponse.equals("o"))
					verifNom = true;
			}while (verifNom == false);
			nomJoueur[i] = playerName;
		}
	}
	
	public void saisirScore(int[] tableauScore){
		Scanner sc = new Scanner(System.in);
		int nombreQuilles;
		String reponse;
		boolean test = false;
		System.out.println("Saisir le nombre de quilles tombées");
		nombreQuilles = sc.nextInt();
		while (test == false){
			if (nombreQuilles <0 || nombreQuilles > 10){
				System.out.println("Le nombre de quilles doit etre entre 0 et 10");
				nombreQuilles = sc.nextInt();
			}else{
				System.out.println("Voulez vous valider le nombre de quilles : "+nombreQuilles+" ?");
				System.out.println("Oui = o / Non = n");
				reponse = sc.nextLine();
				if (reponse == "o")
					test = true;
				else{
					System.out.println("Saisir le nouveau nombre de quilles tombées");
					nombreQuilles = sc.nextInt();
				}
			}
		}
		tableauScore[0] = nombreQuilles;
		if (nombreQuilles == 10){
			System.out.println("Est-ce que c'était un Strike ou Spare ?");
			System.out.println("Strike = st / Spare = sp");
			reponse = sc.nextLine();
			if (reponse == "st")
				tableauScore[1] = 1;
			else
				tableauScore[1] = 2;
		}else
			tableauScore[1] = 0;
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
