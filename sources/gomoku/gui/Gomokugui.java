package gomoku.gui;

import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*; 
import gomoku.regles.*;
import gomoku.jeu.*;
 
public class Gomokugui extends JFrame {

 
	public Gomokugui(Partie p) {

   Plateau plateau = p.getPlateau();



    	
    	//Définit un titre pour notre fenêtre
    	this.setTitle("Gomoku");
    	//Définit sa taille : 500 pixels de large et 500 pixels de haut
    	this.setSize(plateau.largeur()*30,plateau.hauteur()*30);
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

      menuBar.add(jeu);
        
      setJMenuBar(menuBar);

      this.setLayout(new BorderLayout());

      // On crée un dessin de type DessinPlateau (JPanel)
      DessinPlateau dessin = new DessinPlateau(plateau);

      // On ajoute le dessin à la JFrame
      this.getContentPane().add(dessin, BorderLayout.CENTER);

      getContentPane().add(dessin);

      MouseClic me = new MouseClic(dessin, p);
      dessin.addMouseListener(me);

      //Rend la fenêtre visible
      this.setVisible(true);
  	}   

    
    public static void main(String[] args) {
    
      JoueurHumain joueur1 = new JoueurHumain(Joueur.NOIR);
      JoueurHumain joueur2 = new JoueurHumain(Joueur.BLANC);

      Partie partie = new Partie(joueur1, joueur2, new Grille(new Gomoku()));

      Gomokugui gomoku = new Gomokugui(partie);
  }
}







