package trackconversion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import trackconversion.model.dao.*;
import trackconversion.model.dto.Events;
import trackconversion.model.dto.NationalLocation;
import trackconversion.model.dto.TrackLocation;
import trackconversion.service.TrackInfoService;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/tc")
public class TrackController {

    private final TrackLocationRepository trackLocationRepository;

    private final EventsRepository eventsRepository;

    private final NationalLocationRepository nationalLocationRepository;

    private final TrackLocationDao trackLocationDao;

    private final TrackInfoService trackInfoService;

    private final EventsDao eventsDao;


    @Autowired
    public TrackController(TrackLocationRepository trackLocationRepository, EventsRepository eventsRepository, NationalLocationRepository nationalLocationRepository, TrackLocationDao trackLocationDao, TrackInfoService trackInfoService, EventsDao eventsDao) {
        this.trackLocationRepository = trackLocationRepository;
        this.eventsRepository = eventsRepository;
        this.nationalLocationRepository = nationalLocationRepository;
        this.trackLocationDao = trackLocationDao;
        this.trackInfoService = trackInfoService;
        this.eventsDao = eventsDao;
}

    @GetMapping("tracks")
    public List<TrackLocation> getAllTracks(){
        return trackLocationRepository.getAllTracks();
    }

    @GetMapping("events")
    public List<Events> getAllEvents(){
        return eventsRepository.getAllEvents();
    }

    @RequestMapping(value = "/tracklocation", method = RequestMethod.GET)
    public List<TrackLocation> getTrackLocationInfo(@RequestParam String schoolName){
        return trackLocationDao.getInfoBySchoolName(schoolName);
    }

    @RequestMapping(value = "/eventinfo", method = RequestMethod.GET)
    public List<Events> getEventInfo(@RequestParam String eventName){
        return eventsDao.getInfoBySchoolName(eventName);
    }

    @RequestMapping(value = "/nationallocation", method = RequestMethod.GET)
    public List<NationalLocation> getNationalLocation(){
        return nationalLocationRepository.getNationalLocation();
    }

    @RequestMapping(value = "/timecalculation", method = RequestMethod.GET)
    public String getTimeConversionsByInfo(@RequestParam String gender, @RequestParam String schoolName, @RequestParam String eventName, @RequestParam String trackVersion, @RequestParam BigDecimal minutes, @RequestParam BigDecimal seconds, @RequestParam BigDecimal milliseconds){
        HashMap<String, String> timeConversions = trackInfoService.completedTimeConversions(gender, schoolName, eventName, trackVersion, minutes, seconds, milliseconds);
        return trackInfoService.singleConversion(timeConversions, schoolName, trackVersion, gender);
    }
}
