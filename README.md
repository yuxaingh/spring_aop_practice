# spring_aop_practice
This is a tutorial project from <<Java Web 开发实战>>.

##Use Spring AOP
```
1. Create pointcutAdvisor
  - Implement pointCutAdvisor properties (e.g. advice and method mapping pattern)
  - Override member function of advisor interface
2. Create proxy object
  - Pass target class
  - Pass proxyInterface
  ```
  
  ### Configuration Example:
  ```
  <bean class="com.hyx.aop.BeforeAdvice" id="beforeAdvice"/>
  <bean class="com.hyx.aop.AfterAdvice" id="afterAdvice"/>
  <bean class="org.springframework.aop.support.RegexpMethodPointcutAdvisor" id="pointcutAdvisor">
    <property name="advice">
      <ref bean="beforeAdvice"/>
    </property>
    <property name="patterns">
      <list>
        <value>.*executeInsert*.</value>
      </list>
     </property>
    </bean>
    <bean class="com.hyx.aop.ExecuteInsert" id="executeInsert"> </bean>
    <bean class="org.springframework.aop.framework.ProxyFactoryBean" id="checkClass">
      <property name="proxyInterfaces">
        <list>
          <value>com.hyx.aop.UserInterface</value>
        </list>
       </property>
      <property name="target">
      <property name="interceptorNames">
        <list>
          <value>afterAdvice</value>
          <value>pointcutAdvisor</value>
          <value>beforeAdvice</value>
        </list>
       </property>
     </bean>
     ```
