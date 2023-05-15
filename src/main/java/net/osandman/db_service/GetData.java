package net.osandman.db_service;

import net.osandman.util.DbManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class GetData {
    public GetData() {
    }

    public Map<String, String> getAlbums(String bandName) {
        String queryAlbums = "SELECT band.name AS band_name, album.name AS album_name, album.year\n" +
                "FROM album\n" +
                "         INNER JOIN band ON album.band_id = band.band_id\n" +
                "WHERE band.name ILIKE '%" +
                bandName + "%'\n" +
                "ORDER BY band_name, year";
        Map<String, String> map = new LinkedHashMap<>();
        try (Statement statement = DbManager.getConnection().createStatement()) {
            statement.execute(queryAlbums);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                map.put(resultSet.getString("album_name"),
                        resultSet.getString("band_name"));
//                System.out.println(resultSet.getString("album_name"));
//                System.out.println(resultSet.getString("album.name"));
            }
            return map;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
