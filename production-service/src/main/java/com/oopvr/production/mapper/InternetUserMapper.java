package com.oopvr.production.mapper;

import com.oopvr.production.pojo.InternetUser;
import org.apache.ibatis.annotations.Insert;
import tk.mybatis.mapper.common.Mapper;


public interface InternetUserMapper extends Mapper<InternetUser> {

    InternetUser queryUser(int id);

    /**
     * 创建用户
     * @param userName
     * @param userAccount
     * @param userPassword
     * @param imageUrl
     * @param userIphone
     * @param userMailbox
     * @param userIntroduce
     * @return
     */
    @Insert("INSERT INTO " +
            "internetuser_tb (user_name, " +
            "user_account,user_password," +
            "user_image_url,user_iphone," +
            "user_mailbox,user_introduce) " +
            "VALUES" +
            " (#{userName},#{userAccount}," +
            "#{userPassword},#{imageUrl}," +
            "#{userIphone},#{userMailbox}," +
            "#{userIntroduce})")
    int insertInternetUser(String userName,String userAccount,
                            String userPassword,String imageUrl,
                            String userIphone,String userMailbox,String userIntroduce);

}
