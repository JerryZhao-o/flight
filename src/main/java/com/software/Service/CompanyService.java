package com.software.Service;

import com.software.Dao.CompanyRepository;
import com.software.Domain.Company;
import com.software.Domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;
    public Company findCompanyByName(String name) {
        return companyRepository.findByCompanyusername(name);
    }
}
