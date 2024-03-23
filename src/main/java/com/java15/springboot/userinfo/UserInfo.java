package com.java15.springboot.userinfo;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserInfo {
    private boolean success;
    private Error error;
    private Object userInfo;

    public enum Error {
        ok
    }
}
