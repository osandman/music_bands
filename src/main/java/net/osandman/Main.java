package net.osandman;

import net.osandman.db_service.AlbumsDao;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        new AlbumsDao().getAlbums("metall")
                .forEach((k, v) -> System.out.println(v + " " + k));
    }
}