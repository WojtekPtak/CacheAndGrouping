package dupa.jasiu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;




class MainTester {


    public static void main(String parms[]) {
        ApplicationContext context2 = new AnnotationConfigApplicationContext(AppConfig.class);
        Tester testowanko = context2.getBean(Tester.class);
        testowanko.test();



    }



}