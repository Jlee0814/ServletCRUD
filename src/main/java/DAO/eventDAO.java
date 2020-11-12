package DAO;

import Utils.DBUtil;
import entity.event;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class eventDAO {

    private Connection jdbcConnection;

    DBUtil dbUtil = new DBUtil();

    public boolean insertEvent(event e) throws SQLException {
        String sql = "INSERT INTO event (name, location) VALUES (?,?)";
        jdbcConnection=dbUtil.getConnection();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, e.getName());
        statement.setString(2,e.getLocation());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();

        return rowInserted;
    }

    public List<event> listAllEvents() throws SQLException {
        List<event> listevent= new ArrayList<>();

        String sql = "SELECT * FROM event";

        jdbcConnection=dbUtil.getConnection();
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("event_id");
            String name = resultSet.getString("name");
            String location = resultSet.getString("location");

            event e = new event(id,name,location);
            listevent.add(e);
        }

        resultSet.close();
        statement.close();


        return listevent;
    }

    public boolean deleteEvent(event e) throws SQLException {
        String sql = "DELETE FROM event where event_id = ?";

        jdbcConnection=dbUtil.getConnection();
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, e.getId());

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();

        return rowDeleted;
    }

    public boolean updateEvent(event e) throws SQLException {
        String sql = "UPDATE event SET name = ?, location = ?";
        sql += " WHERE event_id = ?";

        jdbcConnection=dbUtil.getConnection();
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, e.getName());
        statement.setString(2, e.getLocation());
        statement.setInt(3, e.getId());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();

        return rowUpdated;
    }

    public event getEvent(int id) throws SQLException {
        event e = null;
        String sql = "SELECT * FROM event WHERE event_id = ?";

        jdbcConnection=dbUtil.getConnection();
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {

            String name = resultSet.getString("name");
            String location = resultSet.getString("location");

            e = new event(id,name,location);
        }

        resultSet.close();
        statement.close();

        return e;
    }
}
