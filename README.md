## 2. Sistema de Estados Alterados (Debuffs/Buffs)

### Descripción

Se implementó una interfaz `IEstadoAlterado` que puede aplicarse a cualquier personaje del sistema de combate. Esta interfaz permite crear diferentes efectos temporales que modifican el comportamiento del personaje durante la batalla.

Ejemplos de estados implementados:

* **Envenenado:** el personaje pierde vida por turno.
* **Congelado:** el personaje no puede atacar por 1 turno.
* **Aumento de Fuerza:** el personaje mejora su ataque durante algunos turnos.

### Impacto

El algoritmo de combate verifica si el personaje tiene estados activos antes de ejecutar el ataque. De esta manera, los estados alterados pueden afectar directamente el desarrollo del combate, ya sea reduciendo vida, bloqueando ataques o aumentando el daño realizado.

### Reto

La gestión de estados se realizó mediante una lista de objetos en la clase `Personaje`, permitiendo que un mismo personaje pueda tener varios estados alterados activos al mismo tiempo.
