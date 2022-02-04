package com.fundamentos.springboot.fundamentos.bean;

public class MyBeanWithDependenciesImplement implements MyBeanWithDependencies{

    MyOperation myOperation;

    public MyBeanWithDependenciesImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        int numerito = 1;
        System.out.println(myOperation.sum(numerito));
        System.out.println("Hola desde la implementacion de un bean con dependencia");
    }
}
