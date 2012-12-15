package gomoku.gui;

import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import gomoku.regles.*;
import gomoku.jeu.*;

public class Fenetre extends JFrame {

  private JComponent component;

  public Fenetre(Plateau p) {

    //Définit un titre pour notre fenêtre
    this.setTitle("Gomoku");
    //Définit sa taille : 500 pixels de large et 500 pixels de haut
    this.setSize(605,640);
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
      public void actionPerformed(ActionEvent arg0) {
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

  public JComponent getDessinPlateau() {
    return this.component;
  }
}
