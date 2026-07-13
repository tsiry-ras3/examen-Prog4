package hei.school.examen.service;

import hei.school.examen.domain.exception.InvalidImageFormatException;
import hei.school.examen.endpoint.event.EventProducer;
import hei.school.examen.endpoint.event.model.ImageSubmitted;
import hei.school.examen.entity.ImageMetadata;
import hei.school.examen.entity.ImageMetadataRepository;
import hei.school.examen.file.bucket.BucketComponent;
import java.time.Instant;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@AllArgsConstructor
public class SubmitImageService {

  private static final List<String> ALLOWED_CONTENT_TYPES = List.of("image/jpeg", "image/png");

  private final ImageMetadataRepository repository;
  private final BucketComponent bucketComponent;
  private final EventProducer<ImageSubmitted> eventProducer;

  @SneakyThrows
  public ImageMetadata execute(MultipartFile file, String email) {
    if (!ALLOWED_CONTENT_TYPES.contains(file.getContentType())) {
      throw new InvalidImageFormatException("Only JPEG and PNG formats are allowed");
    }

    UUID id = UUID.randomUUID();
    String s3KeyOriginal = "original/" + id;

    bucketComponent.upload(file, s3KeyOriginal);

    ImageMetadata metadata =
        ImageMetadata.builder()
            .id(id)
            .fileName(file.getOriginalFilename())
            .email(email)
            .status("PENDING")
            .createdAt(Instant.now())
            .build();

    repository.save(metadata);

    eventProducer.accept(
        List.of(ImageSubmitted.builder().metadataId(id).s3KeyOriginal(s3KeyOriginal).build()));

    return metadata;
  }
}
