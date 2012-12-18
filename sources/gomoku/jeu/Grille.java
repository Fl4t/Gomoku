/**
 * @author julien Stechele et Thomas Ruchon
 * @version 1.0
 */

package gomoku.jeu;

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import gomoku.regles.Variante;
import gomoku.jeu.Alignement;
import gomoku.regles.RegleCoup;

/** Classe Partie implémentant plateau */
public class Grille implements Plateau {

  /** La grille du jeu */
  private int jeu[][];

  /** La largeur de la grille */
  private int largeur;

  /** La hauteur de la grille */
  private int hauteur;

  /** La variante de la grille */
  private Variante v;

  /** Constructeur permettant d'instancer la grille
   * @param jeu la variante souhaitée */
  public Grille(Variante jeu) {
    this.v = jeu;
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

  public int contenu(Coordonnees c) {
    return jeu[c.abscisse()][c.ordonnee()];
  }

  public void placer(Coordonnees c, int couleur) {
    if (c.abscisse() < this.largeur &&
        c.ordonnee() < this.hauteur)
      jeu[c.abscisse()][c.ordonnee()] = couleur;
  }

  public Set<Coordonnees> voisins(Coordonnees c, int dist) {
    Set<Coordonnees> coorVoisines = new HashSet<Coordonnees>();
    for (int i = c.abscisse() - dist; i <= c.abscisse() + dist; i++)
      for (int j = c.ordonnee() - dist; j <= c.ordonnee() + dist; j++)
        if ((i >= 0 && i < this.largeur) && (j >= 0 && j < this.hauteur))
          coorVoisines.add(new PierreCoordonnees(i, j));
    return coorVoisines;
  }

  public Set<Alignement> rechercherAlignements(int couleur, int taille) {
    Set<Alignement> alignTrouvees = new HashSet<Alignement>();
    alignTrouvees = this.concatenerLesHashSet(alignTrouvees,
        this.vertical(couleur, taille));
    alignTrouvees = this.concatenerLesHashSet(alignTrouvees,
        this.horizontal(couleur, taille));
    alignTrouvees = this.concatenerLesHashSet(alignTrouvees,
        this.deDroiteAGauche(couleur, taille));
    alignTrouvees = this.concatenerLesHashSet(alignTrouvees,
        this.deGaucheADroite(couleur, taille));
    return alignTrouvees;
  }

  /** Méthode permettant de concaténer les alignements trouvées dans les
   * méthodes horizontal, vertical, deDroiteAGauche, deGaucheADroite */
  private Set<Alignement> concatenerLesHashSet(Set<Alignement> englobante, Set<Alignement> englobee) {
    for(Alignement a: englobee)
      englobante.add(a);
    return englobante;
  }

  /** Méthode permettant de trouver les alignements verticaux. */
  public Set<Alignement> vertical(int couleur, int taille) {
    int cpt = 0;
    Set<Alignement> alignV = new HashSet<Alignement>();
    for (int x = 0; x < this.largeur; x++) {
      cpt = 0;
      for (int y = 0; y < this.hauteur; y++) {
        if (this.contenu(new PierreCoordonnees(x, y)) == couleur) {
          cpt++;
        } else {
          cpt = 0;
        }
        if (cpt == taille) {
          if (y+1 < this.hauteur) {
            if (this.contenu(new PierreCoordonnees(x, y+1)) != couleur) {
              alignV.add(new VecteurAlignement(new PierreCoordonnees(x, y - taille),
                    new PierreCoordonnees(x, y),
                    this.v));
            }
          } else {
            alignV.add(new VecteurAlignement(new PierreCoordonnees(x, y - taille),
                  new PierreCoordonnees(x, y),
                  this.v));
          }
        }
      }
    }
    return alignV;
  }

  /** Méthode permettant de trouver les alignements horizontaux. */
  public Set<Alignement> horizontal(int couleur, int taille) {
    int cpt = 0;
    Set<Alignement> alignH = new HashSet<Alignement>();
    for (int y = 0; y < this.hauteur; y++) {
      cpt = 0;
      for (int x = 0; x < this.largeur; x++) {
        if (this.contenu(new PierreCoordonnees(x, y)) == couleur) {
          cpt++;
        } else {
          cpt = 0;
        }
        if (cpt == taille) {
          if (x+1 < this.largeur) {
            if (this.contenu(new PierreCoordonnees(x+1, y)) != couleur) {
              alignH.add(new VecteurAlignement(new PierreCoordonnees(x - taille, y),
                    new PierreCoordonnees(x, y),
                    this.v));
            }
          } else {
            alignH.add(new VecteurAlignement(new PierreCoordonnees(x - taille, y),
                  new PierreCoordonnees(x, y),
                  this.v));
          }
        }
      }
    }
    return alignH;
  }

  /** Méthode permettant de trouver les alignements diagonaux de
   * droite vers la gauche. */
  public Set<Alignement> deDroiteAGauche(int couleur, int taille) {

    int cpt = 0;
    Coordonnees coor[] = new Coordonnees[taille];
    Set<Alignement> alignD = new HashSet<Alignement>();

    // parcours de la première moitiée
    for (int x = 0; x < this.largeur; x++) {
      cpt = 0;
      for (int i = 0; i < coor.length; i++)
        coor[i] = null;

      for (int y = 0; y < x+1; y++)
        if (this.contenu(new PierreCoordonnees(x-y, y)) == couleur) {
          coor[cpt] = new PierreCoordonnees(x-y, y);

          if (cpt == taille-1) {
            if (x-y-1 >= 0 && y+1 < this.hauteur) {
              if (this.contenu(new PierreCoordonnees(x-y-1, y+1)) != couleur) {
                alignD.add(new VecteurAlignement(coor[0], coor[cpt], this.v));
              }
              else
                cpt = 0;
            } else {
              alignD.add(new VecteurAlignement(coor[0], coor[cpt], this.v));
            }
          } else {
            cpt++;
          }

        } else {
          cpt = 0;
          for (int i = 0; i < coor.length; i++)
            coor[i] = null;
        }
    }
    // parcours de la deuxieme moitiée
    for (int y = this.hauteur-1; y > 0; y--) {
      cpt = 0;
      for (int i = 0; i < coor.length; i++)
        coor[i] = null;
      for (int x = this.largeur-1; x >= y; x--)
        if (this.contenu(new PierreCoordonnees(x, (this.hauteur-1) - (x - y))) == couleur) {
          coor[cpt] = new PierreCoordonnees(x, this.hauteur - (x - y));
          if (cpt == taille-1) {
            if (x-1 >= 0 && (this.hauteur-1)-(x-y)+1 < this.hauteur) {
              if (this.contenu(new PierreCoordonnees(x-1, (this.hauteur-1)-(x-y)+1)) != couleur) {
                alignD.add(new VecteurAlignement(coor[0], coor[cpt], this.v));
              }
              else
                cpt=0;

            } else {
              alignD.add(new VecteurAlignement(coor[0], coor[cpt], this.v));
            }
          } else {
            cpt++;
          }
        } else {
          cpt = 0;
          for (int i = 0; i < coor.length; i++)
            coor[i] = null;
        }
    }
    return alignD;
  }

  /** Méthode permettant de trouver les alignements diagonaux de gauche
   * vers la droite. */
  public Set<Alignement> deGaucheADroite(int couleur, int taille) {

    int cpt = 0;
    Coordonnees coor[] = new Coordonnees[taille];
    Set<Alignement> alignG = new HashSet<Alignement>();

    // parcours de la première moitiée
    for (int x = this.largeur-1; x >= 0 ; x--) {
      cpt = 0;
      for (int i = 0; i < coor.length; i++)
        coor[i] = null;
      for (int y = 0; y < this.largeur - x; y++)
        if (this.contenu(new PierreCoordonnees(x+y, y)) == couleur) {
          coor[cpt] = new PierreCoordonnees(x+y, y);
          if (cpt == taille-1) {
            if(x+y+1 < this.largeur && y+1 < this.hauteur) {
              if(this.contenu(new PierreCoordonnees(x+y+1,y+1)) != couleur) {
                alignG.add(new VecteurAlignement(coor[0], coor[cpt], this.v));
              }
              else
                cpt =0;
            }
            else
              alignG.add(new VecteurAlignement(coor[0], coor[cpt], this.v));
          } else {
            cpt++;
          }
        } else {
          cpt = 0;
          for (int i = 0; i < coor.length; i++)
            coor[i] = null;
        }
    }
    // parcours de la deuxieme moitiée
    for (int y = this.hauteur-1; y > 0; y--) {
      cpt = 0;
      for (int i = 0; i < coor.length; i++)
        coor[i] = null;
      for (int x = 0; x < this.hauteur - y; x++)
        if (this.contenu(new PierreCoordonnees(x, y+x)) == couleur) {
          coor[cpt] = new PierreCoordonnees(x, y+x);
          if (cpt == taille-1) {
            if(x+1 < this.largeur && y+x+1 < this.hauteur) {
              if(this.contenu(new PierreCoordonnees(x+1,y+x+1)) != couleur) {
                alignG.add(new VecteurAlignement(coor[0], coor[cpt], this.v));
              }
              else
                cpt = 0;
            }
            else
              alignG.add(new VecteurAlignement(coor[0], coor[cpt], this.v));
          } else {
            cpt++;
          }
        } else {
          cpt = 0;
          for (int i = 0; i < coor.length; i++)
            coor[i] = null;
        }
    }
    return alignG;
  }

  public Set<Coordonnees> casesJouables(int couleur) {
    RegleCoup regle = v.verifCoup();
    Set<Coordonnees> coorJouables = new HashSet<Coordonnees>();
    for (int x = 0; x < this.largeur; x++)
      for (int y = 0; y < this.hauteur; y++)
        if (regle.estValide(new PierreCoordonnees(x, y), this))
          coorJouables.add(new PierreCoordonnees(x, y));
    return coorJouables;
  }

  /** Affiche le tableau dans la console */
  public String toString() {
    String ret = "";
    for (int y = 0; y < this.hauteur(); y++) {
      ret += "\n";
      for (int x = 0; x < this.largeur(); x++) {
        String test = this.jeu[x][y] == 1 ? "B" : "N";
        if (this.jeu[x][y] == -1)
          test = "N";
        else if (this.jeu[x][y] == 1)
          test = "B";
        else
          test = "0";
        ret += " " + test;
      }
    }
    return ret;
  }

  /** Permet de retourner la variante de la grille
   * @return Variante */
  public Variante getVariante() {
    return v;
  }
}
