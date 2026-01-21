package modules

import resourses.ResouceManager
import javax.print.attribute.standard.JobStateReason

sealed class ModuleResult {
    data class  Success(val message: String) : ModuleResult()
    data class ResourceProduced(
        val resourceName: String,val amount: Int
    ) : ModuleResult()
    data class  NotEnoungResources(
        val resourceName: String,
        val required: Int,
        val availabele: Int
    ) : ModuleResult()
    data class  Error(val reason: String) : ModuleResult()
}