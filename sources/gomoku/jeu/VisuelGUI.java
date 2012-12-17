package gomoku.jeu;

import javax.swing.JOptionPane;
import javax.swing.JComponent;

public class VisuelGUI implements Visuel {

  private JComponent component;

  public VisuelGUI(JComponent component) {
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
