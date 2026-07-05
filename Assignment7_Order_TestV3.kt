package com.example.Assignment.Assignment7

import com.example.Assignment.Assignment2.RotiService
import com.example.Assignment.Assignment3.Item
import com.example.Assignment.Assignment5.Order
import java.time.LocalDate

/**
 * Assignment#7 : Order_TestV3
 * ผลลัพธ์เหมือน Order_TestV2 แต่จัดโครงสร้างแบบ MVC
 * - Model      -> RotiService
 * - View       -> OrderView
 * - Controller -> OrderController
 */

// ===================== VIEW =====================
class OrderView {

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

    fun askMainChoice(): String {
        print("Pick menu no. you want -> ")
        return readLine()!!.trim()
    }

    fun askCustomerName(): String {
        print("Write your name -> ")
        return readLine()!!.trim()
    }

    fun askRotiChoice(): String {
        print("Pick what no. you want -> ")
        return readLine()!!.trim()
    }

    fun askAmount(rotiName: String): String {
        print("How many pieces of $rotiName do you want -> ")
        return readLine()!!.trim()
    }

    fun showReceipt(order: Order) {
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

    fun showError(message: String) {
        println(message)
    }
}

// ===================== CONTROLLER =====================
class OrderController(
    private val rotiService: RotiService,   // Model
    private val view: OrderView             // View
) {
    fun run() {
        while (true) {
            view.showOrderMenu()
            val choice = view.askMainChoice().toIntOrNull()

            when (choice) {
                1 -> {
                    val order = createOrder()
                    view.showReceipt(order)
                }
                9 -> return
                else -> view.showError("Invalid choice, please try again")
            }
        }
    }

    private fun createOrder(): Order {
        val order = Order()
        order.id = ++Order.count
        order.customer = view.askCustomerName()
        order.date = LocalDate.now()

        while (true) {
            view.showRotiMenu(rotiService)
            val choice = view.askRotiChoice().toIntOrNull()

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

            order.items.add(Item(selectedRoti, amount))
        }
        return order
    }
}

fun main() {
    val rotiService = RotiService()                        // Model
    val view = OrderView()                                 // View
    val controller = OrderController(rotiService, view)    // Controller
    controller.run()
}
