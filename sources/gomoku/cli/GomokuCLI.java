package gomoku.cli;

import gomoku.jeu.Grille;
import gomoku.regles.Gomoku;
import gomoku.jeu.JoueurHumain;
import gomoku.jeu.Joueur;
import gomoku.jeu.Partie;
import gomoku.jeu.Coordonnees;

public class GomokuCLI {

  public static void main (String[] args) {
    Partie partie = new Partie(new JoueurHumain(Joueur.NOIR),
        new JoueurHumain(Joueur.BLANC),
        new Grille(new Gomoku()));
    partie.jouerCLI();
  }
}
