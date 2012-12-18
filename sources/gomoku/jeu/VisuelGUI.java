/**
 * @author julien Stechele et Thomas Ruchon
 * @version 1.0
 */

package gomoku.jeu;

import javax.swing.JOptionPane;
import javax.swing.JComponent;

/** Classe qui implémente Visuel et permet
 * d'afficher les messages en mode GUI. */
public class VisuelGUI implements Visuel {

  /** Les composants de l'interface GUI */
  private JComponent component;

  /** Constructeur permettant d'instancier
   * un VisuelGUI.
   * @param component les composants du GUI. */
  public VisuelGUI(JComponent component) {
    this.component = component;
  }

  public void leJoueurAGagne(String str) {
    JOptionPane.showMessageDialog(null, "Le joueur " + str +
        " a gagné !" , "Fin", JOptionPane.CLOSED_OPTION,null);
    System.exit(0);
  }

  public void laPartieEstNulle() {
    JOptionPane.showMessageDialog(null, "Partie nulle !" ,
        "Fin", JOptionPane.CLOSED_OPTION,null);
    System.exit(0);
  }

  public void afficherLaGrille() {
    this.component.repaint();
    this.component.validate();
  }
}
