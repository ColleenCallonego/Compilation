/*  License and Copyright:
 *  This file is part of tds project.
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
 *  Copyright 2020 by LORIA, Université de Lorraine
 *  All right reserved 
 */
package fr.ul.miage.tds;

import java.util.logging.Logger;

/**
 * Classe de test de l'api tds licence MIASHS/MIAGE
 * 
 * @author azim roussanaly
 */

public class Main {
	private static final Logger LOG = Logger.getLogger(Main.class.getName());

	public static void main(String[] args) {
		Tds tds = new Tds();
		// remplissage
		try {
			Symbole s = tds.ajouter("x", Symbole.CAT_GLOBAL, Symbole.SCOPE_GLOBAL);
			s.set_valeur(2020);
		} catch (Exception e) {
			LOG.warning(e.getMessage());
		}
		try {
			tds.ajouter("x", Symbole.CAT_GLOBAL, Symbole.SCOPE_GLOBAL);
		} catch (Exception e) {
			LOG.warning(e.getMessage());
		}
		try {
			tds.ajouter("y", Symbole.CAT_GLOBAL, Symbole.SCOPE_GLOBAL);
		} catch (Exception e) {
			LOG.warning(e.getMessage());
		}
		try {
			Symbole s = tds.ajouter("f", Symbole.CAT_FONCTION, Symbole.SCOPE_GLOBAL);
			s.set_nbparam(1);
			s.set_nbloc(3);
		} catch (Exception e) {
			LOG.warning(e.getMessage());
		}
		try {
			Symbole s = tds.ajouter("a", Symbole.CAT_PARAMETRE, "f");
			s.set_rang(0);
		} catch (Exception e) {
			LOG.warning(e.getMessage());
		}
		try {
			Symbole s = tds.ajouter("b", Symbole.CAT_LOCAL, "f");
			s.set_rang(0);
		} catch (Exception e) {
			LOG.warning(e.getMessage());
		}
		try {
			Symbole s = tds.ajouter("c", Symbole.CAT_LOCAL, "f");
			s.set_rang(1);
		} catch (Exception e) {
			LOG.warning(e.getMessage());
		}
		try {
			Symbole s = tds.ajouter("x", Symbole.CAT_LOCAL, "f");
			s.set_rang(2);
		} catch (Exception e) {
			LOG.warning(e.getMessage());
		}
		//affichage
		System.out.println(tds.toString());
		//recherche
		Symbole s = null;
		s = tds.rechercher("x", Symbole.SCOPE_GLOBAL);
		System.out.println("1)"+s);
		s = tds.rechercher("y", Symbole.SCOPE_GLOBAL);
		System.out.println("2)"+s);
		s = tds.rechercher("f", Symbole.SCOPE_GLOBAL);
		System.out.println("3)"+s);
		s = tds.rechercher("a", "f");
		System.out.println("4)"+s);
		s = tds.rechercher("b", "f");
		System.out.println("5)"+s);
		s = tds.rechercher("x", "f");
		System.out.println("6)"+s);
		s = tds.rechercher("z", "f");
		System.out.println("7)"+s);
	}
}
