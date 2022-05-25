package com.kkb.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Team {
    private Integer teamId;
    private String teamName;
    private String Location;
    /**
     * 日期格式 yyyy-MM-dd HH:mm:ss
     * @DateTimeFormat 时间格式转换注解
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")     //处理器获取日期类型参数时加
    @JsonFormat(pattern = "yyyy-MM-dd hh:MM:ss",timezone = "GMT+8") //JSON格式返回给前端的时候添加
    private Date createTime;


    @Override
    public String toString() {
        return "Team{" +
                "teamId=" + teamId +
                ", teamName='" + teamName + '\'' +
                ", Location='" + Location + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }
}