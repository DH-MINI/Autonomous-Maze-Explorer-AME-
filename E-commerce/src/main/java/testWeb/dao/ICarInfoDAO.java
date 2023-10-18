package testWeb.dao;

import testWeb.vo.CarInfo;

import java.sql.SQLException;
import java.util.List;


public interface ICarInfoDAO {

    /**
     * 查询所有小车信息
     * @return
     */
    List<CarInfo> findCarInfoList(String username) throws SQLException;

    void addCar(CarInfo carInfo) throws SQLException;
}
