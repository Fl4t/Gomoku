package gomoku.jeu;

public class PartieCLI extends Partie {

  public PartieCLI(JoueurAbstrait jNoir, JoueurAbstrait jBlanc, Plateau plateau) {
    super(jNoir, jBlanc, plateau);
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
