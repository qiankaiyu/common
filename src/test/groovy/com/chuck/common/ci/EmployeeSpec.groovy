// package com.chuck.common.ci

// import com.chuck.common.vo.EmployeeVO
// import org.springframework.beans.factory.annotation.Autowired
// import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
// import org.springframework.boot.test.context.SpringBootTest
// import org.springframework.test.web.servlet.MockMvc
// import spock.lang.*


// /**
// * @author Chuck,
// * @since 4.10
// * @version 0.0.1
// *,
// **/
// @SpringBootTest
// @AutoConfigureMockMvc
// class EmployeeSpec extends Specification {

//     @Autowired
//     private MockMvc mockMvc;

//     def "Test Restful List Employees "() {
//     when:
//         def result = mockMvc.perform(MockMvcRequestBuilders.get('/employee/employees'))
//     then:
//         result.andExpect(status().isOk())
//     // result.andExpect(content().string(containsString(lastName)))
//     where:
//         title           | _
//         'chuck'      | _
//         'Chuck'     | _
//     }

//     def "Test Create Employee"() {
//         given:
//         def employee = new EmployeeVo()
//         when:
//         def result = mockMvc.perform(MockMvcRequestBuilders.post('/employee/save', employee))
//         then:
//         result.andExpect(status().isOk())
//     // .andExpect(content().string())
//     }

//     // mock&stub
//     // @Resource
//     // EmployeeService employeeService

//     // def "Test Stub"(){
//     //     void setUp() {
//     //         Mockito.when(employeeService.findAll()).thenReturn(Arrays.asList(new Employee()))
//     //     }
//     //     cleanUp(){
//     //         Mockito.reset(employeeService)
//     //     }

//     // @TestConfiguration
//     // static class MockConfig {

//     //     def detachedMockFactory = new DetachedMockFactory()
//     //     @Bean
//     //     HelloWorldService helloWorldService() {
//     //         return detachedMockFactory.Stub(HelloWorldService)
//     //     }

//     //     @Bean
//     //     @Primary
//     //     EmployeeService employeeService() {
//     //         return Mockito.mock(EmployeeService.class)
//     //     }

//     // }

//     }
