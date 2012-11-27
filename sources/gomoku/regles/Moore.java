package gomoku.regles ;

import gomoku.jeu.Coordonnees ;

/** Cette classe implémente la métrique définie par la distance de
 * Moore (ou distance définie par la norme max), qui définit la
 * distance entre deux points par le plus grand écart entre leurs
 * coordonnées). */
public class Moore implements Metrique {
    public double distance(Coordonnees c1, Coordonnees c2) {
	return Math.max(Math.abs(c1.abscisse() - c2.abscisse()), 
			Math.abs(c1.ordonnee() - c2.ordonnee())) ;
    }
}
