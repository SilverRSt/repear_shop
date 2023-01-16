package com.example.repear_shop.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties("users")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roleId", nullable = false)
    private Long roleId;

    @Column
    private String role;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"mvList", "visits", "users", "roles", "users", "roles", "userId", "roleId", "model", "person", "brand", "employeeId", "clientId", "qualificationId", "visitId", "repairShopId", "visits", "services", "repairShops", "serviceId", "vin"})
    private Set<EndUser> users;

    @Override
    public String getAuthority() {
        return this.role;
    }
}
