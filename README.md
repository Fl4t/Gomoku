# Gomoku

Projet Gomoku DA2I

## Auteur

- Thomas
- Julien

## Compiler facilement

J'ai mis en place un fichier qui contient tout les chemins des classes. 

Pour plus d'informations : 
[Javac option to compile recursively](http://stackoverflow.com/questions/6623161/javac-option-to-compile-recursively)

	$ mkdir classes
	$ find . -name "*.java" > classes.txt
	$ javac -classpath classes/ -d classes @classes.txt

## Créer l'archive executable

Se rendre dans le répertoire de l'application puis executer :

	$ jar cfvm Gomoku.jar Manifest.txt -C classes/ .
	
## Lancer l'application

Se placer dans le dossier contenant l'archive .jar puis executer :

	$ java -jar Gomoku.jar
	
# Enjoy :-)
	

