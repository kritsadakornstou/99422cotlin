package com.example.Assignment.Assignment4

import com.example.Assignment.Assignment1.Roti
import com.example.Assignment.Assignment2.RotiService
import com.example.Assignment.Assignment3.Item

/**
 * Assignment#4 : Item_TestV3
 * ผลลัพธ์เหมือน Item_TestV2 แต่จัดโครงสร้างแบบ MVC
 * - Model    -> RotiService (นำเข้าจาก Assignment2)
 * - View     -> ItemView       (แสดงผล / รับ input)
 * - Controller -> ItemController (ควบคุมการทำงาน ประสาน View กับ Model)
 */

// ===================== VIEW =====================
class ItemView {

    fun showMenu(rotiMenu: List<Roti>) {
        println("======== Roti Menu Management ===========")
        for (roti in rotiMenu) {
            println("${roti.id}) --> ${roti.name}\t\t${roti.price} Baht")
        }
        println("9) Quit")
        println("===========================================")
    }

    fun askChoice(): String {
        print("Pick what no. you want -> ")
        return readLine()!!.trim()
    }

    fun askAmount(rotiName: String): String {
        print("How many pieces of $rotiName do you want -> ")
        return readLine()!!.trim()
    }

    fun showReceipt(item: Item) {
        println("============= Receipt ================")
        println(" - ${item.roti.name}\t\t\t${item.roti.price} Baht")
        println("   Amount\t\t\t${item.amount} pieces")
        println("---------------------------------------")
        println("Totol Cost : \t\t\t${item.getCost()} Baht")
        println("---------------------------------------")
    }

    fun showError(message: String) {
        println(message)
    }
}

// ===================== CONTROLLER =====================
class ItemController(
    private val rotiService: RotiService,   // Model
    private val view: ItemView              // View
) {
    fun run() {
        while (true) {
            view.showMenu(rotiService.getRotiMenu())
            val choice = view.askChoice().toIntOrNull()

            if (choice == null) {
                view.showError("Invalid input, please enter a number")
                continue
            }
            if (choice == 9) break

            val selectedRoti = rotiService.getRotiById(choice)
            if (selectedRoti == null) {
                view.showError("Menu not found, please try again")
                continue
            }

            val amount = view.askAmount(selectedRoti.name).toIntOrNull()
            if (amount == null || amount <= 0) {
                view.showError("Invalid amount, please enter a number")
                continue
            }

            val item = Item(selectedRoti, amount)
            view.showReceipt(item)
        }
    }
}

fun main() {
    val rotiService = RotiService()                       // Model
    val view = ItemView()                                 // View
    val controller = ItemController(rotiService, view)    // Controller
    controller.run()
    println("Process finished with exit code 0")
}
