package com.example.Assignment.Assignment8

import com.example.Assignment.Assignment2.RotiService
import com.example.Assignment.Assignment3.Item
import com.example.Assignment.Assignment5.Order
import java.time.LocalDate

/**
 * Assignment#8 (2.2) : OrderService_TestV2
 * ผู้ใช้สามารถกรอกข้อมูลสั่งซื้อได้เอง ได้ผลลัพธ์เช่นเดียวกับ OrderService_TestV1
 * ใช้รูปแบบ MVC:
 * - Model      -> RotiService, OrderService
 * - View       -> OrderServiceView
 * - Controller -> OrderServiceController
 */

// ===================== VIEW =====================
class OrderServiceView {

    fun showMainMenu() {
        println("======== Order Menu Management ===========")
        println("1) Order")
        println("2) Show All Orders")
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

    fun showMessage(message: String) {
        println(message)
    }
}

// ===================== CONTROLLER =====================
class OrderServiceController(
    private val rotiService: RotiService,     // Model
    private val orderService: OrderService,   // Model
    private val view: OrderServiceView        // View
) {
    fun run() {
        while (true) {
            view.showMainMenu()
            val choice = view.askMainChoice().toIntOrNull()

            when (choice) {
                1 -> {
                    val order = createOrder()
                    orderService.add(order)
                    view.showMessage("Order saved successfully!")
                }
                2 -> orderService.showAllOrders()
                9 -> return
                else -> view.showMessage("Invalid choice, please try again")
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
                view.showMessage("Invalid input, please enter a number")
                continue
            }
            if (choice == 9) break

            val selectedRoti = rotiService.getRotiById(choice)
            if (selectedRoti == null) {
                view.showMessage("Menu not found, please try again")
                continue
            }

            val amount = view.askAmount(selectedRoti.name).toIntOrNull()
            if (amount == null || amount <= 0) {
                view.showMessage("Invalid amount, please enter a number")
                continue
            }

            order.items.add(Item(selectedRoti, amount))
        }
        return order
    }
}

fun main() {
    val rotiService = RotiService()               // Model
    val orderService = OrderService()             // Model
    val view = OrderServiceView()                 // View
    val controller = OrderServiceController(rotiService, orderService, view)  // Controller
    controller.run()
}
