package testWeb.vo;

import java.util.Date;


public class CarTestInfo {

    private Integer carTestId;
    private Date carTestDate;
    private String carName;
    private Integer treasureNum;


    private Integer carId;

    public CarTestInfo() {
    }



    public CarTestInfo(Integer carTestId, Date carTestDate, Integer treasureNum) {
        this.carTestId = carTestId;
        this.carTestDate = carTestDate;
        this.treasureNum = treasureNum;
    }


    public CarTestInfo(Date carTestDate, String carName, Integer treasureNum, Integer carId) {
        this.carTestDate = carTestDate;
        this.carName = carName;
        this.treasureNum = treasureNum;
        this.carId = carId;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Integer getCarTestId() {
        return carTestId;
    }

    public void setCarTestId(Integer carTestId) {
        this.carTestId = carTestId;
    }

    public CarTestInfo(Integer carTestId, Date carTestDate, String carName, Integer treasureNum) {
        this.carTestId = carTestId;
        this.carTestDate = carTestDate;
        this.carName = carName;
        this.treasureNum = treasureNum;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Date getCarTestDate() {
        return carTestDate;
    }

    public void setCarTestDate(Date carTestDate) {
        this.carTestDate = carTestDate;
    }

    public Integer getTreasureNum() {
        return treasureNum;
    }

    public void setTreasureNum(Integer treasureNum) {
        this.treasureNum = treasureNum;
    }
}
