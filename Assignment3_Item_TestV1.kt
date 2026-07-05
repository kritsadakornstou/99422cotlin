package com.example.Assignment.Assignment3

import com.example.Assignment.Assignment2.RotiService

/**
 * Assignment#3 (2.1) : Item_TestV1
 * - แสดงเมนูโรตี
 * - ผู้ใช้เลือกหมายเลขเมนูและจำนวนชิ้น
 * - แสดงเงินที่ต้องจ่าย
 */
fun main() {
    val rotiService = RotiService()
    rotiService.showRotiMenu()

    print("Pick what no. you want (1 - ${rotiService.getRotiMenuSize()}) -> ")
    val choice = readLine()!!.trim().toInt()
    val selectedRoti = rotiService.getRotiById(choice)

    if (selectedRoti != null) {
        print("How many pieces of ${selectedRoti.name} do you want -> ")
        val amount = readLine()!!.trim().toInt()

        val item = Item(selectedRoti, amount)

        println("Your order : ${selectedRoti.name} (${selectedRoti.price} Bath)")
        println("Amount : $amount Pieces")
        println("Total Cost : (${selectedRoti.price}*$amount)\t= ${item.getCost()} Baht")
    } else {
        println("Menu not found")
    }
}
