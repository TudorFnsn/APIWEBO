package ro.tudorfnsn.DataTransferObject;

import lombok.*;
import ro.tudorfnsn.Enumerable.Origin;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class DTOSparePart
{
    Long id;
    String picture;
    String name;
    String series;
    Float price;
    Integer quantity;
    Origin origin;
}
