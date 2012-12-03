package gomoku.cli;

import gomoku.jeu.Grille;
import gomoku.regles.Gomoku;
import gomoku.jeu.NouveauJoueur;
import gomoku.jeu.Joueur;
import gomoku.jeu.Partie;
import gomoku.jeu.Coordonnees;

public class GomokuCLI {

  public static void main (String[] args) {
    Partie partie = new Partie(new NouveauJoueur(Joueur.NOIR),
                          new NouveauJoueur(Joueur.BLANC),
                          new Grille(new Gomoku()));
    while (partie.coupAjouer()) {
      Coordonnees c = partie.demanderCoor();
      partie.placerPierreAuxCoor(c);
      partie.rafraichirGrille();
    }
    if (partie.estGagne()) {
      System.out.println("félicitation joueur " +
          partie.joueurGagnant());
    } else {
      System.out.println("Partie nulle !");
    }
  }
}
