package com.indiumsoftware.quizapp.dao;




import com.indiumsoftware.quizapp.model.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<UserInformation, Integer> {
    Optional<UserInformation> findByName(String username);

}