package gomoku.jeu ;

/** Implémentation de l'interface coordonnées */
public class PierreCoordonnees implements Coordonnees {

  private int abs;
  private int ord;

  public PierreCoordonnees(int x, int y) {
    this.abs = x;
    this.ord = y;
  }

  public int abscisse() {
    return this.abs;
  }

  public int ordonnee() {
    return this.ord;
  }

}
