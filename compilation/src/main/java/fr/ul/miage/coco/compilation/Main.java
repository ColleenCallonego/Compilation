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
		//appel pour génération
		System.out.print(generer_programme(a, t));
	}
	
	public static String generer_programme(Noeud a, Tds t) {
		String res = "";
		res += ".include beta.uasm" + newLigne + ".include intio.uasm" + newLigne + ".options tty" + newLigne + "CMOVE(pile, SP)" + newLigne + "BR(debut)";
		res += newLigne + generer_data(t);
		res += generer_code(a, t);
		res += newLigne + "debut : " + "CALL(main)" + newLigne + "HALT()" + newLigne + "pile :";
		return res;
	}
	
	public static String generer_data(Tds t) {
		return "a faire"; 
	}
	
	public static String generer_code(Noeud a, Tds t) {
		String res = "";
		for(Noeud  f : a.getFils()){
			res += newLigne + generer_fonction(f, t);
		}
		return res;
	}

	public static String generer_fonction(Noeud n, Tds t){
		String res ="";
		res += n.getLabel() + " : PUSH(LP)" + newLigne + "PUSH(BP)" + newLigne + "MOVE(SP, BP)";
		if (n.getFils() != null) {
			for(Noeud f : n.getFils()) {
				res += newLigne + generer_bloc(f, t);
			}
		}
		res += newLigne + "MOVE(BP, SP)" + newLigne + "POP(BP)" + newLigne + "POP(LP)" + newLigne + "RTN()";
		return res;
	}
	public static String generer_expression(Noeud a, Tds t) {
		return "a faire";
	}
	
	public static String generer_affectation(Noeud a, Tds t) {
		String res;
		res = "";
		res += generer_expression(a.getFils().get(1), t);
		res += newLigne + "POP(R0)" + newLigne + "ST(R0, " + a.getFils().get(0).getLabel() + ")";
		return res;
	}

	public static String generer_instruction(Noeud a, Tds t) {
		String res = "";
		switch(a.getCat()){
			case AFF :
				res += generer_affectation(a, t);
				break;
			case ECR :
				res += generer_ecrire(a,t);
				break;
			case LIRE :
				res += generer_lire(a,t);
				break;
		}
		return res;
	}

	public static String generer_lire(Noeud a, Tds t){
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
		String res = "";
		if(a.getCat().equals("SUP")){
			res += generer_expression(a.getFils().get(0),t);
			res += generer_expression(a.getFils().get(1),t);
			res += newLigne + "POP(R2)" + newLigne + "POP(R1)" + newLigne + "CMPLT(R2, R1, R3)" + newLigne + "PUSH(R3)";
		}
		if(a.getCat().equals("SUPE")){
			res += generer_expression(a.getFils().get(0),t);
			res += generer_expression(a.getFils().get(1),t);
			res += newLigne + "POP(R2)" + newLigne + "POP(R1)" + newLigne + "CMPLE(R2, R1, R3)" + newLigne + "PUSH(R3)";
		}
		if(a.getCat().equals("INF")){
			res += generer_expression(a.getFils().get(0),t);
			res += generer_expression(a.getFils().get(1),t);
			res += newLigne + "POP(R2)" + newLigne + "POP(R1)" + newLigne + "CMPLT(R1, R2, R3)" + newLigne + "PUSH(R3)";
		}
		if(a.getCat().equals("INFE")){
			res += generer_expression(a.getFils().get(0),t);
			res += generer_expression(a.getFils().get(1),t);
			res += newLigne + "POP(R2)" + newLigne + "POP(R1)" + newLigne + "CMPLE(R1, R2, R3)" + newLigne + "PUSH(R3)";
		}
		if(a.getCat().equals("EG")){
			res += generer_expression(a.getFils().get(0),t);
			res += generer_expression(a.getFils().get(1),t);
			res += newLigne + "POP(R2)" + newLigne + "POP(R1)" + newLigne + "CMPEQ(R1, R2, R3)" + newLigne + "PUSH(R3)";
		}
		return res;
	}
}
