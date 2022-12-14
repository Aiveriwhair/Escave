# Journal de bord

## Semaine du 29 au 5 juin 2022

### Répartition des tâches
* Ana travaille sur les bases de l'architecture du projet.
* William travaille sur la génération des grottes (javascript).
* Jérémy travaille sur les graphismes des joueurs et mob.
* Tout le monde travaille sur la conception du projet .

### Ana : architecture de base du projet

- Création d'une classe Entity
    - position, avatar, fonction tick
- Création d'une classe Avatar
    - gère le chargement d'une image et son animation
- Création d'une classe Vec2
    - un vecteur de 2 flottants pour représenter une position, une échelle, etc

### Jérémy:graphisme du jeu

* appararences des joueurs et des mobs
* apparence du fond du jeu

### Tout le monde (conception)

* conceptualisation du jeu
    * manière dont il sera joué
    * mécaniques récurrentes
    * setting de l'univers, scénario

## Mardi 7 juin 2022

### Répartition des tâches

* Ana travaille sur la mise en place du réseau
* Lucas travaille sur l'implémentation des tests et l'intégration continue avec gitlab
* Benjamin, Léa et Amaury travaillent sur les automates des divers objets
* Jérémy et William travaillent sur la génération des grottes (de javascript à java)
* Ali travaille sur la physique

### Ana : mise en place du réseau

- Abstraction pour pouvoir avoir un "serveur" interne si n'on a qu'un seul client : séparation entre vue et controlleur, avec une implémentation locale et une implémentation contrôlée via le réseau dans les deux cas.
- Deux points d'entrées : un pour le client, un pour le serveur

### Lucas : implémentation des tests et intégration continue

- Mise en place de JUnit afin de réaliser et exécuter des tests unitaires sur les différentes classes du projet.
- Mise en place du build system Maven ce qui a demandé une restructuration du projet. Cela a permis de mettre en place l'intégration continue sur Gitlab permettant de vérifier que le projet build pour chaque commit.

### Benjamin, Léa, Amaury : conception des automates

- Conception des automates des blocs, consumables et de l'inventaire.

### William et Jérémy : génération des grottes

* convertir le code de cette génération qui est en javascript en java. Perlin noise première version+ dessin sprite
### Ali Conception de la partie physique du jeu 

### Idées

- classe dégats propre à la pioche et à l'épée pour que les blocks et mob sachent si ils prennent des dégats et qu'ils puissent détecter l'action de leur mettre des coups.

## Mercredi 8 juin 2022

### Répartition des tâches
* Ana a fini la mise en place du réseau
* Benjamin et Léa travaillent sur les automates des objets restants

### Benjamin et Léa : conception des automates
* Réflexions autour de diverses problématiques d'un point de vue automate : 
    - Quel(s) automate(s) attaque(nt) ? Et que représente la notion d'attaquer ?
    - Est-il est nécessaire de différencier une attaque dans le vide et une attaque qui fait des dégats ?
    - Faut-il créer une "classe intermédiaires" Dégats pour différentes entités afin de détecter les attaques monstres/personnages ?
    - Comment/où choisir quel bloc est frappé en priorité si on en est entouré de plusieurs côtés ?
    - Comment/où  selectionner les objets de l'inventaire que l'on souhaite utiliser ? (on assigne chaque objet à une touche, on utilise les flêches dans un menu inventaire...)
    - Est-ce que le fait de tourner le personnage à 180 degrés est explicite ou implicite dans l'automate ?
    
    - #### Les automates peuvent-ils communiquer entre eux ? i.e : lors de l'activation d'une touche, chaque automate réagit-il, ou bien un premier automate peut-il communiquer l'information à un second et déclencher une de ses transitions ?


* Reconception et amélioration des automates (Bloc, Inventaire, Épée, Pioche) avec les informations reçues de M. Périn

* Suppression des automates Épée et Pioche, maintenant c'est le joueur qui gère l'entièreté des attaques

### Ana : fin de la mise en place du réseau

- Bug dû à une mauvaise utilisation des ObjectOutputStream réglé

### William et Ali : 
- Conception de la partie physique et des colliders . 
- Utilisation de la méthode AABB de détéction des collisions . 

