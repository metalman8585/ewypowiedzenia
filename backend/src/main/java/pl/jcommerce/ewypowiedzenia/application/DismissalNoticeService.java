package pl.jcommerce.ewypowiedzenia.application;

import lombok.SneakyThrows;
import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriUtils;
import pl.jcommerce.ewypowiedzenia.infrastructure.DismissalNoticeDto;
import pl.jcommerce.ewypowiedzenia.infrastructure.FileDto;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

@Service
public class DismissalNoticeService {

    private static final String XSLT_FILE = "dismissal-notice.xsl";

    private final FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());

    @SneakyThrows({IOException.class, FOPException.class, TransformerException.class, JAXBException.class})
    public FileDto generate(DismissalNoticeDto dismissalNoticeDto) {

        FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);

            TransformerFactory factory = TransformerFactory.newInstance();
            Resource xslt = new ClassPathResource(XSLT_FILE);
            Transformer transformer = factory.newTransformer(new StreamSource(xslt.getInputStream()));

            String xml = serializeObject(dismissalNoticeDto);
            ByteArrayInputStream in = new ByteArrayInputStream(xml.getBytes());
            StreamSource src = new StreamSource(in);

            Result res = new SAXResult(fop.getDefaultHandler());

            transformer.transform(src, res);
        } finally {
            out.close();
        }

        return FileDto.builder()
                .filenameWithExtension("dismissal-notice.pdf")
                .mimeType("application/octet-stream")
                .content(out.toByteArray())
                .build();
    }

    public FileDto getFile(Long id) {
        return FileDto.builder()
                .filenameWithExtension("dismissal-notice.pdf")
                .mimeType("application/octet-stream")
                .build();
    }

    @SneakyThrows(UnsupportedEncodingException.class)
    public String encodeFilename(FileDto fileDto) {
        return UriUtils.encode(fileDto.getFilenameWithExtension(), StandardCharsets.UTF_8.name());
    }

    private String serializeObject(DismissalNoticeDto dismissalNoticeDto) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(DismissalNoticeDto.class);
        Marshaller marshaller = context.createMarshaller();
        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(dismissalNoticeDto, stringWriter);
        return stringWriter.toString();
    }

}
