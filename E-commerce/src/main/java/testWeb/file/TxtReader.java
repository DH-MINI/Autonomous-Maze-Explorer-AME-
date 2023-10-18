package testWeb.file;

import testWeb.vo.TestTxtInfo;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


public class TxtReader {


    public List<TestTxtInfo> read(String filepath) throws IOException, ParseException {


        FileInputStream fileInputStream = new FileInputStream(filepath);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        String str = null;

        //日期格式化（可以通过此类完成字符串格式的日期转为Date类型的日期）
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        ArrayList<TestTxtInfo> txtInfos = new ArrayList<>();
        while ( (str = bufferedReader.readLine()) != null) {
            String[] strings = str.split(" ");//根据空格进行切割
            String startTimeStr = strings[0];//实验开始时间
            String endTimeStr = strings[1];//实验结束时间
            String treasureType = strings[2];//宝藏类型
            //计算实验持续时间
            long startTimeLong = 0;
            if (null != startTimeStr && !"".equals(startTimeStr)) {
                Date startTime = simpleDateFormat.parse(startTimeStr);
                startTimeLong = startTime.getTime();
            }
            long endTimeLong = 0;
            if (null != endTimeStr && !"".equals(endTimeStr)) {
                Date endTime = simpleDateFormat.parse(endTimeStr);
                endTimeLong = endTime.getTime();
            }
            long duration = (endTimeLong - startTimeLong)/1000;
            //将毫秒时间转换为时分秒字符串，以便于展示
//            String durationStr = convertMillisecondsToHMS(duration);


            startTimeStr = simpleDateFormat2.format(new Date(startTimeLong));
            endTimeStr = simpleDateFormat2.format(new Date(endTimeLong));

            TestTxtInfo testTxtInfo = new TestTxtInfo(startTimeStr, endTimeStr, duration+"", treasureType);
            txtInfos.add(testTxtInfo);


        }

        return txtInfos;
    }

    public String convertMillisecondsToHMS(long milliseconds) {
        long seconds = milliseconds / 1000;

        long hours = seconds / 3600;
        long remainder = seconds % 3600;

        long minutes = remainder / 60;
        long secs = remainder % 60;

        return String.format("%02d:%02d:%02d", hours, minutes, secs);
    }


}
