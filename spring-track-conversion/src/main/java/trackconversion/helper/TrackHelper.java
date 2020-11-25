package trackconversion.helper;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

@Service
public class TrackHelper {

    public BigDecimal nullToBigDecimal(BigDecimal integerInput){
        if(integerInput == null){
            return BigDecimal.valueOf(0);
        }
        return integerInput;
    }

    public HashMap<String, String> trimCalculatedTimes(HashMap<String, BigDecimal> untrimmedReturnTimes){
        HashMap<String,String> trimmedTimes = new HashMap<String, String>();

        for(Map.Entry<String,BigDecimal> time : untrimmedReturnTimes.entrySet()){
            BigDecimal minute = time.getValue().divide(BigDecimal.valueOf(60), 2, RoundingMode.DOWN);
            String displaySeconds;
            int intMinute = minute.toBigInteger().intValueExact();
            BigDecimal second = time.getValue().remainder(new BigDecimal(60));
            BigDecimal secondWithDecimal = second.setScale(3, RoundingMode.HALF_DOWN).stripTrailingZeros();
            BigDecimal test = secondWithDecimal.divide(BigDecimal.valueOf(1));

            if(test.compareTo(BigDecimal.valueOf(10)) < 0)
                displaySeconds = "0" + secondWithDecimal.toString();
            else
                displaySeconds = secondWithDecimal.toString();
            trimmedTimes.put(time.getKey(), intMinute + ":" + displaySeconds);
        }

        return trimmedTimes;
    }

    public String genderRename(String gender){
        String genderReturn = "";

        if(gender.equals("Male"))
            genderReturn = "men";
        else if(gender.equals("Female"))
            genderReturn = "women";

        return genderReturn;
    }


}
