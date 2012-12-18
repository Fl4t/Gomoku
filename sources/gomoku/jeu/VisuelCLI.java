/**
 * @author julien Stechele et Thomas Ruchon
 * @version 1.0
 */

package gomoku.jeu;

/** Classe qui implémente Visuel et permet
 * d'afficher les messages en mode CLI. */
public class VisuelCLI implements Visuel {

  /** le plateau à afficher */
  private Plateau plateau;

  /** Constructeur permettant d'instancier
   * un VisuelCLI
   * @param plateau le plateau du jeu */
  public VisuelCLI(Plateau plateau) {
    this.plateau = plateau;
  }

  public void leJoueurAGagne(String str) {
    System.out.println("félicitation au joueur " + str);
    System.exit(0);
  }

  public void laPartieEstNulle() {
    System.out.println("Partie nulle!");
    System.exit(0);
  }

  public void afficherLaGrille() {
    System.out.println(this.plateau);
  }
}
