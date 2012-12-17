package gomoku.gui;

import javax.swing.*;
import java.awt.event.*;
import gomoku.jeu.*;
import java.lang.Math;

public class MouseClic extends MouseAdapter {

  private PartieGUI partie;

  public MouseClic(PartieGUI p) {
    this.partie = p;
  }

  public void mouseClicked(MouseEvent e) {
    // On récupère le plateau de la partie
    Plateau plateau = this.partie.getPlateau();

    // On récupère les dimensions en nombre de cases
    int largeur = plateau.largeur();
    int hauteur = plateau.hauteur();

    int coordX = (int) Math.round((e.getX()-30)/(double) 30);
    int coordY = (int) Math.round((e.getY()-30)/(double) 30);

    if(coordX >= 0 && coordX <= 18 && coordY >= 0 && coordY <= 18) {
      this.partie.jouer(new PierreCoordonnees(coordX, coordY));
    }
  }
}
