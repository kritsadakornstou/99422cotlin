package com.example.Assignment.Assignment1

/**
 * Assignment#1 : ทดสอบการทำงานคลาส Roti
 * ผลลัพธ์ที่ควรได้:
 * Roti(id=0, name=Traditional, price=15)
 * Roti(id=2, name=Peanut, price=20)
 */
fun main() {
    var roti1 = Roti(name = "Traditional", price = 15)
    println(roti1)

    var roti2 = Roti(id = 2, name = "Peanut", price = 20)
    println(roti2)
}
