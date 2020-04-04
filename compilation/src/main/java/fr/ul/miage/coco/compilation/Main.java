package fr.ul.miage.coco.compilation;


import java.util.logging.Logger;

import fr.ul.miage.arbre.*;
import fr.ul.miage.arbre.Noeud.Categories;
import fr.ul.miage.tds.*;

public class Main {
	private static final Logger LOG = Logger.getLogger(Tds.class.getName());
	public static String newLigne = System.getProperty("line.separator");
	
	public static void main(String[] args) {
		//Exemple 1 blabla
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
		res += newLigne + "debut :" + newLigne + "CALL(main)" + newLigne + "HALT()" + newLigne + "pile :" + newLigne;
		return res;
	}
	
	public static String generer_data(Tds t) {
		return "a faire";
	}
	
	public static String generer_code(Noeud a) {
		return "a faire";
	}
	
	public static String generer_expression(Noeud a, Tds t) {
		String res;
		res = "";
		switch(a.getCat()) {
		/*La racine de l'arbre en paramètre est une constante*/
		case CONST:
			res += "CMOVE("+a.getLabel()+", R0)" + newLigne + 
				   "PUSH(R0)";
			break;
		/*La racine de l'arbre en paramètre est un identifient*/
		case IDF:
			res += "LD("+a.getLabel()+", R0)" + newLigne + 
				   "PUSH(R0)";
			break;
		/*La racine de l'arbre en paramètre est une opération : ADDITION*/
		case PLUS:
			res += generer_expression(a.getFils().get(0), t) + newLigne;
			res += generer_expression(a.getFils().get(1), t) + newLigne;
			res += "POP(R2)" + newLigne +
				   "POP(R1)" + newLigne +
				   "ADD(R1, R2, R3)" + newLigne +
				   "PUSH(R3)" + newLigne;
			break;
		/*La racine de l'arbre en paramètre est une opération : SOUSTRACTION*/
		case MOINS:
			res += generer_expression(a.getFils().get(0), t) + newLigne;
			res += generer_expression(a.getFils().get(1), t) + newLigne;
			res += "POP(R2)" + newLigne +
				   "POP(R1)" + newLigne +
				   "SUB(R1, R2, R3)" + newLigne +
				   "PUSH(R3)" + newLigne;
			break;
		/*La racine de l'arbre en paramètre est une opération : MULTIPLICATION*/
		case MUL:
			res += generer_expression(a.getFils().get(0), t) + newLigne;
			res += generer_expression(a.getFils().get(1), t) + newLigne;
			res += "POP(R2)" + newLigne +
				   "POP(R1)" + newLigne +
				   "MUL(R1, R2, R3)" + newLigne +
				   "PUSH(R3)" + newLigne;
			break;
		/*La racine de l'arbre en paramètre est une opération : DIVISION*/
		case DIV:
			res += generer_expression(a.getFils().get(0), t) + newLigne;
			res += generer_expression(a.getFils().get(1), t) + newLigne;
			res += "POP(R2)" + newLigne +
				   "POP(R1)" + newLigne +
				   "DIV(R1, R2, R3)" + newLigne +
				   "PUSH(R3)" + newLigne;
			break;
		/*La racine de l'arbre en paramètre ne correspond à aucun t*/
		default:
			System.out.println("Erreur l'arbre ne correspond pas à une expression");
			break;
		}
		return res;
	}
	
	public static String generer_affectation(Noeud a, Tds t) {
		String res;
		res = "";
		res += generer_expression(a.getFils().get(0), t);
		res += newLigne + "POP(R0)" + newLigne + "ST(R0, " + a.getFils().get(0).getLabel() + ")" + newLigne;
		return res;
	}
	
	public static String generer_instruction(Noeud a, Tds t) {
		return "a faire";
	}
	
	public static String generer_ecrire(Noeud a, Tds t) {
		String res;
		res = "";
		res += generer_expression(a.getFils().get(0), t) + newLigne;
		res += "POP(R0)" + newLigne + 
			   "WRINT()" + newLigne;
		return res;
	}
	
	public static String generer_lire(Noeud a, Tds t) {
		String res;
		res = "";
		res += "RDINT()" + newLigne +
			   "PUSH(R0)";
		return res;
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
