package gomoku.jeu ;

/** Implémentation de l'interface coordonnées */
public class PierreCoordonnees implements Coordonnees {

  private int abs;
  private int ord;

  public PierreCoordonnees(int x, int y) {
    this.abs = x;
    this.ord = y;
  }

/** Permet de récupérer l'abscisse d'une pierre
  * @return abscisse de la pierre
  */
  public int abscisse() {
    return this.abs;
  }

/** Permet de récupérer l'ordonnée d'une pierre
  * @return abscisse de la pierre
  */
  public int ordonnee() {
    return this.ord;
  }

}
