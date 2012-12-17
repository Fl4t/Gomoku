package gomoku.jeu;

import java.util.Scanner;

public class JoueurHumain extends JoueurAbstrait {

  public JoueurHumain(int c) {
    super(c);
  }

  public Coordonnees demanderCoorJoueur(Partie p) {
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
