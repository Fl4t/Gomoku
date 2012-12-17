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

  public void jouerAuClic(Coordonnees c) {
    String str;
    if (this.coupAjouer()) {
      if(this.demanderDeJouer(c))
        this.afficherLaGrille();
      if (this.gagnant != 0) {
        if (this.getGagnant() == Joueur.NOIR)
          str = this.jNoir.couleurIntToString();
        else
          str = this.jBlanc.couleurIntToString();
        this.leJoueurAGagne(str);
      }
    } else {
      this.laPartieEstNulle();
    }
  }

  public boolean demanderDeJouer(Coordonnees c) {
    Variante v = ((Grille)plateau).getVariante();
    RegleCoup r = v.verifCoup();
    if (this.premierCoup) {
      this.premierCoup = false;
      this.joueurJoue(c);
      return true;
    } else {
      if (r.estValide(c, plateau) &&
        this.plateau.contenu(c) == Joueur.VIDE)
      {
        this.joueurJoue(c);
        return true;
      }
    }
    return false;
  }

  public void nePeutPasPlacerIci() {
    JOptionPane.showMessageDialog(null, "Vous ne pouvez pas placer ici." ,
        "Fin", JOptionPane.CLOSED_OPTION,null);
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
