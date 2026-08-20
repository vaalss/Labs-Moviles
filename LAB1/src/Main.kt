fun main() {
    val articulo1 = "Brownie"
    var cantidad1 = 10
    var disponible1 = true

    val articulo2 = "Pastel"
    var cantidad2 = 10
    var disponible2 = true

    val articulo3 = "Galleta"
    var cantidad3 = 10
    var disponible3 = true

    val articulo4 = "Gomitas"
    var cantidad4 = 10
    var disponible4 = true

    val articulo5 = "Chocolate"
    var cantidad5 = 10
    var disponible5 = true

    do {
        println("\nInventario:")
        println("1. Mostrar inventario")
        println("2. Buscar producto")
        println("3. Actualizar cantidad")
        println("4. Mostrar estadísticas")
        println("5. Salir")
        print("Seleccione una opción: ")
        val opcion = readln().toIntOrNull()

        when (opcion) {
            1 -> {
                println("\nInventario:")
                println("$articulo1 - Cantidad: $cantidad1 - Disponible: $disponible1")
                println("$articulo2 - Cantidad: $cantidad2 - Disponible: $disponible2")
                println("$articulo3 - Cantidad: $cantidad3 - Disponible: $disponible3")
                println("$articulo4 - Cantidad: $cantidad4 - Disponible: $disponible4")
                println("$articulo5 - Cantidad: $cantidad5 - Disponible: $disponible5")
            }
            2 -> {
                print("\nIngrese el nombre del producto: ")
                val buscar = readln().lowercase()

                when (buscar) {
                    articulo1.lowercase() -> println("\n$articulo1 - Cantidad: $cantidad1 - Disponible: $disponible1")
                    articulo2.lowercase() -> println("\n$articulo2 - Cantidad: $cantidad2 - Disponible: $disponible2")
                    articulo3.lowercase() -> println("\n$articulo3 - Cantidad: $cantidad3 - Disponible: $disponible3")
                    articulo4.lowercase() -> println("\n$articulo4 - Cantidad: $cantidad4 - Disponible: $disponible4")
                    articulo5.lowercase() -> println("\n$articulo5 - Cantidad: $cantidad5 - Disponible: $disponible5")
                    else -> println("Producto no encontrado")
                }
            }
            3 -> {
                println("\nSeleccione el producto:")
                println("1. $articulo1")
                println("2. $articulo2")
                println("3. $articulo3")
                println("4. $articulo4")
                println("5. $articulo5")
                print("Número: ")
                val producto = readln().toIntOrNull()

                if (producto != null && producto in 1..5) {
                    print("Nueva cantidad (0-100): ")
                    val cantidad = readln().toIntOrNull()

                    if (cantidad != null && cantidad in 0..100) {
                        when (producto) {
                            1 -> {
                                cantidad1 = cantidad
                                disponible1 = cantidad1 > 0
                            }

                            2 -> {
                                cantidad2 = cantidad
                                disponible2 = cantidad2 > 0
                            }

                            3 -> {
                                cantidad3 = cantidad
                                disponible3 = cantidad3 > 0
                            }

                            4 -> {
                                cantidad4 = cantidad
                                disponible4 = cantidad4 > 0
                            }

                            5 -> {
                                cantidad5 = cantidad
                                disponible5 = cantidad5 > 0
                            }
                        }
                        println("Cantidad actualizada correctamente")
                    } else {
                        println("Cantidad inválida")
                    }
                } else {
                    println("Producto inválido")
                }
            }
            4 -> {
                var productosDisponibles = 0

                if (disponible1) productosDisponibles++
                if (disponible2) productosDisponibles++
                if (disponible3) productosDisponibles++
                if (disponible4) productosDisponibles++
                if (disponible5) productosDisponibles++

                val totalCantidades = cantidad1 + cantidad2 + cantidad3 + cantidad4 + cantidad5

                println("\nEstadísticas:")
                println("Productos disponibles: $productosDisponibles")
                println("Total de cantidades: $totalCantidades")
            }
            5 -> {}
            else -> println("Opción inválida")
        }
    } while (opcion != 5)
}