package com.example.Assignment.Assignment1

/**
 * Assignment#1 : คลาส Roti
 * data class สำหรับเก็บข้อมูลโรตี 1 เมนู
 * เนื่องจากเป็น data class โค้ตลินจะสร้าง method ที่จำเป็นให้อัตโนมัติ
 * เช่น toString(), equals(), hashCode(), copy()
 */
data class Roti(
    val id: Int = 0,
    val name: String = "",
    val price: Int = 0
)
