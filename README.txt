Author:
	--> AMYOT QUENTIN------------21600414
	--> ROCANCOURT MATHIEU-------21808635		Groupe TP: L2 MATHS grp 1
	--> HERRERIA-LOPEZ MELISSA---21808047		Groupe CC: 10
	--> ANTONOV DEANN------------21806880




|-------------------------------|MODE D'EMPLOI|------------------------------------|


			    1) - LES PROGRAMMES -
	

	Les programmes créés sont: -Le fil rouge (création d'un emploi du temps)
				   
				   -Le package JavaScheduler (création d'un emploi 
				       du temps avec des contraintes de precedences)
				   
				   -Le package JavaEncoder (Permet de coder des 
					messages (String))
				   
				   -Le package JavaInteractive (création d'un emploi
					du temps de maniere interactive avec 
					l'utilisateur)

Chaque Package comprend les classes et méthodes qui lui sont utiles, et uniquement celle-ci.
Il est donc possible de retrouver des classes similaire entre 2 packages.



					INDICATION SUR LES PACKAGES:
	
	-Le package FileRouge contient 2 contraintes supplémentaires: -DisjunctionConstraint
								      -NegationConstraint
		Qui sont 2 contraintes issues d'un exercice "Pour aller plus loin".
		- Disjunction Constraint permet la réalisation d'une de deux contraintes données
		- Negation Constraint permet la réalisation du contraire d'une contrainte donnée
	
	-Les autres packages sont le résultat des exercices "Pour aller plus loin", et comprennent
		uniquement les Classes dont ils ont besoin. Ces classes sont celles utilisées lors
		de leur conception, et sont donc plus anciennes que celles se trouvant dans le 
		package FilRouge.


			        2) - UTILISATION -
	!!! scheduleio.jar est à installer à la racine du dossier RENDU !!!
	!!! Sur Windows, les ":" doivent être remplacé par les ";" !!!

	-Pour lancer l'application du fil touge:
		1-Se placer à la racine du dossier RENDU
		2-Pour compiler: javac -d "build" -cp "scheduleio.jar:." FilRouge/*.java
		3-Pour lancer l'application: java -cp "build:scheduleio.jar" FilRouge/Executable activities.txt constraints.txt
		  Pour lancer la classe Test: java -cp "build:scheduleio.jar" FilRouge/Test activities.txt constraints.txt
		
	!! On peut de même modifier les fichiers activities.txt et constraints.txt pour trouver un emploi du temps different !!


	-Pour lancer l'application Scheduler:
		1-Se placer à la racine du dossier RENDU
		2-Pour compiler: javac -d "build" JavaScheduler/*.java
		3-Pour lancer la classe Test: java -cp "build" JavaScheduler.Test

	-Pour lancer l'application Encoder:
		1-Se placer à la racine du dossier RENDU
		2-Pour compiler: javac -d "build" JavaEncoder/*.java
		3-Pour lancer la classe Test: java -cp "build" JavaEncoder.Test

	-Pour lancer l'application InteractiveScheduler:
		1-Se placer à la racine du dossier RENDU
		2-Pour compiler: javac -d "build" JavaInteractive/*.java
		3-Pour lancer la classe Test: java -cp "build" JavaInteractive.Test
	!!!!!!!!! éxecution ne marche pas car manque Test.java dans le dossier JavaInteractive !!!!!!!!!!
