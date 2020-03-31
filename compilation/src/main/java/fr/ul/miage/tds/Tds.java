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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Classe qui représente un Table des symboles
 * dans le projet du cours de Compilation de la
 * licence MIASHS/MIAGE
 * @author azim roussanaly
 */
public class Tds {
	private static final Logger LOG = Logger.getLogger(Tds.class.getName());

	//fields
	private Map<String, List<Symbole>> table;
	//contructors
	public Tds() {
		table = new HashMap<String, List<Symbole>>();
	}
	//methods
	/**
	 * Vérifier un symbole dans la TDS
	 * @param nom
	 * @param scope
	 * @return le symbole sinon null
	 */
	public Symbole verifier(String nom, String scope){
		Symbole res = null;
		List<Symbole> l = table.get(nom);
		if (l != null) {
			for (Symbole s : l) {
				if (nom.equalsIgnoreCase(s.getNom()) && (scope.equalsIgnoreCase(s.getScope()))){
					res = s;
					break;
				}
			}
		}
		return res;		
	}
	/**
	 * rechercher un symbole avec une priorité au scope local
	 * @param nom
	 * @param scope
	 * @return
	 */
	public Symbole rechercher(String nom, String scope){
		Symbole res = verifier(nom, scope);
		if (res == null) {
			res = verifier(nom, Symbole.SCOPE_GLOBAL);
		}
		return res;
	}
	/**
	 * Ajouter un symbole
	 * @param nom
	 * @param cat
	 * @param scope
	 * @return le symbole ajouté
	 * @throws Exception si le symbole existe déjà
	 */
	public Symbole ajouter(String nom, String cat, String scope) throws Exception{
		Symbole res = verifier(nom, scope);
		if (res != null) {
			throw new Exception("Le symbole existe déjà : " + res.getNom());
		}
		if (!table.containsKey(nom)) {
			table.put(nom, new ArrayList<Symbole>());
		}
		List<Symbole> l = table.get(nom);
		res = new Symbole(nom, cat, scope);
		l.add(res);
		return res;
	}
	@Override
	public String toString() {
		StringBuffer res = new StringBuffer();
		res.append("Table des symboles \n");
		res.append("================== \n");
		for (String k : table.keySet()){
			for (Symbole s : table.get(k)) {
				res.append(s.toString());
				res.append("\n");
			}
		}
		res.append("------------------ \n");
		return res.toString();
	}

}
