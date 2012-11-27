package gomoku.jeu ;

/** Cette interface représente les coordonnées extrêmes (extérieures)
 * d'un alignement de pierres d'une même couleur. Par exemple, si 
 * les pierres noires occupent les positions (3,4), (3,5) et (3,6),
 * elles constituent un alignement de taille 3 délimitées par les 
 * coordonnées (3,3) et (3,7).
 */
public interface Alignement {
  /** une des positions, correspondant au début de l'alignement */
  public Coordonnees debut() ;
  /** l'autre position, correspondant à la fin de l'alignement */
  public Coordonnees fin() ;
  /** la taille de l'alignement (nombre de pierres) */
  public int taille() ;
}
