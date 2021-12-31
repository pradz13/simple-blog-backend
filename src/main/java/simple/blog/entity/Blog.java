package simple.blog.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "blog_data")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String blogHeading;

    @Lob
    private String blogBody;

    private String tag;

    private LocalDateTime date;

}
