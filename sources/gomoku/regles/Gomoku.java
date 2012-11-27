package gomoku.regles ;

/** Cette classe décrit les caractéristiques du Gomoku classique. */
public class Gomoku extends Variante {
  public Gomoku() {
    super(19, 19, // plateau 19x19 intersections
        new RegleCoup(new Moore(), 1), // on joue à distance 1
        // dans le voisinage de
        // Moore des pierres déjà
        // jouées
        new RegleAlignement(false, 5, 5)) ; // il peut y avoir
    // des pierres à
    // l'extrémité d'un
    // alignement mais
    // il doit comporter
    // exactement 5
    // pierres
  }
}
