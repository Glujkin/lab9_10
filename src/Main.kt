import modules.EnergyGenerator
import modules.ModuleResult
import modules.ResearchLab
import resourses.OutpostResource
import resourses.ResouceManager

fun handleModuleResult(result: ModuleResult) {
    when (result) {
        is ModuleResult.Success ->
            println("Успех: ${result.message}")
        is ModuleResult.ResourceProduced ->
            println("Произведено: ${result.resourceName} + ${result.amount}")
        is ModuleResult.NotEnoungResources ->
            println("Недостаточно ресурса ${result.resourceName}. " + "Нужно ${result.required}, есть ${result.availabele}")
    is ModuleResult.Error ->
        println("Ошибка: ${result.reason}")
    }

}
object SystemLogger {
    init {
        println("SystemLogger инициализирован")
    }
    fun log(message: String){
        println("[LOG] $message")
    }
}
val logger by lazy{
    SystemLogger
}
fun main(){
//    val manager = resourses.ResouceManager()
//    val minerals = resourses.OutpostResource(1,"Minerals",300)
//    val gas = resourses.OutpostResource(2,"Gas",100)
//    manager.add(minerals)
//    manager.add(gas)
//    manager.printAll()
//    val bonus = minerals.copy(amount = minerals.amount + 50)
//    println("Копия минералов с бонусом: $bonus")
    val manager = ResouceManager()
    manager.add(OutpostResource(1, "Minerials", 120))
    manager.add(OutpostResource(2, "Gas", 40))
    val generator = EnergyGenerator()
    val lab = ResearchLab()
    generator.performAction(manager)
    lab.performAction(manager)
    println()
    manager.printAll()
    val generatorResult = generator.performAction(manager)
    val labResult = lab.performAction(manager)
    handleModuleResult(generatorResult)
    handleModuleResult(labResult)
    logger.log("запуск базы")
    val loaderResource = FileStorage.load()
    loaderResource.forEach{manager.add(it) }
    if (loaderResource.isEmpty()) {
        manager.add(OutpostResource(1,"Minerals",300))
        manager.add(OutpostResource(2,"Gas",100))
    }
    FileStorage.save(manager.getAll())
}