package calories.tracker.app.controllers;

import calories.tracker.app.dto.DriveDTO;
import calories.tracker.app.dto.DrivesDTO;
import calories.tracker.app.dto.SearchDriveDTO;
import calories.tracker.app.model.Drive;
import calories.tracker.app.model.SearchResult;
import calories.tracker.app.services.DriveService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * Created by alex on 15.30.12.
 */
@Controller
@RequestMapping("drive")
public class DriveController {
    Logger LOGGER = Logger.getLogger(DriveController.class);

    @Autowired
    private DriveService driveService;

//    @ResponseBody
//    @ResponseStatus(HttpStatus.OK)
//    @RequestMapping(method = RequestMethod.GET)
//    public DrivesDTO searchDrives() {
//
//
//        SearchResult<Drive> result = driveService.findLocalities();
//
//        Long resultsCount = result.getResultsCount();
//
//        return new DrivesDTO(DriveDTO.mapFromDrivesEntities(result.getResult()));
//    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.POST)
    public void saveDrive(Principal principal, @RequestBody DriveDTO driveDTO) {
        try {
            driveService.saveDrive(principal.getName(), driveDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteDrive(Principal principal, @RequestBody Long driveId) {
        try {
            driveService.deleteDrive(principal.getName(), driveId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET, value = "dr")
    public DriveDTO getDrive() {


        SearchResult<Drive> result = driveService.findDrives();

        return DriveDTO.mapFromDriveEntity(result.getResult().get(0));
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.POST, value = "find")
    public DrivesDTO findDrives(@RequestBody SearchDriveDTO dto) {


        SearchResult<Drive> result = driveService.findDrives(dto.getFrom(), dto.getTo());

        return DrivesDTO.mapFromDrivesEntities(result.getResult());
    }

}
