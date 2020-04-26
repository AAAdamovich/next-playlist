SELECT * FROM Song;

SELECT * FROM Song WHERE artist='Doja Cat';

SELECT * FROM Song WHERE album='Hot Pink';

SELECT * FROM Song WHERE length > '00:04:00';

SELECT * FROM Song WHERE length > '00:03:00' AND length < '00:03:30';

SELECT * FROM Song WHERE releaseyear='2019';

SELECT * FROM Song WHERE genre = 'Pop';

SELECT * FROM Song WHERE genre = 'Pop' AND length < '00:03:40';

SELECT * FROM Song WHERE genre = 'R&B';