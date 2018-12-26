package com.example.demomongodb.repository;

import com.example.demomongodb.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by loliveira on 25/12/18.
 */
@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
