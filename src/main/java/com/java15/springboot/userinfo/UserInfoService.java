package com.java15.springboot.userinfo;

import com.java15.springboot.userinfo.roledata.AdministratorRoleData;
import com.java15.springboot.userinfo.roledata.ProducerRoleData;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {
    public UserInfo getUserInfo(String email) {
        UserRole role = getUserRole(email);

        switch (role) {
            case PRODUCER:
                return createProducerUserInfo(email);
            case ADMINISTRATOR:
                return createAdminUserInfo(email);
        }

        return null;
    }

    private UserInfo createAdminUserInfo(String email) {
        AdministratorRoleData adminData = AdministratorRoleData.builder()
                .role(UserRole.ADMINISTRATOR)
                .email(email)
                .name("John Doe Administrator")
                .producerStats(
                        AdministratorRoleData.ProducerStats.builder().count(10).build()
                )
                .customerStats(AdministratorRoleData.CustomerStats.builder()
                        .verified(25).awaitingVerification(5).requests(56)
                        .build())
                .droneStats(AdministratorRoleData.DroneStats.builder()
                        .readyForShipping(28).problematic(5).build()).build();
        return UserInfo.builder().success(true).error(UserInfo.Error.ok).userInfo(adminData).build();
    }

    private UserInfo createProducerUserInfo(String email) {
        ProducerRoleData producerData = ProducerRoleData.builder()
                .role(UserRole.PRODUCER)
                .email(email)
                .name("John Doe Producer")
                .droneStats(
                        ProducerRoleData.DroneStats.builder()
                                .assembled(10)
                                .problematic(1)
                                .build()
                ).build();

        return UserInfo.builder()
                .success(true)
                .error(UserInfo.Error.ok)
                .userInfo(producerData)
                .build();
    }

    private UserRole getUserRole(String email) {
        if (email.equals("producer")) {
            return UserRole.PRODUCER;
        } else {
            return UserRole.ADMINISTRATOR;
        }
    }
}
