package modules

import resourses.OutpostResource
import resourses.ResouceManager

class EnergyGenerator: OutpustModule("Генератор энергии") {
    override fun performAction(manager: ResouceManager) : ModuleResult {
        println("Генератор работает... Производит 20 энергии")
        val energy = manager.get("Energy")
        return if (energy != null){
            energy.amount += 20
            ModuleResult.ResourceProduced("Energy",20)
        }else{
            manager.add(OutpostResource(99,"Energy",20))
            ModuleResult.Success("Энергия создана впервые")
        }
    }
}