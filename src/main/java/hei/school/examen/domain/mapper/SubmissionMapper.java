package hei.school.examen.domain.mapper;

import hei.school.examen.endpoint.rest.dto.SubmissionListItemDTO;
import hei.school.examen.endpoint.rest.dto.SubmissionResponseDTO;
import hei.school.examen.entity.ImageMetadata;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class SubmissionMapper {

  public SubmissionResponseDTO toResponseDTO(ImageMetadata metadata) {
    return new SubmissionResponseDTO(metadata.getId(), metadata.getFileName(), metadata.getEmail());
  }

  public SubmissionListItemDTO toListItemDTO(ImageMetadata metadata) {
    return new SubmissionListItemDTO(
        metadata.getId(),
        metadata.getFileName(),
        metadata.getEmail(),
        metadata.getS3UrlBw(),
        metadata.getCreatedAt());
  }

  public List<SubmissionListItemDTO> toListItemDTOs(List<ImageMetadata> metadataList) {
    return metadataList.stream().map(this::toListItemDTO).toList();
  }
}
