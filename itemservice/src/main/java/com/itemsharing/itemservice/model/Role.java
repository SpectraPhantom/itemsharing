package com.itemsharing.itemservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class Role {

    @Id
    private Long id;
    private String name;

    @OneToMany(mappedBy = "role",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<UserRole> userRoles=new HashSet<>();
}
