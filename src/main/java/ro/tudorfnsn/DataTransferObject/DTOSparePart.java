package ro.tudorfnsn.DataTransferObject;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class DTOSparePart
{
    String picture;
    String name;
    String series;
    Float price;
    Integer quantity;
    String origin;
}
