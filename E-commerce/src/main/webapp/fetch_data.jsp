<%@ page import="java.sql.*" %>
<%@ page import="testWeb.db.DBConnect" %>
<%
  Connection connection = null;
  Statement statement = null;
  ResultSet resultSet = null;

  try {
    // 获取数据库连接
    connection = DBConnect.getConnection();
    statement = connection.createStatement();

    // 获取当前登录用户的信息
    Object username = request.getSession().getAttribute("username");
    if (username == null || "".equals(username.toString())) {
      response.sendRedirect("./exceptions.jsp");
    } else {
      // 使用预编译语句查询数据
      String sql = "SELECT * FROM testinfo WHERE username = ?";
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, username.toString());
      resultSet = preparedStatement.executeQuery();
%>
<table>
  <thead>
  <tr>
    <th>ID</th>
    <th>日期</th>
    <th>成功次数</th>
    <th>路线</th>
  </tr>
  </thead>
  <tbody>
  <% while (resultSet.next()) { %>
  <tr>
    <td><%= resultSet.getInt("t_id") %></td>
    <td><%= resultSet.getTimestamp("date").toLocalDateTime().toLocalDate() %></td>
    <td><%= resultSet.getInt("success") %></td>
    <td><%= resultSet.getString("route") %></td>
  </tr>
  <% } %>
  </tbody>
</table>
<%
    }
  } catch (SQLException e) {
    e.printStackTrace();
  } finally {
    // 关闭连接和结果集
    try {
      if (resultSet != null) {
        resultSet.close();
      }
      if (statement != null) {
        statement.close();
      }
      if (connection != null) {
        connection.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
%>
