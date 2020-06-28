package com.applicaster.zapp

import org.gradle.testkit.runner.BuildResult
import org.gradle.testkit.runner.GradleRunner
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import java.io.File
import java.nio.file.Files
import java.nio.file.Path
import kotlin.test.assertEquals
import kotlin.test.assertNull

object GradlePluginFunctionalTest : Spek({
    describe("ZappPlugin") {
        fun execute(projectDir: File, vararg arguments: String): BuildResult {
            return GradleRunner.create()
                    .withProjectDir(projectDir)
                    .withArguments(arguments.toList())
                    .withPluginClasspath()
                    .build()
        }

        context("with plugin applied") {
            val testProjectDir: Path = Files.createTempDirectory("zapp_plugin_test")
            val buildFile = Files.createFile(testProjectDir.resolve("build.gradle")).toFile()

            buildFile.writeText("""
                plugins {
                    id 'com.applicaster.zapp'
                }

                task assertZappDependencyOrProject {
                   doLast {
                       zapp.mavenOrProject("com.applicaster:ExampleDependency", "1.0.0", "example-dependency")
                   }
               }
            """.trimIndent())

            it("provides zappInfo task") {
                val buildResult = execute(testProjectDir.toFile(), "tasks", "--all")
                assert(buildResult.output.contains("zappInfo - "))
            }

            it("provides access to zapp.mavenOrProject util") {
               // Executing this task should not fail
               execute(testProjectDir.toFile(), "assertZappDependencyOrProject", "--stacktrace")
           }
        }
    }
})
