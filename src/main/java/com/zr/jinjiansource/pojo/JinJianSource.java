package com.zr.jinjiansource.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity(name = "jinjiansource")
public class JinJianSource {
    @Id
    @GeneratedValue
    private Integer id;
    private String merchant;
    private String customerName;
    private String orderNum;
    private String idCode;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date incomingPartsTime;
    private String incomingPartsProvince;
    private String incomingPartsCity;
    private String specificAddress;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
    private String createName;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;
    private String updateName;


}
