-- ============================================================
-- WEB3 Ticketer - DATOS DE PRUEBA PARA H2 EN MEMORIA
-- ============================================================
-- IMPORTANTE:
-- 1. Hibernate crea primero las tablas a partir de las @Entity.
-- 2. Este archivo se ejecuta después de crear el esquema porque
--    application-dev.properties tiene:
--      spring.jpa.defer-datasource-initialization=true
-- 3. El orden respeta todas las claves foráneas:
--      countries
--        -> cities
--           -> stadiums
--      music_genres
--        -> bands
--      ticket_categories
--        -> tickets
-- ============================================================

-- ============================================================
-- 1. COUNTRIES
-- ============================================================
INSERT INTO countries (name) VALUES ('Colombia');
INSERT INTO countries (name) VALUES ('Estados Unidos');
INSERT INTO countries (name) VALUES ('Reino Unido');
INSERT INTO countries (name) VALUES ('México');
INSERT INTO countries (name) VALUES ('Argentina');

-- ============================================================
-- 2. MUSIC_GENRES
-- ============================================================
INSERT INTO music_genres (name) VALUES ('Rock');
INSERT INTO music_genres (name) VALUES ('Pop');
INSERT INTO music_genres (name) VALUES ('Reggaeton');
INSERT INTO music_genres (name) VALUES ('Metal');
INSERT INTO music_genres (name) VALUES ('Electrónica');
INSERT INTO music_genres (name) VALUES ('Hip Hop');

-- ============================================================
-- 3. CITIES
-- ============================================================
INSERT INTO cities (name, country_id)
SELECT 'Bogotá', id FROM countries WHERE name = 'Colombia';

INSERT INTO cities (name, country_id)
SELECT 'Medellín', id FROM countries WHERE name = 'Colombia';

INSERT INTO cities (name, country_id)
SELECT 'Cali', id FROM countries WHERE name = 'Colombia';

INSERT INTO cities (name, country_id)
SELECT 'Nueva York', id FROM countries WHERE name = 'Estados Unidos';

INSERT INTO cities (name, country_id)
SELECT 'Los Ángeles', id FROM countries WHERE name = 'Estados Unidos';

INSERT INTO cities (name, country_id)
SELECT 'Londres', id FROM countries WHERE name = 'Reino Unido';

INSERT INTO cities (name, country_id)
SELECT 'Ciudad de México', id FROM countries WHERE name = 'México';

INSERT INTO cities (name, country_id)
SELECT 'Buenos Aires', id FROM countries WHERE name = 'Argentina';

-- ============================================================
-- 4. STADIUMS
-- ============================================================
INSERT INTO stadiums (name, city_id)
SELECT 'Estadio El Campín', id FROM cities WHERE name = 'Bogotá';

INSERT INTO stadiums (name, city_id)
SELECT 'Estadio Atanasio Girardot', id FROM cities WHERE name = 'Medellín';

INSERT INTO stadiums (name, city_id)
SELECT 'Arena Cañaveralejo', id FROM cities WHERE name = 'Cali';

INSERT INTO stadiums (name, city_id)
SELECT 'Madison Square Garden', id FROM cities WHERE name = 'Nueva York';

INSERT INTO stadiums (name, city_id)
SELECT 'SoFi Stadium', id FROM cities WHERE name = 'Los Ángeles';

INSERT INTO stadiums (name, city_id)
SELECT 'Wembley Stadium', id FROM cities WHERE name = 'Londres';

INSERT INTO stadiums (name, city_id)
SELECT 'Foro Sol', id FROM cities WHERE name = 'Ciudad de México';

INSERT INTO stadiums (name, city_id)
SELECT 'Movistar Arena Buenos Aires', id FROM cities WHERE name = 'Buenos Aires';

-- ============================================================
-- 5. TICKET_CATEGORIES
-- ============================================================
INSERT INTO ticket_categories (name, base_price) VALUES ('General', 120000.00);
INSERT INTO ticket_categories (name, base_price) VALUES ('Preferencial', 220000.00);
INSERT INTO ticket_categories (name, base_price) VALUES ('VIP', 450000.00);
INSERT INTO ticket_categories (name, base_price) VALUES ('Platinum', 700000.00);
INSERT INTO ticket_categories (name, base_price) VALUES ('Backstage', 1200000.00);

-- ============================================================
-- 6. BANDS
-- ============================================================
INSERT INTO bands (band_name, genre_id)
SELECT 'Soda Stereo', id FROM music_genres WHERE name = 'Rock';

