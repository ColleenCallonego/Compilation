package fr.ul.miage.coco.compilation;

import java.util.logging.Logger;

import fr.ul.miage.arbre.Noeud;
import fr.ul.miage.arbre.NoeudObj;
import fr.ul.miage.arbre.Prog;
import fr.ul.miage.arbre.Noeud.Categories;
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
					Symbole s = t.ajouter("main", Symbole.TYPE_ENTIER, Symbole.SCOPE_GLOBAL);
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
				NoeudObj n3 = new NoeudObj();
				n3.setCat(Categories.FONCTION);
				n3.setValeur("main");
				a.ajouterUnFils(n3);
				//Création du tds
				t = new Tds();
				try {
					Symbole s = t.ajouter("main", Symbole.TYPE_ENTIER, Symbole.SCOPE_GLOBAL);
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
