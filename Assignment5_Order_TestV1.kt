package com.example.Assignment.Assignment5

import com.example.Assignment.Assignment2.RotiService
import com.example.Assignment.Assignment3.Item
import java.time.LocalDate

/**
 * Assignment#5 (2.1) : Order_TestV1
 * กำหนดให้ 1 คำสั่งซื้อ (Order) มีหลายรายการ (Item)
 */
fun main() {
    val rotiservice: RotiService = RotiService()
    rotiservice.showRotiMenu()

    var order1: Order = Order()
    order1.id = ++Order.count          // เริ่มนับจาก 1
    order1.customer = "Urai"
    order1.date = LocalDate.now()

    var mychoice = rotiservice.getRotiById(2)
    var item: Item = Item(mychoice!!, 3)
    order1.items.add(item)

    mychoice = rotiservice.getRotiById(3)
    item = Item(mychoice!!, 2)
    order1.items.add(item)

    println(order1)
}
