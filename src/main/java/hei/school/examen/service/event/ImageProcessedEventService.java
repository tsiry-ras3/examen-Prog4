package hei.school.examen.service.event;

import hei.school.examen.endpoint.event.model.ImageProcessedEvent;
import hei.school.examen.mail.Email;
import hei.school.examen.mail.Mailer;
import jakarta.mail.internet.InternetAddress;
import java.util.List;
import java.util.function.Consumer;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ImageProcessedEventService implements Consumer<ImageProcessedEvent> {
  private final Mailer mailer;

  @SneakyThrows
  @Override
  public void accept(ImageProcessedEvent event) {
    InternetAddress recipientAddress = new InternetAddress(event.getTo());
    String body =
        "Your image \""
            + event.getFileName()
            + "\" has been processed. You can download it here: "
            + event.getS3Url();

    mailer.accept(
        new Email(recipientAddress, List.of(), List.of(), "Your image is ready", body, List.of()));
  }
}