INSERT INTO bands (band_name, genre_id)
SELECT 'Coldplay', id FROM music_genres WHERE name = 'Pop';

INSERT INTO bands (band_name, genre_id)
SELECT 'Metallica', id FROM music_genres WHERE name = 'Metal';

INSERT INTO bands (band_name, genre_id)
SELECT 'Rauw Alejandro', id FROM music_genres WHERE name = 'Reggaeton';

INSERT INTO bands (band_name, genre_id)
SELECT 'The Weeknd', id FROM music_genres WHERE name = 'Pop';

INSERT INTO bands (band_name, genre_id)
SELECT 'Daft Punk', id FROM music_genres WHERE name = 'Electrónica';

INSERT INTO bands (band_name, genre_id)
SELECT 'Foo Fighters', id FROM music_genres WHERE name = 'Rock';

INSERT INTO bands (band_name, genre_id)
SELECT 'Linkin Park', id FROM music_genres WHERE name = 'Rock';

INSERT INTO bands (band_name, genre_id)
SELECT 'Drake', id FROM music_genres WHERE name = 'Hip Hop';

-- ============================================================
-- 7. TICKETS / EVENTOS
-- ============================================================
INSERT INTO tickets (band_id, stadium_id, event_date, category_id)
SELECT b.id, s.id, TIMESTAMP '2026-09-20 20:00:00', c.id
FROM bands b
JOIN stadiums s ON s.name = 'Estadio El Campín'
JOIN ticket_categories c ON c.name = 'General'
WHERE b.band_name = 'Soda Stereo';

INSERT INTO tickets (band_id, stadium_id, event_date, category_id)
SELECT b.id, s.id, TIMESTAMP '2026-10-10 19:30:00', c.id
FROM bands b
JOIN stadiums s ON s.name = 'Wembley Stadium'
JOIN ticket_categories c ON c.name = 'VIP'
WHERE b.band_name = 'Coldplay';

INSERT INTO tickets (band_id, stadium_id, event_date, category_id)
SELECT b.id, s.id, TIMESTAMP '2026-11-15 21:00:00', c.id
FROM bands b
JOIN stadiums s ON s.name = 'Madison Square Garden'
JOIN ticket_categories c ON c.name = 'Platinum'
WHERE b.band_name = 'Metallica';

INSERT INTO tickets (band_id, stadium_id, event_date, category_id)
SELECT b.id, s.id, TIMESTAMP '2026-09-28 20:30:00', c.id
FROM bands b
JOIN stadiums s ON s.name = 'Estadio Atanasio Girardot'
JOIN ticket_categories c ON c.name = 'Preferencial'
WHERE b.band_name = 'Rauw Alejandro';

INSERT INTO tickets (band_id, stadium_id, event_date, category_id)
SELECT b.id, s.id, TIMESTAMP '2026-12-05 20:00:00', c.id
FROM bands b
JOIN stadiums s ON s.name = 'Foro Sol'
JOIN ticket_categories c ON c.name = 'VIP'
WHERE b.band_name = 'The Weeknd';

INSERT INTO tickets (band_id, stadium_id, event_date, category_id)
SELECT b.id, s.id, TIMESTAMP '2026-10-25 22:00:00', c.id
FROM bands b
JOIN stadiums s ON s.name = 'Estadio El Campín'
JOIN ticket_categories c ON c.name = 'General'
WHERE b.band_name = 'Daft Punk';

INSERT INTO tickets (band_id, stadium_id, event_date, category_id)
SELECT b.id, s.id, TIMESTAMP '2026-11-28 20:00:00', c.id
FROM bands b
JOIN stadiums s ON s.name = 'SoFi Stadium'
JOIN ticket_categories c ON c.name = 'Platinum'
WHERE b.band_name = 'Foo Fighters';

INSERT INTO tickets (band_id, stadium_id, event_date, category_id)
SELECT b.id, s.id, TIMESTAMP '2026-12-12 21:00:00', c.id
FROM bands b
JOIN stadiums s ON s.name = 'Madison Square Garden'
JOIN ticket_categories c ON c.name = 'VIP'
WHERE b.band_name = 'Linkin Park';

INSERT INTO tickets (band_id, stadium_id, event_date, category_id)
SELECT b.id, s.id, TIMESTAMP '2027-01-16 21:30:00', c.id
FROM bands b
JOIN stadiums s ON s.name = 'Movistar Arena Buenos Aires'
JOIN ticket_categories c ON c.name = 'Backstage'
WHERE b.band_name = 'Drake';

-- ============================================================
-- FIN DE LOS DATOS DE PRUEBA
-- ============================================================
