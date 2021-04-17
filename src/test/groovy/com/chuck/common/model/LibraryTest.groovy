// import java.io.Console

// class Action {

//     def addBook() {
//         println 'Enter book catalog number...'
//         def catalogNumber = System.console().readLine()
//         println 'Enter book title...'
//         def title = System.console().readLine()
//         println 'Enter book author...'
//         def author = System.console().readLine()
//         def book = new Book(catalogNumber:catalogNumber, title:title, author:author)
//         lib.addBook(book)
//     }
//     // def displayStock = {
//     //     println "Library:${name}"
//     //     println '====='
//     //     loanStock.each { catalogNumber, book->println "$book" }
//     // }
//     def displayStock() {
//         println "Library:${lib.name}"
//         println '====='
//         lib.loanStock.each { catalogNumber, book->println "$book" }
//     }
//     def displayBooksAvailableForLoan() {
//         println "\n \n Library:${lib.name}:Available for loan "
//         println '====='
//         lib.loanStock.each { catalogNumber, book->if (book.borrower == null) println "${book}" }
//     }

//     def displayBooksOnLoan() {
//         println "\n \n Library:${lib.name}:On loan "
//         println '====='
//         lib.loanStock.each { catalogNumber, book->if (book.borrower != null)println "${book }" }
//     }
//     def displayBorrowers() {
//         println "\n \n Library:${lib.name}:Borrower details "
//         println '====='
//         lib.borrowers.each {
//             membershipNumber, borrower->println borrower; borrower.borrowedBooks.each { catalogNumber, book->println "  ${book }" }
//         }
//     }

//     def registerBorrower() {
//         println 'Enter borrower membership number...'
//         def membershipNumber = System.console().readLine()
//         println 'Enter borrower name...'
//         def name = System.console().readLine()

//         def bor = new Borrower(membershipNumber:membershipNumber, name:name)
//         lib.registerBorrower(bor)
//     }

//     def lendBook() {
//         println 'Enter book catalog number...'
//         def catalogNumber = System.console().readLine()
//         println 'Enter borrower membereship number...'
//         def membershipNumber = System.console().readLine()
//         lib.lendBook(catalogNumber, membershipNumber)
//     }

//     def returnBook() {
//         println 'Enter book catalog number..'
//         def catalogNumber = System.console().readLine()
//         lib.returnBook(catalogNumber)
//     }

//     def lib

// }
// class Library {

//     def name
//     def loanStock = [:]//book.catalogNumber=book
//     def borrowers = [:]

//     // def addBook = {
//     //     book->loanStock[book.catalogNumber] = book
//     // }
//     def addBook(bk) {
//         loanStock[bk.catalogNumber] = bk
//     }

//     def registerBorrower(borrower) {
//         borrowers[borrower.membershipNumber] = borrower
//     }

//     def lendBook(catalogNumber, membershipNumber) {
//         def loanStockEntry = loanStock.find { entry->entry.key == catalogNumber }
//         def borrowersEntry = borrowers.find { entry-> entry.key == membershipNumber }
//         borrowersEntry.value.attachBook(loanStockEntry.value)
//     }
//     def returnBook(catalogNumber) {
//         def loanStockEntry = loanStock.find { entry->entry.key == catalogNumber }
//         def bor = loanStockEntry.value.borrower
//         bor.detachBook(loanStockEntry.value)
//     }

// }

// class Book {

//     def catalogNumber
//     def title
//     def author
//     def borrower = null

//     String toString() {
//         "Book:${catalogNumber} :${title} by:${author}"
//     }
//     def attachBorrower(borrower) {
//         this.borrower = borrower
//     }
//     def detachBorrower() {
//         borrower = null
//     }

// }
// class Borrower {

//     def membershipNumber
//     def name
//     def borrowedBooks = [:]

//     // def attachBook = {
//     //     borrowedBooks["${it.catalogNumber}"] = "${it}"
//     //     "$it.attachBorrower()"
//     // }
//     def attachBook(bk) {
//         borrowedBooks[bk.catalogNumber] = bk
//         bk.attachBorrower(this)
//     }
//     // def detachBook = {
//     //     borrowedBooks.remove($it.catalogNumber)
//     //     $it.detachBorrower()
//     // }
//     def detachBook(bk) {
//         borrowedBooks.remove(bk.catalogNumber)
//         bk.detachBorrower()
//     }

//     String toString() {
//         "Borrower:${membershipNumber};${name}"
//     }

// }

// def readMenuSelection() {
//     println ''
//     println '0:Quit'
//     println '1:Add new book'
//     println '2:Display stock'
//     println '3:Display books available for loan'
//     println '4:Display books on loan'
//     println '5:Register new borrower'
//     println '6:Display borrowers'
//     println '7:Lend a book'
//     println '8:Return a book'
//     System.console().readLine('')
// }

// def action = new Action(lib:new Library(name:'Dunning'))

// def choice = readMenuSelection()

// while (choice != '0') {
//     switch (choice) {
//         case '1':
//             action.addBook()
//             break
//         case '2':
//             action.displayStock()
//             break
//         case '3':
//             action.displayBooksAvailableForLoan()
//             break
//         case '4':
//             action.displayBooksOnLoan()
//             break
//         case '5':
//             action.registerBorrower()
//             break
//         case '6':
//             action.displayBorrowers()
//             break
//         case '7':
//             action.lendBook()
//             break
//         case '8':
//             action.returnBook()
//             break
//         default:
//             println 'Unknown Selection'
//     }
//     choice = readMenuSelection()
// }
// println 'System closing'
