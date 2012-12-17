package gomoku.jeu;

import java.util.Set;
import gomoku.regles.Variante;
import gomoku.regles.RegleCoup;
import gomoku.regles.RegleAlignement;
import gomoku.jeu.Plateau;
import gomoku.jeu.Grille;
import gomoku.jeu.PierreCoordonnees;

public abstract class Partie {

  protected JoueurAbstrait jNoir;
  protected JoueurAbstrait jBlanc;
  protected Plateau plateau;
  protected boolean premierCoup = true;
  protected int doisJouer = Joueur.NOIR;
  protected int gagnant;

  public Partie(JoueurAbstrait jNoir, JoueurAbstrait jBlanc, Plateau plateau) {
    this.jNoir = jNoir;
    this.jBlanc = jBlanc;
    this.plateau = plateau;
  }

  public int getGagnant() {
    return this.gagnant;
  }

  public void jouer() {
    String str;
    while (this.coupAjouer()) {
      if (this.getGagnant() == 0) {
        if (this.demanderDeJouer())
          this.afficherLaGrille();
        else
          this.nePeutPasPlacerIci();
      } else {
        if (this.getGagnant() == Joueur.NOIR)
          str = this.jNoir.couleurIntToString();
        else
          str = this.jBlanc.couleurIntToString();
        this.leJoueurAGagne(str);
        break;
      }
    }
    if (!this.coupAjouer())
      this.laPartieEstNulle();
  }

  public abstract void afficherLaGrille();
  public abstract void nePeutPasPlacerIci();
  public abstract void leJoueurAGagne(String str);
  public abstract void laPartieEstNulle();

  public boolean coupAjouer() {
    if (!(this.jNoir.getNbCoups() == 0
          && this.jBlanc.getNbCoups() == 0))
      return true;
    return false;
  }

  public Coordonnees demanderCoor() {
    return this.aLaMain(Joueur.BLANC) ?
      this.jBlanc.demanderCoorJoueur(this) :
      this.jNoir.demanderCoorJoueur(this);
  }

  public boolean aLaMain(int couleur) {
    return couleur == this.doisJouer ? true : false;
  }

  public boolean demanderDeJouer() {
    Coordonnees c = null;
    Variante v = ((Grille)plateau).getVariante();
    RegleCoup r = v.verifCoup();
    if (this.premierCoup) {
      this.premierCoup = false;
      c = this.demanderCoor();
      this.joueurJoue(c);
      return true;
    } else {
      c = this.demanderCoor();
      if (r.estValide(c, plateau) &&
        this.plateau.contenu(c) == Joueur.VIDE)
      {
        this.joueurJoue(c);
        return true;
      }
    }
    return false;
  }

  public void joueurJoue(Coordonnees c) {
    if (this.aLaMain(Joueur.NOIR)) {
      this.plateau.placer(c, this.jNoir.couleur());
      this.jNoir.joueUnePierre();
    }
    else {
      this.plateau.placer(c, this.jBlanc.couleur());
      this.jBlanc.joueUnePierre();
    }
    this.verifierCoupGagnant();
  }

  public void donnerLaMain() {
    this.doisJouer = this.aLaMain(Joueur.NOIR) ?
      Joueur.BLANC : Joueur.NOIR;
  }

  public void verifierCoupGagnant() {
    Variante v = ((Grille)this.plateau).getVariante();
    RegleAlignement regle = v.verifAlignement();
    Set<Alignement> align = plateau.rechercherAlignements(this.doisJouer,
        regle.tailleMin());
    for (Alignement a: align) {
      if (regle.estGagnant(a, this.plateau))
        this.gagnant = this.doisJouer;
    }
    if (this.gagnant == 0)
      this.donnerLaMain();
  }

  public Plateau getPlateau() {
    return this.plateau;
  }
}
