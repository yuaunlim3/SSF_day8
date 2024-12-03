package VTTP_ssf.day8.Model;

public class Carpark {
    private Integer id;
    private String carpark;
    private String weekday1Rate;
    private String weekday2Rate;
    private String satRate;
    private String sunPHRate;

    @Override
    public String toString() {
        return "Carpark Infos: [id=" + id + ", carpark=" + carpark + ", weekday1Rate=" + weekday1Rate + ", weekday2Rate="
                + weekday2Rate + ", satRate=" + satRate + ", sunPHRate=" + sunPHRate + "]";
    }

    public Carpark(int id, String carpark, String weekday1Rate, String weekday2Rate, String satRate, String sunPHRate){
        this.id = id;
        this.carpark = carpark;
        this.weekday1Rate = weekday1Rate;
        this.weekday2Rate = weekday2Rate;
        this.satRate = satRate;
        this.sunPHRate = sunPHRate;
    }

    
    public String getCarpark() {
        return carpark;
    }
    public void setCarpark(String carpark) {
        this.carpark = carpark;
    }
    public String getWeekday1Rate() {
        return weekday1Rate;
    }
    public void setWeekday1Rate(String weekday1Rate) {
        this.weekday1Rate = weekday1Rate;
    }
    public String getWeekday2Rate() {
        return weekday2Rate;
    }
    public void setWeekday2Rate(String weekday2Rate) {
        this.weekday2Rate = weekday2Rate;
    }
    public String getSatRate() {
        return satRate;
    }
    public void setSatRate(String satRate) {
        this.satRate = satRate;
    }
    public String getSunPHRate() {
        return sunPHRate;
    }
    public void setSunPHRate(String sunPHRate) {
        this.sunPHRate = sunPHRate;
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }



    
}
