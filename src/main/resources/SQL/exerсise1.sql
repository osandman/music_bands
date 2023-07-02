SELECT band_id, name, year FROM band
WHERE name = 'Led Zeppelin';

SELECT album_id, name, band_id, year FROM album
WHERE band_id = 388
