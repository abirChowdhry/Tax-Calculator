package com.service;

import com.domain.Admin;
import com.repository.AdminRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
@Transactional
public class AdminService {

    private AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {this.adminRepository = adminRepository;}

    @Transactional
    public boolean insert(Admin admin) throws SQLException {
        admin.setName(admin.getName());
        admin.setPassword(admin.getPassword());
        return adminRepository.create(admin);
    }

    @Transactional(readOnly = true)
    public Admin get(Long id) throws SQLException { return adminRepository.get(id);}
}
