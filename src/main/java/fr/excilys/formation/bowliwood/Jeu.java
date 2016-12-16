package fr.excilys.formation.bowliwood;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Jeu {
	private int nombreJoueur;
	private Map<String, Integer[][]> scoreJoueur = new HashMap<>();
	
	/**
	 * Javadoc.
	 */
	public void lancerJeu(Scanner sc){
		Joueur player = new Joueur();
		nombreJoueur = player.saisirNombreJoueur(sc);
		String nomJoueur[] = new String[nombreJoueur];
		player.saisirNomJoueur(nombreJoueur, nomJoueur, sc);
		for (int i = 0;i<nombreJoueur; i++){
			scoreJoueur.put(nomJoueur[i],new Integer[11][2]);
			scoreJoueur.get(nomJoueur[i])[10][0]=0;
		}
		
	}
	
	public void afficherScore(){
				for (String key: scoreJoueur.keySet()){
					System.out.print(key+" ");
					Integer tableauScore[][] = scoreJoueur.get(key);
					for (int j=0;j<10;j++){
						if (tableauScore[j][0]==null)
							System.out.print(" ");
						else{
							if (tableauScore[j][0]==10)
								System.out.print("X ");
							else {
								if (tableauScore[j][0]+tableauScore[j][1]==10)
									System.out.print("/ ");
								else
									System.out.print(tableauScore[j][0]+tableauScore[j][1]+" ");
					
							}
						}
					 }
					System.out.print(tableauScore[10][0]);
					System.out.println("\n");
				}
	}
	
	public void calculScore(String nomJoueur, int[] coup, int numTour){
		Integer tableauScore[][] = scoreJoueur.get(nomJoueur);
			if (coup[0]+coup[1]<10){
				if (numTour>0){
					if (tableauScore[numTour-1][0]+tableauScore[numTour-1][1]==10)
						tableauScore[10][0]+=2*(coup[0])+10+coup[1];
				}
				if (numTour>1){
					if (tableauScore[numTour-2][0]==10)
						tableauScore[10][0]+=2*(coup[0]+coup[1])+tableauScore[numTour-1][0]+tableauScore[numTour-1][1]+10;
				}
				if (numTour==0)
					tableauScore[10][0]+=coup[0]+coup[1];
			}
				
	}

	public int getNombreJoueur() {
		return nombreJoueur;
	}

	public void setNombreJoueur(int nombreJoueur) {
		this.nombreJoueur = nombreJoueur;
	}
	
	public Map<String, Integer[][]> getScoreJoueur() {
		return scoreJoueur;
	}

	public void setScoreJoueur(Map<String, Integer[][]> scoreJoueur) {
		this.scoreJoueur = scoreJoueur;
	}
	
	public static void main(String[] args) {
		Jeu jeu = new Jeu();
		Joueur player = new Joueur();
		Scanner sc = new Scanner(System.in);
		jeu.lancerJeu(sc);
		jeu.afficherScore();
		for (int i=0; i<10;i++){
			for (String key: jeu.getScoreJoueur().keySet()){
				int tableauScore[] = new int[2];
				player.saisirScore(tableauScore, sc);
				jeu.calculScore(key, tableauScore, i);
			}
		jeu.afficherScore();
		}
	}
}
