
// package services;

// import java.util.HashSet;
// import java.util.Set;

// import com.chuck.common.domain.Book;
// import com.chuck.common.domain.BookCategory;
// import com.chuck.common.repository.BookCategoryRepository;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.transaction.annotation.Transactional;

// // @RunWith(SpringRunner.class)
// // @SpringBootTest
// public class Writecommon {
// @Autowired
// private BookCategoryRepository bookCategoryRepository;

// // @Test
// public void saveTest() {
// BookCategory categoryA = new BookCategory("Category A");
// Set bookAs = new HashSet<Book>() {
// {
// add(new Book("Book A1", categoryA));
// add(new Book("Book A2", categoryA));
// add(new Book("Book A3", categoryA));
// }
// };
// categoryA.setBooks(bookAs);

// BookCategory categoryB = new BookCategory("Category B");
// Set bookBs = new HashSet<Book>() {
// {
// add(new Book("Book B1", categoryB));
// add(new Book("Book B2", categoryB));
// add(new Book("Book B3", categoryB));
// }
// };
// categoryB.setBooks(bookBs);

// // bookCategoryRepository.saveAll(new HashSet<BookCategory>()
// // {
// // {
// // add(categoryA);
// // add(categoryB);
// // }
// // });
// }

// // @Test
// @Transactional
// public void testQuery() {
// // fetch all categories
// // for (BookCategory bookCategory : bookCategoryRepository.findAll())
// // {
// // System.out.println(bookCategory.toString());
// // }
// }
// }
