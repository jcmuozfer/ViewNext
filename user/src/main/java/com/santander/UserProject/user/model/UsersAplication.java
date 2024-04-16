package com.santander.UserProject.user.model;

import lombok.Getter;

import java.util.TreeMap;

@Getter
public class UsersAplication {

    private final TreeMap<String, User> listUser;

    public UsersAplication() {
        this.listUser = new TreeMap<>();
    }

    public User getUser(String dni){
        return this.listUser.get(dni);
    }

    public boolean addUser (String dni, User user) {

        return listUser.computeIfAbsent(dni, k -> user).equals(user);
    }

    public boolean updateUser (String oldDni, String newDni) {
        boolean operation = false;
        User user  = this.listUser.get(oldDni);
        if (user != null) {
            this.listUser.remove(oldDni);
            operation = this.addUser(newDni,user);
        }
        return operation;
    }

    public boolean deleteUser (String dni) {
        boolean operation = false;
        if (this.listUser.containsKey(dni)) {
            this.listUser.remove(dni);
            operation = true;
        }

        return operation;
    }
}
