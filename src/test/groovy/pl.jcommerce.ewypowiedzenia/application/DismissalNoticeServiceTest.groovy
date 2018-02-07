package pl.jcommerce.ewypowiedzenia.application

import pl.jcommerce.ewypowiedzenia.infrastructure.FileDto
import spock.lang.Specification

class DismissalNoticeServiceTest extends Specification {

    def dismissalNoticeService = new DismissalNoticeService()

    def "should get file"() {
        given:
        def id = 1L

        when:
        def fileDto = dismissalNoticeService.getFile(id)

        then:
        fileDto.filenameWithExtension == "dismissal.pdf"
        fileDto.mimeType == "application/octet-stream"
    }

    def "should encode filename"() {
        given:
        def fileName = 'file #,name.pdf'
        def fileDto = FileDto.builder().filenameWithExtension(fileName).build()

        when:
        def encodedFileName = dismissalNoticeService.encodeFilename(fileDto)

        then:
        encodedFileName == 'file%20%23%2Cname.pdf'
    }

}
