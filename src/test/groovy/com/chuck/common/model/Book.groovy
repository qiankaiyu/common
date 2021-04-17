class Book {

    def catalogNumber
    def title
    def author
    def borrower = null

    String toString() {
        "Book: ${catalogNumber}:${title} by:${author}"
    }
    def attachBorrower(borrower) {
        this.borrower = borrower
    }
    def detachBorrower() {
        borrower = null
    }

}
