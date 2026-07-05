package com.example.Assignment.Assignment5

import com.example.Assignment.Assignment3.Item
import java.time.LocalDate

/**
 * Assignment#5 : คลาส Order
 * data class ที่แทน "คำสั่งซื้อ" 1 ครั้ง ซึ่งภายในมีได้หลายรายการ (Item)
 */
data class Order(
    var id: Int = 0,
    var items: ArrayList<Item> = ArrayList(),
    var customer: String = "",
    var date: LocalDate = LocalDate.now()
) {
    companion object {
        // ตัวนับกลาง ใช้สำหรับกำหนดเลข id ของ order ให้ไม่ซ้ำกัน
        var count = 0
    }

    /** คำนวณค่าใช้จ่ายรวมของ order นี้ (รวมทุกรายการใน items) */
    fun getCost(): Int {
        return items.sumOf { it.getCost() }
    }
}
