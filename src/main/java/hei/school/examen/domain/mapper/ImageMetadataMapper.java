package hei.school.examen.domain.mapper;

import hei.school.examen.entity.ImageMetadata;
import hei.school.examen.repository.model.JImageMetadata;
import org.springframework.stereotype.Component;

@Component
public class ImageMetadataMapper {

  public JImageMetadata toEntity(ImageMetadata metadata) {
    return JImageMetadata.builder()
        .id(metadata.getId())
        .fileName(metadata.getFileName())
        .email(metadata.getEmail())
        .s3UrlBw(metadata.getS3UrlBw())
        .createdAt(metadata.getCreatedAt())
        .build();
  }

  public ImageMetadata toDomain(JImageMetadata entity) {
    return ImageMetadata.builder()
        .id(entity.getId())
        .fileName(entity.getFileName())
        .email(entity.getEmail())
        .s3UrlBw(entity.getS3UrlBw())
        .createdAt(entity.getCreatedAt())
        .build();
  }
}
