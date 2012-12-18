/**
 * @author julien Stechele et Thomas Ruchon
 * @version 1.0
 */

package gomoku.jeu;

/** Interface Visuel, implémente les messages
 * suivant si c'est le mode GUI ou CLI */
public interface Visuel {

  /** affichage de la grille */
  void afficherLaGrille();

  /** affichage du joueur gagant */
  void leJoueurAGagne(String s);

  /** affichage lorsque la partie est nulle */
  void laPartieEstNulle();
}
