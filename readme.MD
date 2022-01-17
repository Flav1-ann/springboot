# Projet Spring Boot

## Le projet

L'objectif de cette application est de permettre à un utilisateur d'ajouter des musiques dans une liste, de modifier une musique ou bien de la supprimer.

Ce projet comprend le déploiement via terraform, ansible et docker de l'application. 

## Prérequis

* Un compte AWS amazon [site](https://aws.amazon.com/fr/console/)
* Un fichier "credentials" [voir documentation](https://docs.aws.amazon.com/fr_fr/toolkit-for-vscode/latest/userguide/obtain-credentials.html)
* Une clé pour la connexion aux machines au format `.pem` [voir documentation](https://docs.aws.amazon.com/fr_fr/AWSEC2/latest/UserGuide/ec2-key-pairs.html)
* Terraform v1.1.3 [installation](https://learn.hashicorp.com/tutorials/terraform/install-cli)

##  Paramétrage

Afin d'effectuer le déploiement de l'application vous allez devoir modifier deux fichiers. 

### Modifier les identifiants

Le premier fichier est le fichier main.tf se trouvant au chemin terraform/app:

- Modifiez tout en haut du fichier la clé `shared_credentials_file` avec la valeur représentant le chemin jusqu'à votre fichier "credentials".

Le second fichier est le fichier variable.tf se trouvant au chemin terraform/modules/ec2.

- Modifiez la clé `default` de la variable `path_ssh_key` avec le chemin jusqu'au dossier contenant votre clé de connexion.
- Modifiez la clé `default` de la variable `ssh_key` avec le nom de votre clé de connexion (sans l'extension .pem).

### Renommer les variables (Optionnel)

Si vous souhaitez changer les noms qui apparaissent (ici annaix) par le votre, vous pouvez modifier dans les différents fichiers `variable.tf` la variable `author` en changeant la clé `default` avec la valeur de votre choix.

## Lancement

Une fois le paramétrage réalisé, vous pouvez exécuter terraform. Pour ce faire, vous devez vous rendre à l'aide d'un terminal au niveau du fichier main.tf se trouvant au chemin terraform/app puis:

- Lancez la commande `terraform init`
- Lancez la commande `terraform apply` et répondez "yes" lorsque demandé.

le déploiement prend un certain temps, une fois terminé rendez-vous sur votre [compte aws](https://console.aws.amazon.com/ec2). Vous devriez voir une instance en cours d'exécution. Récupérer son ip et entrez là dans le navigateur sous le format suivant: http://VOTRE_IP:8080

cependant une erreur connue peut survenir, si c'est le cas rendez-vous [ici](#troubleshooting) 

<div id='troubleshooting'/>

## Troubleshooting

Il est possible que lors de l'installation de la machine sur aws. Une installation de paquets échoue, nous n'avons pas trouvé de solution à ce problème. Si le problème survient il faut relancer la commande `terraform apply`.