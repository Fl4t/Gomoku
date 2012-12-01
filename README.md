# Gomoku

Projet Gomoku DA2I

## Auteur

- Thomas
- Julien

## Compiler facilement

Pour pas se faire chier, j'ai mis en place un fichier qui contient tout les chemins des classes. 

Tout est décrit ici : 
[Javac option to compile recursively](http://stackoverflow.com/questions/6623161/javac-option-to-compile-recursively)

	# Pour que ça marche
	$ mkdir classes
	$ javac -classpath classes/ -d classes @classes.txt
	
	# Petit plus
	alias jc='javac -classpath classes/ -d classes @classes.txt'
