package com.applicaster.zapp

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaBasePlugin

class GradlePlugin : Plugin<Project> {
    val ZAPP_INFO_TASK_NAME = "zappInfo"
    val EXTENSION_NAME = "zapp"

    override fun apply(project: Project): Unit = project.run {
        val pluginExtension = extensions.create(EXTENSION_NAME, GradlePluginExtension::class.java, project)

        tasks.create(ZAPP_INFO_TASK_NAME, ZappInfoGradleTask::class.java)
    }
}
