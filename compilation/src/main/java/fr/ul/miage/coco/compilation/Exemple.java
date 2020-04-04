package fr.ul.miage.coco.compilation;

import java.util.ArrayList;
import java.util.logging.Logger;

import fr.ul.miage.arbre.Noeud;
import fr.ul.miage.arbre.NoeudObj;
import fr.ul.miage.arbre.Prog;
import fr.ul.miage.arbre.Noeud.Categories;
import fr.ul.miage.arbre.Noeud0;
import fr.ul.miage.arbre.NoeudInt;
import fr.ul.miage.tds.Symbole;
import fr.ul.miage.tds.Tds;

//classe pour créer les différents exemples à tester

public class Exemple {
	private static final Logger LOG = Logger.getLogger(Tds.class.getName());
	public Noeud a;
	public Tds t;
	
	public Exemple (int numero) {
		switch(numero){
			case 1 : //Exemple 1
				//Création de l'arbre
				a = new Prog();
				NoeudObj n1 = new NoeudObj();
				n1.setCat(Categories.FONCTION);
				n1.setValeur("main");
				a.ajouterUnFils(n1);
				//Création du tds
				t = new Tds();
				try {
					Symbole s = t.ajouter("main", Symbole.CAT_FONCTION, Symbole.SCOPE_GLOBAL);
					s.set_nbparam(0);
					s.set_nbloc(0);
				} catch (Exception e) {
					LOG.warning(e.getMessage());
				}
				break;
			case 2 : //Exemple 2
				//Création de l'arbre
				a = new Prog();
				NoeudObj n2 = new NoeudObj();
				n2.setCat(Categories.FONCTION);
				n2.setValeur("main");
				a.ajouterUnFils(n2);
				//Création du tds
				t = new Tds();
				try {
					Symbole s = t.ajouter("main", Symbole.CAT_FONCTION, Symbole.SCOPE_GLOBAL);
					s.set_nbparam(0);
					s.set_nbloc(0);
				} catch (Exception e) {
					LOG.warning(e.getMessage());
				}
				try {
					Symbole s = t.ajouter("i", Symbole.TYPE_ENTIER, Symbole.SCOPE_GLOBAL);
					s.set_valeur(10);
				} catch (Exception e) {
					LOG.warning(e.getMessage());
				}
				try {
					Symbole s = t.ajouter("j", Symbole.TYPE_ENTIER, Symbole.SCOPE_GLOBAL);
					s.set_valeur(20);
				} catch (Exception e) {
					LOG.warning(e.getMessage());
				}
				try {
					Symbole s = t.ajouter("k", Symbole.TYPE_ENTIER, Symbole.SCOPE_GLOBAL);
				} catch (Exception e) {
					LOG.warning(e.getMessage());
				}
				try {
					Symbole s = t.ajouter("l", Symbole.TYPE_ENTIER, Symbole.SCOPE_GLOBAL);
				} catch (Exception e) {
					LOG.warning(e.getMessage());
				}
				break;
			case 3 : //Exemple 3
				//Création de l'arbre
				a = new Prog();
				NoeudObj n3_1 = new NoeudObj();
				n3_1.setCat(Categories.FONCTION);
				n3_1.setValeur("main");
				n3_1.setFils(new ArrayList<>());
				Noeud0 n3_2 = new Noeud0();
				n3_2.setCat(Categories.AFF);
				n3_2.setFils(new ArrayList<>());
				NoeudObj n3_3 = new NoeudObj();
				n3_3.setCat(Categories.IDF);
				n3_3.setValeur("k");
				n3_3.setFils(new ArrayList<>());
				n3_2.ajouterUnFils(n3_3);
				NoeudInt n3_4 = new NoeudInt();
				n3_4.setCat(Categories.CONST);
				n3_4.setValeur(2);
				n3_4.setFils(new ArrayList<>());
				n3_2.ajouterUnFils(n3_4);
				n3_1.ajouterUnFils(n3_2);
				Noeud0 n3_5 = new Noeud0();
				n3_5.setCat(Categories.AFF);
				n3_5.setFils(new ArrayList<>());
				NoeudObj n3_6 = new NoeudObj();
				n3_6.setCat(Categories.IDF);
				n3_6.setValeur("l");
				n3_6.setFils(new ArrayList<>());
				n3_5.ajouterUnFils(n3_6);
				Noeud0 n3_7 = new Noeud0();
				n3_7.setCat(Categories.PLUS);
				n3_7.setFils(new ArrayList<>());
				NoeudObj n3_8 = new NoeudObj();
				n3_8.setCat(Categories.IDF);
				n3_8.setValeur("i");
				n3_8.setFils(new ArrayList<>());
				n3_7.ajouterUnFils(n3_8);
				Noeud0 n3_9 = new Noeud0();
				n3_9.setCat(Categories.MUL);
				n3_9.setFils(new ArrayList<>());
				NoeudObj n3_10 = new NoeudObj();
				n3_10.setCat(Categories.CONST);
				n3_10.setValeur(3);
				n3_10.setFils(new ArrayList<>());
				n3_9.ajouterUnFils(n3_10);
				NoeudObj n3_11 = new NoeudObj();
				n3_11.setCat(Categories.IDF);
				n3_11.setValeur("j");
				n3_11.setFils(new ArrayList<>());
				n3_9.ajouterUnFils(n3_11);
				n3_7.ajouterUnFils(n3_9);
				n3_5.ajouterUnFils(n3_7);
				n3_1.ajouterUnFils(n3_5);
				a.ajouterUnFils(n3_1);
				//Création du tds
				t = new Tds();
				try {
					Symbole s = t.ajouter("main", Symbole.CAT_FONCTION, Symbole.SCOPE_GLOBAL);
					s.set_nbparam(0);
					s.set_nbloc(0);
				} catch (Exception e) {
					LOG.warning(e.getMessage());
				}
				try {
					Symbole s = t.ajouter("i", Symbole.TYPE_ENTIER, Symbole.SCOPE_GLOBAL);
					s.set_valeur(10);
				} catch (Exception e) {
					LOG.warning(e.getMessage());
				}
				try {
					Symbole s = t.ajouter("j", Symbole.TYPE_ENTIER, Symbole.SCOPE_GLOBAL);
					s.set_valeur(20);
				} catch (Exception e) {
					LOG.warning(e.getMessage());
				}
				try {
					Symbole s = t.ajouter("k", Symbole.TYPE_ENTIER, Symbole.SCOPE_GLOBAL);
				} catch (Exception e) {
					LOG.warning(e.getMessage());
				}
				try {
					Symbole s = t.ajouter("l", Symbole.TYPE_ENTIER, Symbole.SCOPE_GLOBAL);
				} catch (Exception e) {
					LOG.warning(e.getMessage());
				}
				break;
			case 4 : //Exemple 4
				
				break;
			case 5 : //Exemple 5
				
				break;
			case 6 : //Exemple 6
				
				break;
			case 7 : //Exemple 7
				
				break;
			case 8 : //Exemple 8
				
				break;
		}
	}
}
