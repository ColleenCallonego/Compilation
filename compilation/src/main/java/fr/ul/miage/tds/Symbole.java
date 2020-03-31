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

import java.util.Properties;
import java.util.logging.Logger;

/**
 * Classe qui représente un symbole de la table des symboles
 * dans le projet du cours de Compilation de la
 * licence MIASHS/MIAGE
 * @author azim roussanaly
 */
public class Symbole {
	private static final Logger LOG = Logger.getLogger(Symbole.class.getName());
	
	//const
	public static final String PROP_NOM = "nom";
	public static final String PROP_VALEUR = "val";
	public static final String PROP_RANG = "#";
	public static final String PROP_NBPARAM = "nbparam";
	public static final String PROP_NBLOC = "nbloc";
	
	public static final String PROP_SCOPE = "scope";
	public static final String SCOPE_GLOBAL = "global";
		
	public static final String PROP_TYPE = "type";
	public static final String TYPE_ENTIER = "int";
	public static final String TYPE_VOID = "void";
	
	public static final String PROP_CATEGORIE = "cat";
	public static final String CAT_LOCAL = "local";
	public static final String CAT_PARAMETRE = "param";
	public static final String CAT_GLOBAL = "global";
	public static final String CAT_FONCTION = "fonction";
	
	//fields
	private Properties prop;

	//constructors
	public Symbole() {
		prop = new Properties();
	}
	public Symbole(String nom, String cat, String scope) {
		prop = new Properties();
		prop.put(PROP_NOM, nom);
		prop.put(PROP_CATEGORIE, cat);
		prop.put(PROP_SCOPE, scope);
	}

	//methods
	/**
	 * fournit le nom du symbole
	 * @return
	 */
	public String getNom() {
		return prop.getProperty(PROP_NOM);
	}
	/**
	 * fournit le scope du symbole
	 * @return
	 */
	public String getScope() {
		return prop.getProperty(PROP_SCOPE);
	}
	/**
	 * fournit la catégorie du symbole (global, local, param ou fonction)
	 * @return
	 */
	public String getCat() {
		return prop.getProperty(PROP_CATEGORIE);
	}
	/**
	 * fournit la valeur d'une variable globale
	 * @return
	 */
	public int get_valeur() {
		int res = 0; 
		try {
			res = Integer.parseInt(prop.getProperty(PROP_VALEUR));
		} catch (NumberFormatException e) {
			//res = 0 par défaut
		}
		return res;
	}
	/**
	 * fournit le rang d'un paramètre ou d'une variable locale d'une variable globale
	 * @return
	 */
	public int get_rang() {
		int res = 0; 
		try {
			res = Integer.parseInt(prop.getProperty(PROP_RANG));
		} catch (NumberFormatException e) {
			//res = 0 par défaut
		}
		return res;
	}
	/**
	 * fournit le nombre de paramètres d'une fonction
	 * @return
	 */
	public int get_nbparam() {
		int res = 0; 
		try {
			res = Integer.parseInt(prop.getProperty(PROP_NBPARAM));
		} catch (NumberFormatException e) {
			//res = 0 par défaut
		}
		return res;
	}
	/**
	 * fournit le nombre de variables locales d'une fonction
	 * @return
	 */
	public int get_nbloc() {
		int res = 0; 
		try {
			res = Integer.parseInt(prop.getProperty(PROP_NBLOC));
		} catch (NumberFormatException e) {
			//res = 0 par défaut
		}
		return res;
	}
	/**
	 * met à jour la valeur d'une variable globale
	 * @return
	 */
	public Symbole set_valeur(int v) {
		prop.put(PROP_VALEUR, String.valueOf(v));
		return this;
	}
	/**
	 * met à jour le rang d'une variable locale ou celui d'un paramètre
	 * @return
	 */
	public Symbole set_rang(int v) {
		prop.put(PROP_RANG, String.valueOf(v));
		return this;
	}
	/**
	 * met à jour le nombre de paramètres d'une fonction
	 * @return
	 */
	public Symbole set_nbparam(int v) {
		prop.put(PROP_NBPARAM, String.valueOf(v));
		return this;
	}
	/**
	 * met à jour le nombre de variables locales d'une fonction
	 * @return
	 */
	public Symbole set_nbloc(int v) {
		prop.put(PROP_NBLOC, String.valueOf(v));
		return this;
	}
	@Override
	public String toString() {
		return prop.toString();
	}
	
}
