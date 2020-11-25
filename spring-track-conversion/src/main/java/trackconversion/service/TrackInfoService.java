package trackconversion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trackconversion.helper.TrackHelper;
import trackconversion.model.dao.EventsDao;
import trackconversion.model.dao.NationalLocationRepository;
import trackconversion.model.dao.TrackLocationDao;
import trackconversion.model.dto.Events;
import trackconversion.model.dto.NationalLocation;
import trackconversion.model.dto.TrackLocation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TrackInfoService {

    @Autowired
    private EventsDao eventsDao;

    @Autowired
    private TrackLocationDao trackLocationDao;

    @Autowired
    private TrackHelper trackHelper;

    @Autowired
    private NationalLocationRepository nationalLocationRepository;

    public HashMap<String, String> completedTimeConversions(String gender, String schoolName, String eventName, String trackVersion, BigDecimal minutes, BigDecimal seconds, BigDecimal milliseconds){
        //initializations
        HashMap <String, String> completedTimes = new HashMap<String, String>();


        //handle nulls
        minutes = trackHelper.nullToBigDecimal(minutes);
        seconds = trackHelper.nullToBigDecimal(seconds);
        milliseconds = trackHelper.nullToBigDecimal(milliseconds);

        //call to do raw calculations
        HashMap <String, BigDecimal> rawTimeConversion = calculateTimeConversions(gender, schoolName, eventName, trackVersion, minutes, seconds, milliseconds);

        //trim calculated times
        completedTimes = trackHelper.trimCalculatedTimes(rawTimeConversion);

        return completedTimes;
    }


    public HashMap<String, BigDecimal> calculateTimeConversions(String gender, String schoolName, String eventName, String trackVersion, BigDecimal minutes, BigDecimal seconds, BigDecimal milliseconds){

        //initializations
        Events event;
        TrackLocation trackLocation;
        BigDecimal cityConversion;
        BigDecimal secondsInMinute = new BigDecimal("60");
        BigDecimal totalTime = minutes.multiply(secondsInMinute).add(seconds).add(milliseconds.divide(BigDecimal.valueOf(100)));
        HashMap<String, BigDecimal> timeConversions = new HashMap<String, BigDecimal>();


        //pull in event and track information
        event = eventsDao.getInfoBySchoolName(eventName).get(0);
        trackLocation = trackLocationDao.getInfoBySchoolName(schoolName).get(0);



        if(gender.equals("Male")) {
            if (trackLocation.getAltitude() > 3000) {
                if(trackVersion == "Indoor"){
                    cityConversion = trackLocation.getMen_conversion_indoor();
                } else{
                    cityConversion = trackLocation.getMen_conversion_outdoor();
                }


                timeConversions.put("default", totalTime.multiply(cityConversion));
                timeConversions.put("men_u2f", totalTime.multiply(event.getMen_u2f().multiply(cityConversion)));
                timeConversions.put("men_bo2f", totalTime.multiply(event.getMen_bo2f().multiply(cityConversion)));
                timeConversions.put("men_u2bo", totalTime.multiply(event.getMen_u2bo().multiply(cityConversion)));
                timeConversions.put("men_f2bo", totalTime.multiply(event.getMen_f2bo().multiply(cityConversion)));

            } else{
                timeConversions.put("default", totalTime);
                timeConversions.put("men_u2f", totalTime.multiply(event.getMen_u2f()));
                timeConversions.put("men_bo2f", totalTime.multiply(event.getMen_bo2f()));
                timeConversions.put("men_u2bo", totalTime.multiply(event.getMen_u2bo()));
                timeConversions.put("men_f2bo", totalTime.multiply(event.getMen_f2bo()));

            }
        }else{
            if(trackLocation.getAltitude() > 3000){
                if(trackVersion == "Indoor"){
                    cityConversion = trackLocation.getWomen_conversion_indoor();
                } else{
                    cityConversion = trackLocation.getWomen_conversion_outdoor();
                }
                timeConversions.put("default", totalTime.multiply(cityConversion));
                timeConversions.put("women_u2f", totalTime.multiply(event.getWomen_u2f().multiply(cityConversion)));
                timeConversions.put("women_bo2f", totalTime.multiply(event.getWomen_bo2f().multiply(cityConversion)));
                timeConversions.put("women_u2bo", totalTime.multiply(event.getWomen_u2bo().multiply(cityConversion)));
                timeConversions.put("women_f2bo", totalTime.multiply(event.getWomen_f2bo().multiply(cityConversion)));
            } else{
                timeConversions.put("default", totalTime);
                timeConversions.put("women_u2f", totalTime.multiply(event.getWomen_u2f()));
                timeConversions.put("women_bo2f", totalTime.multiply(event.getWomen_bo2f()));
                timeConversions.put("women_u2bo", totalTime.multiply(event.getWomen_u2bo()));
                timeConversions.put("women_f2bo", totalTime.multiply(event.getWomen_f2bo()));
            }
        }

        return timeConversions;
    }


    public String singleConversion(HashMap<String, String> timeConversions, String schoolName, String trackVersion, String gender){

        //initialize
        String trackType = "";

        //pull national location and track location information
        NationalLocation nationalLocation = nationalLocationRepository.getNationalLocation().get(0);
        TrackLocation trackLocation = trackLocationDao.getInfoBySchoolName(schoolName).get(0);

        //Get type for track location
        if(trackVersion.equals("Indoor"))
            trackType = trackLocation.getIndoor_type();
        else if(trackVersion.equals("Outdoor"))
            trackType = trackLocation.getOutdoor_type();


        String genderString = trackHelper.genderRename(gender);


        if(nationalLocation.getLocation_type().equals(trackType)){
            return timeConversions.get("default");
        }else if(trackType.equals("u") && nationalLocation.getLocation_type().equals("f")){
            return timeConversions.get(genderString + "_u2f");
        }else if(trackType.equals("bo") && nationalLocation.getLocation_type().equals("f")){
            return timeConversions.get(genderString + "_bo2f");
        }else if(trackType.equals("u") && nationalLocation.getLocation_type().equals("bo")){
            return timeConversions.get(genderString + "_u2bo");
        }else if(trackType.equals("f") && nationalLocation.getLocation_type().equals("bo")){
            return timeConversions.get(genderString + "_f2bo");
        } else
            return "Error computing national conversion";

    }
}
