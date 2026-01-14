package modules

import resourses.OutpostResource
import resourses.ResouceManager

class EnergyGenerator: OutpustModule("Генератор энергии") {
    override fun performAction(manager: ResouceManager) {
        println("Генератор работает... Производит 20 энергии")
        val energy = manager.get("Energy")
        if (energy != null){
            energy.amount += 20
        }else{
            manager.add(OutpostResource(99,"Energy",20))
        }
    }
}