package gomoku.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gomoku.cli.*;
import gomoku.jeu.*;

public class Selection extends JFrame implements ActionListener {

  // le panel
  private JPanel pan1 = new JPanel();
  private JPanel pan2 = new JPanel();
  private JPanel pan3 = new JPanel();
  private JPanel pan4 = new JPanel();
  pan1.setLayout(new BoxLayout(pan1, BoxLayout.LINE_AXIS));
  pan1.add(labelC);
  // les bouttons
  private JButton boutonIA = new JButton("Jouer contre l'IA");
  private JButton boutonH = new JButton("Jouer contre un ami");
  private JButton boutonIAG = new JButton("Jouer contre l'IA");
  private JButton boutonHG = new JButton("Jouer contre un ami");

  // les labels
  private JLabel labelG = new JLabel("Mode Graphique :");
  private JLabel labelC = new JLabel("Mode M.Beaufils :");

  // les joueurs humains
  private JoueurAbstrait jh1 = new JoueurHumain(Joueur.NOIR);
  private JoueurAbstrait jh2 = new JoueurHumain(Joueur.BLANC);

  // les joueurs IA
  private JoueurAbstrait jIA1 = new JoueurCybernetique(Joueur.NOIR);
  private JoueurAbstrait jIA2 = new JoueurCybernetique(Joueur.BLANC);

  public void actionPerformed(ActionEvent e) {
    if ((JButton)e.getSource() == boutonIA)
      new GomokuCLI(jh1, jIA2);
    else if ((JButton)e.getSource() == boutonH)
      new GomokuCLI(jh1, jh2);
    else if ((JButton)e.getSource() == boutonIAG)
      new GomokuGUI(jh1, jIA2);
    else if ((JButton)e.getSource() == boutonHG)
      new GomokuGUI(jh1, jh2);
    this.dispose();
    this.setVisible(false);
  }

  public Selection () {

    this.setTitle("Animation");
    this.setSize(400, 300);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);

    boutonIA.addActionListener(this);
    boutonH.addActionListener(this);
    boutonIAG.addActionListener(this);
    boutonHG.addActionListener(this);

    pan.add(labelC);
    pan.add(boutonIA);
    pan.add(boutonH);
    pan.add(labelG);
    pan.add(boutonIAG);
    pan.add(boutonHG);

    this.setContentPane(pan);
    this.setVisible(true);
  }

  public static void main (String[] args) {
    Selection s = new Selection();
  }
}
