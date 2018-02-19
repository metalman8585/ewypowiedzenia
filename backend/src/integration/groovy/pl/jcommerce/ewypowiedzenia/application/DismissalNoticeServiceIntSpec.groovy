package pl.jcommerce.ewypowiedzenia.api

import com.google.common.io.Files
import pl.jcommerce.ewypowiedzenia.BaseIntSpec
import pl.jcommerce.ewypowiedzenia.application.DismissalNoticeService
import pl.jcommerce.ewypowiedzenia.infrastructure.DismissalNoticeDto

class DismissalNoticeServiceIntSpec extends BaseIntSpec {

    private static String dismissalNoticeSampleFilename = 'target/sample_dismissal_notice.pdf'

    def service = new DismissalNoticeService()

    def "should generate dismissal notice pdf"() {
        given:
        def file = new File(dismissalNoticeSampleFilename)
        def dismissalNoticeDto = new DismissalNoticeDto()

        when:
        def pdfDto = service.generate(dismissalNoticeDto)

        then:
        pdfDto.filenameWithExtension == "dismissal-notice.pdf"
        pdfDto.mimeType == "application/octet-stream"
        Files.write(pdfDto.content, file)
    }

    def "should return file dto"() {
        given:
        def id = 1L

        when:
        def pdfDto = service.getFile(id)

        then:
        pdfDto.filenameWithExtension == "dismissal-notice.pdf"
        pdfDto.mimeType == "application/octet-stream"
    }

}