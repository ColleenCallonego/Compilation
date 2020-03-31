package fr.ul.miage.coco.compilation;


import fr.ul.miage.arbre.*;
import fr.ul.miage.tds.*;

public class Main {
	
	public static void main(String[] args) {
		
	}
	
	public static String generer_programme(Prog a, Tds t) {
		String newLigne = System.getProperty("line.separator");
		String res;
		res = "";
		res += ".include.uasm" + newLigne + ".include intio.uasm" + newLigne + ".options tty" + newLigne + "CMOVE(pile, sp)" + newLigne + "BR(debut)";
		res += generer_data(t);
		res += generer_code(a);
		res += "debut :" + newLigne + "CALL(main)" + newLigne + "HALT()" + newLigne + "pile :";
		return res;
	}
	
	public static String generer_data(Tds t) {
		return "a faire";
	}
	
	public static String generer_code(Prog a) {
		return "a faire";
	}
}
