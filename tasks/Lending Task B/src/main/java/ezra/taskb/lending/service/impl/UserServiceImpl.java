package ezra.taskb.lending.service.impl;

import ezra.taskb.lending.model.Users;
import ezra.taskb.lending.repository.UserRepository;
import ezra.taskb.lending.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Collins K. Sang
 * 11/11/22 8:54 AM
 * Lending Task B
 * UserServiceImpl
 * IntelliJ IDEA
 **/
@Service
public class UserServiceImpl implements UserService {
    final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Users save(Users users) {
        return userRepository.save(users);
    }

    @Override
    public Users findByPhoneNo(String phone_no) {
        return userRepository.findByMsisdn(phone_no);
    }
}
