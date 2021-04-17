class Borrower {

    def membershipNumber
    def name
    def borrowedBooks = [:]

    // def attachBook = {
    //     borrowedBooks["${it.catalogNumber}"] = "${it}"
    //     "$it.attachBorrower()"
    // }
    def attachBook(bk) {
        borrowedBooks[bk.catalogNumber] = bk
        bk.attachBorrower(this)
    }
    // def detachBook = {
    //     borrowedBooks.remove($it.catalogNumber)
    //     $it.detachBorrower()
    // }
    def detachBook(bk) {
        borrowedBooks.remove(bk.catalogNumber)
        bk.detachBorrower()
    }

    String toString() {
        "Borrower:${membershipNumber};${name}"
    }

}
