
// package services;

// import static org.junit.jupiter.api.Assertions.assertTrue;

// import java.util.List;

// import javax.persistence.EntityManager;
// import javax.persistence.EntityManagerFactory;
// import javax.persistence.Persistence;

// import com.chuck.common.model.Employee;
// import com.chuck.common.services.impl.EmployeeServiceImpl;

// import org.junit.Ignore;
// import org.junit.jupiter.api.Test;

// /**
// * @author Chuck
// * @since 1/1/2021
// * @version
// *
// **/
// public class EmployeeService {

// @Ignore
// @Test
// public void serviceTest() {
// // EntityManagerFactory emf =
// Persistence.createEntityManagerFactory("EmployServiceImpl");
// // EntityManager em = emf.createEntityManager();
// EmployeeServiceImpl service = new EmployeeServiceImpl();
// EntityManager em = service.getEm();

// em.getTransaction().begin();
// Employee e = service.createEmployee(158, "Joe Doe", 45000);
// em.getTransaction().commit();
// System.out.format("persisted :%s\n", e);

// e = service.findEmployee(158);
// System.out.format("found :%s\n", e);

// List<Employee> es = service.findAllEmployees();
// for (Employee employee : es) {
// System.out.format("found employee:%s \n", employee);
// }

// em.getTransaction().begin();
// e = service.raiseEmployeeSalary(158, 1000);
// System.out.format("updated employee:%s \n", e);
// em.getTransaction().commit();

// em.getTransaction().begin();

// assertTrue(service.removeEmployee(158));

// em.getTransaction().commit();
// System.out.format("removed employee 158\n");

// em.close();
// // emf.close();
// }
// }
