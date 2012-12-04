package gomoku.jeu;

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import gomoku.regles.Variante;

/**
 * Cette classe implémente l'interface Plateau
 */
public class Grille implements Plateau {

  private int jeu[][];
  private int largeur;
  private int hauteur;
  private Variante jeu;

  public Grille(Variante jeu) {
    this.jeu = jeu;
    this.largeur = jeu.largeur();
    this.hauteur = jeu.hauteur();
    this.jeu = new int[this.largeur][this.hauteur];
  }

  /** Largeur du jeu */
  public int largeur() {
    return this.largeur;
  }

  /** Hauteur du jeu */
  public int hauteur() {
    return this.hauteur;
  }

  /** Donne la couleur de la pierre située à la position spécifiée.
   * @param c coordonnées de la position à tester
   * @return Joueur.NOIR, Joueur.BLANC ou Joueur.VIDE */
  public int contenu(Coordonnees c) {
    return jeu[c.abscisse()][c.ordonnee()];
  }

  /** Place une pierre de la couleur spécifiée à la position
   * indiquée. Ne fait rien si les coordonnées sont incorrectes.
   * @param c coordonnées de la position à modifier
   * @param couleur couleur de la pierre (Joueur.NOIR ou
   * Joueur.BLANC ; on peut aussi utiliser Joueur.VIDE pour
   * supprimer une pierre) */
  public void placer(Coordonnees c, int couleur) {
    if (c.abscisse() < this.largeur &&
        c.ordonnee() < this.hauteur)
    jeu[c.abscisse()][c.ordonnee()] = couleur;
  }

  /** Calcule les positions voisines de la position spécifiée,
   * jusqu'à la distance spécifiée
   * @param c coordonnées de la position dont on veut calculer les voisines
   * @param dist distance maximale pour calculer le voisinage
   * @return l'ensemble des coordonnées des positions voisines */
  public Set<Coordonnees> voisins(Coordonnees c, int dist) {
    Set<Coordonnees> coorVoisines = new HashSet<Coordonnees>();
    for (int i = c.abscisse() - dist; i < c.abscisse() + dist; i++)
      for (int j = c.ordonnee() - dist; j < c.abscisse() + dist; j++)
        if ((i >= 0 && i < this.largeur) && (j >= 0 && j < this.hauteur))
          coorVoisines.add(new PierreCoordonnees(i, j));
    return coorVoisines;
  }

  /** Calcule, pour le joueur de la couleur spécifiée, l'ensemble
   * des alignements de pierres de ce joueur qui ont
   * <b>exactement</b> la taille indiquée.
   * @param couleur la couleur des pierres à tester
   * @param taille le nombre de pierres qui doivent être alignées
   * @return l'ensemble des alignements touvés */
  public Set<Alignement> rechercherAlignements(int couleur, int taille) {
    Set<Alignement> alignTrouvees = new HashSet<Alignement>();
    Set<Alignement> alignV = this.rechercherAlignementsVertical(couleur, taille);
    Set<Alignement> alignHorizontal = this.rechercherAlignementsHorizontal(couleur, taille);
    Set<Alignement> alignDiagonaleDes = this.rechercherAlignementsDiagonaleDes(couleur, taille);
    Set<Alignement> alignDiagonaleAsc = this.rechercherAlignementsDiagonaleAsc(couleur, taille);
  }

  public Set<Alignement> rechercherAlignementsVertical(int couleur, int taille) {
    int yDebut = 0;
    int cpt = 0;
    Set<Alignement> alignV = new HashSet<Alignement>();
    for (int x = 0; x < this.largeur; x++) {
      cpt = 0;
      for (int y = 0; y < this.hauteur; y++) {
        if (this.contenu(New PierreCoordonnees(x, y), couleur)) {
          yDebut = y;
          cpt++;
        } else {
          cpt = 0;
        }
      }
      if (cpt == taille) {
        alignTrouvees.add(new VecteurAlignement(new PierreCoordonnees(x, yDebut)),
              new VecteurAlignement(new PierreCoordonnees(x, yDebut + cpt)),
                          this.jeu);
      }
    }
    return alignV;
  }

  public Set<Alignement> rechercherAlignementsHorizontal(int couleur, int taille) {
    int xDebut = 0;
    int cpt = 0;
    Set<Alignement> alignTrouvees = new HashSet<Alignement>();
    for (int y = 0; y < this.hauteur; y++) {
      cpt = 0;
      for (int x = 0; x < this.largeur; x++) {
        if (this.contenu(new PierreCoordonnees(x, y), couleur)) {
          xDebut = x;
          cpt++;
        } else {
          cpt = 0;
        }
      }
      if (cpt == taille) {
        alignTrouvees.add(new VecteurAlignement(new PierreCoordonnees(xDebut, y)),
                          new VecteurAlignement(new PierreCoordonnees(x, y)),
                          this.jeu);
      }
    }
    return alignTrouvees;
  }

  // TODO
  public Set<Alignement> rechercherAlignementsDiagonalFacile(int couleur, int taille) {
    // parcourt de la premiere moitié
    for (int i = 0; i < this.largeur; i++)
      for (int j = 0; j < i+1; j++)
        this.contenu(new PierreCoordonnees(i-j, j), couleur);
    // parcourt de la deuxieme moitié
    for ( int j = 1; j < this.largeur; j++)
      for ( int i = this.largeur-1 ; i > j; i--)
        this.contenu(new PierreCoordonnees(i, this.largeur - i), couleur);
  }

  // TODO
  public Set<Alignement> rechercherAlignementsDiagonalDifficile(int couleur, int taille) {
  }

  /** Calcule, pour le joueur de la couleur spécifiée, l'ensemble
   * des positions où il est autorisé à jouer.
   * @param couleur la couleur du joueur
   * @return un ensemble de cases libres où le joueur peut poser une
   * pierre */
  public Set<Coordonnees> casesJouables(int couleur) {
    int contenuCouleur;
    Set<Coordonnees> coorJouables = new HashSet<Coordonnees>();
    for (int x = 0; x < this.largeur; x++)
      for (int y = 0; y < this.hauteur; y++)
        if (this.contenu(new PierreCoordonnees(x, y)) == couleur) {
          Set<Coordonnees> coorVoisines = this.voisins(new PierreCoordonnees(x, y), couleur);
          Iterator it = coorVoisines.iterator();
          while (it.hasNext())
            if (this.contenu(new PierreCoordonnees(x, y)) == Joueur.VIDE)
              coorJouables.add(new PierreCoordonnees(x, y));
        }
    return coorJouables;
  }

  /**
   * @override
   * Methode toString.
   * Affiche le tableau dans la console
   */
  public String toString() {
    String ret = "";
    for (int x = 0; x < this.largeur(); x++) {
      ret += " ----------------------------------------" +
        "-------------------------------------\n";
      for (int y = 0; y < this.hauteur(); y++) {
        ret += " | " + this.jeu[x][y];
      }
      ret +=  " | \n";
    }
    ret += " ----------------------------------------" +
      "-------------------------------------\n";
    return ret;
  }
}
