package com.frank.shirojwt.repository;

import com.frank.shirojwt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 小石潭记
 * @date 2020/6/20 21:38
 * @Description: ${todo}
 */
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(String userName);

}
