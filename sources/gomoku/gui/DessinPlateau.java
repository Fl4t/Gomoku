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
 	
		for(int iX = 0; iX < this.largeur-1; iX++){
        	for(int iY = 0; iY < this.hauteur-1; iY++){          
                g.setColor(Color.BLACK);
            	g.drawRect(30*iX+30, 30*iY+30, 30, 30);
    	    }
    	}
        //On parcours le plateau
        for(int iX = 0; iX<this.largeur; iX++) {
            for (int iY = 0;iY<this.hauteur;iY++ ) {
                // Si l'emplacement contient la couleur NOIR, on dessine une pierre NOIRE
                if(plateau.contenu(new PierreCoordonnees(iX,iY)) == Joueur.NOIR) {
                    g.setColor(Color.BLACK);
                    g.fillRect(((iX+1)*30)-10, ((iY+1)*30)-10, 20, 20);
                    g.drawRect(((iX+1)*30)-10, ((iY+1)*30)-10, 20, 20);                  
                }
                // Si l'emplacement contien la couleur BLANC, on dessine une pierre BLANCHE
                if(plateau.contenu(new PierreCoordonnees(iX,iY)) == Joueur.BLANC) {                 
                    g.setColor(Color.WHITE);
                    g.fillRect(((iX+1)*30)-10, ((iY+1)*30)-10, 20, 20);
                    g.setColor(Color.BLACK);
                    g.drawRect(((iX+1)*30)-10, ((iY+1)*30)-10, 20, 20);
                }
            }
        }
	}   	
}