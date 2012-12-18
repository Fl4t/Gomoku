package gomoku.jeu;

public abstract class JoueurAbstrait implements Joueur {

  private int couleur;

  private int nbCoups;

  public JoueurAbstrait(int c) {
    this.couleur = c;
    this.nbCoups = 60;
  }

  public int couleur() {
    return this.couleur;
  }

  /**
   * Retourne le nombre de coups restants
   */
  public int getNbCoups() {
    return this.nbCoups;
  }

  /**
   * Décrémente le nombre de coups
   */
  public int joueUnePierre() {
    return this.nbCoups--;
  }

/** Demande les coordonnées au joueur
  * @param la partie
  * @return les coordonnées où il va placer la pierre
  */
  public abstract Coordonnees demanderCoorJoueur(Partie p);

  public String couleurIntToString() {
    return this.couleur == Joueur.NOIR ? "NOIR" : "BLANC";
  }
}
