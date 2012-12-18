/**
 * @author julien Stechele et Thomas Ruchon
 * @version 1.0
 */

package gomoku.gui;

import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import gomoku.regles.*;
import gomoku.jeu.*;

/** Class Fenetre représentant le jeu en
 * mode GUI (Graphical User Interface) */
public class Fenetre extends JFrame {

  /** Composant interne de la JFrame */
  private JComponent component;

  /** Constructeur de la Fenetre */
  public Fenetre(Plateau p) {

    int hauteur = p.hauteur();
    int largeur = p.largeur();

    if(largeur == 19 && hauteur == 19) {
      // Définit sa taille
      this.setSize(605,640);
      // Définit un titre pour notre fenêtre
      this.setTitle("Gomoku");
    }

    if(largeur == 3 && hauteur == 3) {
      // Définit sa taille
      this.setSize(290,320);
      // Définit un titre pour notre fenêtre
      this.setTitle("Morpion");
    }
    //Nous demandons maintenant à notre objet de se positionner au centre
    this.setLocationRelativeTo(null);
    //Termine le processus lorsqu'on clique sur la croix rouge
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //On interdit le redimensionnement de la fenêtre
    this.setResizable(false);

    // On crée un menu
    JMenuBar menuBar = new JMenuBar();
    JMenu jeu = new JMenu("Jeu");
    //On ajoute l'option Lancer une partie
    JMenuItem itemLancer = new JMenuItem("Lancer une partie");
    jeu.add(itemLancer);
    //On ajoute l'option Quitter
    JMenuItem itemQuitter = new JMenuItem("Quitter");
    jeu.add(itemQuitter);

    // On ajoute l'evenement fermet l'application à l'objet Quitter du menu
    itemQuitter.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });

    // On ajoute le menu créé précedemment dans la fenêtre
    menuBar.add(jeu);
    setJMenuBar(menuBar);

    this.component = new DessinPlateau(p);

    // On ajoute le dessin à la JFrame
    this.getContentPane().add(component);

    //Rend la fenêtre visible
    this.setVisible(true);
  }

  /** Méthode permettant de retourner les composants
   * @return JComponent */
  public JComponent getDessinPlateau() {
    return this.component;
  }
}
