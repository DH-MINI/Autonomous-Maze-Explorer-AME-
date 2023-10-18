package testWeb.dao.impl;

import testWeb.dao.ICarInfoDAO;
import testWeb.db.DBConnect;
import testWeb.vo.CarInfo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CarInfoDAOImpl implements ICarInfoDAO {


    @Override
    public List<CarInfo> findCarInfoList(String username) throws SQLException {
        //查询所有数据的sql
        String sql = "SELECT * FROM tb_car_info where username=?";
        //获取数据库操作对象
        PreparedStatement preparedStatement = DBConnect.getConnection().prepareStatement(sql);
        preparedStatement.setString(1,username);
        //执行查询
        ResultSet resultSet = preparedStatement.executeQuery();
        //定义临时文件List，用于存储所有的CarInfo结果数据
        ArrayList<CarInfo> carInfos = new ArrayList<>();
        //循环遍历数据库读取出来的数据
        while (resultSet.next()){
            Integer carId = resultSet.getInt("car_id");
            String carName = resultSet.getString("car_name");
            String carImg = resultSet.getString("car_img");
            CarInfo carInfo = new CarInfo(carId, carName, carImg);
            //每一条CarInfo都存入List集合
            carInfos.add(carInfo);

        }
        return carInfos;
    }

    @Override
    public void addCar(CarInfo carInfo) throws SQLException {
        String sql = "INSERT INTO tb_car_info(car_name,car_img,username) VALUES(?,?,?)";
        PreparedStatement preparedStatement = DBConnect.getConnection().prepareStatement(sql);
        preparedStatement.setString(1,carInfo.getCarName());
        preparedStatement.setString(2,carInfo.getCarImg());
        preparedStatement.setString(3,carInfo.getUsername());
        preparedStatement.execute();
        preparedStatement.close();



    }
}
