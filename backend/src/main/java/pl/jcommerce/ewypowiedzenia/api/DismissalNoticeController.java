package pl.jcommerce.ewypowiedzenia.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.jcommerce.ewypowiedzenia.application.DismissalNoticeService;
import pl.jcommerce.ewypowiedzenia.infrastructure.DismissalNoticeDto;
import pl.jcommerce.ewypowiedzenia.infrastructure.FileDto;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class DismissalNoticeController {

    private final DismissalNoticeService dismissalNoticeService;

    @PostMapping("/generate")
    @ResponseStatus(code = HttpStatus.CREATED)
    public DismissalNoticeDto generate(@RequestBody DismissalNoticeDto dismissalNoticeDto) {
        dismissalNoticeService.generate(dismissalNoticeDto);
        return dismissalNoticeDto;
    }

    @GetMapping("/download/{id}")
    public HttpEntity download(@PathVariable("id") Long id) {
        FileDto fileDto = dismissalNoticeService.getFile(id);
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.valueOf(fileDto.getMimeType()));
        header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + dismissalNoticeService.encodeFilename(fileDto));
        byte[] content = fileDto.getContent();
        header.setContentLength(content != null ? content.length : 0);
        return new HttpEntity<>(content, header);
    }
}
