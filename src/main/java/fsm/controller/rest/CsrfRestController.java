package fsm.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import fsm.model.domain.City;
import fsm.model.domain.Country;
import fsm.service.CountryService;
import fsm.util.JsonFilter;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/csrfToken")
public class CsrfRestController {

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getCsrfToken(HttpServletRequest request) throws JsonProcessingException {

        System.out.println("********************************* Taken ***************************************");

        CsrfToken csrfToken = (CsrfToken) request.getAttribute("_csrf");
        String[] propsToBeIgnored = {};
        return JsonFilter.filter(csrfToken, propsToBeIgnored);
    }
}
