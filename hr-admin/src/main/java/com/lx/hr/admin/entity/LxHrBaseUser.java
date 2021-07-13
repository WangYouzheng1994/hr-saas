package com.lx.hr.admin.entity;

import com.lx.hr.admin.common.BaseService;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 后台配置服务，用户管理表，TODO
 * </p>
 *
 * @author WangYouzheng
 * @since 2021-07-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class LxHrBaseUser extends BaseService {

    private static final long serialVersionUID = 1L;

    /**
     * 用户uuid
     */
    private String pid;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 密码
     */
    private String password;

    /**
     * 加密
     */
    private String salt;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 性别
     */
    private String sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 出生日期
     */
    private Integer birthday;

    /**
     * 入职日期
     */
    private Integer joinDate;

    /**
     * 离职日期
     */
    private Integer leaveDate;

    /**
     * 部门编码，格式：000-000-000-000-000
     */
    private String departmentCode;

    /**
     * 是否启用，0不启用，1启用
     */
    private String useFlag;

    /**
     * 是否删除，0正常，1删除
     */
    private String delFlag;

    /**
     * 创建人
     */
    private String createUserName;

    /**
     * 创建人uuid
     */
    private String createUserId;

    /**
     * 创建时间
     */
    private Long createDate;

    /**
     * 更新人
     */
    private String updateUserName;

    /**
     * 更新人uuid
     */
    private String updateUserId;

    /**
     * 更新时间
     */
    private Long updateDate;


}
