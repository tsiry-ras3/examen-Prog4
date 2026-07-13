package hei.school.examen.service;

import hei.school.examen.entity.ImageMetadata;
import hei.school.examen.entity.ImageMetadataRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindAllSubmissionsService {

  private final ImageMetadataRepository repository;

  public List<ImageMetadata> execute() {
    return repository.findAll();
  }
}
