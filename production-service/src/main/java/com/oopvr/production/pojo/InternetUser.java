package com.oopvr.production.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table( name = "netuser_tb")
@JsonInclude(value= JsonInclude.Include.NON_NULL)
public class InternetUser {

    @Id
    @KeySql(useGeneratedKeys = true)
    @Column(name = "pk_user_id")
    private Integer userId;

    /**
     * 用户名称
     */
    private  String userName;

    /**
     * 用户账号
     */
    private  String userAccount;


    /**
     * 用户密码
     */
    private  String userPassword;

    /**
     * 用户头像
     */
    @Column(name = "user_imageurl")
    private String userImageUrl;

    /**
     * 用户手机号码
     */
    private String userIphone;

    /**
     * 用户邮箱
     */
    private String userMailbox;

    private  String userIntroduce;

    private String userCircles;

    private String userLocal;

    private String userRegion;

    private String userAddress;

    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date userMake;

    private int userState;

    @Column(name = "is_effect")
    private int iseffect;

    private String confirmPassword;
}
