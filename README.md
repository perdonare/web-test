# spring aop
##  概念
1.  Aspect
2.  Join point
3.  Advice
4.  Pointcut
5.  Introduction
6.  Target object
7.  AOP proxy
8.  Weaving
##  advice类型
1.  Before advice
2.  After returning advice
3.  After throwing advice
4.  After (finally) advice
5.  Around advice
##  `@AspectJ`
1.  启用Aspect的方式

    ``` 
      @Configuration
      @EnableAspectJAutoProxy
      public class AppConfig {
      } 
      ```
    或者
      ```
      <aop:aspectj-autoproxy/>
      ````
2.  声明一个Aspect
    ```
    package org.xyz;
    import org.aspectj.lang.annotation.Aspect;
    
    @Aspect@Service
    public class NotVeryUsefulAspect {
    
    }
    ```
3. 声明一个pointcut
    ```
    @Pointcut("execution(* transfer(..))")// the pointcut expression
    private void anyOldTransfer() {}// the pointcut signature
    ```
4.  支持的pointcut类型
    1.  execution 
    2.  within
    3.  this
    4.  target 
    5.  args
    6.  @target 
    7.  @args 
    8.  @within
    9.  @annotation
 5. 支持&& , || and  !
 
        ```
        @Pointcut("execution(public * *(..))")
        private void anyPublicOperation() {}

        @Pointcut("within(com.xyz.someapp.trading..*)")
        private void inTrading() {}
        
        @Pointcut("anyPublicOperation() && inTrading()")
        private void tradingOperation() {}
        
        ```