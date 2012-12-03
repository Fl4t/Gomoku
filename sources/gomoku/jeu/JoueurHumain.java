package gomoku.jeu;

public class JoueurHumain implements Joueur {

  /**
   * couleur attribué au joueur
   */
	private int couleur;
  private int nbCoups;

  public JoueurHumain (int c) {
    this.couleur = c;
    this.nbCoups = 60;
  }

  /**
   * @override
   * Couleur du joueur (retourne une des constantes NOIR ou BLANC)
   */
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
   * Place une pierre et décremente le nombre de coups jouables
   */
  public void jouerUnCoup(Plateau p, Coordonnees c) {
    p.placer(c, this.couleur());
    this.nbCoups--;
  }
}
