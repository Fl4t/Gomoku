public class NouveauJoueur implements Joueur {

	// nom du joueur
	protected String nom;
  // couleur attribué au joueur
	protected int couleur;
	
  /** Constantes permettant de nommer la couleur des joueurs (ou
    * aucun joueur) 
    */
  public int NOIR = -1, VIDE = 0, BLANC = 1 ;

  public NouveauJoueur (String n, int c) {
    this.nom = n;
    this.couleur = c;
  }

  /** Couleur du joueur (retourne une des constantes NOIR ou BLANC) */
  public int couleur() {
    return this.couleur;
  }	
}