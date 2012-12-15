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

import javax.swing.JOptionPane;

public class Partie {

  private JoueurHumain jNoir;
  private JoueurHumain jBlanc;
  private Plateau plateau;
  private boolean premierCoup = true;
  private int doisJouer = Joueur.NOIR;
  private int gagnant;
  private JOptionPane jop1;

  public Partie(JoueurHumain jNoir, JoueurHumain jBlanc, Plateau plateau) {
    this.jNoir = jNoir;
    this.jBlanc = jBlanc;
    this.plateau = plateau;
  }

  public void jouerCLI() {
    while (this.coupAjouer() && this.gagnant == 0) {
      Coordonnees c = this.demanderCoor();
      if (this.placerPierreAuxCoor(c)) {
        System.out.println(plateau);
      } else {
        System.out.println("Vous ne pouvez pas placer ici.");
      }
    }
    System.out.println("félicitation joueur " +
        this.couleurIntToString(this.gagnant));
  }

  public void jouerGUI(JComponent component, Coordonnees c) {
    if (this.coupAjouer() && this.gagnant == 0) {
      if(this.placerPierreAuxCoor(c))
        component.repaint();
    } else {
          jop1 = new JOptionPane();
           jop1.showMessageDialog(null, "Le joueur " + this.couleurIntToString(this.gagnant) + " a gagné !" , "Fin", JOptionPane.CLOSED_OPTION,null);   
           System.exit(0);
          
          
      }
  }

  private boolean coupAjouer() {
    if (!(this.jNoir.getNbCoups() == 0
          && this.jBlanc.getNbCoups() == 0))
      return true;
    return false;
  }

  private Coordonnees demanderCoor() {
    return this.aLaMain(Joueur.BLANC) ?
      this.demanderCoorJoueur(Joueur.BLANC) :
      this.demanderCoorJoueur(Joueur.NOIR);
  }

  private Coordonnees demanderCoorJoueur(int couleur) {
    String str = this.couleurIntToString(couleur);
    Scanner sc = new Scanner(System.in);
    System.out.println("\nJoueur " + str + "\n");
    System.out.println("Saisir la coordonnée x : ");
    int coorX = sc.nextInt();
    System.out.println("Saisir la coordonnée y : ");
    int coorY = sc.nextInt();
    return new PierreCoordonnees(coorX, coorY);
  }

  private String couleurIntToString(int couleur) {
    return couleur == Joueur.NOIR ? "NOIR" : "BLANC";
  }

  private boolean aLaMain(int couleur) {
    return couleur == this.doisJouer ? true : false;
  }

  private boolean placerPierreAuxCoor(Coordonnees c) {
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
    this.verifierCoupGagnant();
  }

  private void donnerLaMain() {
    this.doisJouer = this.aLaMain(Joueur.NOIR) ?
      Joueur.BLANC : Joueur.NOIR;
  }

  private void verifierCoupGagnant() {
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
