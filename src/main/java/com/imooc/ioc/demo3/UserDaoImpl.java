package com.imooc.ioc.demo3;

public class UserDaoImpl implements UserDao {
    @Override
    public void findAll() {
        System.out.println("find");
    }

    @Override
    public void save() {
        System.out.println("save");

    }

    @Override
    public void update() {
        System.out.println("update");

    }

    @Override
    public void delete() {
        System.out.println("delete");

    }
}
