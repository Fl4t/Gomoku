package gomoku.jeu ;

public interface Joueur {
    /** Constantes permettant de nommer la couleur des joueurs (ou
     * aucun joueur) */
    public int NOIR = -1, VIDE = 0, BLANC = 1 ;
    /** Couleur du joueur (retourne une des constantes NOIR ou BLANC) */
    public int couleur() ;
}