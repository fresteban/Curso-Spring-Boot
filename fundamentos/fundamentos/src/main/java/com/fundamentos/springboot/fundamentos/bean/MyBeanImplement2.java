package com.fundamentos.springboot.fundamentos.bean;

public class MyBeanImplement2 implements MyBean{
    @Override
    public void print() {
        System.out.println("Hola desde mi implementacion propia del bean 2");
    }
}
