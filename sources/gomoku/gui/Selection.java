package gomoku.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gomoku.cli.*;

public class Selection extends JFrame implements ActionListener {
  private JPanel pan = new JPanel();
  private JButton boutonG = new JButton("Gomoku Graphique");
  private JButton boutonC = new JButton("Gomoku Console");

  public void actionPerformed(ActionEvent e) {
    if ((JButton)e.getSource() == boutonG)
      new GomokuGUI();
    else if ((JButton)e.getSource() == boutonC)
      new GomokuCLI();
    this.dispose();
    this.setVisible(false);
  }

  public Selection () {
    this.setTitle("Animation");
    this.setSize(300, 150);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    //Ajout du bouton à notre content pane
    boutonG.addActionListener(this);
    boutonC.addActionListener(this);
    pan.add(boutonG);
    pan.add(boutonC);
    this.setContentPane(pan);
    this.setVisible(true);
  }

  public static void main (String[] args) {
    Selection s = new Selection();
  }
}
