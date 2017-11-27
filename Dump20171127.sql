CREATE DATABASE  IF NOT EXISTS `booksManagement` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `booksManagement`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: testinstance.cgmvcwk4njr8.us-west-2.rds.amazonaws.com    Database: booksManagement
-- ------------------------------------------------------
-- Server version	5.6.35-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `books` (
  `book_id` int(11) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(45) NOT NULL,
  `author` varchar(45) NOT NULL,
  `publication_date` datetime DEFAULT NULL,
  `short_desc` varchar(300) DEFAULT NULL,
  `rating` int(11) DEFAULT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (1,'The Pilgrim\'s Progress','John Bunyan','1678-08-24 00:00:00','A story of a man in search of truth told with the simple clarity and beauty of Bunyan\'s prose make this the ultimate English classic.',5),(2,'Robinson Crusoe','Daniel Defoe','1719-05-12 00:00:00','By the end of the 19th century, no book in English literary history had enjoyed more editions, spin-offs and translations. Crusoe\'s world-famous novel is a complex literary confection, and it\'s irresistible.',4),(3,'Gulliver\'s Travels','Jonathan Swift','1726-12-24 00:00:00','A satirical masterpiece that\'s never been out of print, Jonathan Swift\'s Gulliver\'s Travels comes third in our list of the best novels written in English',5),(4,'Clarissa','Samuel Richardson','1748-10-31 00:00:00','Clarissa is a tragic heroine, pressured by her unscrupulous nouveau-riche family to marry a wealthy man she detests, in the book that Samuel Johnson described as the first book in the world for the knowledge it displays of the human heart.\"',3),(5,'Tom Jones','Henry Fielding','1749-10-12 00:00:00','Tom Jones is a classic English novel that captures the spirit of its age and whose famous characters have come to represent Augustan society in all its loquacious, turbulent, comic variety.',4),(6,'Emma','Jane Austen','1816-08-08 00:00:00','Jane Austen\'s Emma is her masterpiece, mixing the sparkle of her early books with a deep sensibility.',3),(7,'Frankenstein','Mary Shelley','1818-06-12 00:00:00','Mary Shelley\'s first novel has been hailed as a masterpiece of horror and the macabre.',2),(8,'Nightmare Abbey','Thomas Love Peacock','1818-05-21 00:00:00','The great pleasure of Nightmare Abbey, which was inspired by Thomas Love Peacock\'s friendship with Shelley, lies in the delight the author takes in poking fun at the romantic movement.',1),(9,'Sybil','Benjamin Disraeli','1845-05-08 00:00:00','The future prime minister displayed flashes of brilliance that equalled the greatest Victorian novelists.',5),(10,'Jane Eyre','Charlotte Bront','1847-02-14 00:00:00','Charlotte Bront\'s erotic, gothic masterpiece became the sensation of Victorian England. Its great breakthrough was its intimate dialogue with the reader.',3),(11,'Wuthering Heights','Emily Bront','1847-01-12 00:00:00','Emily Bront\'s windswept masterpiece is notable not just for its wild beauty but for its daring reinvention of the novel form itself.',4),(12,'Vanity Fair','William Thackeray','1848-06-21 00:00:00','William Thackeray\'s masterpiece, set in Regency England, is a bravura performance by a writer at the top of his game.',4),(13,'David Copperfield','Charles Dickens','1850-09-23 00:00:00','David Copperfield marked the point at which Dickens became the great entertainer and also laid the foundations for his later, darker masterpieces.',4),(14,'The Scarlet Letter','Nathaniel Hawthorne','1850-03-29 00:00:00','Nathaniel Hawthorne\'s astounding book is full of intense symbolism and as haunting as anything by Edgar Allan Poe.',5),(15,'Moby-Dick','Herman Melville','1851-11-12 00:00:00','Wise, funny and gripping, Melville\'s epic work continues to cast a long shadow over American literature.',4),(16,'Alice\'s Adventures in Wonderland','Lewis Carroll','1865-09-11 00:00:00','Lewis Carroll\'s brilliant nonsense tale is one of the most influential and best loved in the English canon.',3),(17,'The Moonstone','Wilkie Collins','1868-09-12 00:00:00','Wilkie Collins\'s masterpiece, hailed by many as the greatest English detective novel, is a brilliant marriage of the sensational and the realistic.',1),(18,'Little Women','Louisa May Alcott','1868-12-13 00:00:00','Louisa May Alcott\'s highly original tale aimed at a young female market has iconic status in America and never been out of print.',5),(19,'Middlemarch','George Eliot','1871-09-24 00:00:00','This cathedral of words stands today as perhaps the greatest of the great Victorian fictions.',5),(20,'The Way We Live Now','Anthony Trollope','1875-10-12 00:00:00','Inspired by the author\'s fury at the corrupt state of England, and dismissed by critics at the time, The Way We Live Now is recognised as Trollope\'s masterpiece.',3),(21,'The Adventures of Huckleberry Finn','Mark Twain','1884-11-12 00:00:00','Mark Twain\'s tale of a rebel boy and a runaway slave seeking liberation upon the waters of the Mississippi remains a defining classic of American literature.',2),(22,'Kidnapped','Robert Louis Stevenson','1887-04-12 00:00:00','A thrilling adventure story, gripping history and fascinating study of the Scottish character, Kidnapped has lost none of its power.',4),(23,'Three Men in a Boat','Jerome K Jerome','1890-05-11 00:00:00','Jerome K Jerome\'s accidental classic about messing about on the Thames remains a comic gem.',5),(24,'The Sign of Four','Arthur Conan Doyle','1891-05-06 00:00:00','Sherlock Holmes\'s second outing sees Conan Doyle\'s brilliant sleuth and his bluff sidekick Watson  come into their own.',4),(25,'The Picture of Dorian Gray','Oscar Wilde','1891-09-06 00:00:00','Wilde\'s brilliantly allusive moral tale of youth, beauty and corruption was greeted with howls of protest on publication.',4),(26,'New Grub Street','George Gissing','1892-02-11 00:00:00','George Gissing\'s portrayal of the hard facts of a literary life remains as relevant today as it was in the late 19th century.',4),(27,'Jude the Obscure','Thomas Hardy','1896-04-04 00:00:00','Hardy exposed his deepest feelings in this bleak, angry novel and, stung by the hostile response, he never wrote another.',3),(28,'The Red Badge of Courage','Stephen Crane','1895-12-12 00:00:00','Stephen Crane\'s account of a young man\'s passage to manhood through soldiery is a blueprint for the great American war novel.',2),(29,'Dracula','Bram Stoker','1897-01-01 00:00:00','Bram Stoker\'s classic vampire story was very much of its time but still resonates more than a century later.',4),(30,'Heart of Darkness','Joseph Conrad','1900-02-09 00:00:00','Joseph Conrad\'s masterpiece about a life-changing journey in search of Mr Kurtz has the simplicity of great myth.',4),(31,'Sister Carrie','Theodore Dreiser','1901-04-12 00:00:00','Theodore Dreiser was no stylist, but there\'s a terrific momentum to his unflinching novel about a country girl\'s American dream.',5),(32,'Kim','Rudyard Kipling','1901-09-12 00:00:00','In Kipling\'s classic boy\'s own spy story, an orphan in British India must make a choice between east and west.',5),(33,'The Call of the Wild','Jack London','1903-12-08 00:00:00','Jack London\'s vivid adventures of a pet dog that goes back to nature reveal an extraordinary style and consummate storytelling.',1);
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_books`
--

DROP TABLE IF EXISTS `user_books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_books` (
  `user_books_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `notes` varchar(800) DEFAULT NULL,
  PRIMARY KEY (`user_books_id`),
  UNIQUE KEY `unique_note` (`user_id`,`book_id`),
  KEY `user_id_idx` (`user_id`),
  KEY `book_id_idx` (`book_id`),
  CONSTRAINT `book_id` FOREIGN KEY (`book_id`) REFERENCES `books` (`book_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_books`
--

LOCK TABLES `user_books` WRITE;
/*!40000 ALTER TABLE `user_books` DISABLE KEYS */;
INSERT INTO `user_books` VALUES (1,1,1,'Good book. To becontinued'),(3,19,1,'Good book. Read it later1'),(9,19,2,'Hey, It is super'),(31,42,2,'Good book. Read it later1'),(34,42,16,'Example1'),(35,42,4,'note it'),(37,62,16,'Hey, Good.'),(38,62,4,'Vallabh recommended'),(40,62,33,'The Call of the wild is about cool people'),(41,62,21,'I have this in my school'),(42,62,10,'Had Great Time'),(43,62,23,'Three Men in a Boat'),(45,62,13,'He is a great writer.'),(46,62,29,'Mast book'),(47,62,7,' Frankenstein'),(48,62,3,'Gulliver\'s Travels is cool'),(49,62,6,'Emma but not watson'),(50,62,30,'My Heart stopped'),(51,62,27,'Jude the Obscure'),(59,66,16,'Alice in wonderla'),(61,62,2,'Adding Note'),(62,68,17,'Adding some notes'),(63,68,15,'Good book'),(65,42,24,'Add Note'),(66,45,16,'Notes is important'),(67,70,16,'Good Book'),(68,42,15,'Add Noteq'),(69,42,30,'Add Note'),(70,74,16,'Nice Book');
/*!40000 ALTER TABLE `user_books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_info`
--

DROP TABLE IF EXISTS `user_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_info` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_info`
--

LOCK TABLES `user_info` WRITE;
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
INSERT INTO `user_info` VALUES (1,'fds@fa','fas'),(19,'surendra2@gmail.com','surendra'),(23,'surendra@gmail.com','surendra'),(24,'surendra3@gmail.com','surendra'),(28,'surendra4@gmail.com','surendra'),(29,'surendra6@gmail.com','surendra'),(33,'anjana@gmail.com','surendra'),(35,'phani@gmail.com','surendra'),(37,'satya@gmail.com','surendra'),(40,'surendra10@gmail.com','surendra'),(41,'fs@fas','fdsa'),(42,'surendra.vantedu@gmail.com','suri'),(45,'suri26@ex','suri'),(46,'suri261@ex','suri'),(47,'suri262@ex','suri'),(48,'suri263@ex','suri'),(49,'suri264@ex','suri'),(50,'suri265@ex','suri'),(51,'suri266@ex','suri'),(52,'suri267@ex','suri'),(54,'surendra26@gmail.com','surendra'),(57,'suri268@ex','suri'),(59,'surendra27@gmail.com','suri'),(62,'suri21@ex','suri'),(66,'suri212@ex','suri'),(68,'suri22@ex','suri'),(69,'shanthan@gmail.com','suri'),(70,'shantan@reddy','suri'),(71,'suri1126@gmail','suri'),(72,'suri302@we','suri'),(73,'suri3120@gmail','suri'),(74,'shantan@gmail.com','abcd');
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-27  0:43:30
