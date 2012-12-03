package gomoku.jeu;

public class JoueurHumain implements Joueur {

  /**
   * couleur attribué au joueur
   */
	private int couleur;

  public JoueurHumain (int c) {
    this.couleur = c;
  }

  /*
   * @override
   * Couleur du joueur (retourne une des constantes NOIR ou BLANC)
   */
  public int couleur() {
    return this.couleur;
  }	
}
