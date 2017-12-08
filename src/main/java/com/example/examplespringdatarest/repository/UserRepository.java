/**
 * RequestMapping 不能注解在 Repository 上面.Repository 方法不能修改返回结果的格式(默认为JSON).
 * 如果需要服务返回XML格式的, 需要一个控制器来调用 Repository
 * <p>
 * https://reflectoring.io/documenting-spring-data-rest-api-with-springfox/
 */
package com.example.examplespringdatarest.repository;

import com.example.examplespringdatarest.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@Api(tags = "用户对象管理")
@RepositoryRestResource(path = "users")
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * 分页查询以指定字符串开头的名字
     *
     * @param username
     * @param pageable
     * @return
     */
    @RestResource(path = "nameStartsWith", rel = "nameStartsWith")
    @ApiOperation("查找以字符串开头的用户名称")
    Page<User> findByUsernameStartsWith(@Param("username") String username, Pageable pageable);

    /**
     * 屏蔽DELETE方法
     *
     * @param id
     */
    @RestResource(exported = false)
    @Override
    void delete(Long id);

    /**
     * 屏蔽DELETE ALL方法
     */
    @RestResource(exported = false)
    @Override
    void deleteAll();
}
