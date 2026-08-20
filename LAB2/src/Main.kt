enum class ElementType {
    ENTERO,
    CADENA,
    BOOLEANO,
    DESCONOCIDO
}

data class ItemData(
    val originalPos: Int,
    val originalValue: Any,
    val type: ElementType,
    val info: String) {

    override fun toString(): String {
        return "'$originalValue' estaba en la posición $originalPos, es de tipo ${type.name.lowercase()} e info es ${info.lowercase()}"
    }
}

fun processList(list: List<Any?>?): MutableList<ItemData>?  {
    if (list == null) {
        return null
    }

    val result = mutableListOf<ItemData>()

    for ((index, element) in list.withIndex()) {
        if (element == null) continue

        val type: ElementType
        val info: String

        when (element) {
            is Int -> {
                type = ElementType.ENTERO
                info = when {
                    element % 10 == 0 -> "M10"
                    element % 5 == 0 -> "M5"
                    element % 2 == 0 -> "M2"
                    else -> "-"
                }

            }
            is String -> {
                type = ElementType.CADENA
                info = "l${element.length}"
            }
            is Boolean -> {
                type = ElementType.BOOLEANO
                info = if (element) "verdadero" else "falso"
            }
            else -> {
                type = ElementType.DESCONOCIDO
                info = "desconocido"
            }
        }

        result.add(
            ItemData(
                originalPos = index,
                originalValue = element,
                type = type,
                info = info
            )
        )
    }

    return result
}

fun main() {
    val list = listOf(null, 20, "Hola", true, true, null, 22, false, "PC")
    val result = processList(list)
    result?.forEach {
        println(it)
    }
}