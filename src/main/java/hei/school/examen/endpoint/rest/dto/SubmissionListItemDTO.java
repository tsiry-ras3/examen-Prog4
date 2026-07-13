package hei.school.examen.endpoint.rest.dto;

import java.time.Instant;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubmissionListItemDTO {
  private UUID id;
  private String fileName;
  private String email;
  private String s3UrlBw;
  private Instant createdAt;
}
