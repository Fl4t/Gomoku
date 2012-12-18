package gomoku.cli;

import gomoku.regles.*;
import gomoku.jeu.*;

public class GomokuCLI {

  public GomokuCLI(JoueurAbstrait j1, JoueurAbstrait j2, Plateau plateau) {

    Partie partie = new Partie(j1, j2, plateau, new VisuelCLI(plateau));
    partie.jouer(null);
  }
}
