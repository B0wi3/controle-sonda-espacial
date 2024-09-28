# Sistema de controle de sondas espaciais via API REST

# Como usar

## Inicialmente não haverão sondas ou planetas criados.

- Para criar sondas: POST - http://localhost:8080/probe/{NomeDaSonda}
- Para criar planetas: POST - http://localhost:8080/planet BODY -> {
    "name": "Saturn",
    "height": 7,
    "width": 3
}
- Para pousar uma sonda em um planeta: POST - http://localhost:8080/probe/land?probeName={NomeDaSonda}&planetName={NomeDoPlaneta}
- Para mover a sonda dentro da área do planeta (um plano cartesiano): PUT - http://localhost:8080/probe/{NomeDaSondaPosicionada}/move?commands={Commandos}

- Comandos:
  - M: Move na direção para qual a sonda aponta. Inicialmente a sonda aponta para Norte (N), coordenadas 0,0
  - L: Gira 90° para a esquerda (se apontando ao Norte, irá para W, West/Oeste)
  - R: Gira 90° para a ddireita (se apontando ao Norte, irá para E, East/Leste)
  
