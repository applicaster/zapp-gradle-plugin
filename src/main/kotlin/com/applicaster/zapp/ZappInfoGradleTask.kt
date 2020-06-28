package com.applicaster.zapp

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.CacheableTask
import org.gradle.api.tasks.TaskAction
import org.gradle.workers.WorkerExecutor
import javax.inject.Inject

@CacheableTask
open class ZappInfoGradleTask() : DefaultTask() {
    init {
        group = "Zapp"
        description = "Print information about the project"
    }

    @TaskAction
    fun printInfo() {
        println("======== Zapp Info =========")
        println("No info yet... \uD83D\uDE05")
        println("============================")
    }
}