package com.java15.springboot.userinfo.roledata;

import com.java15.springboot.userinfo.UserRole;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProducerRoleData {
    private UserRole role;
    private String email;
    private String name;
    private DroneStats droneStats;

    @Builder
    @Data
    public static class DroneStats {
        private int assembled;
        private int problematic;
    }
}
