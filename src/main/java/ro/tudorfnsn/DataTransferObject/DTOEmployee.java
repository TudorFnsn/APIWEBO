package ro.tudorfnsn.DataTransferObject;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString

public class DTOEmployee
{
    String picture;
    String name;
    String position;
}