### Jérémy
* Réalisation de la V1 du perlin Noise, premier rendu de grotte en 2D+ dessin sprite

## Jeudi 9 Juin 2022

Après l'entretien avec M. Gruber, nous avons décidé de faire une réunion afin de définir techniquement les tâches à faire (ainsi qu'évaluer leur difficulté et temps), réaliser des diagrammes de classes et d'objets, et répondre aux éventuelles questions des membres de l'équipe.

### Répartition des tâches
* Benjamin, Léa, Lucas et Amaury travaillent sur les automates
* Ana optimise le code du réseau et règle quelques bugs
* Jérémy s'occupe de la génération du monde+ dessin sprite
### Lucas,  Benjamin, Léa, Amaury: conception des automates

* Amélioratons des automates (Bloc, Inventaire, Consumables)
* Conception des automates Statue, Champignon (monstre basique)
* Réflexion autour de l'automate du joueur et début de conception
* Les automates des consumables (eau, nourriture) deviennent des automates vides, maintenant c'est l'inventaire qui se charge de tout gérer (ramasser, jeter, comsommer)

### Ana : optimisation du réseau
- Bugs d'accès concurrents réglés
- Optimisations
    - Message "MultiMessage" qui permet d'envoyer plusieurs messages en un seul paquet
    - Un seul paquet au plus est envoyé par tick du serveur, pour éviter de saturer le réseau et s'assurer que les clients ont bien le temps de traiter les paquets reçus

### Ali et William: 
* Création du package physique 
* Mise en place des colliders : 
   -Une classe absraite Collider
   -Classe Boxcollider qui hérite de Collider et gère les collisions par des rectangles . 
   -Classe Circle Collider(pas encore implémenter pour le moment ), on pourra introduire de cette classe pour la gestion des collisions de type  cercle-cerlce ou rectangle-cercle .
   
### Jérémy
* Réalisation du Simplex Noise en 2D, rendu de tore.+ dessin sprite

## Vendredi 10 Juin 2022

### Répartition des tâches

- Ana : review de code et aide
- Benjamin, Léa, et Amaury travaillent sur les automates
- Jérémy travaille sur la génération
- 
### Lucas: ajout d'une caméra

* Ajout d'un système de caméra basique contrôlable avec les flêches du clavier, pour l'instant les différents clients sur le réseau partagent la même caméra

### Benjamin, Amaury et Léa : conception des automates
* Communication importante avec les chargés de la partie Physique après avoir pensé à d'autres détails (dialogue autour des collisions, actions possibles dans les airs pour les monstres et héros...)
* mise en place des pop et Wizz et généralisation des conditions
* finalisation des automates en GAL

### William et Ali 
* Création de la classe ColliderSide qui permet de déterminer le coté du rectangle où il a eu une collision . 
* Création de la classe RigidBody pour la mise en place des forces physiques. 

### Jérémy
* Implémentation du Open Simplex Noise
* Recherches intensives et etudes mathématiques pour comprendre comment générer un tore avec du simplex noise+ dessin sprite

## Lundi 13 juin 2022

### Répartition des tâches

* Ana : merge de trois branches
* Lucas, Benjamin et Léa : rédaction du contrat
* Lucas : rédaction du planning
* Ali : Gestion du déplacements du joueur dans une Tore
* Jérémy travaille sur la réalisation du tore en OpenSimplexNoise
### Ana : merge de trois branches

- Merge du code permettant de différencier les joueurs côté serveur.
    - chaque joueur a maintenant ses propres contrôles indépendants des autres
    - chaque joueur a sa caméra qui suit son avatar
- Merge du code de génération de la carte
    - crée des blocs dans le modèle là où le code de génération indique qu'il en faut
- Merge du code de physique

### Jérémy
* Implementation du Simplex noise en 4D pour générer de la 2D 
* Implémentation du spawn des joueurs et de la sortie+ dessin sprite

## Mardi 14 juin 2022

- Ana : règle quelques bugs liés au réseau. Objectif à la fin de la journée : pouvoir se promener à deux (ou plus) sur la carte qu'on génère maintenant, en réseau
- Lucas : implémentation des classes pour les Automates + commencement de BotBuilder
- Benjamin et Amaury : implémentation des classes pour les conditions des automates et fonctions de la classe playerBehaviour.
- Léa : review des automates et mise au propre du fichier GAL, remodification des automates de l'inventaire et de la statue.

