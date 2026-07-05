package com.example.Assignment.Assignment2

import com.example.Assignment.Assignment1.Roti

/**
 * Assignment#2 : คลาส RotiService
 * service class ที่เก็บ "เล่มเมนูโรตี" และให้บริการจัดการเมนูโรตี
 */
class RotiService {

    // Attribute : เล่มเมนู Roti (ตั้งค่าเริ่มต้นไว้ 3 รายการตามตัวอย่างในเอกสาร)
    private val rotiMenu: ArrayList<Roti> = arrayListOf(
        Roti(1, "Regular", 10),
        Roti(2, "Egg", 15),
        Roti(3, "Banana", 20)
    )

    /** เพิ่มเมนูโรตีใหม่เข้าไปในเล่มเมนู */
    fun add(roti: Roti) {
        rotiMenu.add(roti)
    }

    /** คืนค่าเล่มเมนูโรตีทั้งหมด */
    fun getRotiMenu(): ArrayList<Roti> {
        return rotiMenu
    }

    /** คืนค่าจำนวนเมนูโรตีทั้งหมด */
    fun getRotiMenuSize(): Int {
        return rotiMenu.size
    }

    /** ค้นหาโรตีจาก id ถ้าไม่พบจะคืนค่า null */
    fun getRotiById(id: Int): Roti? {
        return rotiMenu.find { it.id == id }
    }

    /** แสดงเมนูโรตีทั้งหมดในรูปแบบ Text UI */
    fun showRotiMenu() {
        println("============= Roti Menu ===============")
        for (roti in rotiMenu) {
            println("${roti.id}) -> ${roti.name}\t-- ${roti.price} Baht")
        }
        println("=========================================")
    }

    /** alias ของ showRotiMenu() ตามที่โจทย์ระบุ method show() */
    fun show() {
        showRotiMenu()
    }
}
