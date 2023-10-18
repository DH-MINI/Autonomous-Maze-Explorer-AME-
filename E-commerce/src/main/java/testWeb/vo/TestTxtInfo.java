package testWeb.vo;

/**
 * @ClassName TestTxtInfo
 * @Description 从txt文本中读取的数据封装到此类中
 * @Author
 * @Date 2023/10/8 10:57
 * @Version V1.0
 **/
public class TestTxtInfo {

    /**
     * 实验开始时间
     */
    private String startTime;
    /**
     * 实验结束时间
     */
    private String endTime;
    /**
     * 实验持续时间
     */
    private String duration;
    /**
     * 宝藏类型
     */
    private String treasureType;

    public TestTxtInfo() {
    }

    public TestTxtInfo(String startTime, String endTime, String duration, String treasureType) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.duration = duration;
        this.treasureType = treasureType;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getTreasureType() {
        return treasureType;
    }

    public void setTreasureType(String treasureType) {
        this.treasureType = treasureType;
    }
}
