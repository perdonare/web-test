package com.lance.test.spring;

import com.lance.persistence.model.User;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

/**
 * Created by perdonare on 2015/12/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/spring-config.xml"})
public class IocTest {
    private ClassPathXmlApplicationContext context = null;
    @Autowired
    private TestListenerService testListenerService;


    @Before
    public void init() {
        context = new ClassPathXmlApplicationContext(new String[]{"spring-config.xml"});
    }

    /**
     * 将容器外的bean放入容器
     */
    @Test
    public void testOutsideBean() {
        UserModel user = new UserModel();
        user.setName("lance");
        user.setAge(100);
        context.getBeanFactory().registerSingleton("userModel",user);

        UserModel userModel = context.getBean(UserModel.class);
        System.out.println(userModel.getName());
    }

    /**
     * 测试spring别名
     * <bean id="userModel" name="userAlias" class="com.lance.test.spring.UserModel"/>
     * <alias name="userAlias" alias="myAlias" />
     */
    @Test
    public void testAlias() {
        UserModel userModel = context.getBean(UserModel.class);
        UserModel userModel1  = (UserModel) context.getBean("userModel");
        UserModel userModel2 = (UserModel) context.getBean("userAlias");
        UserModel userModel3 = (UserModel) context.getBean("myAlias");

        System.out.println(userModel);
        System.out.println(userModel1);
        System.out.println(userModel2);
        System.out.println(userModel3);
    }

    /**
     * 单独使用Factory factory-method="getUserFactory"  这种方式是对这个类来创建实例 getUserFactory必须为静态工厂
     *  <bean id="userModel" factory-bean="userFactory" factory-method="getUserModel" />这种方式userFactory是通过spring实例化的bean 然后通过非静态方法创建UserModel类型
     *  工厂方法也支持构造函数式的方式注入参数
     */
    @Test
    public void testFactory(){
        UserModel userModel = (UserModel) context.getBean("userModel");
        UserModel userMode2 = (UserModel) context.getBean("userModel2");
        System.out.println(userModel);
        System.out.println(userMode2);

    }

    @Test
    public void testDependency() {
        TestModelTwo testModelTwo = (TestModelTwo) context.getBean("modelTwo");
        System.out.println(testModelTwo.getModelOne());
    }

    @Test
    public void testProtoType() {
        TestModelFour testModelFour = (TestModelFour) context.getBean("modelFour");
        System.out.println(testModelFour.getTestModelThree());
        //TestModelFour testModelFour1 = (TestModelFour) context.getBean("modelFour");
        System.out.println(testModelFour.getTestModelThree());
        //System.out.println(testModelFour.getThree());
    }

    @Test
    public void testMethodReplace() {
        TestModelFive testModelFive = (TestModelFive) context.getBean("modelFive");
        String value = testModelFive.compute("asdfsdf");
        System.out.println(value);
    }

    /**
     * 测试两个相同类型如何autowire
     */
    @Test
    public void testModelAutowire() {

    }

    @Test
    public void testListener(){
        testListenerService.sendEmail("mail");
    }
    @Test
    public void testResource() throws Exception {
        Resource resource = context.getResource("classpath*:test.properties");
        resource.getFile();

        TestResource testResource = context.getBean(TestResource.class);
        System.out.println("=============");
        Resource resource1 = testResource.show();
        System.out.println(resource1.isReadable());
    }

    @Test
    public void testPropertiesEditor() {

    }

    @Test
    public void testSpEL() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("'hello world'.concat('!')");
        Expression expressionByte = parser.parseExpression("'hello world'.bytes");
        Expression expressionLength = parser.parseExpression("'hello world'.bytes.length");
        String hello = (String) expression.getValue();
        byte[] bytes = (byte[]) expressionByte.getValue();
        int length = (int) expressionLength.getValue();
        System.out.println(hello);
        System.out.println(bytes.length);
        System.out.println(length);

        int year = (Integer) parser.parseExpression("Birthdate.Year + 1900").getValue(context);

        String city = (String) parser.parseExpression("placeOfBirth.City").getValue(context);

        System.out.println("year"+year+"city"+city);


        /*================================*/
        TestModelOne one = new TestModelOne();
        one.setName("lance");

        ExpressionParser parser1 = new SpelExpressionParser();
        Expression expression1 = parser1.parseExpression("name");

        //EvaluationContext很重  注意缓存起来
        EvaluationContext executionContext = new StandardEvaluationContext(one);
        String name = (String) expression1.getValue(executionContext);
        String name1 = (String) expression1.getValue(one);
        System.out.println(name);
        System.out.println(name1);

        /**=============================**/

        TestSpelModel model = context.getBean(TestSpelModel.class);
        System.out.println(model.getName()+"spel");
    }

    @Test
    public void testAspect() throws Exception {
        TestAspectService service = context.getBean(TestAspectService.class);
        //service.sayHi();
        service.sayHiParam("lance",18);
    }

    @Test
    public void testIntroduction() {
        Fit service = (Fit) context.getBean("testAspectService");
        service.fun();

    }


}
