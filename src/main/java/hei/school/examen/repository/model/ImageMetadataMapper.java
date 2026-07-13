package hei.school.examen.repository.model;

import hei.school.examen.entity.ImageMetadata;
import org.springframework.stereotype.Component;

@Component
public class ImageMetadataMapper {

  public ImageMetadata toDomain(JImageMetadata entity) {
    if (entity == null) {
      return null;
    }
    return ImageMetadata.builder()
        .id(entity.getId())
        .nomFichier(entity.getNomFichier())
        .email(entity.getEmail())
        .createdAt(entity.getCreatedAt())
        .build();
  }

  public JImageMetadata toEntity(ImageMetadata domain) {
    if (domain == null) {
      return null;
    }
    return JImageMetadata.builder()
        .id(domain.getId())
        .nomFichier(domain.getNomFichier())
        .email(domain.getEmail())
        .createdAt(domain.getCreatedAt())
        .build();
  }
}
