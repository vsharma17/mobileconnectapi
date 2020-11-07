package com.hcl.net.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hcl.net.model.UserInformation;
@Repository
public interface UserInformationRepository extends JpaRepository<UserInformation,String> {

}
