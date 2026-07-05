package com.example.Assignment.Assignment2

/**
 * Assignment#2 : ทดสอบการทำงานคลาส RotiService
 */
fun main() {
    var rotiservice = RotiService()
    rotiservice.showRotiMenu()
    println("List of Menu : ${rotiservice.getRotiMenu()}")
    println("Menu size : ${rotiservice.getRotiMenuSize()}")
    println("Roti Menu #2 : ${rotiservice.getRotiById(2)}")
}
