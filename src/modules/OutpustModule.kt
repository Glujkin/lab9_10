package modules

import resourses.ResouceManager

abstract class OutpustModule(
    val name: String,
    var level: Int = 1
) {
    fun upgrade(){
        level++
        println("$name улучшен до уровня $level")
    }
    abstract fun performAction(manager: ResouceManager)
}