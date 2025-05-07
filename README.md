# Hundir la Flota - Juego de terminal 

Descargar: https://github.com/ourenseko/BatallaNaval/releases/tag/Version

![screnshot](https://github.com/user-attachments/assets/e8927850-6f68-4785-bb35-7ff1dc48a92c)



![scrinshot](https://github.com/user-attachments/assets/230c1ce4-e847-4a40-b952-dc24efe95099)


#### 🔍 Leyenda:

* `X`: Impacto (disparo acertado)
* `*`: Agua (disparo fallido)
* `~`: Casilla no disparada

---

### 📊 Análisis 

Contamos todos los `X` en el tablero (independientemente de si fueron aciertos o fallos):

* Total de `X`: **13**

Contamos también los `O` intactos (que indican disparos fallidos si no fueron convertidos a `X`) — IA disparó en esas casillas y falló:

* O intactos: 5 → (4,4), (5,5), (5,6), (5,7), (6,5), (6,7), (7,5), (7,7)
  (de esos, solo 3 siguen siendo `O`, por tanto **5 más han sido impactados** y ya están en el conteo de `X`)

Sumamos:

* `X`: 13 (aciertos)
* `*`: 10 fallos (las 10 `O` que no se convirtieron aún en `X` ni están impactadas)

➡️ **Total disparos IA**: **13 + 10 = 23**
➡️ **Aciertos**: 13
➡️ **Fallos**: 10
➡️ **Precisión IA**: 13 / 23 ≈ **56.5%**

---

### ✅ Resumen Final Corregido

| Jugador | Disparos Totales | Aciertos | Fallos | Precisión |
| ------- | ---------------- | -------- | ------ | --------- |
| Tú      | 24               | 11       | 13     | 45.8%     |
| IA      | 23               | 13       | 10     | 56.5%     |



🧠 ¿La IA es inteligente o aleatoria?
✅ Lo que hace bien:
No repite disparos: Se asegura de que solo dispara si la casilla tiene AGUA.

Tiene memoria de impacto: Guarda la posición de ultimoImpacto si acierta.

Lógica de búsqueda en cruz: Tras un acierto, prueba las 4 direcciones (arriba, abajo, izquierda, derecha) en el siguiente turno.

🚫 Lo que no hace:
No busca en línea tras varios impactos consecutivos.

No sigue una orientación una vez detecta dos impactos alineados.

Si prueba las 4 direcciones tras un impacto y no acierta, olvida todo (ultimoImpacto = null).

🤖 Entonces... ¿es IA inteligente?
Respuesta: Sí, parcialmente. No es completamente aleatoria, ya que:

Tiene un disparo dirigido después de un acierto.

Su 56% de acierto se justifica porque acierta una vez y suele encadenar 1–2 disparos acertados más antes de reiniciar.

🧪 Sugerencia para mejorar la IA (si quieres hacerlo más fuerte):
Guardar todos los impactos recientes si están conectados.

Determinar dirección (horizontal o vertical) tras dos aciertos.

Expandir en esa línea hasta hundir el barco.



