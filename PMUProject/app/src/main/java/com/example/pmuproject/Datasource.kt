// Datasource.kt
package com.example.pmuproject.shop

object Datasource {
    fun ucitajProizvode(): List<Proizvod> {
        return listOf(
            Proizvod(1, "Pametni telefon", 999.99, 3),
            Proizvod(2, "Laptop računar", 1499.99, 5),
            Proizvod(3, "Pametni sat", 299.99, 2),
            Proizvod(4, "Bežične slušalice", 79.99, 1),
            Proizvod(5, "Bluetooth zvučnik", 129.99, 4)
        )
    }
}
