package ro.tudorfnsn.Model;

import lombok.*;

import javax.persistence.*;
import java.awt.*;
import java.util.Date;

@Entity
@Table(name="news")
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode

public class News
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String title;

    @Column
    private Date startDate;

    @Column
    private Date endDate;

    @Column
    private TextArea description;

    public News(String title, Date startDate, Date endDate, TextArea description)
    {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }
}
