INSERT INTO client (name) VALUES
    ('Alice'), ('Bob'), ('Charlie'), ('David'), ('Eva'),
    ('Frank'), ('Grace'), ('Hannah'), ('Ivy'), ('Jack');

INSERT INTO planet (id, name) VALUES
    ('MARS', 'Mars'),
    ('VEN', 'Venus'),
    ('EARTH', 'Earth'),
    ('JUP', 'Jupiter'),
    ('SAT', 'Saturn');

INSERT INTO ticket (client_id, from_planet_id, to_planet_id) VALUES
    (1, 'EARTH', 'MARS'), (2, 'VEN', 'JUP'), (3, 'EARTH', 'SAT'),
    (4, 'JUP', 'VEN'), (5, 'SAT', 'EARTH'), (6, 'VEN', 'EARTH'),
    (7, 'EARTH', 'MARS'), (8, 'MARS', 'VEN'), (9, 'JUP', 'SAT'),
    (10, 'SAT', 'JUP');