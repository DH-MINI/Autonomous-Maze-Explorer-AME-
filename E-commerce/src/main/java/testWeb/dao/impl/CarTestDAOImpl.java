package testWeb.dao.impl;

import testWeb.dao.ICarTestDAO;
import testWeb.db.DBConnect;
import testWeb.vo.CarTestInfo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CarTestDAOImpl implements ICarTestDAO {

    @Override
    public CarTestInfo findCarTestInfoByCarId(Integer carId) throws SQLException {
        String sql = "SELECT * FROM tb_car_test_info JOIN tb_car_info on fk_car_id=car_id AND car_id=?";
        PreparedStatement preparedStatement = DBConnect.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1,carId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            int carTestId = resultSet.getInt("car_test_id");
            Date carTestDate = resultSet.getDate("test_date");
            int treasureNum = resultSet.getInt("treasure_num");
            String carName = resultSet.getString("car_name");
            CarTestInfo carTestInfo = new CarTestInfo(carTestId, carTestDate, carName,treasureNum);

            return carTestInfo;
        }
        //如果没有找到数据，则仅仅换回一个空的对象，并且传回carID为了新增功能
        CarTestInfo carTestInfo = new CarTestInfo();
        carTestInfo.setCarId(carId);
        return carTestInfo;
    }

    @Override
    public void addCarTest(CarTestInfo carTestInfo) throws SQLException {
        String sql = "INSERT INTO tb_car_test_info(test_date,treasure_num,fk_car_id) VALUES(?,?,?)";
        PreparedStatement preparedStatement = DBConnect.getConnection().prepareStatement(sql);
        preparedStatement.setDate(1,new Date(carTestInfo.getCarTestDate().getTime()));
        preparedStatement.setInt(2,carTestInfo.getTreasureNum());
        preparedStatement.setInt(3,carTestInfo.getCarId());
        preparedStatement.executeUpdate();
        preparedStatement.close();

    }
}
