/**
 * @author julien Stechele et Thomas Ruchon
 * @version 1.0
 */

package gomoku.regles ;

/** Cette classe décrit les caractéristiques du
 * Morpion classique. */
public class Morpion extends Variante {

  /** Constructeur permettant d'instancier
   * la variante Morpion */
  public Morpion() {
    super(3, 3, // plateau 3x3 intersections
        new RegleCoup(new Moore(), 2), // on joue à distance 2
        // dans le voisinage de
        // Moore des pierres déjà
        // jouées
        new RegleAlignement(false, 3, 3)) ; // il peut y avoir
    // des pierres à
    // l'extrémité d'un
    // alignement mais
    // il doit comporter
    // exactement 3
    // pierres
  }
}
