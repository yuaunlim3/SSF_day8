package VTTP_ssf.day8.Service;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import VTTP_ssf.day8.Constants.Constants;
import VTTP_ssf.day8.Model.Carpark;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

@Service
public class CPService {
    private final Logger logger = Logger.getLogger(CPService.class.getName());
    RestTemplate restTemplate = new RestTemplate();
    public List<Carpark> getCarpark(){
        List<Carpark> carparkList = new ArrayList<>();
        try{
            RequestEntity<Void> req = RequestEntity
                    .get(Constants.carparkURL)
                    .accept(MediaType.APPLICATION_JSON)
                    .build();
            ResponseEntity<String> resp = restTemplate.exchange(req,String.class);
            String payload = resp.getBody();
            JsonReader reader = Json.createReader(new StringReader(payload));
            JsonObject jsonObject= reader.readObject();
            //logger.info("Whole data: %s\n".formatted(jsonObject.toString()));

            JsonArray records = jsonObject.getJsonObject("result").getJsonArray("records");

            for(int i = 0 ; i < records.size(); i++){
                JsonObject carparkInfo = records.getJsonObject(i);
                //logger.info("this is the CarparkInfo: %s\n".formatted(carparkInfo.toString()));
                Carpark carpark = new Carpark(carparkInfo.getInt("_id"),carparkInfo.getString("carpark"),carparkInfo.getString("weekdays_rate_1"),carparkInfo.getString("weekdays_rate_2"),carparkInfo.getString("saturday_rate"),
                carparkInfo.getString("sunday_publicholiday_rate")
                );
                carparkList.add(carpark);
            }

            return carparkList;
            


        }catch(Exception ex){
            ex.printStackTrace();
        }

        return null;
        
    }
}
