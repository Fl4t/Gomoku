package gomoku.cli;

import gomoku.regles.Gomoku;
import gomoku.jeu.*;

public class GomokuCLI {

  public GomokuCLI() {
    JoueurAbstrait joueur1 = new JoueurHumain(Joueur.NOIR);
    JoueurAbstrait joueur2 = new JoueurHumain(Joueur.BLANC);
    Partie partie = new PartieCLI(joueur1, joueur2,
        new Grille(new Gomoku()));

    partie.jouer();
  }
}
