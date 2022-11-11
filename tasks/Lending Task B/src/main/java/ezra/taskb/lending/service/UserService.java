package ezra.taskb.lending.service;

import ezra.taskb.lending.model.Users;

/**
 * Collins K. Sang
 * 11/11/22 8:54 AM
 * Lending Task B
 * UserService
 * IntelliJ IDEA
 **/
public interface UserService {
    Users save(Users users);

    Users findByPhoneNo(String phone_no);
}
