package fr.ul.miage.coco.compilation;


import java.util.logging.Logger;

import fr.ul.miage.arbre.*;
import fr.ul.miage.arbre.Noeud.Categories;
import fr.ul.miage.tds.*;

public class Main {
	private static final Logger LOG = Logger.getLogger(Tds.class.getName());
	public static String newLigne = System.getProperty("line.separator");
	
	public static void main(String[] args) {
		//Exemple 1
		//Création de l'arbre de l'exemple 1
		Prog a = new Prog();
		NoeudObj n = new NoeudObj();
		n.setCat(Categories.FONCTION);
		n.setValeur("main");
		a.ajouterUnFils(n);
		//Création du tds de l'exemple 1
		Tds t = new Tds();
		try {
			Symbole s = t.ajouter("main", Symbole.CAT_FONCTION, Symbole.SCOPE_GLOBAL);
			s.set_nbparam(0);
			s.set_nbloc(0);
		} catch (Exception e) {
			LOG.warning(e.getMessage());
		}
		System.out.println(t.toString());
		//appel pour génération
		//System.out.print(generer_programme(a, t));
	}
	
	public static String generer_programme(Noeud a, Tds t) {
		String res;
		res = "";
		res += ".include.uasm" + newLigne + ".include intio.uasm" + newLigne + ".options tty" + newLigne + "CMOVE(pile, sp)" + newLigne + "BR(debut)";
		res += newLigne + generer_data(t);
		res += newLigne + generer_code(a);
		res += newLigne + "debut :" + newLigne + "CALL(main)" + newLigne + "HALT()" + newLigne + "pile :";
		return res;
	}
	
	public static String generer_data(Tds t) {
		return "a faire";
	}
	
	public static String generer_code(Noeud a) {
		return "a faire";
	}
	
	public static String generer_expression(Noeud a, Tds t) {
		return "a faire";
	}
	
	public static String generer_affectation(Noeud a, Tds t) {
		String res;
		res = "";
		res += generer_expression(a.getFils().get(0), t);
		res += newLigne + "POP(R0)" + newLigne + "ST(R0, " + a.getFils().get(0).getLabel() + ")";
		return res;
	}
	
	public static String generer_instruction(Noeud a, Tds t) {
		return "a faire";
	}
	
	public static String generer_ecrire(Noeud a, Tds t) {
		return "a faire";
	}
	
	public static String generer_si(Noeud a, Tds t) {
		return "a faire";
	}
	
	public static String generer_bloc(Noeud a, Tds t) {
		return "a faire";
	}
	
	public static String generer_expression_boolean(Noeud a, Tds t) {
		return "a faire";
	}
}
