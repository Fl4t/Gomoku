package gomoku.jeu;

public class NouveauJoueur implements Joueur {

  // couleur attribué au joueur
	protected int couleur;

  public NouveauJoueur (int c) {
    this.couleur = c;
  }

  /** Couleur du joueur (retourne une des constantes NOIR ou BLANC) */
  public int couleur() {
    return this.couleur;
  }	
}