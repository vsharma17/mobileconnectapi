package com.hcl.net.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hcl.net.model.MobileCompanyNumber;
@Repository
public interface MobileNoRepository extends JpaRepository<MobileCompanyNumber,String> {

}
