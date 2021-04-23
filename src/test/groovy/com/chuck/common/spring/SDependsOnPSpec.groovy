package com.chuck.common.spring


import com.chuck.common.domain.Prototype
import com.chuck.common.domain.Singleton
import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification
import spock.lang.Title

/**
* @author Chuck
* @since 
* @version 0.0.1
*
**/
@Title("测试Singleton对象依赖Prototype对象")
//因为Groovy没有数组类型，所以这里使用ArrayList []
@ContextConfiguration(classes=[Singleton.class,Prototype.class])
//@ActiveProfiles("spring-depends-test")
@Slf4j
class  SDependsOnPSpec extends Specification
{
    @Autowired
    ApplicationContext ctx

    def 'Singleton对象每次获取注入不同Prototype对象'() {
      given: ''
      Arrays.stream(ctx.getBeanDefinitionNames()).forEach(name -> System.out.print(name));
      when: '从Application获取两次Singleton对象' 
      def singleton=ctx.getBean('singleton')
      def singleton1=ctx.getBean('singleton')
      then: '两次Singleton的Prototype对象不相等' 
       singleton.prototype==singleton1.prototype
    } 
}