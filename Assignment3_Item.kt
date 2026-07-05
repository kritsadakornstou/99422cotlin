package com.example.Assignment.Assignment3

import com.example.Assignment.Assignment1.Roti

/**
 * Assignment#3 : คลาส Item
 * data class ที่แทน "รายการสั่งซื้อ" 1 รายการ (โรตี 1 ชนิด + จำนวนที่สั่ง)
 */
data class Item(
    val roti: Roti,
    val amount: Int
) {
    /** คำนวณค่าใช้จ่ายของรายการนี้ = ราคาต่อชิ้น x จำนวน */
    fun getCost(): Int {
        return roti.price * amount
    }
}
