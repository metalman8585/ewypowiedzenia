package pl.jcommerce.ewypowiedzenia.api

import com.google.common.io.Files
import pl.jcommerce.ewypowiedzenia.BaseIntSpec
import pl.jcommerce.ewypowiedzenia.application.DismissalNoticeService
import pl.jcommerce.ewypowiedzenia.infrastructure.AddressDto
import pl.jcommerce.ewypowiedzenia.infrastructure.DismissalNoticeDto

import java.time.LocalDate

class DismissalNoticeServiceIntSpec extends BaseIntSpec {

    private static String dismissalNoticeSampleFilename = 'target/sample_dismissal_notice.pdf'

    def service = new DismissalNoticeService()

    def "should generate dismissal notice pdf"() {
        given:
        def file = new File(dismissalNoticeSampleFilename)
        def dismissalNoticeDto = new DismissalNoticeDto(firstName: "Adam", lastName: "Kowalski",
                homeAddress: new AddressDto(street: "Armii Czerwonej 5/7", postalCode: "41-506", city: "Chorzów"),
                companyName: "JanuszeBiznesu",
                companyAddress: new AddressDto(street: "Jaruzelskiego 351", postalCode: "40-600", city: "Katowice"),
                agreementDate: LocalDate.of(2017, 1, 2),
                dismissalPlace: "Katowice", dismissalDate: LocalDate.now(), dismissalPeriod: 3)

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