package net.osandman;

import net.osandman.repository.AlbumsDao;
import net.osandman.util.DbManager;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        new AlbumsDao().getAlbums("metall")
                .forEach((k, v) -> System.out.println(v + " " + k));
        DbManager.closePool();
    }
}