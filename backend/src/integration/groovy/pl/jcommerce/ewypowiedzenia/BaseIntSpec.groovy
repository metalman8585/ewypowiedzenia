package pl.jcommerce.ewypowiedzenia

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import spock.lang.Shared
import spock.lang.Specification

@ContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
abstract class BaseIntSpec extends Specification {

    static final ObjectMapper jsonMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

    @Autowired
    WebApplicationContext context

    @Shared
    MockMvc client

    def setup() {
        client = MockMvcBuilders.webAppContextSetup(context).build()
    }

    def performRequest(MockHttpServletRequestBuilder requestBuilder) {
        client.perform(requestBuilder)
    }

    def toJson(def object) {
        jsonMapper.writeValueAsString(object)
    }

}
