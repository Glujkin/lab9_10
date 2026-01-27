package DZ_LAB12

import java.io.File

object StateStorage {
    fun save(resources: List<ObservableResource>, filename: String) {
        val data = resources.joinToString("\n") { "${it.name}:${it.amount}" }
        File(filename).writeText(data)
        println("Сохранено в $filename")
    }

    fun load(filename: String): List<ObservableResource> {
        return try {
            File(filename).readLines().map {
                val (name, amount) = it.split(":")
                ObservableResource(name, amount.toInt())
            }
        } catch (e: Exception) {
            println("Ошибка загрузки: ${e.message}")
            emptyList()
        }
    }
}