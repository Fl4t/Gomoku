/**
 * @author julien Stechele et Thomas Ruchon
 * @version 1.0
 */

package gomoku.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gomoku.cli.*;
import gomoku.jeu.*;
import gomoku.regles.*;

/** Cette classe permet d'instancier la fenêtre principale de l'application */
public class Selection extends JFrame implements ActionListener {

  // le panel
  private JPanel pan1 = new JPanel();
  private JPanel pan2 = new JPanel();
  private JPanel pan3 = new JPanel();
  private JPanel pan4 = new JPanel();
  private JPanel pan5 = new JPanel();

  // les bouttons
  private JButton boutonIA = new JButton("Gomoku contre l'IA");
  private JButton boutonH = new JButton("Gomoku contre un ami");
  private JButton boutonIAG = new JButton("Gomoku contre l'IA");
  private JButton boutonHG = new JButton("Gomoku contre un ami");
  private JButton boutonIAM = new JButton("Morpion contre l'IA");
  private JButton boutonHM = new JButton("Morpion contre un ami");
  private JButton boutonIAGM = new JButton("Morpion contre l'IA");
  private JButton boutonHGM = new JButton("Morpion contre un ami");

  // les labels
  private JLabel labelG = new JLabel("Mode Graphique :");
  private JLabel labelC = new JLabel("Mode M.Beaufils :");

  // les joueurs humains
  private JoueurAbstrait jh1 = new JoueurHumain(Joueur.NOIR);
  private JoueurAbstrait jh2 = new JoueurHumain(Joueur.BLANC);

  // les joueurs IA
  private JoueurAbstrait jIA1 = new JoueurCybernetique(Joueur.NOIR);
  private JoueurAbstrait jIA2 = new JoueurCybernetique(Joueur.BLANC);

  private Plateau pM = new Grille(new Morpion());
  private Plateau pG = new Grille(new Gomoku());

  public void actionPerformed(ActionEvent e) {
    if ((JButton)e.getSource() == boutonIA)
      new JeuCLI(jh1, jIA2, pG);
    else if ((JButton)e.getSource() == boutonH)
      new JeuCLI(jh1, jh2, pG);
    else if ((JButton)e.getSource() == boutonIAG)
      new JeuGUI(jh1, jIA2, pG);
    else if ((JButton)e.getSource() == boutonHG)
      new JeuGUI(jh1, jh2, pG);
    else if ((JButton)e.getSource() == boutonIAM)
      new JeuCLI(jh1, jIA2, pM);
    else if ((JButton)e.getSource() == boutonHM)
      new JeuCLI(jh1, jh2,  pM);
    else if ((JButton)e.getSource() == boutonIAGM)
      new JeuGUI(jh1, jIA2, pM);
    else if ((JButton)e.getSource() == boutonHGM)
      new JeuGUI(jh1, jh2,  pM);
    this.dispose();
    this.setVisible(false);
  }

  /** Constructeur de Selection permetant l'instanciation
   * de la fenêtre principale. */
  public Selection () {

    this.setTitle("Choix du mode de jeu");
    this.setSize(800, 200);
    this.setResizable(false);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);

    // Ajout des actions sur les boutons.
    boutonIA.addActionListener(this);
    boutonH.addActionListener(this);
    boutonIAG.addActionListener(this);
    boutonHG.addActionListener(this);
    boutonIAM.addActionListener(this);
    boutonHM.addActionListener(this);
    boutonIAGM.addActionListener(this);
    boutonHGM.addActionListener(this);

    // On place les labels et boutons dans la fenêtre.
    pan1.add(labelC);
    pan2.add(boutonIA);
    pan2.add(boutonH);
    pan2.add(boutonIAM);
    pan2.add(boutonHM);
    pan3.add(labelG);
    pan4.add(boutonIAG);
    pan4.add(boutonHG);
    pan4.add(boutonIAGM);
    pan4.add(boutonHGM);
    pan5.add(pan1);
    pan5.add(pan2);
    pan5.add(pan3);
    pan5.add(pan4);

    this.setContentPane(pan5);
    this.setVisible(true);
  }

  /** Methode principale du programme */
  public static void main (String[] args) {
    Selection s = new Selection();
  }
}
