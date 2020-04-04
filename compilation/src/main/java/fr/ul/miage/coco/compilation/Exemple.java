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
				a = new Prog();
				NoeudObj n = new NoeudObj();
				n.setCat(Categories.FONCTION);
				n.setValeur("main");
				a.ajouterUnFils(n);
				//Création du tds de l'exemple 1
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
				
				break;
			case 3 : //Exemple 3
				
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
