/**
 * RequestMapping 不能注解在 Repository 上面.Repository 方法不能修改返回结果的格式(默认为JSON).
 * 如果需要服务返回XML格式的, 需要一个控制器来调用 Repository
 */

package com.example.examplespringdatarest.repository;

import com.example.examplespringdatarest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "user")
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * 屏蔽DELETE方法
     *
     * @param id
     */
    @RestResource(exported = false)
    @Override
    public void delete(Long id);

    /**
     * 屏蔽DELETE ALL方法
     */
    @RestResource(exported = false)
    @Override
    void deleteAll();
}
