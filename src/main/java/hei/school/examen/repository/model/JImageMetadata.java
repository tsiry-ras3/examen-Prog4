package hei.school.examen.repository.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.Instant;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "image_metadata")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class JImageMetadata {

  @Id private UUID id;

  @Column(name = "file_name", nullable = false)
  private String fileName;

  @Column(nullable = false)
  private String email;

  @Column(name = "s3_url_bw")
  private String s3UrlBw;

  @Column(name = "created_at", nullable = false)
  private Instant createdAt;
}
