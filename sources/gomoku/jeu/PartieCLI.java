package gomoku.jeu;

public class PartieCLI extends Partie {

  public PartieCLI(JoueurAbstrait jNoir, JoueurAbstrait jBlanc, Plateau plateau) {
    super(jNoir, jBlanc, plateau);
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

  public void nePeutPasPlacerIci() {
    System.out.println("Vous ne pouvez pas placer ici.");
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
