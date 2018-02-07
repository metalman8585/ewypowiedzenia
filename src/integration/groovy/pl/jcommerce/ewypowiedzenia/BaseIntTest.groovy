package pl.jcommerce.ewypowiedzenia

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
abstract class BaseIntTest extends Specification {

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

}
