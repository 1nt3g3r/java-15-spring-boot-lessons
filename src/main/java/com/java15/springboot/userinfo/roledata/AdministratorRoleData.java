package com.java15.springboot.userinfo.roledata;

import com.java15.springboot.userinfo.UserRole;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AdministratorRoleData {
    private UserRole role;
    private String email;
    private String name;
    private ProducerStats producerStats;
    private CustomerStats customerStats;
    private DroneStats droneStats;

    @Builder
    @Data
    public static class ProducerStats {
        private int count;
    }

    @Builder
    @Data
    public static class CustomerStats {
        private int verified;
        private int awaitingVerification;
        private int requests;
    }

    @Builder
    @Data
    public static class DroneStats {
        private int readyForShipping;
        private int problematic;
    }
}
