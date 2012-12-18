/**
 * @author julien Stechele et Thomas Ruchon
 * @version 1.0
 */

package gomoku.jeu ;

/** Implémentation de l'interface coordonnées */
public class PierreCoordonnees implements Coordonnees {

  /** abscisse */
  private int abs;

  /** ordonnee */
  private int ord;

  /** Constructeur permettant d'instancier
   * une Coordonnees de pierre */
  public PierreCoordonnees(int x, int y) {
    this.abs = x;
    this.ord = y;
  }

  public int abscisse() {
    return this.abs;
  }

  public int ordonnee() {
    return this.ord;
  }

}
