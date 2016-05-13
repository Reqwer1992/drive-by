package calories.tracker.app;

import calories.tracker.app.model.Locality;
import calories.tracker.app.model.SearchResult;
import calories.tracker.app.services.LocalityService;
import calories.tracker.config.root.RootContextConfig;
import calories.tracker.config.root.TestConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;

/**
 * Created by alex on 16.10.5.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
@ContextConfiguration(classes={TestConfiguration.class, RootContextConfig.class})
public class LocalityServiceTest {
    @Autowired
    LocalityService localityService;

    @Test
    public void testFindLocalities(){
        SearchResult<Locality> result = localityService.findLocalities("Rīga");
        assertTrue("Result not expected, total " + result.getResultsCount(),
                result.getResultsCount() == 1);
    }
}
