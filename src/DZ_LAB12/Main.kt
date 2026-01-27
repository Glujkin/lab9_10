package DZ_LAB12

fun main() {

    println("Первый вызов менеджера:")
    manager.addResource("Minerals", 100)
    manager.addResource("Gas", 50)

    val observer = ConsoleObserver()

    manager.resources[0].addObserver(observer)
    manager.resources[1].addObserver(observer)

    println("\nИзменяем ресурсы:")
    manager.resources[0].amount = 120  // Minerals: 100 → 120
    manager.resources[1].amount = 30   // Gas: 50 → 30

    println("\nСохранение:")
    StateStorage.save(manager.resources, "save.txt")

    println("\nЗагрузка:")
    val loaded = StateStorage.load("save.txt")
    loaded.forEach { println("${it.name}: ${it.amount}") }
}