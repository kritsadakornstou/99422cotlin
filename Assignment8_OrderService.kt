package com.example.Assignment.Assignment8

import com.example.Assignment.Assignment5.Order

/**
 * Assignment#8 : คลาส OrderService
 * service class ที่รวบรวมคำสั่งซื้อ (Order) ทั้งหมด และให้บริการคำนวณ/แสดงรายงาน
 */
class OrderService {

    // Attribute : ที่รวม Order ทั้งหมด
    private val orderList: ArrayList<Order> = ArrayList()

    /** เพิ่ม order เข้าไปในรายการ */
    fun add(order: Order) {
        orderList.add(order)
    }

    /** คืนค่ารายการ order ทั้งหมด */
    fun getOrderToList(): ArrayList<Order> {
        return orderList
    }

    /** คำนวณรายได้รวมจากทุก order */
    fun getCost(): Int {
        return orderList.sumOf { it.getCost() }
    }

    /**
     * แสดงรายละเอียดของทุก order พร้อมยอดรวมแต่ละ order
     * และแสดงรายได้รวมทั้งหมดในตอนท้าย
     */
    fun showAllOrders() {
        for (order in orderList) {
            println("Order id : ${order.id}")
            println("Order name : ${order.customer}")
            println("Order date : ${order.date}")

            val totalPieces = order.items.sumOf { it.amount }
            println("Order total pieces : $totalPieces pieces")

            // จัดกลุ่มรายการตามชื่อโรตี เผื่อสั่งเมนูเดียวกันหลายครั้งใน order เดียว
            val groupedItems = order.items.groupBy { it.roti.name }
            for ((name, itemsOfName) in groupedItems) {
                val amount = itemsOfName.sumOf { it.amount }
                val price = itemsOfName.first().roti.price
                val cost = price * amount
                println("  + $name ($price*$amount)\t\t$cost Baht")
            }

            println("Order Total Cost : ${order.getCost()} Baht")
            println("-----------------------------------------")
        }
        println("All Order Total Cost : ${getCost()}")
        println("-----------------------------------------")
    }
}
