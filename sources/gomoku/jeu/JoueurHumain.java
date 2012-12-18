package gomoku.jeu;

import java.util.Scanner;

public class JoueurHumain extends JoueurAbstrait {

  public JoueurHumain(int c) {
    super(c);
  }

/** Demande les coordonnées au joueur
  * @param la partie
  * @return les coordonnées où il va placer la pierre
  */
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
