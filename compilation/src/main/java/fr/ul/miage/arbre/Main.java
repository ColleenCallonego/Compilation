/*
 *  License and Copyright:
 *  This file is part of arbre project.
 *
 *   It is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   any later version.
 *
 *   It is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with Foobar.  If not, see <http://www.gnu.org/licenses/>.
 * 
 *  Copyright 2019 by LORIA, Université de Lorraine
 *  All right reserved 
 */
package fr.ul.miage.arbre;


/**
 * Description :
 * 
 * @author Azim Roussanaly Created at 28 févr. 2019
 */
public class Main {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String n = "0";
		if (args.length == 1) { 
			n = args[0];
		}
		switch (n) {
		case "1":
			// test #1
			Noeud prog2 = new Prog();
			Noeud max2 = new Fonction("max");
			Noeud main2 = new Fonction("main");
			prog2.ajouterUnFils(max2);
			prog2.ajouterUnFils(main2);
			Afficheur.afficher(prog2);
			break;
		case "2":
			// test #2
			Prog prog3 = new Prog();
			Fonction max3 = new Fonction("max");
			Fonction main3 = new Fonction("main");
			Affectation aff3 = new Affectation();
			Idf x3 = new Idf("x");
			Const c3 = new Const(10);
			aff3.setFilsGauche(x3);
			aff3.setFilsDroit(c3);
			Retour r3 = new Retour("max");
			Idf y3 = new Idf("x");
			r3.setLeFils(y3);
			Bloc b3 = new Bloc();
			b3.ajouterUnFils(aff3);
			b3.ajouterUnFils(r3);
			max3.ajouterUnFils(b3);
			prog3.ajouterUnFils(max3);
			prog3.ajouterUnFils(main3);
			Afficheur.afficher(prog3);
			break;

		default:
			// test #0
			Noeud prog = new Prog();
			Noeud main = new Fonction("main");
			prog.ajouterUnFils(main);
			Afficheur.afficher(prog);
			break;
		}
	}

}
