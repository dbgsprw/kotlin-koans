// Return the set of products that were ordered by all customers
fun Shop.getProductsOrderedByAll(): Set<Product> {
    val first = customers.first().getOrderedProducts().toSet()

    return customers.subList(1, customers.size).fold(first) { previous, customer ->
        previous.intersect(customer.getOrderedProducts().toSet())
    }
}

fun Customer.getOrderedProducts(): List<Product> =
    orders.flatMap(Order::products)