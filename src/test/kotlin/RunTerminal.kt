package org.example

import java.io.File
import net.mamoe.mirai.alsoLogin
import net.mamoe.mirai.console.MiraiConsole
import net.mamoe.mirai.console.plugin.PluginManager.INSTANCE.enable
import net.mamoe.mirai.console.plugin.PluginManager.INSTANCE.load
import net.mamoe.mirai.console.terminal.MiraiConsoleTerminalLoader
import net.mamoe.mirai.console.util.ConsoleExperimentalApi

fun setupWorkingDir() {
    // see: net.mamoe.mirai.console.terminal.MiraiConsoleImplementationTerminal
    System.setProperty("user.dir", File("D:\\dev\\program\\mcl").absolutePath)
}

@ConsoleExperimentalApi
suspend fun main() {
    setupWorkingDir()

    MiraiConsoleTerminalLoader.startAsDaemon()

    val pluginInstance = Plugin.INSTANCE

    pluginInstance.load() // 主动加载插件, Console 会调用 Plugin.onLoad
    pluginInstance.enable() // 主动启用插件, Console 会调用 Plugin.onEnable

    val bot = MiraiConsole.addBot(392290694, "1381932shen").login() // 登录一个测试环境的 Bot

    MiraiConsole.job.join()
}
