CREATE DATABASE  IF NOT EXISTS `mypeople` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `mypeople`;
-- MySQL dump 10.13  Distrib 8.0.17, for macos10.14 (x86_64)
--
-- Host: localhost    Database: mypeople
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
-- Table structure for table `friendslist`
--

DROP TABLE IF EXISTS `friendslist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `friendslist` (
  `fSeqno` int(11) NOT NULL AUTO_INCREMENT,
  `fName` varchar(45) DEFAULT NULL,
  `fTel` varchar(45) DEFAULT NULL,
  `fRelation` varchar(45) DEFAULT NULL,
  `fImage` varchar(200) DEFAULT NULL,
  `fImageReal` varchar(200) DEFAULT NULL,
  `fTag1` int(11) DEFAULT '0',
  `fTag2` int(11) DEFAULT '0',
  `fTag3` int(11) DEFAULT '0',
  `fTag4` int(11) DEFAULT '0',
  `fTag5` int(11) DEFAULT '0',
  `fComment` varchar(200) DEFAULT '코멘트를 작성해주세요',
  `fAddress` varchar(100) DEFAULT NULL,
  `fEmail` varchar(50) DEFAULT NULL,
  `user_uSeqno` int(11) NOT NULL,
  PRIMARY KEY (`fSeqno`,`user_uSeqno`),
  UNIQUE KEY `fSepno_UNIQUE` (`fSeqno`),
  KEY `fk_friendslist_user` (`user_uSeqno`),
  CONSTRAINT `fk_friendslist_user` FOREIGN KEY (`user_uSeqno`) REFERENCES `user` (`uSeqno`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `friendslist`
--

LOCK TABLES `friendslist` WRITE;
/*!40000 ALTER TABLE `friendslist` DISABLE KEYS */;
INSERT INTO `friendslist` VALUES (2,'엄마','010-9882-7178','가족',NULL,NULL,1,0,0,0,0,'엄마 사랑해요','경기도 하남시',NULL,49),(3,'아빠','010-7827-8471','가족',NULL,NULL,1,0,0,0,0,'아빠 사랑해요','경기도 하남시',NULL,49),(4,'이건수','010-1838-4719','경영과 동기',NULL,NULL,0,0,0,0,1,'건수야 살좀빼라','서울시 강동구',NULL,49),(5,'김덕중','010-2374-5738','경산고 친구',NULL,NULL,0,0,0,1,0,'5000원 안갚음','서울시 강동구',NULL,49),(6,'김명훈','010-2738-2858','전기과 친구',NULL,NULL,0,0,0,0,1,'클라이밍 잘함','서울시 송파구',NULL,49),(7,'박서진','010-3819-3829','경영과 선배',NULL,NULL,0,0,0,0,1,'어사','서울시 동작구',NULL,49),(8,'선형덕','010-1924-3849','선일초 친구',NULL,NULL,0,1,0,0,0,'어사2','경기도 이천시',NULL,49),(9,'지종화','010-4449-9472','바보',NULL,NULL,0,1,1,0,0,'롤 친구','경기도 수원시',NULL,49),(10,'오일록','010-5748-3938','친구',NULL,NULL,0,1,1,0,0,'빡빡이','경기도 용인시',NULL,49),(11,'김대현','010-3432-5656','친한친구',NULL,NULL,0,1,1,1,0,'양동근','강원도 동해시',NULL,49),(12,'음향 김조선','010-7685-9386','음향 실장님',NULL,NULL,0,1,0,0,0,'웨이오디오 실장','경상남도 부산시',NULL,50),(13,'음향 박민지','010-8887-9993','음향 대리님',NULL,NULL,0,1,0,0,0,'웨이오디오 대리','경상남도 김해시',NULL,50),(14,'음향 김진표','010-1121-7827','음향팀',NULL,NULL,0,1,0,0,0,'웨이오디오 크루','경상북도 경주시',NULL,50),(15,'조명 박주선','010-2323-8989','조명 팀장님',NULL,NULL,1,0,0,0,0,'페오라 팀장님','전라북도 나주시',NULL,50),(16,'조명 황인규','010-4738-3929','조명팀',NULL,NULL,1,0,0,0,0,'페오라 크루','전라남도 광주시',NULL,50),(17,'민영이','010-2648-0938','기타모임 ',NULL,NULL,0,0,1,1,1,'아르페지오','경기도 인천시',NULL,51),(18,'건강한애','010-3738-5627','기타모임',NULL,NULL,0,0,1,1,1,'띵땅띵땅','경기도 의정부시',NULL,51),(19,'김쌍','010-0060-7232','스터디그룹',NULL,NULL,0,0,0,1,1,'토익 좀 침','전라북도 군산시',NULL,51),(20,'모이수','010-3452-9238','스터디그룹',NULL,NULL,1,1,1,0,0,'코딩 좀 함','경기도 성남시',NULL,51),(21,'김태현 님','010-8581-6379','야간반',NULL,NULL,1,0,0,0,0,'잘 드심','서울시 은평구',NULL,51),(22,'삼성 김부장님','010-0021-6662','경영 지원과',NULL,NULL,0,1,0,0,0,'12/12까지 결재서류','서울시 강북구',NULL,52),(23,'현대 김대리님','010-4343-9898','인사과',NULL,NULL,0,0,1,0,0,'14일 점심약속','서울시 노원구',NULL,52),(24,'카카오 선차장님','010-4562-2831','모바일관련',NULL,NULL,1,0,0,0,0,'앱관련 문의전화','경기도 일산시',NULL,52),(25,'세민이형','010-3761-3831','친한 형',NULL,NULL,1,0,0,0,0,'풋살화 받기로함','서울시 광진구',NULL,53),(26,'명진이형','010-2822-2372','두번째로 친한형',NULL,NULL,1,0,0,0,0,'10/9 술약속 ','용인시 기흥구',NULL,53),(27,'James','010-9090-1829','디자인',NULL,NULL,0,0,0,1,0,'사와디캅','강원도 삼척시',NULL,53),(28,'Jack','010-2389-0001','천재',NULL,NULL,0,0,1,0,0,'동무','함경북도 ',NULL,53);
/*!40000 ALTER TABLE `friendslist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tag`
--

DROP TABLE IF EXISTS `tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tag` (
  `tag1` varchar(45) DEFAULT 'TAG1',
  `tag2` varchar(45) DEFAULT 'TAG2',
  `tag3` varchar(45) DEFAULT 'TAG3',
  `tag4` varchar(45) DEFAULT 'TAG4',
  `tag5` varchar(45) DEFAULT 'TAG5',
  `user_uSeqno` int(11) NOT NULL,
  PRIMARY KEY (`user_uSeqno`),
  CONSTRAINT `fk_tag_user1` FOREIGN KEY (`user_uSeqno`) REFERENCES `user` (`uSeqno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tag`
--

LOCK TABLES `tag` WRITE;
/*!40000 ALTER TABLE `tag` DISABLE KEYS */;
INSERT INTO `tag` VALUES ('가족','초등친구','중등친구','고등친구','대학친구',49),('조명팀','음향팀','영상팀','특효팀','연출팀',50),('가족같은 사람','만나면 좋은사람','함께하면 좋은사람','소식 알고싶은 사람','알아둘 번호',51),('거래처','회사','협력사','디자인업체','전력업체',52),('풋살동호회','학원4조','학원3조','학원2조','학원1조',53);
/*!40000 ALTER TABLE `tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `uSeqno` int(11) NOT NULL AUTO_INCREMENT,
  `uId` varchar(45) DEFAULT NULL,
  `uPw` varchar(45) DEFAULT NULL,
  `uName` varchar(45) DEFAULT NULL,
  `uTel` varchar(45) DEFAULT NULL,
  `uDeleteDate` date DEFAULT '1111-11-11',
  `uInsertDate` date DEFAULT NULL,
  PRIMARY KEY (`uSeqno`),
  UNIQUE KEY `uSeqno_UNIQUE` (`uSeqno`),
  UNIQUE KEY `uId_UNIQUE` (`uId`),
  UNIQUE KEY `uTel_UNIQUE` (`uTel`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (49,'wntnftk2001@naver.com','Testtest1!','정영재','010-9196-8996','1111-11-11','2020-12-30'),(50,'thlbyl0109@naver.com','Testtest1!','김태현','010-7426-0214','1111-11-11','2020-11-01'),(51,'hyeona_c@naver.com','Testtest1!','최현아','010-5446-2753','1111-11-11','2020-10-05'),(52,'wltjr318@naver.com','Testtest1!','최지석','010-1111-1111','1111-11-11','2020-09-15'),(53,'tnctis21@naver.com','Testtest1!','이민우','010-3046-3035','1111-11-11','2020-08-07'),(54,NULL,NULL,NULL,NULL,'1111-11-11','2020-12-30');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-30 17:18:18
