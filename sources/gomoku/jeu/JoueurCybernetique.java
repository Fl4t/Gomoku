package gomoku.jeu;

import gomoku.regles.RegleCoup;
import gomoku.regles.Variante;

public class JoueurCybernetique extends JoueurAbstrait {

  public JoueurCybernetique (int c) {
    super(c);
  }

  public Coordonnees demanderCoorJoueur(Partie partie) {
    Plateau p = partie.getPlateau();
    Variante v = ((Grille)p).getVariante();
    RegleCoup r = v.verifCoup();
    for (int x = 0; x < p.largeur(); x++)
      for (int y = 0; y < p.hauteur(); y++)
        if (r.estValide(new PierreCoordonnees(x, y), p) &&
          p.contenu(new PierreCoordonnees(x, y)) == Joueur.VIDE)
          return new PierreCoordonnees(x, y);
    return null;
  }

}
