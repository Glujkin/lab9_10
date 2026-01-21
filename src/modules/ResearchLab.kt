package modules

import resourses.ResouceManager

class ResearchLab: OutpustModule("Иследовательская лаборотория") {
    override fun performAction(manager: ResouceManager) : ModuleResult {
        val minerals = manager.get("Minerals")
        if (minerals == null || minerals.amount < 30){
            println("Недостаточно минералов для исследования")
            return ModuleResult.NotEnoungResources(
                resourceName = "Minerals",
                required = 30,
                availabele =  minerals?.amount ?: 0
            )
        }
        minerals.amount -= 30
        return ModuleResult.Success("Исследование завершено")
    }

}