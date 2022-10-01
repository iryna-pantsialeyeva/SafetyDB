package service;

import service.impl.ADRServiceImpl;

public class Runner {

    public static void main(String[] args) {

        ADRService adr = new ADRServiceImpl();
        System.out.println(adr.getAll());
    }
}
