package actions

import resourses.ResouceManager

interface ModuleAction {
    fun execute(manager: ResouceManager)
}