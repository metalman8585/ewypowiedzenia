package pl.jcommerce.ewypowiedzenia.api

import org.springframework.http.MediaType
import pl.jcommerce.ewypowiedzenia.BaseIntSpec
import pl.jcommerce.ewypowiedzenia.infrastructure.DismissalNoticeDto

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class DismissalNoticeControllerIntSpec extends BaseIntSpec {

    def "should create dismissal notice"() {
        given:
        def dismissalNoticeDto = new DismissalNoticeDto()

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
