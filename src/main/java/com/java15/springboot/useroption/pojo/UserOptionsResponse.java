package com.java15.springboot.useroption.pojo;

import com.java15.springboot.useroption.UserOption;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Builder
@Data
public class UserOptionsResponse {
    private boolean success;
    private Map<String, String> options;

    public static UserOptionsResponse failed() {
        return UserOptionsResponse.builder().success(false).build();
    }

    public static UserOptionsResponse success(List<UserOption> options) {
        Map<String, String> userOptions = options.stream().collect(Collectors.toMap(
                UserOption::getOption,
                UserOption::getValue
        ));

        return UserOptionsResponse.builder().success(true).options(userOptions).build();
    }


}
