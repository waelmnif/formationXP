package fr.excilys.formation.bowliwood;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.junit.Test;

public class JeuTest {
	@Test
	public void testLancerJeu(){
		String testScoreJoueur[] = {"Monoem","Wael","Sabrine","Zied"};
		ByteArrayInputStream in = new ByteArrayInputStream("4\nMonoem\no\nWael\no\nSabrine\no\nZied\no".getBytes());
		System.setIn(in);
		Scanner sc = new Scanner(System.in);
		Jeu jeu = new Jeu();
		jeu.lancerJeu(sc);
		int i = 3;
			for (String key: jeu.getScoreJoueur().keySet()){
					assertEquals(key,testScoreJoueur[i]);
					i--;
			}
	}
	
	@Test
	public void testSaisirNombreJoueur(){
		int testNombreJoueur;
		ByteArrayInputStream in = new ByteArrayInputStream("4 ".getBytes());
		System.setIn(in);
		Scanner sc = new Scanner(System.in);
		testNombreJoueur = 4;
		Joueur joueur = new Joueur();
		assertEquals(joueur.saisirNombreJoueur(sc),testNombreJoueur);
	}
	
	@Test
	public void testSaisirNomJoueur(){
		String nomJoueur[] = {"Monoem","Wael"};
		ByteArrayInputStream in = new ByteArrayInputStream("Monoem\no\nWael\no".getBytes());
		System.setIn(in);
		Scanner sc = new Scanner(System.in);
		Joueur joueur = new Joueur();
		String testNomJoueur[] = new String[2];
		joueur.saisirNomJoueur(2, testNomJoueur, sc);
		assertEquals(testNomJoueur,nomJoueur);
		//assertTrue(testNomJoueur.equals(nomJoueur));
	}
	
	@Test
	public void testSaisirScore(){
		int scoreJoueur[] = {5,4};
		ByteArrayInputStream in = new ByteArrayInputStream("5 \no\n4 \no".getBytes());
		System.setIn(in);
		Scanner sc = new Scanner(System.in);
		Joueur joueur = new Joueur();
		int testScoreJoueur[] = new int[2];
		joueur.saisirScore(testScoreJoueur, sc);
		for (int i = 0;i<2;i++)
		assertEquals(testScoreJoueur[i],scoreJoueur[i]);
	}
	
	@Test
	public void testCalculScore(){
		Map<String, Integer[][]> testScoreJoueur = new HashMap<>();
		Integer scoreJoueur1[][] = new Integer[11][2];
		scoreJoueur1[0][0]=4;
		scoreJoueur1[0][1]=5;
		scoreJoueur1[1][0]=8;
		scoreJoueur1[1][1]=2;
		testScoreJoueur.put("Monoem", scoreJoueur1);
		Jeu jeu = new Jeu();
		jeu.setScoreJoueur(testScoreJoueur);
		int coup[]= new int[2];
		coup[0]=5;
		coup[1]=1;
		jeu.calculScore("Monoem", coup, 2);
		Integer resultat = new Integer(30);
		assertEquals(testScoreJoueur.get("Monoem")[10][0],resultat);
	}
	
	
	
}
