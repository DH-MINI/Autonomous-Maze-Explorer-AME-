package testWeb.vo;


public class CarInfo {

    private Integer carId;
    private String carName;
    private String carImg;

    private String username;

    public CarInfo() {
    }

    public CarInfo(Integer carId, String carName, String carImg) {
        this.carId = carId;
        this.carName = carName;
        this.carImg = carImg;
    }

    public CarInfo(String carName, String carImg, String username) {
        this.carName = carName;
        this.carImg = carImg;
        this.username = username;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarImg() {
        return carImg;
    }

    public void setCarImg(String carImg) {
        this.carImg = carImg;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
