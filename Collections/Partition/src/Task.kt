// Return customers who have more undelivered orders than delivered
fun Shop.getCustomersWithMoreUndeliveredOrders(): Set<Customer> =
    customers.filter {
        val pair = it.orders.partition(Order::isDelivered)
        pair.first.size < pair.second.size
    }.toSet()
