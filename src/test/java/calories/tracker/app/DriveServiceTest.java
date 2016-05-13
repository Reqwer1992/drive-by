package calories.tracker.app;

import calories.tracker.app.model.Drive;
import calories.tracker.app.model.SearchResult;
import calories.tracker.app.services.DriveService;
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
 * Created by alex on 15.31.12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
@ContextConfiguration(classes={TestConfiguration.class, RootContextConfig.class})
public class DriveServiceTest {

    @Autowired
    private DriveService driveService;

    @Test
    public void testGetDrives(){
        SearchResult<Drive> res = driveService.findDrives();
        assertTrue("Result not expected, total " + res.getResultsCount(), res.getResultsCount() == 3);
    }
}
