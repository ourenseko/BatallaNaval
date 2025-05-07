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





