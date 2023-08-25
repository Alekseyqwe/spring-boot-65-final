package com.tms.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.time.LocalDateTime;
@Data
@EqualsAndHashCode(exclude = "updatedAt")
@Entity(name = "user_info")
public class UserInfo {

    @Id
    @SequenceGenerator(name = "mySeqGen", sequenceName = "user_info_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "mySeqGen")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "created")
    private LocalDateTime createdAt;

    @Column(name = "updated")
    private LocalDateTime updatedAt;

    @Column(name = "user_role")
    @Enumerated(EnumType.STRING)
    private Role role;
}
