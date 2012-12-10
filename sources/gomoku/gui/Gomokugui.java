package gomoku.gui;

import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*; 
import gomoku.regles.*;
import gomoku.jeu.*;
 
public class Gomokugui extends JFrame {

 
	public Gomokugui(Partie p) {

    	//Rend la fenêtre visible
    	this.setVisible(true);
    	//Définit un titre pour notre fenêtre
    	this.setTitle("Gomoku");
    	//Définit sa taille : 500 pixels de large et 500 pixels de haut
    	this.setSize(500, 500);
    	//Nous demandons maintenant à notre objet de se positionner au centre
    	this.setLocationRelativeTo(null);
    	//Termine le processus lorsqu'on clique sur la croix rouge
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //On interdit le redimensionnement de la fenêtre
      this.setResizable(false);

      DessinPlateau dessin = new DessinPlateau(p.getPlateau());

      setContentPane(dessin);

      MouseClic me = new MouseClic(dessin, p);
      dessin.addMouseListener(me);
   

      JMenuBar menuBar = new JMenuBar();
      JMenu jeu = new JMenu("Jeu");

      JMenuItem itemLancer = new JMenuItem("Lancer");
      jeu.add(itemLancer);

      JMenuItem itemQuitter = new JMenuItem("Quitter");
      jeu.add(itemQuitter);

      menuBar.add(jeu);
        
      setJMenuBar(menuBar);
  	}   

    
    public static void main(String[] args) {
    
      JoueurHumain joueur1 = new JoueurHumain(Joueur.NOIR);
      JoueurHumain joueur2 = new JoueurHumain(Joueur.BLANC);

      Partie partie = new Partie(joueur1, joueur2, new Grille(new Gomoku()));

      Gomokugui gomoku = new Gomokugui(partie);
  }
}







