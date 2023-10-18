package testWeb.dao;

import testWeb.vo.*;

public interface UserDAO {
	public int queryByUserInfo (UserInfo userinfo) throws Exception;
	public int insert(UserInfo user) throws Exception;
	public void insertData(TestInfo testInfo) throws Exception;
}
