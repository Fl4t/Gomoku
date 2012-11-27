package gomoku.jeu ;

import java.util.Set ;

/** Cette interface représente un plateau de jeu à deux dimensions. 
 */
public interface Plateau {
    /** Largeur du plateau */
    public int largeur() ;

    /** Hauteur du plateau */
    public int hauteur() ;

    /** Donne la couleur de la pierre située à la position spécifiée.
     * @param c coordonnées de la position à tester
     * @return Joueur.NOIR, Joueur.BLANC ou Joueur.VIDE */
    public int contenu(Coordonnees c) ;

    /** Place une pierre de la couleur spécifiée à la position
     * indiquée. Ne fait rien si les coordonnées sont incorrectes.
     * @param c coordonnées de la position à modifier
     * @param couleur couleur de la pierre (Joueur.NOIR ou
     * Joueur.BLANC ; on peut aussi utiliser Joueur.VIDE pour
     * supprimer une pierre) */
    public void placer(Coordonnees c, int couleur) ;

    /** Calcule les positions voisines de la position spécifiée,
     * jusqu'à la distance spécifiée
     * @param c coordonnées de la position dont on veut calculer les voisines
     * @param dist distance maximale pour calculer le voisinage 
     * @return l'ensemble des coordonnées des positions voisines */
    public Set<Coordonnees> voisins(Coordonnees c, int dist) ;

    /** Calcule, pour le joueur de la couleur spécifiée, l'ensemble
     * des alignements de pierres de ce joueur qui ont
     * <b>exactement</b> la taille indiquée.
     * @param couleur la couleur des pierres à tester
     * @param taille le nombre de pierres qui doivent être alignées
     * @return l'ensemble des alignements touvés */
    public Set<Alignement> rechercherAlignements(int couleur, int taille) ;

    /** Calcule, pour le joueur de la couleur spécifiée, l'ensemble
     * des positions où il est autorisé à jouer.
     * @param couleur la couleur du joueur
     * @return un ensemble de cases libres où le joueur peut poser une
     * pierre */
    public Set<Coordonnees> casesJouables(int couleur) ;
}
