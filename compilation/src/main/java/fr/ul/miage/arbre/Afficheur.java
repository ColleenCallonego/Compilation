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

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Description :
 * Classe qui affiche un arbre/noeud
 * @author Azim Roussanaly
 * Created at 28 févr. 2019
 */
public class Afficheur extends Application {
	//attribut
	private static Noeud arbre = null;
	//methodes
	private static TreeItem<Noeud> buildTreeItem(Noeud n) {
		TreeItem<Noeud> res = new TreeItem<>(n);
		if (n.estFeuille()) {
			return res;
		}
		for (Noeud f : n.getFils()) {
			TreeItem<Noeud> tmp = buildTreeItem(f);
			res.getChildren().add(tmp);
		}
		return res;
	}
	/**
	 * afficher dans une popup
	 */
	public static void afficher(Noeud noeud) {
		arbre = noeud;
		String args[] = {"Université de Lorraine"};
		launch(args);
	}
	/* (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
	    StackPane root = new StackPane();
	    root.setPadding(new Insets(5));
	    TreeView<Noeud> tree = new TreeView<>(buildTreeItem(arbre));
	    root.getChildren().add(tree);		
	    primaryStage.setTitle("Arbre abstrait");
	    primaryStage.setScene(new Scene(root, 300, 250));
	    primaryStage.show();				
    }
	
}
