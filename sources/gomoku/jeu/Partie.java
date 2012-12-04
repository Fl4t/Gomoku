package gomoku.jeu;

import java.lang.Integer;
import java.util.Scanner;
import gomoku.regles.Variante;
import gomoku.jeu.Plateau;
import java.io.IOException;
import gomoku.jeu.PierreCoordonnees;

public class Partie {

  private JoueurHumain jNoir;
  private JoueurHumain jBlanc;
  private Plateau p;
  private boolean premierCoup = true;
  private int doisJouer;
  private int gagnant;

  public Partie(JoueurHumain jNoir, JoueurHumain jBlanc, Plateau p) {
    this.jNoir = jNoir;
    this.jBlanc = jBlanc;
    this.p = p;
  }

  public boolean coupAjouer() {
    while (!(this.jNoir.getNbCoups() == 0
          && this.jBlanc.getNbCoups() == 0)) {
      return true;
    }
    return false;
  }

  // TODO : Bug
  public Coordonnees demanderCoor() {
    if (this.premierCoup())
      return this.demanderCoor(Joueur.NOIR);
    else
      if (this.aLaMain(Joueur.BLANC))
        return this.demanderCoor(Joueur.BLANC);
      else
        return this.demanderCoor(Joueur.NOIR);
  }

  private boolean premierCoup() {
    if (this.premierCoup) {
      this.premierCoup = false;
      return true;
    }
    return this.premierCoup;
  }

  public Coordonnees demanderCoor(int couleur) {
    String str = couleur == Joueur.NOIR ? "NOIR" : "BLANC";
    Scanner sc = new Scanner(System.in);
    System.out.println("\nJoueur " + str + "\n");
    System.out.println("Saisir la coordonnée x : ");
    int coorX = sc.nextInt();
    System.out.println("Saisir la coordonnée y : ");
    int coorY = sc.nextInt();
    return new PierreCoordonnees(coorX, coorY);
  }

  private boolean aLaMain(int couleur) {
    return couleur == this.doisJouer ? true : false;
  }

  public void placerPierreAuxCoor(Coordonnees c) {
    int couleur = this.doisJouer;
    if (p.contenu(c) == Joueur.VIDE) {
      p.placer(c, couleur);
      this.donnerLaMain();
    } else {
      System.out.println("Vous ne pouvez pas placer ici.\n");
    }
  }

  private void donnerLaMain() {
    this.doisJouer = this.doisJouer == Joueur.NOIR ? Joueur.BLANC : Joueur.NOIR;
  }

  public void rafraichirGrille() {
    System.out.println(p);
  }

  // TODO
  public boolean estGagne() {
    return true;
  }

  // TODO
  public int joueurGagnant() {
    return 1;
  }

}
