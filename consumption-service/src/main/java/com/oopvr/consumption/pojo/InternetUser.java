package com.oopvr.consumption.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.Date;

@Data
@JsonInclude(value= JsonInclude.Include.NON_NULL)
public class InternetUser {

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

    private int iseffect;
}
