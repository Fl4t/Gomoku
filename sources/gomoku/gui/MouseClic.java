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

		PierreCoordonnees coordPierre = new PierreCoordonnees(e.getX(),e.getY());
		partie.placerPierreAuxCoor(coordPierre);
	}
}
