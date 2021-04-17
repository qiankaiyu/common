import console.*

class Action {

    def addBook() {
        println 'Enter book catalog number...'
        def catalogNumber = Console.readLine()
        println 'Enter book title...'
        def title = Console.readLine()
        println 'Enter book author...'
        def author = Console.readLine()
        def book = new Book(catalogNumber, title, author)
        lib.addBook(book)
    }
    // def displayStock = {
    //     println "Library:${name}"
    //     println '====='
    //     loanStock.each { catalogNumber, book->println "$book" }
    // }
    def displayStock() {
        println "Library:${lib.name}"
        println '====='
        lib.loanStock.each { catalogNumber, book->println "$book" }
    }
    def displayBooksAvailableForLoan() {
        println "\n \n Library:${lib.name}:Available for loan "
        println '====='
        lib.loanStock.each { catalogNumber, book->if (book.borrower == null) println "${book}" }
    }

    def displayBooksOnLoan() {
        println "\n \n Library:${lib.name}:On loan "
        println '====='
        lib.loanStock.each { catalogNumber, book->if (book.borrower != null)println "${book }" }
    }
    def displayBorrowers() {
        println "\n \n Library:${lib.name}:Borrower details "
        println '====='
        lib.borrowers.each {
            membershipNumber, borrower->println borrower; borrower.borrowedBooks.each { catalogNumber, book->println "  ${book }" }
        }
    }

    def registerBorrower() {
        println 'Enter borrower membership number...'
        def membershipNumber = Console.readLine()
        println 'Enter borrower name...'
        def name = Console.readLine()

        def bor = new Borrower(membershipNumber, name)
        lib.registerBorrower(bor)
    }

    def lendBook() {
        println 'Enter book catalog number...'
        def catalogNumber = Console.readLine()
        println 'Enter borrower membereship number...'
        def membershipNumber = Console.readLine()
        lib.lendBook(catalogNumber, membershipNumber)
    }

    def returnBook() {
        println 'Enter book catalog number..'
        def catalogNumber = Console.readLine()
        lib.returnBook(catalogNumber)
    }

    def readMenuSelection() {
        println ''
        println '0:Quit'
        println '1:Add new book'
        println '2:Display stock'
        println '3:Display books available for loan'
        println '4:Display books on loan'
        println '5:Register new borrower'
        println '6:Display borrowers'
        println '7:Lend a book'
        println '8:Return a book'
        Console.readString()
    }

    def lib

}
