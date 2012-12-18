/**
 * @author julien Stechele et Thomas Ruchon
 * @version 1.0
 */

package gomoku.jeu;

/** Représente un joueur quelconque (abstrait) */
public abstract class JoueurAbstrait implements Joueur {

  /** La couleur du joueur */
  private int couleur;

  /** Le nombre de coups restants */
  private int nbCoups;

  /** Constructeur permettant de spécifier les
   * attributs couleurs et nbCoups.
   * @param c la couleur */
  public JoueurAbstrait(int c) {
    this.couleur = c;
    this.nbCoups = 60;
  }

  public int couleur() {
    return this.couleur;
  }

  /** Retourne le nombre de coups restants */
  public int getNbCoups() {
    return this.nbCoups;
  }

  /** Décrémente le nombre de coups */
  public int joueUnePierre() {
    return this.nbCoups--;
  }

  /** Demande les coordonnées au joueur
   * @param p partie
   * @return les coordonnées où il va placer la pierre */
  public abstract Coordonnees demanderCoorJoueur(Partie p);

  /** retourne la couleur du joueur en Chaine de caractère */
  public String couleurIntToString() {
    return this.couleur == Joueur.NOIR ? "NOIR" : "BLANC";
  }
}
