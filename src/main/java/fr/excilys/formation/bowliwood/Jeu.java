package fr.excilys.formation.bowliwood;

import java.util.HashMap;
import java.util.Map;

public class Jeu {
	private int nombreJoueur;
	private Map<String, Integer[]> scoreJoueur = new HashMap<>();
	
	/**
	 * Javadoc.
	 */
	public void lancerJeu(){
		Joueur player = new Joueur();
		nombreJoueur = player.saisirNombreJoueur();
		String nomJoueur[] = new String[nombreJoueur];
		player.saisirNomJoueur(nombreJoueur, nomJoueur);
		for (int i = 0;i<nombreJoueur; i++)
			scoreJoueur.put(nomJoueur[i],new Integer[11]);	
	}
	
	public void afficherScore(){
		for (int i=0;i<nombreJoueur; i++)
				for (String key: scoreJoueur.keySet()){
					System.out.print(key);
					Integer tableauScore[] = scoreJoueur.get(key);
					for (int j=0;j<11;j++)
						if (tableauScore[j]==null)
							System.out.print(" ");
						else
							System.out.print(tableauScore[j]);
				}
	}

	public int getNombreJoueur() {
		return nombreJoueur;
	}

	public void setNombreJoueur(int nombreJoueur) {
		this.nombreJoueur = nombreJoueur;
	}

	public Map<String, Integer[]> getScoreJoueur() {
		return scoreJoueur;
	}

	public void setScoreJoueur(Map<String, Integer[]> scoreJoueur) {
		this.scoreJoueur = scoreJoueur;
	}
	
	public static void main(String[] args) {
		Jeu jeu = new Jeu();
		jeu.lancerJeu();
	}
}
