package ro.tudorfnsn.DataTransferObject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class UserDTO
{
    private Long id;
    private String username;
    private String password;

    public UserDTO(Long id, String username, String password)
    {
        this.id = id;
        this.username = username;
        this.password = password;

    }

}
