package gomoku.gui;

import gomoku.jeu.* ;
import javax.swing.JPanel;
import gomoku.regles.*;
import java.awt.*;
import java.awt.event.*;


public class DessinPlateau extends JPanel {

	private int largeur, hauteur;

	public DessinPlateau(Plateau p) {
        this.largeur = p.largeur();
        this.hauteur = p.hauteur();

  	}      
       
	public void paintComponent(Graphics g){
    	g.drawRect(20, 20, 380, 380);

    	for (int i=20;i<=400 ;i+=this.largeur ) {
    		g.drawLine(i,20,i,400);
    	}

    	for (int i=20;i<=400 ;i+=this.hauteur ) {
    		g.drawLine(20,i,400,i);
    	} 	
	}   
	public int getLargeur(){
		return this.largeur;
	}
	
	public int getHauteur(){
		return this.hauteur;
	}
	
}
