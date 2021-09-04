package simple.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogDto {
    private Long id;

    private String blogHeading;

    private String blogBody;

    private String tag;

    private LocalDateTime date;
}
