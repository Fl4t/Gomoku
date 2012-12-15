package gomoku.gui;

import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import gomoku.regles.*;
import gomoku.jeu.*;

public class GomokuGUI {

  public static void main(String[] args) {
    JoueurAbstrait joueur1 = new JoueurHumain(Joueur.NOIR);
    JoueurAbstrait joueur2 = new JoueurHumain(Joueur.BLANC);
    Plateau p = new Grille(new Gomoku());
    Fenetre f = new Fenetre(p);
    JComponent component = f.getDessinPlateau();

    PartieGUI partie = new PartieGUI(joueur1, joueur2, p, component);

    MouseClic me = new MouseClic(partie);
    component.addMouseListener(me);

    partie.jouer();
  }
}
