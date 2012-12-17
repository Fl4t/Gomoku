package gomoku.cli;

import gomoku.regles.Gomoku;
import gomoku.jeu.*;

public class GomokuCLI {

  public GomokuCLI(JoueurAbstrait j1, JoueurAbstrait j2) {
    Partie partie = new PartieCLI(j1, j2, new Grille(new Gomoku()));
    partie.jouer(null);
  }
}
