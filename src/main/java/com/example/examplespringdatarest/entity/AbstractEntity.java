package com.example.examplespringdatarest.entity;

/**
 * @MappedSuperclass 实体基类
 * <p>
 * 用于保存所有数据库表公共的字段, 标注为@MappedSuperclass的类不会映射到数据库表, 它是一个不完整的实体.
 * 其拥有的熟悉会被子类映射到数据库表的列(Column)
 * <p>
 * 本类创建了一个三个公共的字段
 * <p>
 * - id
 * - created_at
 * - is_deleted
 * <p>
 * ## MappedSuperclass 实体的限制
 * <p>
 * - 不能使用 @Entity 或 @Table标注
 * - 不存在对应的数据库表
 * <p>
 * ## 参考资料
 * <p>
 * - http://blog.csdn.net/qq_527235890/article/details/70196396
 * <p>
 * ## 多对多关系
 * <p>
 * http://sourfeng.cn/2017/05/08/spring-data-jpa/
 * <p>
 * 拆解多对多关系为两个多对一关系, 目的是为了扩展关系,比如关系的建立时间, 说明等信息.
 * 需要一个中间的独立实体
 */

import lombok.Data;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Data
public abstract class AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long createdAt;
    private Long deletedAt;
    private Long updatedAt;

    /**
     * 持久化钩子: 当执行创建操作时, 在持久化到数据库之前, 更新实体对象的创建和修改时间
     */
    @PrePersist
    protected void onCreate() {
        Date date = new Date();
        createdAt = updatedAt = date.getTime() / 1000;
    }

    /**
     * 持久化钩子: 当执行更新操作时, 在持久化到数据库之前, 更新实体对象的修改时间
     */
    @PreUpdate
    protected void onUpdate() {
        Date date = new Date();
        updatedAt = date.getTime() / 1000;
    }

    /**
     * 持久化钩子: 当执行删除操作时, 在持久化到数据库之前, 更新实体对象的删除时间
     */
    @PreRemove
    protected void onDelete() {
        Date date = new Date();
        deletedAt = date.getTime() / 1000;
    }

}
