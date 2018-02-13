package pl.jcommerce.ewypowiedzenia.api

import pl.jcommerce.ewypowiedzenia.BaseIntSpec

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class DismissalNoticeControllerIntSpec extends BaseIntSpec {

    def "should create dismissal notice"() {
        when:
        def response = performRequest(post("/generate"))

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
