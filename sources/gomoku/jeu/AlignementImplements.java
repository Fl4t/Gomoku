package gomoku.jeu;

import gomoku.regles.Variante;

public class AlignementImplements implements Alignement {
	
	Coordonnees debut, fin;
	Variante v;

	public AlignementImplements (Coordonnees coord1, Coordonnees coord2, Variante v) {
		this.debut = coord1;
		this.fin = coord2;
		this.v = v;
	}

	/** une des positions, correspondant au début de l'alignement */
  	public Coordonnees debut() {
  		return this.debut;
  	}
  	/** l'autre position, correspondant à la fin de l'alignement */
  	public Coordonnees fin() {
  		return this.fin;
  	}
  	/** la taille de l'alignement (nombre de pierres) */
  	public int taille() ;
}