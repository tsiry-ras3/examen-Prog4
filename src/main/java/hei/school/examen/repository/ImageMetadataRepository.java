package hei.school.examen.repository;

import hei.school.examen.repository.model.JImageMetadata;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageMetadataRepository extends JpaRepository<JImageMetadata, UUID> {}
