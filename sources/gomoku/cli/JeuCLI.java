/**
 * @author julien Stechele et Thomas Ruchon
 * @version 1.0
 */

package gomoku.cli;

import gomoku.regles.*;
import gomoku.jeu.*;

/** Le jeu en mode CLI (Command Line Interface) */
public class JeuCLI {

  /** Constructeur du jeu en mode CLI */
  public JeuCLI(JoueurAbstrait j1, JoueurAbstrait j2, Plateau plateau) {

    Partie partie = new Partie(j1, j2, plateau, new VisuelCLI(plateau));
    partie.jouer(null);
  }
}
