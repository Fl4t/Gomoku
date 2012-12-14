package gomoku.jeu;

import java.lang.Integer;
import java.util.Set;
import java.util.Scanner;
import java.util.Iterator;
import javax.swing.JComponent;
import gomoku.regles.Variante;
import gomoku.regles.RegleCoup;
import gomoku.regles.RegleAlignement;
import gomoku.jeu.Plateau;
import gomoku.jeu.Grille;
import gomoku.jeu.PierreCoordonnees;

public class Partie {

  private JoueurHumain jNoir;
  private JoueurHumain jBlanc;
  private Plateau plateau;
  private boolean premierCoup = true;
  private int doisJouer = Joueur.NOIR;
  private int gagnant;

  public Partie(JoueurHumain jNoir, JoueurHumain jBlanc, Plateau plateau) {
    this.jNoir = jNoir;
    this.jBlanc = jBlanc;
    this.plateau = plateau;
  }

  public void jouerCLI() {
    while (this.coupAjouer()) {
      Coordonnees c = this.demanderCoor();
      if (!this.placerPierreAuxCoor(c))
        System.out.println("Vous ne pouvez pas placer ici.");
      this.rafraichirGrille();
    }
    if (this.estGagne())
      System.out.println("félicitation joueur " +
          this.joueurGagnant());
    else
      System.out.println("Partie nulle !");
  }

  public void jouerGUI(JComponent component, Coordonnees c) {
    if (this.coupAjouer())
      if(this.placerPierreAuxCoor(c))
        component.repaint();
  }

  public boolean coupAjouer() {
    if (!(this.jNoir.getNbCoups() == 0
        && this.jBlanc.getNbCoups() == 0))
      return true;
    return false;
  }

  public Coordonnees demanderCoor() {
      return this.aLaMain(Joueur.BLANC) ?
        this.demanderCoorJoueur(Joueur.BLANC) :
        this.demanderCoorJoueur(Joueur.NOIR);
  }

  public Coordonnees demanderCoorJoueur(int couleur) {
    String str = this.couleurIntToString(couleur);
    Scanner sc = new Scanner(System.in);
    System.out.println("\nJoueur " + str + "\n");
    System.out.println("Saisir la coordonnée x : ");
    int coorX = sc.nextInt();
    System.out.println("Saisir la coordonnée y : ");
    int coorY = sc.nextInt();
    return new PierreCoordonnees(coorX, coorY);
  }

  public String couleurIntToString(int couleur) {
    return couleur == Joueur.NOIR ? "NOIR" : "BLANC";
  }

  private boolean aLaMain(int couleur) {
    return couleur == this.doisJouer ? true : false;
  }

  public boolean placerPierreAuxCoor(Coordonnees c) {
    Variante v = ((Grille)plateau).getVariante();
    RegleCoup r = v.verifCoup();
    if (this.premierCoup) {
      this.premierCoup = false;
      this.joueurJoue(c);
      return true;
    } else if (r.estValide(c, plateau) &&
        plateau.contenu(c) == Joueur.VIDE)
    {
      this.joueurJoue(c);
      return true;
    }
    return false;
  }

  private void joueurJoue(Coordonnees c) {
    if (this.aLaMain(Joueur.NOIR))
      jNoir.jouerUnCoup(plateau, c);
    else
      jBlanc.jouerUnCoup(plateau, c);
    this.donnerLaMain();
  }

  private void donnerLaMain() {
    this.doisJouer = this.aLaMain(Joueur.NOIR) ?
      Joueur.BLANC : Joueur.NOIR;
  }

  public void rafraichirGrille() {
    System.out.println(plateau);
  }

  /*
   * Méthode estGagne.
   * Methode retournant un booléen lorsque la partie
   * est gagné par l'un des joueurs.
   * Une partie est gagné lorsque :
   *
   */
  public boolean estGagne() {
    Variante v = ((Grille)this.plateau).getVariante();
    RegleAlignement regle = v.verifAlignement();
    Set<Alignement> align = plateau.rechercherAlignements( this.doisJouer,
        regle.tailleMin());
    Iterator<Alignement> it = align.iterator();
    while (it.hasNext())
      if (regle.estGagnant(it.next(), this.plateau)) return true;
    return false;
  }

  public String joueurGagnant() {
    return this.aLaMain(Joueur.NOIR) ? "BLANC" : "NOIR";
  }

  public Plateau getPlateau(){
    return this.plateau;
  }

}
