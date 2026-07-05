package com.example.Assignment.Assignment3

import com.example.Assignment.Assignment2.RotiService

/**
 * Assignment#3 (2.2) : Item_TestV2
 * - ผู้ใช้สั่งโรตีไปเรื่อย ๆ จนกดออก (9)
 * - ตรวจสอบข้อมูลที่ผู้ใช้ใส่ (กันข้อมูลที่ไม่ใช่ตัวเลข)
 * - แสดงใบเสร็จหลังสั่งแต่ละครั้ง
 */

fun showRotiMenuV2(rotiService: RotiService) {
    println("======== Roti Menu Management ===========")
    for (roti in rotiService.getRotiMenu()) {
        println("${roti.id}) --> ${roti.name}\t\t${roti.price} Baht")
    }
    println("9) Quit")
    println("===========================================")
}

fun printItemReceipt(item: Item) {
    println("============= Receipt ================")
    println(" - ${item.roti.name}\t\t\t${item.roti.price} Baht")
    println("   Amount\t\t\t${item.amount} pieces")
    println("---------------------------------------")
    println("Totol Cost : \t\t\t${item.getCost()} Baht")
    println("---------------------------------------")
}

fun main() {
    val rotiService = RotiService()

    while (true) {
        showRotiMenuV2(rotiService)
        print("Pick what no. you want -> ")
        val input = readLine()!!.trim()
        val choice = input.toIntOrNull()

        // ตรวจสอบว่าผู้ใช้กรอกตัวเลขหรือไม่
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
        val amountInput = readLine()!!.trim()
        val amount = amountInput.toIntOrNull()

        if (amount == null || amount <= 0) {
            println("Invalid amount, please enter a number")
            continue
        }

        val item = Item(selectedRoti, amount)
        printItemReceipt(item)
    }
    println("Process finished with exit code 0")
}
