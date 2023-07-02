SELECT band_id, name, year
FROM band
WHERE name = 'Led Zeppelin';

SELECT album_id, name, band_id, year
FROM album
WHERE band_id = 388;

SELECT *
FROM album
WHERE band_id = (SELECT band_id
                 FROM band
                 WHERE name LIKE 'Bea%lica');

SELECT band.name, album.name, album.year
FROM album
         INNER JOIN band ON album.band_id = band.band_id
WHERE band.name LIKE 'Child%'
ORDER BY band.name, year;


SELECT DISTINCT name, '2020-01-01'::DATE + floor(random() * 365)::integer AS Дата
FROM band
LIMIT 10;

SELECT band.name, count(album.name) as count
FROM band
         INNER JOIN album ON band.band_id = album.band_id
    AND band.name LIKE '%'
GROUP BY band.name
HAVING count(album.name) > 10
ORDER BY count DESC;

SELECT band.name, album.name
FROM band
         INNER JOIN album ON band.band_id = album.band_id
WHERE band.name LIKE ':%:%'
ORDER BY band.name;

SELECT b.name, p.name, p.year, p.comment
FROM band b
         INNER JOIN band_person bp ON b.band_id = bp.band_id
         INNER JOIN person p on bp.person_id = p.person_id
WHERE b.name LIKE ':%:'
ORDER BY b.name, p.year;