package fsm.controller.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import fsm.util.JsonFilter;
import org.springframework.http.MediaType;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/csrfToken")
public class CsrfRestController {

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getCsrfToken(HttpServletRequest request) throws JsonProcessingException {
        CsrfToken csrfToken = (CsrfToken) request.getAttribute("_csrf");
        String[] propsToBeIgnored = {};
        return JsonFilter.filter(csrfToken, propsToBeIgnored);
    }
}
