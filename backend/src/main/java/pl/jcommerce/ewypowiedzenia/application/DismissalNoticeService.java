package pl.jcommerce.ewypowiedzenia.application;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriUtils;
import pl.jcommerce.ewypowiedzenia.infrastructure.FileDto;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

@Service
public class DismissalNoticeService {

    public FileDto getFile(Long id) {
        return FileDto.builder()
                .filenameWithExtension("dismissal.pdf")
                .mimeType("application/octet-stream")
                .build();
    }

    @SneakyThrows(UnsupportedEncodingException.class)
    public String encodeFilename(FileDto fileDto) {
        return UriUtils.encode(fileDto.getFilenameWithExtension(), StandardCharsets.UTF_8.name());
    }

}
