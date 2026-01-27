package DZ_LAB12

class OutpostManager {
    val resources = mutableListOf<ObservableResource>()

    fun addResource(name: String, amount: Int) {
        resources.add(ObservableResource(name, amount))
    }
}

val manager by lazy {
    println("Менеджер создан!")
    OutpostManager()
}