- Ali : Conception du déplacement du joueur lorqu'il atteint les limites de la Map et déplacement de la map en permanence ne plus avoir du vide aux limites . 
- Jérémy : génération de la sortie, des statues de manière cohérentes en fonction du nombre de joueur, rendre générique le code.+ dessin sprite


### Lucas : implémentation des classes pour les Automates + commencement de BotBuilder

* Ajout des classes Automata, AutomataState et AutomataTransition permettant de représenter les automates dans le code
* Ajout de la classe BotBuilder implémentant l'interface fournie IVisitor, cette classe permet de créer les automates à partir d'un AST.

### Benjamin, Amaury: implémentation des classes pour les conditions et actions des automates et fonctions de la classe playerBehaviour.

* Ajout des classes IConditions, IActions et de toutes les classes des diveress conditions et action avec leurs fonctions eval.
* Implémentation des fonctions True,Cell,GotPower,wizz(jump) et move de la classe playerBehaviour.


## Mercredi 15 juin 2022

* Benjamin : implémentation des points de vie, des divers dégats, des classes de toutes les entités nécessaires ainsi que leurs behaviours

### Benjamin : implémentation des points de vie, des divers dégats, des classes des entités et de leurs behaviours.

* Ajout des classes Mushroom, Block, Statue, Socle et Stalactite.
* Ajout des classes Behaviours pour toutes les entités.
* implémentation des fonctions  hit et coup_reçu.

### Jérémy
* Première version des identifiants de blocs et des patterns.+ dessin sprite

## Jeudi 16 juin 2022

* Benjamin, Amaury : implémentation des fonctions des Behaviours de chaque entité.

### Benjamin et Amaury : implémentation des fonctions des Behaviours de chaque entitié.

* implémentation des fonctions de déplacements (Move,Jump...)

*Ali: implémentation de la fonction setposition dans la classe Entity qui gère le deplacement du joueurs lorqu'il franchit les limites de la map . 

### Jérémy
* Implémentation des patterns de couche 1 et 2+ dessin sprite

## Vendredi 17 juin 2022

* Benjamin, Amaury : implémentation des fonctions des Behaviours de chaque entité.
* Lucas: BotBuilder terminé
* William et Léa : Conception et début d'implémentation de la classe inventaire

### Benjamin et Amaury : implémentation des fonctions des Behaviours de chaque entitié.

* implémentation des fonctions de hit et coup reçu.
* implémentation des fonctions de cell et closest.

### Jérémy
* Rajout de la décoration dans les grottes + dessin sprite

## Dimanche 19 juin 2022

* Lucas: Exécution des automates dans le code
* Benjamin, Amaury : tests des fonctions faites et des automates.
* Léa : implémentation de la classe inventaire et des autres classes nécéssaires
* William : aide et revoit le code de Léa, travaille sur le RayCasting

### Lucas: Execution des automates dans le code

* Ajout des automates enregistrés par le BotBuilder au modèle
* Automates liés aux entités
* Automates exécutés dans les ticks 

### Benjamin et Amaury : tests des fonctions faites et des automates

* tests et débug des fonctions cell, closest et des déplacements
* modification des fonctions cell et closest.
* fonction egg implémentée (à tester sur les mobs)
* ajustement dans la hiérarchie des behaviours

### Jérémy, Ana, Amaury : génération des filons

### Léa, William : implémentation de la classe inventaire et des autres classes nécéssaires

* Ajout de plusieurs champs dans la classe player (jauge de satiété et de soif)
* Création d'une classe Tool : les objets de l'inventaire héritent de cette classe. On a des armes et des consommables.
* Les armes sont fixes dans l'inventaire alors que les consommables disparaissent une fois utilisés.

### William : aide et revoit le code de Léa, travaille sur le RayCasting

* Définir nos besoins pour implémenter les Ray Casting
* Créations des classes et de leurs structures de base
* Implémentation de l'algorithme de Ray Casting

## Lundi 20 juin 2022

* Lucas : Implementation des conditions key dans les automates
* Amaury et Benjamin : implémentation des behaviours
* Léa : réimplémentation de la classe inventaire et des autres classes nécéssaires
* William : aide et revoit le code de Léa, travaille sur le RayCasting, et l'apparition des mosntres

