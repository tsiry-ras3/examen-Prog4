package hei.school.examen.entity;

import java.time.Instant;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ImageMetadata {
  private UUID id;
  private String fileName;
  private String email;
  private String s3UrlBw;
  private Instant createdAt;
}
