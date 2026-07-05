package com.example.Assignment.Assignment8

import com.example.Assignment.Assignment2.RotiService
import com.example.Assignment.Assignment3.Item
import com.example.Assignment.Assignment5.Order
import java.time.LocalDate

/**
 * Assignment#8 (2.1) : OrderService_TestV1
 * สร้างข้อมูล order สมมติ 2 รายการ แล้วให้ OrderService แสดงรายละเอียดและรายได้รวม
 */
fun main() {
    val rotiService = RotiService()
    val orderService = OrderService()

    // Order 1: Sukjai
    val order1 = Order()
    order1.id = ++Order.count
    order1.customer = "Sukjai"
    order1.date = LocalDate.now()
    order1.items.add(Item(rotiService.getRotiById(1)!!, 3))    // Regular x3
    order1.items.add(Item(rotiService.getRotiById(2)!!, 10))   // Egg x10
    orderService.add(order1)

    // Order 2: Kinjung
    val order2 = Order()
    order2.id = ++Order.count
    order2.customer = "Kinjung"
    order2.date = LocalDate.now()
    order2.items.add(Item(rotiService.getRotiById(2)!!, 5))    // Egg x5
    order2.items.add(Item(rotiService.getRotiById(3)!!, 9))    // Banana x9
    order2.items.add(Item(rotiService.getRotiById(1)!!, 20))   // Regular x20
    orderService.add(order2)

    orderService.showAllOrders()
}
