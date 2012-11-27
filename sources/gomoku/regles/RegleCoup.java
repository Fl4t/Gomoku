package gomoku.regles ;

import gomoku.jeu.Plateau ;
import gomoku.jeu.Joueur ;
import gomoku.jeu.Coordonnees ;

/** Cette classe a pour rôle de vérifier si un coup est valide pour un
 * joueur */
public class RegleCoup {
    private Metrique metrique ;
    private int distanceMax ;

    /** Crée une règle qui autorise les coups joués à une distance
     * égale au maximum à dist d'une autre pierre, selon la métrique
     * spécifiée.
     * @param m la métrique à utiliser
     * @param dist la distance maximale autorisée entre pierres */ 
    public RegleCoup(Metrique m, int dist) {
	this.metrique = m ;
	this.distanceMax = dist ;
    }

    /** Teste si le coup à la position et sur le plateau spécifiés est
     * valide
     * @param c les coordonnées de la position à tester
     * @param p le plateau où le test est effectuée
     * @return true si le coup est valide, false sinon */
    public boolean estValide(Coordonnees c, Plateau p) {
	for (Coordonnees v: p.voisins(c, this.distanceMax))
	    if (p.contenu(v) != Joueur.VIDE)
		return true ;
	return false ;
    }
    
    /** La métrique utilisée */
    public Metrique metrique() { return this.metrique ; }

    /** La distance maxi utilisée */
    public int distanceMax() { return this.distanceMax ; }
}
