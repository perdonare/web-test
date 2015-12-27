package com.lance.test.spring;

import com.lance.persistence.model.User;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by perdonare on 2015/12/13.
 */
public class IocTest {
    private ClassPathXmlApplicationContext context = null;

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
     * @postConstruct 和 @preDestroy测试
     */
    @Test
    public void testConstructAndDestroy() throws InterruptedException {
        TestModelSeven testModelSeven = context.getBean(TestModelSeven.class);
        System.out.println(testModelSeven);
        Thread.sleep(50000);
    }

    /**
     * 通过@Bean来生成bean
     */
    @Test
    public void testAnnotationCreateBean() {
        TestModelNine testModelNine = context.getBean(TestModelNine.class);
        System.out.println(testModelNine);
    }

    /**
     * 构造函数注入
     */
    @Test
    public void testConstructWire() {
        TestModelTen testModelTen = context.getBean(TestModelTen.class);
        System.out.println(testModelTen);
    }

    @Test
    public void testApplicationContextWire() {
        TestModelOneOne testModelOneOne = context.getBean(TestModelOneOne.class);

        testModelOneOne.contextFun();
    }
}
