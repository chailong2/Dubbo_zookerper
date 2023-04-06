/*
 Navicat MySQL Data Transfer

 Source Server         : mydata
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : Hrmsdatabase

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 07/06/2022 22:44:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for administer
-- ----------------------------
DROP TABLE IF EXISTS `administer`;
CREATE TABLE `administer` (
  `administername` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`account`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

-- ----------------------------
-- Records of administer
-- ----------------------------
BEGIN;
INSERT INTO `administer` VALUES ('柴龙', '123455', '123456');
COMMIT;

-- ----------------------------
-- Table structure for Apply
-- ----------------------------
DROP TABLE IF EXISTS `Apply`;
CREATE TABLE `Apply` (
  `account` varchar(255) COLLATE utf8_bin NOT NULL,
  `applyname` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `applysex` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `applyage` int DEFAULT NULL,
  `applyeducation` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `applyidcard` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `applyaddress` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `applyphonenumber` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `applystatue` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`account`),
  CONSTRAINT `myfor1` FOREIGN KEY (`account`) REFERENCES `Visitors_login` (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

-- ----------------------------
-- Records of Apply
-- ----------------------------
BEGIN;
INSERT INTO `Apply` VALUES ('123456', '赵云', '男', 24, '北京大学', '4t3534534534534', '上海', '12312312', '审核通过');
COMMIT;

-- ----------------------------
-- Table structure for attendance
-- ----------------------------
DROP TABLE IF EXISTS `attendance`;
CREATE TABLE `attendance` (
  `attendanceId` int NOT NULL,
  `staffId` int NOT NULL,
  `attendancetype` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `attendancetime` date NOT NULL,
  PRIMARY KEY (`attendanceId`,`attendancetime`) USING BTREE,
  KEY `for4` (`staffId`),
  CONSTRAINT `for4` FOREIGN KEY (`staffId`) REFERENCES `Staff_information` (`staffId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

-- ----------------------------
-- Records of attendance
-- ----------------------------
BEGIN;
INSERT INTO `attendance` VALUES (1, 3, '未操作', '2022-05-02');
INSERT INTO `attendance` VALUES (1, 3, '未操作', '2022-05-03');
INSERT INTO `attendance` VALUES (1, 3, '未操作', '2022-05-06');
INSERT INTO `attendance` VALUES (1, 3, '缺勤', '2022-05-07');
INSERT INTO `attendance` VALUES (1, 3, '未操作', '2022-05-10');
INSERT INTO `attendance` VALUES (1, 3, '未操作', '2022-05-17');
INSERT INTO `attendance` VALUES (1, 3, '未操作', '2022-05-23');
INSERT INTO `attendance` VALUES (1, 3, '未操作', '2022-06-02');
INSERT INTO `attendance` VALUES (1, 3, '未操作', '2022-06-03');
INSERT INTO `attendance` VALUES (2, 4, '未操作', '2022-05-02');
INSERT INTO `attendance` VALUES (2, 4, '未操作', '2022-05-03');
INSERT INTO `attendance` VALUES (2, 4, '未操作', '2022-05-06');
INSERT INTO `attendance` VALUES (2, 4, '在勤', '2022-05-07');
INSERT INTO `attendance` VALUES (2, 4, '未操作', '2022-05-10');
INSERT INTO `attendance` VALUES (2, 4, '未操作', '2022-05-17');
INSERT INTO `attendance` VALUES (2, 4, '未操作', '2022-05-23');
INSERT INTO `attendance` VALUES (2, 4, '未操作', '2022-06-02');
INSERT INTO `attendance` VALUES (2, 4, '未操作', '2022-06-03');
INSERT INTO `attendance` VALUES (3, 5, '未操作', '2022-05-02');
INSERT INTO `attendance` VALUES (3, 5, '未操作', '2022-05-03');
INSERT INTO `attendance` VALUES (3, 5, '未操作', '2022-05-06');
INSERT INTO `attendance` VALUES (3, 5, '未操作', '2022-05-07');
INSERT INTO `attendance` VALUES (3, 5, '未操作', '2022-05-10');
INSERT INTO `attendance` VALUES (3, 5, '未操作', '2022-05-17');
INSERT INTO `attendance` VALUES (3, 5, '未操作', '2022-05-23');
INSERT INTO `attendance` VALUES (3, 5, '未操作', '2022-06-02');
INSERT INTO `attendance` VALUES (3, 5, '未操作', '2022-06-03');
INSERT INTO `attendance` VALUES (4, 6, '未操作', '2022-05-02');
INSERT INTO `attendance` VALUES (4, 6, '未操作', '2022-05-03');
INSERT INTO `attendance` VALUES (4, 6, '未操作', '2022-05-06');
INSERT INTO `attendance` VALUES (4, 6, '未操作', '2022-05-07');
INSERT INTO `attendance` VALUES (4, 6, '未操作', '2022-05-10');
INSERT INTO `attendance` VALUES (4, 6, '未操作', '2022-05-17');
INSERT INTO `attendance` VALUES (4, 6, '未操作', '2022-05-23');
INSERT INTO `attendance` VALUES (4, 6, '未操作', '2022-06-02');
INSERT INTO `attendance` VALUES (4, 6, '未操作', '2022-06-03');
INSERT INTO `attendance` VALUES (5, 7, '未操作', '2022-05-02');
INSERT INTO `attendance` VALUES (5, 7, '未操作', '2022-05-03');
INSERT INTO `attendance` VALUES (5, 7, '未操作', '2022-05-06');
INSERT INTO `attendance` VALUES (5, 7, '未操作', '2022-05-07');
INSERT INTO `attendance` VALUES (5, 7, '未操作', '2022-05-10');
INSERT INTO `attendance` VALUES (5, 7, '未操作', '2022-05-17');
INSERT INTO `attendance` VALUES (5, 7, '未操作', '2022-05-23');
INSERT INTO `attendance` VALUES (5, 7, '未操作', '2022-06-02');
INSERT INTO `attendance` VALUES (5, 7, '未操作', '2022-06-03');
INSERT INTO `attendance` VALUES (6, 8, '未操作', '2022-05-02');
INSERT INTO `attendance` VALUES (6, 8, '未操作', '2022-05-03');
INSERT INTO `attendance` VALUES (6, 8, '未操作', '2022-05-06');
INSERT INTO `attendance` VALUES (6, 8, '未操作', '2022-05-07');
INSERT INTO `attendance` VALUES (6, 8, '未操作', '2022-05-10');
INSERT INTO `attendance` VALUES (6, 8, '未操作', '2022-05-17');
INSERT INTO `attendance` VALUES (6, 8, '未操作', '2022-05-23');
INSERT INTO `attendance` VALUES (6, 8, '未操作', '2022-06-02');
INSERT INTO `attendance` VALUES (6, 8, '未操作', '2022-06-03');
INSERT INTO `attendance` VALUES (7, 9, '在勤', '2022-05-02');
INSERT INTO `attendance` VALUES (7, 9, '在勤', '2022-05-03');
INSERT INTO `attendance` VALUES (7, 9, '在勤', '2022-05-06');
INSERT INTO `attendance` VALUES (7, 9, '未操作', '2022-05-07');
INSERT INTO `attendance` VALUES (7, 9, '在勤', '2022-05-10');
INSERT INTO `attendance` VALUES (7, 9, '未操作', '2022-05-17');
INSERT INTO `attendance` VALUES (7, 9, '未操作', '2022-05-23');
INSERT INTO `attendance` VALUES (7, 9, '未操作', '2022-06-02');
INSERT INTO `attendance` VALUES (7, 9, '在勤', '2022-06-03');
INSERT INTO `attendance` VALUES (8, 10021, '未操作', '2022-05-03');
INSERT INTO `attendance` VALUES (8, 10021, '未操作', '2022-05-06');
INSERT INTO `attendance` VALUES (8, 10021, '未操作', '2022-05-07');
INSERT INTO `attendance` VALUES (8, 10021, '未操作', '2022-05-10');
INSERT INTO `attendance` VALUES (8, 10021, '未操作', '2022-05-17');
INSERT INTO `attendance` VALUES (8, 10021, '未操作', '2022-05-23');
INSERT INTO `attendance` VALUES (8, 10021, '未操作', '2022-06-02');
INSERT INTO `attendance` VALUES (8, 10021, '未操作', '2022-06-03');
INSERT INTO `attendance` VALUES (9, 10022, '未操作', '2022-05-03');
INSERT INTO `attendance` VALUES (9, 10022, '未操作', '2022-05-06');
INSERT INTO `attendance` VALUES (9, 10022, '未操作', '2022-05-07');
INSERT INTO `attendance` VALUES (9, 10022, '未操作', '2022-05-10');
INSERT INTO `attendance` VALUES (9, 10022, '未操作', '2022-05-17');
INSERT INTO `attendance` VALUES (9, 10022, '未操作', '2022-05-23');
INSERT INTO `attendance` VALUES (9, 10022, '未操作', '2022-06-02');
INSERT INTO `attendance` VALUES (9, 10022, '未操作', '2022-06-03');
INSERT INTO `attendance` VALUES (10, 10025, '未操作', '2022-05-07');
INSERT INTO `attendance` VALUES (10, 10025, '未操作', '2022-05-10');
INSERT INTO `attendance` VALUES (10, 10025, '未操作', '2022-05-17');
INSERT INTO `attendance` VALUES (10, 10025, '未操作', '2022-05-23');
INSERT INTO `attendance` VALUES (10, 10025, '未操作', '2022-06-02');
INSERT INTO `attendance` VALUES (10, 10025, '未操作', '2022-06-03');
INSERT INTO `attendance` VALUES (11, 10027, '未操作', '2022-05-10');
INSERT INTO `attendance` VALUES (11, 10027, '未操作', '2022-05-17');
INSERT INTO `attendance` VALUES (11, 10027, '未操作', '2022-05-23');
INSERT INTO `attendance` VALUES (11, 10027, '未操作', '2022-06-02');
INSERT INTO `attendance` VALUES (11, 10027, '未操作', '2022-06-03');
INSERT INTO `attendance` VALUES (12, 10029, '未操作', '2022-05-17');
INSERT INTO `attendance` VALUES (12, 10029, '未操作', '2022-05-23');
INSERT INTO `attendance` VALUES (12, 10029, '未操作', '2022-06-02');
INSERT INTO `attendance` VALUES (12, 10029, '未操作', '2022-06-03');
INSERT INTO `attendance` VALUES (13, 10030, '未操作', '2022-05-17');
INSERT INTO `attendance` VALUES (13, 10030, '未操作', '2022-05-23');
INSERT INTO `attendance` VALUES (13, 10030, '未操作', '2022-06-02');
INSERT INTO `attendance` VALUES (13, 10030, '未操作', '2022-06-03');
INSERT INTO `attendance` VALUES (14, 10031, '未操作', '2022-06-03');
COMMIT;

-- ----------------------------
-- Table structure for Department_information
-- ----------------------------
DROP TABLE IF EXISTS `Department_information`;
CREATE TABLE `Department_information` (
  `detid` int NOT NULL COMMENT '部门id',
  `detname` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '部门名称',
  `dephonenumber` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`detid`),
  KEY `detname` (`detname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

-- ----------------------------
-- Records of Department_information
-- ----------------------------
BEGIN;
INSERT INTO `Department_information` VALUES (1, '行政部', '12277');
INSERT INTO `Department_information` VALUES (2, '开发部', '12278');
INSERT INTO `Department_information` VALUES (3, '财务部', '12313');
INSERT INTO `Department_information` VALUES (4, '销售部', '12312');
COMMIT;

-- ----------------------------
-- Table structure for Employ_information
-- ----------------------------
DROP TABLE IF EXISTS `Employ_information`;
CREATE TABLE `Employ_information` (
  `staffid` int NOT NULL,
  `deptid` int NOT NULL,
  `staffoffice` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '员工职务',
  PRIMARY KEY (`staffid`,`deptid`) USING BTREE,
  KEY `forkey_2` (`deptid`),
  CONSTRAINT `for3` FOREIGN KEY (`staffid`) REFERENCES `Staff_information` (`staffId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `forkey_2` FOREIGN KEY (`deptid`) REFERENCES `Department_information` (`detid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

-- ----------------------------
-- Records of Employ_information
-- ----------------------------
BEGIN;
INSERT INTO `Employ_information` VALUES (3, 2, '员工');
INSERT INTO `Employ_information` VALUES (4, 1, '员工');
INSERT INTO `Employ_information` VALUES (5, 2, '部门负责人');
INSERT INTO `Employ_information` VALUES (6, 2, '员工');
INSERT INTO `Employ_information` VALUES (7, 3, '部门负责人');
INSERT INTO `Employ_information` VALUES (8, 2, '员工');
INSERT INTO `Employ_information` VALUES (9, 4, '员工');
INSERT INTO `Employ_information` VALUES (10021, 1, '部门负责人');
INSERT INTO `Employ_information` VALUES (10022, 3, '员工');
INSERT INTO `Employ_information` VALUES (10025, 4, '部门负责人');
INSERT INTO `Employ_information` VALUES (10027, 2, '员工');
INSERT INTO `Employ_information` VALUES (10029, 1, '员工');
INSERT INTO `Employ_information` VALUES (10030, 1, '员工');
COMMIT;

-- ----------------------------
-- Table structure for Salary
-- ----------------------------
DROP TABLE IF EXISTS `Salary`;
CREATE TABLE `Salary` (
  `salaryId` int NOT NULL AUTO_INCREMENT,
  `staffid` int DEFAULT NULL,
  `salaryyear` int NOT NULL,
  `salarymouth` int NOT NULL,
  `salarynum` int DEFAULT NULL,
  `salarystatue` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`salaryId`,`salaryyear`,`salarymouth`),
  KEY `for2` (`staffid`),
  CONSTRAINT `for2` FOREIGN KEY (`staffid`) REFERENCES `Staff_information` (`staffId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10354 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

-- ----------------------------
-- Records of Salary
-- ----------------------------
BEGIN;
INSERT INTO `Salary` VALUES (10339, 3, 2022, 6, 8000, '未发放');
INSERT INTO `Salary` VALUES (10340, 4, 2022, 6, 8000, '未发放');
INSERT INTO `Salary` VALUES (10341, 5, 2022, 6, 12000, '未发放');
INSERT INTO `Salary` VALUES (10342, 6, 2022, 6, 8000, '未发放');
INSERT INTO `Salary` VALUES (10343, 7, 2022, 6, 12000, '未发放');
INSERT INTO `Salary` VALUES (10344, 8, 2022, 6, 8000, '未发放');
INSERT INTO `Salary` VALUES (10345, 9, 2022, 6, 12000, '未发放');
INSERT INTO `Salary` VALUES (10346, 10021, 2022, 6, 12000, '未发放');
INSERT INTO `Salary` VALUES (10347, 10022, 2022, 6, 8000, '未发放');
INSERT INTO `Salary` VALUES (10348, 10025, 2022, 6, 12000, '未发放');
INSERT INTO `Salary` VALUES (10349, 10027, 2022, 6, 8000, '未发放');
INSERT INTO `Salary` VALUES (10350, 10029, 2022, 6, 8000, '未发放');
INSERT INTO `Salary` VALUES (10351, 10030, 2022, 6, 8000, '未发放');
INSERT INTO `Salary` VALUES (10352, 10031, 2022, 6, 8000, '未发放');
INSERT INTO `Salary` VALUES (10353, 10032, 2022, 6, 8000, '未发放');
COMMIT;

-- ----------------------------
-- Table structure for Staff_information
-- ----------------------------
DROP TABLE IF EXISTS `Staff_information`;
CREATE TABLE `Staff_information` (
  `staffId` int NOT NULL AUTO_INCREMENT,
  `staffname` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `staffage` int DEFAULT NULL,
  `staffsex` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `educationBackground` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `duty` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `idcard` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `phonenumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`staffId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10034 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

-- ----------------------------
-- Records of Staff_information
-- ----------------------------
BEGIN;
INSERT INTO `Staff_information` VALUES (3, '李四', 37, '男', '四川大学', '员工', '22323', '北京', '17302242526');
INSERT INTO `Staff_information` VALUES (4, '王五', 15, '男', '重庆大学', '员工', '23424', '重庆', '17302242527');
INSERT INTO `Staff_information` VALUES (5, '小芳', 12, '女', '湖南大学', '部门负责人', '123123', '上海', '13202242528');
INSERT INTO `Staff_information` VALUES (6, '赵万', 34, '男', '中南大虚', '员工', '123123', '西藏', '13202242529');
INSERT INTO `Staff_information` VALUES (7, '王月', 45, '男', '哈佛大学', '部门负责人', '123213', '云南', '13202242510');
INSERT INTO `Staff_information` VALUES (8, '李明', 23, '女', '中国人民大学', '员工', '123213', '上海', '13202242511');
INSERT INTO `Staff_information` VALUES (9, '李哲', 25, '女', '华中科技大学', '部门负责人', '123123', '四川', '13202242512');
INSERT INTO `Staff_information` VALUES (10021, '赵云', 23, '男', '上海大学', '部门负责人', '123123', '上海', '13202242513');
INSERT INTO `Staff_information` VALUES (10022, '青叶', 21, '男', '北京大学', '员工', '123123', '湖南', '13202242514');
INSERT INTO `Staff_information` VALUES (10025, '赵云', 21, '男', '北京大学', '部门负责人', '123123', '四川', '13202242515');
INSERT INTO `Staff_information` VALUES (10027, '赵云', 4, '男', '北京大学', '员工', '123123', '上海', '13202242516');
INSERT INTO `Staff_information` VALUES (10029, '黎明', 23, '男', '天津理工大学', '员工', '123456', '北京', '13202242517');
INSERT INTO `Staff_information` VALUES (10030, '曹操', 45, '男', '天津大学', '员工', '123456', '北京', '13202242518');
INSERT INTO `Staff_information` VALUES (10031, '李湘', 34, '男', '北京大学', '未定', '430623200003010330', '北京', '17302242421');
INSERT INTO `Staff_information` VALUES (10032, '李湘', 23, '男', '北京大学', '未定', '123123', '上海', '12312312');
INSERT INTO `Staff_information` VALUES (10033, '赵云', 24, '男', '北京大学', '未定', '4t3534534534534', '上海', '12312312');
COMMIT;

-- ----------------------------
-- Table structure for staff_log
-- ----------------------------
DROP TABLE IF EXISTS `staff_log`;
CREATE TABLE `staff_log` (
  `account` varchar(255) COLLATE utf8_bin NOT NULL,
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `staffid` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`account`),
  KEY `for1` (`staffid`),
  CONSTRAINT `for1` FOREIGN KEY (`staffid`) REFERENCES `Staff_information` (`staffId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

-- ----------------------------
-- Records of staff_log
-- ----------------------------
BEGIN;
INSERT INTO `staff_log` VALUES ('1234567', '123456', 9);
INSERT INTO `staff_log` VALUES ('23456', '23456', 4);
COMMIT;

-- ----------------------------
-- Table structure for Visitors_login
-- ----------------------------
DROP TABLE IF EXISTS `Visitors_login`;
CREATE TABLE `Visitors_login` (
  `account` varchar(255) COLLATE utf8_bin NOT NULL,
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

-- ----------------------------
-- Records of Visitors_login
-- ----------------------------
BEGIN;
INSERT INTO `Visitors_login` VALUES ('12312312', '123123123');
INSERT INTO `Visitors_login` VALUES ('123456', '123456');
INSERT INTO `Visitors_login` VALUES ('123457', '123456');
INSERT INTO `Visitors_login` VALUES ('2012126846', '123456');
INSERT INTO `Visitors_login` VALUES ('345678', '345678');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
