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
@Table( name = "super_tb")
@JsonInclude(value= JsonInclude.Include.NON_NULL)
public class SuperPvr {
    @Id
    @KeySql(useGeneratedKeys = true)
    @Column(name = "pk_home_id")
    private Integer homeId;

    private String name;

    private String englishName;

    private String nameAlias;

    private String nameUrl;

    private String namePosition;

    private String linkCode;

    private Integer idxId;

    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date nameMake;

    private Integer nameState;

}
