package fr.ul.miage.coco.compilation;


import fr.ul.miage.arbre.*;
import fr.ul.miage.tds.*;

public class Main {
	
	public static void main(String[] args) {
		
	}
	
	public static String generer_programme(Noeud a, Tds t) {
		String newLigne = System.getProperty("line.separator");
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
		String newLigne = System.getProperty("line.separator");
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
