package gomoku.gui;

import gomoku.jeu.* ;
import javax.swing.JPanel;
import gomoku.regles.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.awt.Image;
import java.io.File;
import java.io.IOException;


public class DessinPlateau extends JPanel {

    private int largeur, hauteur;
    private Plateau plateau;
    private Image fond, pionBlanc, pionNoir;

    public DessinPlateau(Plateau p) {
        this.plateau = p;
        this.largeur = p.largeur();
        this.hauteur = p.hauteur();
    }      
       
    public void paintComponent(Graphics g){
        super.paintComponent(g);
               
        try {
            fond = ImageIO.read(new File("images/fond.png"));
            g.drawImage(fond, 0, 0, this.getWidth(), this.getHeight(), this);

        } 
        catch (IOException e) {
            e.printStackTrace();
        }


        // On dessine le plateau de jeu	
        for(int iX = 0; iX < this.largeur-1; iX++){
        	for(int iY = 0; iY < this.hauteur-1; iY++){          
                g.setColor(Color.BLACK);
                g.drawRect(30*iX+30, 30*iY+30, 30, 30);
    	}
        }

        // On parcours le plateau pour savoir si des pions sont placés 
        for(int iX = 0; iX<this.largeur; iX++) {
            for (int iY = 0;iY<this.hauteur;iY++ ) {
                // Si l'emplacement contient la couleur NOIR, on dessine une pierre NOIRE
                if(plateau.contenu(new PierreCoordonnees(iX,iY)) == Joueur.NOIR) {
                    try {  
                        pionNoir = ImageIO.read(new File("images/pion_noir.png"));
                        g.drawImage(pionNoir,((iX+1)*30)-15, ((iY+1)*30)-15, this);   
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }    
                    //g.setColor(Color.BLACK);  
                    //g.fillOval(((iX+1)*30)-15, ((iY+1)*30)-15, 30, 30);             
                }
                // Si l'emplacement contient la couleur BLANC, on dessine une pierre BLANCHE
                if(plateau.contenu(new PierreCoordonnees(iX,iY)) == Joueur.BLANC) {   
                    try {  
                        pionBlanc = ImageIO.read(new File("images/pion_blanc.png"));
                        g.drawImage(pionBlanc,((iX+1)*30)-15, ((iY+1)*30)-15, this);   
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }    
                    //g.setColor(Color.WHITE);
                   // g.fillOval(((iX+1)*30)-15, ((iY+1)*30)-15, 30, 30);              
                   // g.setColor(Color.BLACK);
                    //g.drawOval(((iX+1)*30)-15, ((iY+1)*30)-15, 30, 30); 
                }
            }
        }
    }   	
}