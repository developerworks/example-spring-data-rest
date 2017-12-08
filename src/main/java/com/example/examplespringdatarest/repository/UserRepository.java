/**
 * https://reflectoring.io/documenting-spring-data-rest-api-with-springfox/
 */
package com.example.examplespringdatarest.repository;

import com.example.examplespringdatarest.entity.User;
import io.swagger.annotations.*;
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
     * <p>
     * 输入参数的名称和描述可以使用 @ApiParam 注解进行配置.
     * 注意: 从Springfox 2.7.1开始阐述名称也会从Spring Data提供的@Param 注解进行读取.
     * <p>
     * 注意: 当前Springfox 的版本为2.7.0, 还需要等2.7.1发布才可以省略@ApiParam 注解, 否则无法自定义参数的说明.
     *
     * @param username
     * @param pageable
     * @return
     */
    @RestResource(path = "nameStartsWith", rel = "nameStartsWith")
    @ApiOperation("查找以字符串开头的用户名称")
    Page<User> findByUsernameStartsWith(
        @Param("username") @ApiParam(value = "用户名称", required = true) String username,
        Pageable pageable
    );

    /**
     * 覆盖父接口CrudRepository的save方法, 增加Springfox标注用于Swagger UI的显示
     *
     * @param user
     * @return
     */
    @Override
    @ApiResponses({
        @ApiResponse(code = 201, message = "已创建", response = User.class),
        @ApiResponse(code = 401, message = "未授权"),
        @ApiResponse(code = 403, message = "禁止访问"),
        @ApiResponse(code = 404, message = "资源不存在")
    })
    User save(User user);

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
