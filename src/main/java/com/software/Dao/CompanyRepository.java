package com.software.Dao;

import com.software.Domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<CompanyRepository,Integer> {
    Company findByCompanyusernameAndCompanypassword(String companyusername, String companypassword);
    Company findByCompanyusername(String companyusername);
    Company findByCompanyid(Integer companyid);
}
