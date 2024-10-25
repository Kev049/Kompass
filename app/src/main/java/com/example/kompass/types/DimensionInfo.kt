package com.example.kompass.types


/*
SÄBOVIK
Längd: 204 cm

Bredd: 140 cm

Höjd: 90 cm

Madrasslängd: 200 cm

Madrassbredd: 140 cm
 */

data class DimensionInfo(
    val length: Int,
    val width: Int,
    val height: Int,
    val mattressLength: Int,
    val mattressWidth: Int
)
