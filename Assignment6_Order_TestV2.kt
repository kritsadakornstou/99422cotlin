package com.example.Assignment.Assignment6

import com.example.Assignment.Assignment2.RotiService
import com.example.Assignment.Assignment3.Item
import com.example.Assignment.Assignment5.Order
import java.time.LocalDate

/**
 * Assignment#6 (2.2) : Order_TestV2
 * ปรับปรุงจาก Item_TestV2 ให้รวมหลาย Item เป็น 1 Order
 * - รับข้อมูลการสั่งโรตีจากผู้ใช้ไปเรื่อย ๆ ในออเดอร์เดียว
 * - แสดงใบเสร็จจ่ายเงินเมื่อจบออเดอร์
 */

fun showOrderMenu() {
    println("======== Order Menu Management ===========")
    println("1) Order")
    println("9) Quit")
    println("=============================================")
}

fun showRotiMenu(rotiService: RotiService) {
    println("======== Roti Menu Management ===========")
    for (roti in rotiService.getRotiMenu()) {
        println("${roti.id}) --> ${roti.name}\t\t${roti.price} Baht")
    }
    println("9) Quit")
    println("===========================================")
}

fun printOrderReceipt(order: Order) {
    println("============= Receipt ================")
    println("Order No : ${order.id}")
    println("Customer Name : ${order.customer}")
    println("Order Date : ${order.date}")
    println("Items : ")
    for (item in order.items) {
        println("  + ${item.roti.name}(${item.roti.price}*${item.amount})\t\t${item.getCost()} Baht")
    }
    println("---------------------------------------")
    println("Total Cost : ${order.getCost()} Baht")
    println("---------------------------------------")
}

fun createOrder(rotiService: RotiService): Order {
    val order = Order()
    order.id = ++Order.count
    print("Write your name -> ")
    order.customer = readLine()!!.trim()
    order.date = LocalDate.now()

    while (true) {
        showRotiMenu(rotiService)
        print("Pick what no. you want -> ")
        val choice = readLine()!!.trim().toIntOrNull()

        if (choice == null) {
            println("Invalid input, please enter a number")
            continue
        }
        if (choice == 9) break

        val selectedRoti = rotiService.getRotiById(choice)
        if (selectedRoti == null) {
            println("Menu not found, please try again")
            continue
        }

        print("How many pieces of ${selectedRoti.name} do you want -> ")
        val amount = readLine()!!.trim().toIntOrNull()
        if (amount == null || amount <= 0) {
            println("Invalid amount, please enter a number")
            continue
        }

        order.items.add(Item(selectedRoti, amount))
    }
    return order
}

fun main() {
    val rotiService = RotiService()

    while (true) {
        showOrderMenu()
        print("Pick menu no. you want -> ")
        val choice = readLine()!!.trim().toIntOrNull()

        when (choice) {
            1 -> {
                val order = createOrder(rotiService)
                printOrderReceipt(order)
            }
            9 -> return
            else -> println("Invalid choice, please try again")
        }
    }
}
