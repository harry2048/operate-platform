package com.zr.jiuyitobelent.enumall;

/**
 * 枚举必须要有有参构造
 * Created by 11936 on 2019/4/25.
 */
public enum ChannelEnum {
    JIUYIJINRONG("91金融",0),JIUYIWANGCAI("91旺财",1);

    private String channelName;
    private Integer channelValue;

    public static String getChannelName(Integer  channelValue){
        for(ChannelEnum channelEnum : ChannelEnum.values()){
            if(channelEnum.getChannelValue() ==  channelValue){
                return channelEnum.getChannelName();
            }
        }
        return null;
    }

    public static Integer getChannelValue(String channelName){
        for(ChannelEnum channelEnum : ChannelEnum.values()){
            if(channelEnum.getChannelName().equals(channelName)){
                return channelEnum.getChannelValue();
            }
        }
        return null;
    }

    ChannelEnum(String channelName, Integer channelValue) {
        this.channelName = channelName;
        this.channelValue = channelValue;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public Integer getChannelValue() {
        return channelValue;
    }

    public void setChannelValue(Integer channelValue) {
        this.channelValue = channelValue;
    }
}
