package pl.jcommerce.ewypowiedzenia.api

import org.springframework.http.MediaType
import pl.jcommerce.ewypowiedzenia.BaseIntSpec
import pl.jcommerce.ewypowiedzenia.infrastructure.AddressDto
import pl.jcommerce.ewypowiedzenia.infrastructure.DismissalNoticeDto

import java.time.LocalDate

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class DismissalNoticeControllerIntSpec extends BaseIntSpec {

    def "should create dismissal notice"() {
        given:
        def dismissalNoticeDto = new DismissalNoticeDto(firstName: "Adam", lastName: "Kowalski",
                homeAddress: new AddressDto(street: "Armii Czerwonej 5/7", postalCode: "41-506", city: "Chorzów"),
                companyName: "JanuszeBiznesu",
                companyAddress: new AddressDto(street: "Jaruzelskiego 351", postalCode: "40-600", city: "Katowice"),
                agreementDate: LocalDate.of(2017, 1, 2),
                dismissalPlace: "Katowice", dismissalDate: LocalDate.now(), dismissalPeriod: 3)

        when:
        def response = performRequest(post("/generate", dismissalNoticeDto)
                .content(toJson(dismissalNoticeDto))
                .contentType(MediaType.APPLICATION_JSON))

        then:
        response.andExpect(status().isCreated())
    }

    def "should download file"() {
        given:
        def id = 1L

        when:
        def response = performRequest(get("/download/" + id))

        then:
        response.andExpect(status().isOk())
    }

}
