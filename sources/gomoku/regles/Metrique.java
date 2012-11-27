package gomoku.regles ;

import gomoku.jeu.Coordonnees ;

/** Cette interface permet de définir une méthode qui donne la
 * distance entre deux positions identifiées par leurs
 * coordonnées. Les métriques les plus classiques sont définies par la
 * distance euclidienne, la distance de von Neumann (ou distance de
 * Manhattan), et la distance de Moore (ou norme max). */
public interface Metrique {
    /** La distance entre deux points selon la métrique considérée. 
     * @param c1 coordonnées du premier point
     * @param c2 coordonnées du second point
     * @return la distance entre les deux points */
    public double distance(Coordonnees c1, Coordonnees c2) ;
}
