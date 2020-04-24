

-- Table structure for table `Song`

CREATE TABLE `Song` (
  title varchar(120) COLLATE utf8_bin NOT NULL,
  artist varchar(100) COLLATE utf8_bin NOT NULL,
  album varchar(120) COLLATE utf8_bin NOT NULL,
  genre varchar(20) COLLATE utf8_bin NOT NULL,
  length time NOT NULL,
  releaseyear int(4) NOT NULL
) DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- data for table `Song`

INSERT INTO Song (title, artist, album, genre, length, releaseyear) VALUES
('Toosie Slide', 'Drake', 'Toosie Slide', 'Trap', '00:04:07', 2020),
('Blinding Lights', 'The Weekend', 'Blinding Lights', 'Synthwave', '00:03:22', 2019),
('The Box', 'Roddy Ricch', 'Please Excuse Me for Being Antisocial', 'Rap', '00:03:16', 2019),
('Don\'t Start Now', 'Dua Lipa', 'Don\'t Start Now', 'Pop', '00:03:03', 2019),
('Life Is Good', 'Future', 'Life Is Good', 'Trap', '00:03:58', 2020),
('Circles', 'Post Malone', 'Circles', 'Pop rock', '00:03:34', 2019),
('Adore You', 'Harry Styles', 'Adore You', 'Pop rock', '00:03:27', 2019),
('Say SO', 'Doja Cat', 'Hot Pink', 'R&B', '00:03:58', 2019),
('Intentions', 'Justin Bieber', 'Changes', 'R&B', '00:03:32', 2020),
('Everything I Wanted', 'Billie Eilish', 'When We All Fall Asleep, Where Do We Go?', 'Pop', '00:04:05', 2019);

-- Example Queries

SELECT * FROM Song

SELECT * FROM Song WHERE album='N/A';

SELECT * FROM Song WHERE length > '00:04:00';

SELECT * FROM Song WHERE length > '00:03:00' AND length < '00:03:30';

SELECT * FROM Song WHERE [releaseyear]='2019';

SELECT * FROM Song WHERE genre = 'Pop';

SELECT * FROM Song WHERE genre = 'Pop' AND length < '00:03:40';
