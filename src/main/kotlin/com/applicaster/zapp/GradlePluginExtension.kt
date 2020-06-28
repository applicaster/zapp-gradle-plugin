package com.applicaster.zapp

import org.gradle.api.ActionConfiguration
import org.gradle.api.Project
import org.gradle.internal.impldep.com.esotericsoftware.minlog.Log

open class GradlePluginExtension(var project: Project) {
    fun mavenOrProject(mavenName: String, mavenVersion: String, projectName: String): Any {
        var proj = project.findProject(projectName);
        if (proj != null) return proj;
        return "$mavenName:$mavenVersion"
    }

//    fun requireDependency(dependency: String, projectName: String): Unit = project.run {
//            if (findProject(projectName) != null) {
//                println("Using " + dependency + " from local project " + projectName)
//                project.dependencies.add("implementation", project(projectName))
//            } else {
//                println("Using " + dependency + " from maven")
//                project.dependencies.add("implementation", dependency)
//            }
//    }
//
//    fun addDependency(configurationName: String, mavenName: String, mavenVersion: String, projectName: String): Unit = project.run {
//        if (findProject(projectName) != null) {
//            Log.info("Using " + mavenName + " from local project " + projectName)
//            project.dependencies.add(configurationName, project(projectName))
//        } else {
//            Log.info("Using " + mavenName + " from maven with version " + mavenVersion)
//            project.dependencies.add(configurationName, mavenName + ":" + mavenVersion)
//        }
//    }
}
