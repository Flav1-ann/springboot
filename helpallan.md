Pour créer votre propre images sur votre repo dockerhub

1. Ouvrir un terminal
2. Ce conncter au docker hub 
```docker login```
renseigner login et password dockerhub

3. Build l'image avec un tag correcte
```docker build -t logindockerhub/springapp . ```

4. Push sur le repo docker hub
```docker push logindockerhub/springapp```

5. Ajouter sont images a sont docker-compose
