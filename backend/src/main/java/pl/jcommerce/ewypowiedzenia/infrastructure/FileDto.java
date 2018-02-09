package pl.jcommerce.ewypowiedzenia.infrastructure;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Wither;

@Data
@Builder
public class FileDto {
    private final @Wither String filenameWithExtension;
    private final String mimeType;
    private final @Wither byte[] content;
}
