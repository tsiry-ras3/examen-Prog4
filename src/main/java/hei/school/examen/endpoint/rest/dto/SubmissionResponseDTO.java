package hei.school.examen.endpoint.rest.dto;

import java.security.Timestamp;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubmissionResponseDTO {
  private UUID id;
  private String fileName;
  private String email;
  private String s3UrlBw;
  private Timestamp createdAt;
}
