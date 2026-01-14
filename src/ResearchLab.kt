class ResearchLab: OutpustModule("Иследовательская лаборотория") {
    override fun performAction(manager: ResouceManager) {
        val minerals = manager.get("Minerals")
        if (minerals == null || minerals.amount < 30){
            println("Недостаточно минералов для исследования")
            return

        }
        minerals.amount -= 30
        println("Лаборотория проводит исследование (минералы -30)")
    }

}