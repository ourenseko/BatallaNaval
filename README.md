# Hundir la Flota - Juego de terminal 

Descargar: https://github.com/ourenseko/BatallaNaval/releases/tag/Version

![screnshot](https://github.com/user-attachments/assets/e8927850-6f68-4785-bb35-7ff1dc48a92c)



![scrinshot](https://github.com/user-attachments/assets/230c1ce4-e847-4a40-b952-dc24efe95099)


#### 🔍 Leyenda:

* `X`: Impacto (disparo acertado)
* `*`: Agua (disparo fallido)
* `~`: Casilla no disparada


---

### ✅ Resumen Final 

| Jugador | Disparos Totales | Aciertos | Fallos | Precisión |
| ------- | ---------------- | -------- | ------ | --------- |
| Humano  | 38               | 16       | 22     | 42.1%     |
| IA      | 37               | 12       | 25     | 48.0%     |



---

### 🧠 ¿La IA es inteligente o aleatoria?

#### ✅ Lo que hace bien:

1. **No repite disparos**: Se asegura de que solo dispara si la casilla tiene `AGUA`.
2. **Tiene memoria de impacto**: Guarda la posición de `ultimoImpacto` si acierta.
3. **Lógica de búsqueda en cruz**: Tras un acierto, prueba las 4 direcciones (arriba, abajo, izquierda, derecha) **en el siguiente turno**.

#### 🚫 Lo que **no** hace:

* No busca en línea tras varios impactos consecutivos.
* No sigue una orientación una vez detecta dos impactos alineados.
* Si prueba las 4 direcciones tras un impacto y no acierta, **olvida todo** (`ultimoImpacto = null`).

---

### 🤖 Entonces... ¿es IA inteligente?

**Respuesta:** **Sí, parcialmente.** No es completamente aleatoria, ya que:

* Tiene un disparo dirigido después de un acierto y suele encadenar 1–2 disparos acertados más antes de reiniciar.

---

### 🧪 Sugerencia para mejorar la IA (si quieres hacerlo más fuerte):

1. **Guardar todos los impactos recientes** si están conectados.
2. **Determinar dirección (horizontal o vertical)** tras dos aciertos.
3. **Expandir en esa línea hasta hundir el barco.**

Nivel de dificultad: Marina
Nivel actual: Niño rata.

