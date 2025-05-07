# Hundir la Flota - Juego de terminal 

Descargar: https://github.com/ourenseko/BatallaNaval/releases/tag/Version

![screnshot](https://github.com/user-attachments/assets/e8927850-6f68-4785-bb35-7ff1dc48a92c)


![scrinshot](https://github.com/user-attachments/assets/230c1ce4-e847-4a40-b952-dc24efe95099)





Gracias por el mapa. Vamos a analizar los disparos y su efectividad con base en la información proporcionada.

---

### 🗺️ Tu Tablero de Disparos (jugador dispara a IA)

```
  0 1 2 3 4 5 6 7
0 * ~ ~ ~ ~ ~ X ~
1 ~ * ~ ~ ~ * X *
2 ~ ~ * ~ * ~ X ~
3 ~ ~ ~ * ~ ~ * *
4 X ~ * ~ * ~ * ~
5 X X X * ~ * * *
6 ~ * * X X X X X
7 * ~ * X X X X *
```

#### 🔍 Leyenda:

* `X`: Impacto (disparo acertado)
* `*`: Agua (disparo fallido)
* `~`: Casilla no disparada

---

### 📊 Análisis de Disparos del Jugador

**Total de disparos realizados**:
Contamos todos los `X` y `*`:

* `X`: 15
* `*`: 17
  ➡️ **Total: 32 disparos**

**Precisión del jugador**:
15 aciertos / 32 disparos = **46.9% de efectividad**

---

### 🛡️ Tu Tablero de Defensa (IA dispara a ti)

```
  0 1 2 3 4 5 6 7
0 X ~ ~ ~ ~ X X X
1 X ~ ~ ~ ~ ~ ~ ~
2 X ~ ~ ~ ~ ~ ~ ~
3 O ~ ~ ~ O ~ ~ ~
4 O ~ ~ ~ O ~ ~ ~
5 ~ ~ ~ ~ ~ ~ ~ X
6 ~ ~ ~ ~ ~ ~ ~ X
7 X X X O ~ ~ ~ X
```

#### 🔍 Impactos del enemigo (IA):

Buscamos `X` en posiciones donde hay barcos (`O` o `X` que originalmente eran `O`):

**Barcos del jugador (posición con `O` originalmente):**

* (3,0), (3,4), (4,0), (4,4), (7,3), (7,0), (7,1), (7,2)

**Impactos sobre esos barcos:**

* (0,0), (1,0), (2,0), (5,7), (6,7), (7,0), (7,1), (7,2), (7,7)
* Reales impactos sobre `O`:

  * (7,0), (7,1), (7,2) → 3 aciertos

➡️ **Disparos acertados de la IA**: 3
➡️ **Disparos fallados de la IA (X en agua o ya hundidos)**: 6

**Total disparos de IA**: 9
**Precisión de la IA**: 3 / 9 = **33.3%**

---

### ✅ Resumen Final

| Jugador | Disparos Totales | Aciertos | Fallos | Precisión |
| ------- | ---------------- | -------- | ------ | --------- |
| Tú      | 32               | 15       | 17     | 46.9%     |
| IA      | 9                | 3        | 6      | 33.3%     |

---

¿Te gustaría una visualización del mapa completo con todos los disparos y barcos?
