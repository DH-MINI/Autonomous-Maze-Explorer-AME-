package testWeb.dao;

import testWeb.vo.CarTestInfo;

import java.sql.SQLException;


public interface ICarTestDAO {
    /**
     * 通过小车ID获取小车测试数据
     * @param carId
     * @return
     */
    CarTestInfo findCarTestInfoByCarId(Integer carId) throws SQLException;

    void addCarTest(CarTestInfo carTestInfo) throws SQLException;
}
