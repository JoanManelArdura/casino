Funcionalidades de la aplicacion de casino virtual:

hay 5 juegos, cada uno con base similar pero completamente independiente. 
Cada uno tiene distintos porcentajes de premio y posiblidades de ganar.

El jugador escoge juego y cantidad a apostar, y retorna via consola si ha ganado, 
si ha perdido, y las cantidades (muy abreviado para que el spam sea controlable)

Cada jugador es un hilo independiente, por lo que puede haber tantos jugadores simultaneos como haga falta.

Hay 3 tablas de base de datos: jugador(Player), jugada(jugada), y transacciones(Transaction). cada una tiene su repository y su clase de servicio.

He implementado una mínima funcionalidad web (controller) para poder acceder a datos y jugar, a traves de localhost:8080 en este caso. 
Esta parte se podría desarrollar tanto como hiciera falta, para permitir un funcionamiento total a traves de web.

Para comprobar que todo es funcional, he implementado unos jugadores virtuales...se crean con una cantidad de dinero random, 
y cada segundo, hacen apuestas aleatorias a juegos al azar, respetando minimos y maximos de apuesta de cada juego. Si se quedan sin fondos, hay un 50% de posiblidad 
que recarguen $, y en caso contrario, abandonan el casino. Y si se quedan sin tiempo (les doy 30 segundos), tambien abandonan el casino.

Toda la comunicacion del programa es por consola.






