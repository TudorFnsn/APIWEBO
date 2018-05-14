package ro.tudorfnsn.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
public class UserEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String username;
    @Column
    private String password;
    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleEntity> roles;


    public UserEntity(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    public UserEntity(Long id, String username, String password)
    {
        this.id = id;
        this.username = username;
        this.password = password;

    }
}
