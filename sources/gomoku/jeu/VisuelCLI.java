package gomoku.jeu;

public class VisuelCLI implements Visuel {

  private Plateau plateau;

  public VisuelCLI(Plateau plateau) {
    this.plateau = plateau;
  }

  /** Affiche un message quand un joueur gagne
  * @param le message à afficher
  */
  public void leJoueurAGagne(String str) {
    System.out.println("félicitation au joueur " + str);
    System.exit(0);
  }

/** Affiche un message quand la partie est nulle
  * @param le message à afficher
  */
  public void laPartieEstNulle() {
    System.out.println("Partie nulle!");
    System.exit(0);
  }

/** Actualise la grille
*/
  public void afficherLaGrille() {
    System.out.println(this.plateau);
  }
}
