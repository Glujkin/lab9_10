package DZ_LAB12
import kotlin.properties.Delegates

class ObservableResource(val name: String, initialAmount: Int) {
    var amount: Int by Delegates.observable(initialAmount) { _, old, new ->
        println("Ресурс $name изменён: $old → $new")
        observers.forEach { it.onChanged(name, old, new) }
    }

    private val observers = mutableListOf<ResourceObserver>()

    fun addObserver(observer: ResourceObserver) {
        observers.add(observer)
    }
}