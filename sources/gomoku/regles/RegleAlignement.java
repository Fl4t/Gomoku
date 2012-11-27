package gomoku.regles ;

import gomoku.jeu.Plateau ;
import gomoku.jeu.Joueur ;
import gomoku.jeu.Alignement ;
import gomoku.jeu.Coordonnees ;

/** Cette classe a pour rôle de vérifier si un alignement est valide
 * pour un joueur. Un alignement peut être valide s'il a la bonne
 * taille, et selon que ses extrémités sont libres ou non. */
public class RegleAlignement {
  private boolean videAutour ;
  private int tailleMin, tailleMax ;

  /** Crée une règle qui considère un alignement comme gagnant
   * selon les critères spécifiés
   * @param extremitesVides true si les cases qui délimitent
   * l'alignement doivent être vides, false sinon
   * @param tailleMin taille minimale de l'alignement */
  public RegleAlignement(boolean extremitesVides, int tailleMin, int tailleMax) {
    this.videAutour = extremitesVides ;
    this.tailleMin = tailleMin ;
    this.tailleMax = tailleMax ;
  }

  /** Teste si l'alignement spécifié est gagnant ou non
   * @param a l'alignement à tester
   * @param p le plateau où le test est effectuée
   * @return true si l'alignement est gagnant, false sinon */
  public boolean estGagnant(Alignement a, Plateau p) {
    if (this.videAutour) {
      if ((p.contenu(a.debut()) != Joueur.VIDE) ||
          (p.contenu(a.fin()) != Joueur.VIDE))
        return false ;
    }
    return (a.taille() >= this.tailleMin) && (a.taille() <= this.tailleMax) ;
  }

  /** La taille minimale d'un alignement */
  public int tailleMin() { return this.tailleMin ; }

  /** La taille maximale d'un alignement */
  public int tailleMax() { return this.tailleMax ; }

  /** Les positions extrêmes doivent-elles être libres ? */
  public boolean extremitesVides()  { return this.videAutour ; }
}
