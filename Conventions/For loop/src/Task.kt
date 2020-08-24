class DateRange(val start: MyDate, val end: MyDate) : Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> =
        object : Iterator<MyDate> {
            var current: MyDate = start

            override fun hasNext(): Boolean {
                return current <= end
            }

            override fun next(): MyDate {
                if (!hasNext()) throw NoSuchElementException()
                val current = this.current
                this.current = current.followingDate()
                return current
            }
        }
}

fun iterateOverDateRange(firstDate: MyDate, secondDate: MyDate, handler: (MyDate) -> Unit) {
    for (date in firstDate..secondDate) {
        handler(date)
    }
}