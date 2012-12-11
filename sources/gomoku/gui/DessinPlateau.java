package gomoku.gui;

import gomoku.jeu.* ;
import javax.swing.JPanel;
import gomoku.regles.*;
import java.awt.*;
import java.awt.event.*;


public class DessinPlateau extends JPanel {

	private int largeur, hauteur;
	private Plateau plateau;

	public DessinPlateau(Plateau p) {
        this.plateau = p;
        this.largeur = p.largeur();
        this.hauteur = p.hauteur();

  	}      
       
	public void paint(Graphics g){


    	
		for(int iX = this.largeur; iX < this.largeur*this.largeur; iX+=40){
        	for(int iY = this.hauteur; iY < this.hauteur*this.hauteur; iY+=40){          
                g.setColor(Color.RED);
            	g.drawRect(iX,iY,40,40);
    	    }
    	}

        //On parcours le plateau
        for(int iX = 1; iX<this.largeur; iX++) {
            for (int iY = 1;iY<this.hauteur ;iY++ ) {
                // Si l'emplacement contient la couleur NOIR, on dessine une pierre NOIRE
                if(plateau.contenu(new PierreCoordonnees(iX,iY)) == Joueur.NOIR) {
                    g.setColor(Color.BLACK);
                    g.fillRect(iX*this.largeur-5,iY*this.hauteur-5,20,20);
                    
                }
                // Si l'emplacement contien la couleur BLANC, on dessine une pierre BLANCHE
                if(plateau.contenu(new PierreCoordonnees(iX,iY)) == Joueur.BLANC) {
                    g.setColor(Color.WHITE);
                    g.fillRect(iX*this.largeur-5,iY*this.hauteur-5,20,20);
                }
            }
        }
	}   	
}