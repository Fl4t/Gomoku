/**
 * @author julien Stechele et Thomas Ruchon
 * @version 1.0
 */

package gomoku.jeu;

import gomoku.regles.Variante;

/** Classe qui implémente alignement */
public class VecteurAlignement implements Alignement {

  /** Les coordonnées debut et fin de l'alignement */
  Coordonnees debut, fin;

  /** La variante de l'alignement */
  Variante v;

  /** Constructeur permetant d'instancier un alignement */
  public VecteurAlignement(Coordonnees coord1, Coordonnees coord2, Variante v) {
    this.debut = coord1;
    this.fin = coord2;
    this.v = v;
  }

  public Coordonnees debut() {
    return this.debut;
  }

  public Coordonnees fin() {
    return this.fin;
  }

  public int taille() {
    return v.verifAlignement().tailleMin();
  }
}
