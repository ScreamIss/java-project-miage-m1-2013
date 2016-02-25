Projet 2012-2013
1. Modalités
2. Fonctionnalité
3. Chargement dynamique
4. Persistance
5. Modularité et dépendance
6. Documentation et suivi de projet
Modalités
Pour le projet, vous devez constituer des groupes entre 3 et 4 étudiants maximum.
Le projet sera évalué en fonction des critères suivants :
fonctionnalité
mécanisme de gestion de plugins et de chargement dynamique
persistance
modularité et dépendances
documentation / gestion du projet
Chacun de ces critères comptant pour 20% de la note de rendu du projet. Cette note sera commune à tout le groupe.
Vous devez remettre votre projet au plus tard le dimanche 20 janvier à minuit. Le chef de projet doit envoyer un e-mail à son chargé de TP en mettant en copie ses équipiers. Le mail aura obligatoirement un titre de la forme [Miage](Miage.md)[M1](M1.md)[POO](POO.md) Projet [du projet](Nom.md) - <Nom de famille des équipiers>
Le corps du mail doit obligatoirement contenir :
Le NOM et prénom des participants du projet
Une archive contenant les sources du projet (un projet Eclipse ou NetBeans), pas les binaires !
Un .jar exécutable qui aura été préalablement testé
Un rapport (20 pages maximum) qui décrit
La participation de chacun des membres de l'équipe ;
La procédure à suivre pour tester votre projet ;
Un calendrier des grandes étapes du projet (par membre) ;
Pour chacun des 5 points énoncés au début (fonctionnalité, chargement dynamique, persistance, modularité, suivi), la façon dont ils ont été adressés ou pas et les aspects remarquables.
La procédure pour créer de nouveaux plugins
Plusieurs exemples de plugins (au moins 4) avec une courte description (10 lignes maximum) de ce qu'ils font.
Le contenu du mail (si trop gros) peut également être déposé sur un site de gestion de code (type google code ou assembla). Il faudra penser à garder une copie locale au cas où le site tombe en panne la veille de la démonstration.
Une soutenance orale (par groupe) aura lieu le mardi 22 janvier selon un calendrier annoncé ultérieurement. Cette présentation orale de 20 minutes aura pour but de mettre en lumière la contribution individuelle de chaque membre du groupe. Cette note de soutenance sera individuelle.
La note finale de projet sera calculée en faisant la moyenne de la note de rendu de projet (50%) et la note de soutenance (50%).
Fonctionnalité
Le but du projet est de mettre en oeuvre les différents aspects étudiés et appliqués lors des cours et des TDs. Pour cela, on vous propose, de réaliser un tableau extensible par ajout de plugins.
La plugin principal devra permettre à l'utilisateur de saisir des valeurs numériques ou textuelles dans un tableau avec les fonctions d'édition habituelles.

Trois familles de plugins complémentaires sont proposées
Des plugins de courbes pour dessiner graphiquement les données saisies dans le tableau (Diagramme en barres, en camembert, en lignes brisées, interpolation, ...). La modification des données doit entrainer la mise à jour des graphiques !
Des plugins de formules qui permettent d'appliquer une formule à des cellules. Pour chaque formule, l'utilisateur devra disposer d'une description de la formule, de la nature et du nombre de paramètres attendus.
Tableaux de valeurs numériques: Somme ; Moyenne ;
Deux tableaux de valeurs numériques: Moyenne pondérée;
Deux tableaux de valeurs comparables: Minimum, maximum, tri.
Des plugins de mise en forme
Changer la couleur et la famille de la police;
Changer la couleur de fond
Aligner à gauche, au centre ou à droite;
Afficher des valeurs numériques, monétaires, ou des dates.
La liste des plugins n'est pas imposée ni exhaustive.
D'autres familles sont aussi possibles: un plugin qui permet d'associer de l'aide (fichier .html) à un plugin déployé.
Chargement dynamique
Les fonctionnalités supplémentaires doivent être chargées dynamiquement. Il est impératif de pouvoir recharger des nouveaux plugins à chaud (sans avoir besoin de fermer la fenêtre).
Une considération particulière sera donnée aux projets capables de montrer qu'ils ont intégrés des plugins réalisés par d'autres équipes.
Persistance
La persistance consistera à pouvoir sauvegarder et rétablir l'environnement en restaurant la ou les feuilles ouvertes, en restaurant les fenêtres graphiques, les formules ou les mises en forme lorsqu'elles ont été appliquées.
Attention toutefois à se préoccuper des erreurs potentielles lorsque le plugin associé à une fonctionnalité sauvegardée n'est plus disponible.
Modularité et dépendance
Certains plugins peuvent dépendre d'autres plugins. Par exemple, un plugin ne peut pas ajouter des menus dans la fenêtre s'il n'y a pas un plugin spécifique pour gérer l'ajout des menus. Il n'est pas possible de dessiner des données s'il n'y a pas un plugin pour gérer le contenu de la table.
Le rapport devra décrire le mécanisme mis en place pour gérer les dépendances entre les plugins.
Documentation et suivi de projet
Le code devra être suffisamment commenté pour être lisible. La documentation javadoc sera générée. Cela n'a de l'intérêt que s'il y a au minimum:
Une description du rôle de chaque classe dans l'en-tête de la classe ;
Une description du fonctionnement des méthodes (hors accesseurs et modificateurs) ainsi que des paramètres.
Un des équipiers s'occupera du suivi du projet, de la coordination des actions des équipiers. Il sera déchargé d'une partie du travail de développement pour assurer cette tâche. Cette "décharge" ne sera prise en compte que s'il y a réellement du travail de suivi et de coordination mis en place. Il vous appartient de valoriser cette action dans votre rapport et votre présentation.