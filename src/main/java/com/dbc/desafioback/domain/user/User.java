package com.dbc.desafioback.domain.user;

import com.dbc.desafioback.dtos.UserDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name="users")
@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String document;
    @Column(unique = true)
    private String email;
    @Enumerated(EnumType.STRING)
    private UserType userType;

    public User(UserDTO userDTO) {
        //String name, String document, String email, UserType userType
        this.name = userDTO.name();
        this.document = userDTO.document();
        this.email = userDTO.email();
        this.userType = userDTO.userType();
    }
}
