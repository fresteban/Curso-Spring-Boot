package com.fundamentos.springboot.fundamentos.bean;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

public class MyBeanWithDependenciesImplement implements MyBeanWithDependencies{

    Log LOGGER = LogFactory.getLog(MyBeanWithDependenciesImplement.class);

    MyOperation myOperation;

    public MyBeanWithDependenciesImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        LOGGER.info("Hemos ingresado al método printWithDependency");
        int numerito = 1;
        LOGGER.debug("El número enviado como parametro a la dependencia operation es : " + numerito);
        System.out.println(myOperation.sum(numerito));
        System.out.println("Hola desde la implementacion de un bean con dependencia");
    }
}
