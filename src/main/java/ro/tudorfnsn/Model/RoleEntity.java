package ro.tudorfnsn.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;


@Entity
@Table(name = "role")
@NoArgsConstructor
@Getter
@Setter
public class RoleEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    @ManyToMany(mappedBy = "roles")
    private Collection<UserEntity> users;


    public RoleEntity(String name)
    {
        this.name = name;
    }

}
