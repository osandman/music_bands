package net.osandman.db_service;

import net.osandman.util.DbManager;

import java.sql.*;
import java.util.*;

public class AlbumsDao {
    private static final String ALBUMS_SQL = """
            SELECT band.name AS band_name, album.name AS album_name, album.year
            FROM album
            INNER JOIN band ON album.band_id = band.band_id
            WHERE band.name LIKE ?
            ORDER BY band_name, year;
            """;

    public AlbumsDao() {
    }

    public Map<String, String> getAlbums(String bandName) {
        try (Connection connection = DbManager.getConnection()) {
            return findByBandName(connection, bandName);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Map<String, String> findByBandName(Connection connection, String bandName) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(ALBUMS_SQL)) {
            preparedStatement.setString(1, "%" + bandName + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            Map<String, String> albumsByBand = new LinkedHashMap<>();
            while (resultSet.next()) {
                albumsByBand.put(resultSet.getString("album_name") +
                                 " (" + resultSet.getString("year") + ")",
                        resultSet.getString("band_name"));
            }
            return albumsByBand;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
