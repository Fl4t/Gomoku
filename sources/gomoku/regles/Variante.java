package gomoku.regles ;

/** Cette classe décrit les caractéristiques des variantes du
 * jeu */
public abstract class Variante {
    private int largeur, hauteur ;
    private RegleCoup coups ;
    private RegleAlignement alignements ;
     
    /** Construit une variante à partir des dimensions et des règles
     * spécifiées */
    public Variante(int largeur, int hauteur, 
		    RegleCoup verificationDesCoups,
		    RegleAlignement verificationDesAlignements) {
	this.largeur = largeur ;
	this.hauteur = hauteur ;
	this.coups = verificationDesCoups ; 
	this.alignements = verificationDesAlignements ;
    }

    /** Largeur du plateau */
    public int largeur() { 
	return this.largeur ;
    }

    /** Hauteur du plateau */
    public int hauteur() { 
	return this.hauteur ;
    }

    /** La stratégie de vérification de la validité d'un coup
     * (position d'une pierre) */
    public RegleCoup verifCoup() {
	return this.coups ;
    }

    /** La stratégie de vérification de la validité d'un alignement */
    public RegleAlignement verifAlignement() {
	return this.alignements ;
    } 
}