### Lucas: Implementation des conditions key dans les automates

* Enregistrement des touches appuyées dans une liste dans le controlleur local
* Lecture de cette liste par les conditions Key pour savoir si la touche est appuyée ou non

### Amaury et Benjamin

* Implémentation des actions des statues, socles et stalactites
* Factorisation et nettoyage de certaines méthodes
* Ajout des frottements pour le player

### Léa, William : réimplémentation de la classe inventaire et des autres classes nécéssaires

* Création d'une classe InventoryCouple qui permet de stocker plusieurs fois des objets de même nature
* Réimplémentation de toute la classe inventaire qui contient maintenant des couples (Tool, Quantité)

### William : aide et revoit le code de Léa, travaille sur le RayCasting, et l'apparition des mosntres

* Implémentation terminée du RayCasting en mono ray pour le cassage de bloc 
* Début de l'implémentation du RayCasting multi ray pour simuler la lumière
* Implémentation de l'algorithme d'apparition des monstres sur la carte

### Jérémy
* Implementation des sprites et première version des stalactites

## Mardi 21 juin 2022

* Lucas : implémentation des automates des mobs et des statues
* Amaury : utilisation des objets de l'inventaire (placement de blocs)

## Mercredi 22 juin 2022

* Lucas : Synchronisation de la caméra quand le joueur devient statue et inversement
* Lucas : Implémentation des animations du joueur
* Amaury et Benjamin : utilisation des objets avec la souris
* Amaury : test d'ajout de musique
* Léa et William : Implémentation de la détection des conditions de fin de partie
* Léa : Implémentation de la doublure
* William : Création de la page de selection des automates et de selection de l'IP dans le menu
* Jérémy : Implémentation du menu du jeu

### Amaury et Benjamin : objets avec la souris
* Placement et destruction de blocs selon la position de la souris (avec raycasting)
* Frappe joueur-ennemi (et réciproquement) avec recul
* Ressources vitales du personnage, mort personnage et ennemis
* dégradation de la soif et de la satiété avec mort éventuelle
* ramasser de l'eau et de la nourriture et l'utiliser 

## Jeudi 23 juin 2022
* Benjamin : fix quelques bugs ou implémentation
* William : Finir l'implémentation du menu, implémentation du spawn des monstres
* Jérémy : sprites manquant + implémentation du menu du jeu

### Benjamin : fix quelques bugs ou implémentation
* réglage collider player
* mouvement du player dans l'état statue
* egg du Mushroom
* fix point de vie du mob et sa mort

### Amaury : musiques
* composition thème menu sur Bandlab
* recherche de bruitages et solutions pour lire le son dans le jeu différemment qu'avec ogg player


## Vendredi 24 juin 2022
* Benjamin : fix quelques bugs ou implémentation
* Jérémy: fix beaucoup de bug + implementation sprite + dessins sprites sortie + statue + spawn
* William : Début de l'implémentation d'une extension pour la lumière en utilisant le ray casting

### Benjamin : fix quelques bugs ou implémentation
* implémentation des stalactites avec toutes ses conséquences
* fix collider


### Amaury : intégration des musiques et bruitages
* Lecture des sons .wav grâce java.Clip




## Samedi 25 juin 2022

* Lucas : Réglage de nombreux bugs + ajout de la fin du jeu
* Amaury : branche checkbox, affichage des zones analysées par les automates pour améliorer le debug graphique. Fix de bugs mineurs (utilisation de raycasting, bruitages)
* William : Fix du spawn des monstres, fin de l'implémentation de la lumière. Impasse technique due à AWT.
* Jérémy: Merge des deux menus, le mien et celui de william. Finir le design du menu. Implementation de l'eau et de la parallax

## Dimanche 26 juin 2022

* William : Tests du jeu et fixs des quelques problèmes restants
* William : Ajustements sur la difficulté du jeu, enregistrement de vidéos pour la vidéo de démonstration
* Jérémy : implementation des tout dernier sprites + réalisation de la vidéo finale (tournage, voix off, montage...)
* Amaury : prolongement musique menu, intégration du thème de jeu, fix de bugs mineurs.
