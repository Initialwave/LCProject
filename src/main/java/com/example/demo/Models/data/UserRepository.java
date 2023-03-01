package com.example.demo.Models.data;

import com.example.demo.Models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    static Object getAll() {
        return null;
    }


    static void add(User newUser) {
    }

    static void remove(int id) {
    }
}
