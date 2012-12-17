package gomoku.jeu;

public class VisuelCLI implements Visuel {

  private Plateau plateau;

  public VisuelCLI(Plateau plateau) {
    this.plateau = plateau;
  }
  public void leJoueurAGagne(String str) {
    System.out.println("félicitation au joueur " + str);
  }

  public void laPartieEstNulle() {
    System.out.println("Partie nulle!");
  }

  public void afficherLaGrille() {
    System.out.println(this.plateau);
  }
}
