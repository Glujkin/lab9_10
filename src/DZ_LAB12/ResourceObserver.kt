package DZ_LAB12

interface ResourceObserver {
    fun onChanged(name: String, old: Int, new: Int)
}

class ConsoleObserver : ResourceObserver {
    override fun onChanged(name: String, old: Int, new: Int) {
        println("[Наблюдатель] $name: $old -> $new (изменение: ${new - old})")
    }
}