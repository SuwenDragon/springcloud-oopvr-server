package com.oopvr.production.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.apache.ibatis.annotations.Results;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table( name = "internetuser_tb")
@JsonInclude(value= JsonInclude.Include.NON_NULL)
public class InternetUser {

    @Id
    @KeySql(useGeneratedKeys = true)
    @Column(name = "pk_user_id")
    private Integer userId;

    private  String userName;

    private  String userAccount;

    private  String userPassword;

    private String userImageUrl;

    private String userIphone;

    private String userMailbox;

    private  String userIntroduce;

    private String userCircles;

    private String userLocal;

    private String userRegion;

    private String userAddress;

    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date userMake;

    private int userState;

}
