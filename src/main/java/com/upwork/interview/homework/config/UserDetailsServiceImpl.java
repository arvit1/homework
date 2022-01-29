package com.upwork.interview.homework.config;

import com.upwork.interview.homework.model.Student;
import com.upwork.interview.homework.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Student student = studentRepo.getUserByUsername(username);

        if (student == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        return new StudentDetails(student);
    }
}
