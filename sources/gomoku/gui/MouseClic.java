package gomoku.gui;

import javax.swing.*;
import java.awt.event.*;
import gomoku.jeu.*;
import gomoku.regles.*;
 
public class MouseClic extends MouseAdapter implements MouseListener{
 
	JComponent component;
	Partie partie;
 
	public MouseClic(JComponent component, Partie p) {
		this.component = component;
		this.partie = p;
	}
 
	public void mouseClicked(MouseEvent e){
		// On récupère le plateau de la partie
		Plateau plateau = partie.getPlateau();

		// On récupère les dimensions en nombre de cases
		int largeur = plateau.largeur();
		int hauteur = plateau.hauteur();

		PierreCoordonnees coordPierre = new PierreCoordonnees(e.getX()/largeur,e.getY()/hauteur);
		System.out.println(e.getX()/largeur + " " + e.getY()/hauteur);

		if(partie.placerPierreAuxCoor(coordPierre)) {
			component.repaint();
		}

	}
}
