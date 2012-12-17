package gomoku.jeu;

import javax.swing.JOptionPane;
import javax.swing.JComponent;
import javax.swing.*;
import java.awt.event.*;
import gomoku.jeu.*;
import gomoku.gui.MouseClic;
import gomoku.regles.Variante;
import gomoku.regles.RegleCoup;
import java.lang.Math;

public class PartieGUI extends Partie {

  private JComponent component;

  public PartieGUI(JoueurAbstrait jNoir, JoueurAbstrait jBlanc,
      Plateau plateau, JComponent component) {
    super(jNoir, jBlanc, plateau);
    this.component = component;
  }

  public void leJoueurAGagne(String str) {
    JOptionPane.showMessageDialog(null, "Le joueur " + str +
        " a gagné !" , "Fin", JOptionPane.CLOSED_OPTION,null);
  }

  public void laPartieEstNulle() {
    JOptionPane.showMessageDialog(null, "Partie nulle !" ,
        "Fin", JOptionPane.CLOSED_OPTION,null);
  }

  public void afficherLaGrille() {
    this.component.repaint();
    this.component.validate();
  }
}
