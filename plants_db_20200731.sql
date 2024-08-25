CREATE DATABASE  IF NOT EXISTS `plants_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `plants_db`;
-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: plants_db
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `plants`
--

DROP TABLE IF EXISTS `plants`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plants` (
  `plant_id` int(11) NOT NULL AUTO_INCREMENT,
  `common_name` varchar(25) NOT NULL,
  `scientific_name` varchar(50) DEFAULT NULL,
  `plant_description` varchar(500) DEFAULT NULL,
  `watering_frequency` varchar(200) DEFAULT NULL,
  `sunlight_amount` varchar(200) DEFAULT NULL,
  `img_file_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`plant_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plants`
--

LOCK TABLES `plants` WRITE;
/*!40000 ALTER TABLE `plants` DISABLE KEYS */;
INSERT INTO `plants` VALUES (1,'Orchid','Orchidaceae','Orchids are easily distinguished from other plants, as they share some very evident derived characteristics or synapomorphies. Among these are: bilateral symmetry of the flower (zygomorphism), many resupinate flowers, a nearly always highly modified petal (labellum), fused stamens and carpels, and extremely small seeds.','Once per week.','Bright, indirect sunlight.','orchid.jpg'),(2,'Succulent','Succulent Plant','In botany, succulent plants, also known as succulents, are plants with parts that are thickened, fleshy, and engorged, usually to retain water in arid climates or soil conditions.','Soak the soil and do not water again until the soil is dry.','3 hours of direct sunlight daily.','succulent.jpg'),(3,'Chinese Evergreen','Aglaonema','Chinese Evergreen are perennial herbs with stems growing erect or decumbent and creeping.','Soak the soil and do not water again until the soil is dry.','Medium to lowlight conditions or indirect sunlight.','chinese_evergreen.png'),(4,'Asparagus Fern','Asparagus aethiopicus','Asparagus aethiopicus is a branching perennial herb with tough green aerial stems which are sparsely covered with spines.','Mist arching stems daily.','Indirect light.','asparagus_fern.jpg'),(5,'Fiddle Leaf Fig','Ficus lyrata','Ficus lyrata, commonly known as the fiddle-leaf fig, is a species of flowering plant in the mulberry and fig family Moraceae. It is native to western Africa, from Cameroon west to Sierra Leone, where it grows in lowland tropical rainforest','Keep soil moist, but be careful not to overwater.','Bright, indirect sunlight.','fiddle_leaf_fig.jpg'),(6,'Guiana Chestnut','Pachira aquatica','Pachira aquatica can grow up to 18 m (59.1 ft) in height in the wild. It has shiny green palmate leaves with lanceolate leaflets and smooth green bark. This species forms a slightly thickened root with smaller roots or roots, which also serves as a water reservoir','Water once the topsoil becomes dry.','Bright to medium, indirect light.','guiana_chestnut.png'),(7,'Lucky Bamboo','Dracaena sanderiana','Lucky Bamboo are a perennial herb reaching a height of 100 cm (39 in), the plant has slightly twisted leaves of grey-green colour, with a length of which is up to 23 cm (9 in). The stem is fleshy, which distinguishes it from bamboo. It requires bright, ventilated areas. It tolerates dry air and does not require constant spraying. A very tenacious plant, it is rather difficult to destroy it','One inch of water if using pebbles as the potting medium. Keep soil moist if using rich potting soil.','Bright, indirect sunlight.','lucky_bamboo.jpg'),(8,'Golden Pothos','Epipremnum aureum','This plant has a multitude of common names including Golden Pothos, Ceylon creeper, hunter\'s robe, ivy arum, money plant, silver vine, Solomon Islands ivy, marble queen, and taro vine. It is also called devil\'s vine or devil\'s ivy because it is almost impossible to kill and it stays green even when kept in the dark.','Soak the soil and do not water again until the soil is dry.','Bright, indirect sunlight.','golden_pothos.jpg'),(9,'Snake Plant','Dracaena trifasciata','Snake Plants are an evergreen perennial plant forming dense stands, spreading by way of its creeping rhizome, which is sometimes above ground, sometimes underground. Its stiff leaves grow vertically from a basal rosette. Mature leaves are dark green with light gray-green cross-banding and usually range from 70-90 centimetres (28-35 in) long and 5-6 centimetres (2.0-2.4 in) wide, though it can reach heights above 2 m (6 ft) in optimal conditions.','Soak the soil and do not water again until the soil is dry.','Bright, indirect sunlight.','snake_plant.jpg'),(10,'Laceleaf','Anthurium','Anthurium is a genus of herbs often growing as epiphytes on other plants. Some are terrestrial. The leaves are often clustered and are variable in shape. The inflorescence bears small flowers which are perfect, containing male and female structures.','Keep soil moist, but be careful not to overwater.','Bright, indirect sunlight.','laceleaf.jpg');
/*!40000 ALTER TABLE `plants` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'plants_db'
--

--
-- Dumping routines for database 'plants_db'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-31 16:18:11
