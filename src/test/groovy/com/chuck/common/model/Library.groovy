class Library {

    def name
    def loanStock = [:]//book.catalogNumber=book
    def borrowers = [:]

    // def addBook = {
    //     book->loanStock[book.catalogNumber] = book
    // }
    def addBook(bk) {
        loanStock[bk.catalogNumber] = bk
    }

    def registerBorrower(borrower) {
        borrowers[borrower.membershipNumber] = borrower
    }

    def lendBook(catalogNumber, membershipNumber) {
        def loanStockEntry = loanStock.find { entry->entry.key == catalogNumber }
        def borrowersEntry = borrowers.find { entry-> entry.key == membershipNumber }
        borrowersEntry.value.attachBook(loanStockEntry.value)
    }
    def returnBook(catalogNumber) {
        def loanStockEntry = loanStock.find { entry->entry.key == catalogNumber }
        def bor = loanStockEntry.value.borrower
        bor.detachBook(loanStockEntry.value)
    }

}
