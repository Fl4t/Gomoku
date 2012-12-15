package gomoku.jeu;

import javax.swing.JOptionPane;
import javax.swing.JComponent;
import javax.swing.*;
import java.awt.event.*;
import gomoku.jeu.*;
import gomoku.gui.MouseClic;
import java.lang.Math;

public class PartieGUI extends Partie {

  private JComponent component;

  public PartieGUI(JoueurAbstrait jNoir, JoueurAbstrait jBlanc,
      Plateau plateau, JComponent component) {
    super(jNoir, jBlanc, plateau);
    this.component = component;
  }

  public void jouer() {
    String str;
    while (this.coupAjouer()) {
      if (this.getGagnant() == 0) {
        if (this.demanderDeJouer())
          this.afficherLaGrille();
        else
          this.nePeutPasPlacerIci();
      } else {
        if (this.getGagnant() == Joueur.NOIR)
          str = this.jNoir.couleurIntToString();
        else
          str = this.jBlanc.couleurIntToString();
        this.leJoueurAGagne(str);
        break;
      }
    }
    if (!this.coupAjouer())
      this.laPartieEstNulle();
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
  }

  public void getLesCoordonneesGUI() {
    MouseListener[] ecouteurs = this.component.getMouseListeners();
    Coordonnees c = ((MouseClic)ecouteurs[0]).getLesCoordonnees();
    System.out.println("abscisse : "+c.abscisse()+" ordonnee : "+c.ordonnee());
  }
}
