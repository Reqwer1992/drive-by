package calories.tracker.app.controllers;

import calories.tracker.app.dto.LocalitiesDTO;
import calories.tracker.app.model.Locality;
import calories.tracker.app.model.SearchResult;
import calories.tracker.app.services.LocalityService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by alex on 16.3.1.
 */
@Controller
@RequestMapping("autocomplete")
public class AutocompleteController {
    Logger LOGGER = Logger.getLogger(AutocompleteController.class);

    @Autowired
    private LocalityService localityService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public LocalitiesDTO autoComplete(@RequestParam(value = "predicate") String predicate) {

        SearchResult<Locality> result = localityService.findLocalities(predicate);
        return LocalitiesDTO.mapFromLocalityEntities(result.getResult());
    }
}
