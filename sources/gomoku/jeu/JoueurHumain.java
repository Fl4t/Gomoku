/**
 * @author julien Stechele et Thomas Ruchon
 * @version 1.0
 */

package gomoku.jeu;

import java.util.Scanner;

/** Classe représentant un joueur Humain */
public class JoueurHumain extends JoueurAbstrait {

  /** Constructeur permettant d'instancier un joueur
   * humain. */
  public JoueurHumain(int c) {
    super(c);
  }

  public Coordonnees demanderCoorJoueur(Partie partie) {
    String str = this.couleurIntToString();
    Scanner sc = new Scanner(System.in);
    System.out.println("\nJoueur " + str + "\n");
    System.out.println("Saisir la coordonnée x : ");
    int coorX = sc.nextInt();
    System.out.println("Saisir la coordonnée y : ");
    int coorY = sc.nextInt();
    return new PierreCoordonnees(coorX, coorY);
  }
}
