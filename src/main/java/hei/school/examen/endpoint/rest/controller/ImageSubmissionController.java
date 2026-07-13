package hei.school.examen.endpoint.rest.controller;

import hei.school.examen.domain.mapper.SubmissionMapper;
import hei.school.examen.endpoint.rest.dto.SubmissionListItemDTO;
import hei.school.examen.endpoint.rest.dto.SubmissionResponseDTO;
import hei.school.examen.entity.ImageMetadata;
import hei.school.examen.service.FindAllSubmissionsService;
import hei.school.examen.service.SubmitImageService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@AllArgsConstructor
@RequestMapping("/submissions")
public class ImageSubmissionController {

  private final SubmitImageService submitImageService;
  private final FindAllSubmissionsService findAllSubmissionsService;
  private final SubmissionMapper mapper;

  @PostMapping
  public ResponseEntity<SubmissionResponseDTO> submit(
      @RequestParam("file") MultipartFile file, @RequestParam("email") String email) {

    ImageMetadata metadata = submitImageService.execute(file, email);
    return ResponseEntity.status(HttpStatus.ACCEPTED).body(mapper.toResponseDTO(metadata));
  }

  @GetMapping
  public ResponseEntity<List<SubmissionListItemDTO>> findAll() {
    List<ImageMetadata> metadataList = findAllSubmissionsService.execute();
    return ResponseEntity.ok(mapper.toListItemDTOs(metadataList));
  }
}