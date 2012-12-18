package gomoku.gui;

import javax.swing.*;
import java.awt.event.*;
import gomoku.jeu.*;
import java.lang.Math;

public class MouseClic extends MouseAdapter {

  private Partie partie;

  public MouseClic(Partie p) {
    this.partie = p;
  }

/** Permet de récupérer les coordonnées lorsque
  * le joueur clique sur le plateau
  */
  public void mouseClicked(MouseEvent e) {
    // On récupère le plateau de la partie
    Plateau plateau = this.partie.getPlateau();

    // On récupère les dimensions en nombre de cases
    int largeur = plateau.largeur();
    int hauteur = plateau.hauteur();
    int espace = 0;

     if(largeur == 3 && hauteur == 3) {
      espace = 70;
    }
    else if (largeur == 19 && hauteur ==19) {
      espace = 30;
    }

    int coordX = (int) Math.round((e.getX()-espace)/(double) espace);
    int coordY = (int) Math.round((e.getY()-espace)/(double) espace);

   if(coordX >= 0 && coordX < largeur && coordY >= 0 && coordY < hauteur) {
      this.partie.jouer(new PierreCoordonnees(coordX, coordY));

    }
  }
}
