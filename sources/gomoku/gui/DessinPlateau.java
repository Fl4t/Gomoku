/**
 * @author julien Stechele et Thomas Ruchon
 * @version 1.0
 */

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


/** La représentation graphique du plateau */
public class DessinPlateau extends JPanel {

  /** Largeur du plateau */
  /** Hauteur du plateau */
  /** Espace du plateau */
  private int largeur, hauteur,espace;

  /** Le plateau */
  private Plateau plateau;

  /** Elements graphiques */
  private Image fond, pionBlanc, pionNoir;

  /** Constructeur DessinPlateau */
  public DessinPlateau(Plateau p) {
    this.plateau = p;
    this.largeur = p.largeur();
    this.hauteur = p.hauteur();
  }

  /** Redéfinition de la méthode paintComponent
   * pour dessiner le plateau correspondant à la partie
   */
  public void paintComponent(Graphics g){
    super.paintComponent(g);

    try {
      fond = ImageIO.read(new File("images/fond.png"));
      g.drawImage(fond, 0, 0, this.getWidth(), this.getHeight(), this);

    }
    catch (IOException e) {
      e.printStackTrace();
    }

    // On regarde si c'est un morpion
    if(this.largeur == 3 && this.hauteur == 3) {
      espace = 70;
    }
    else if (this.largeur == 19 && this.hauteur ==19) {
      espace = 30;
    }
    for(int iX = 0; iX < this.largeur-1; iX++){
      for(int iY = 0; iY < this.hauteur-1; iY++){
        g.setColor(Color.BLACK);
        g.drawRect(espace*iX+espace, espace*iY+espace, espace, espace);
      }
    }

    // On parcours le plateau pour savoir si des pions sont placés
    for(int iX = 0; iX<this.largeur; iX++) {
      for (int iY = 0;iY<this.hauteur;iY++ ) {
        // Si l'emplacement contient la couleur NOIR, on dessine une pierre NOIRE
        if(plateau.contenu(new PierreCoordonnees(iX,iY)) == Joueur.NOIR) {
          try {
            pionNoir = ImageIO.read(new File("images/pion_noir.png"));
            g.drawImage(pionNoir,((iX+1)*espace)-15, ((iY+1)*espace)-15, this);
          }
          catch (IOException e) {
            e.printStackTrace();
          }

        }
        // Si l'emplacement contient la couleur BLANC, on dessine une pierre BLANCHE
        if(plateau.contenu(new PierreCoordonnees(iX,iY)) == Joueur.BLANC) {
          try {
            pionBlanc = ImageIO.read(new File("images/pion_blanc.png"));
            g.drawImage(pionBlanc,((iX+1)*espace)-15, ((iY+1)*espace)-15, this);
          }
          catch (IOException e) {
            e.printStackTrace();
          }
        }
      }
    }
  }
}
