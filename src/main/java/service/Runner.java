package service;

import service.impl.ADRServiceImpl;

public class Runner {

    public static void main(String[] args) {
        ADRService adrService = new ADRServiceImpl();
        System.out.println(adrService.getAll());
    }
}
