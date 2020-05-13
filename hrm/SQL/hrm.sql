/*
 Navicat Premium Data Transfer

 Source Server         : 阿里云
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : **********
 Source Schema         : hrm

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 13/05/2020 17:10:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for accessLog
-- ----------------------------
DROP TABLE IF EXISTS `accessLog`;
CREATE TABLE `accessLog`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `className` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '类名',
  `requestMethod` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '请求的方法',
  `contentType` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT 'Content-Type',
  `requestParams` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '请求所带的参数',
  `requestType` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '请求类型Restful',
  `serverAddr` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '服务端地址',
  `remoteAddr` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '客户端地址',
  `deviceName` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '设备名',
  `browserName` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '浏览器名称',
  `userAgent` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT 'UserAgent',
  `requestUri` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '请求的Uri',
  `requestTime` timestamp(0) NULL DEFAULT NULL COMMENT '发起请求的时间',
  `hrid` int(11) NULL DEFAULT NULL COMMENT 'hrID',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `access_id`(`id`) USING BTREE,
  INDEX `hrid_fk`(`hrid`) USING BTREE,
  CONSTRAINT `hrid_fk` FOREIGN KEY (`hrid`) REFERENCES `hr` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of accessLog
-- ----------------------------
INSERT INTO `accessLog` VALUES (1, 'org.dev.hrm.controller.per.EmployeeInfoController', 'getEmployeeInfo()', 'FORM', '{\"size\":\"10\",\"name\":\"\",\"page\":\"1\"}', 'GET', 'http://localhost:8080', '127.0.0.1', 'Windows 10', 'Chrome 8', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.138 Safari/537.36', '/per/emp/', '2020-05-13 04:04:01', 3);
INSERT INTO `accessLog` VALUES (2, 'org.dev.hrm.controller.per.EmployeeInfoController', 'getAllPositions()', 'FORM', '\"[]\"', 'GET', 'http://localhost:8080', '127.0.0.1', 'Windows 10', 'Chrome 8', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.138 Safari/537.36', '/per/emp/positions', '2020-05-13 04:04:01', 3);
INSERT INTO `accessLog` VALUES (3, 'org.dev.hrm.controller.per.EmployeeInfoController', 'getEmployeeInfo()', 'FORM', '{\"size\":\"10\",\"name\":\"你好\",\"page\":\"1\"}', 'GET', 'http://localhost:8080', '127.0.0.1', 'Windows 10', 'Chrome 8', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.138 Safari/537.36', '/per/emp/', '2020-05-13 04:04:03', 3);
INSERT INTO `accessLog` VALUES (4, 'org.dev.hrm.controller.per.EmployeeInfoController', 'availableWorkId()', 'FORM', '\"[]\"', 'GET', 'http://localhost:8080', '127.0.0.1', 'Windows 10', 'Chrome 8', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.138 Safari/537.36', '/per/emp/availableWorkId', '2020-05-13 04:04:08', 3);
INSERT INTO `accessLog` VALUES (5, 'org.dev.hrm.controller.per.EmployeeInfoController', 'addEmp()', 'application/json;charset=UTF-8', '\"[{\\\"name\\\":\\\"员工\\\",\\\"gender\\\":\\\"男\\\",\\\"birthday\\\":\\\"2002-02-02\\\",\\\"idCard\\\":\\\"202020202002022222\\\",\\\"wedlock\\\":\\\"已婚\\\",\\\"nationId\\\":1,\\\"nativePlace\\\":\\\"湖北\\\",\\\"politicId\\\":1,\\\"email\\\":\\\"1610940520@qq.com\\\",\\\"phone\\\":\\\"1776543210\\\",\\\"address\\\":\\\"湖北省武汉市\\\",\\\"departmentId\\\":1,\\\"jobLevelId\\\":1,\\\"posId\\\":1,\\\"engageForm\\\":\\\"劳动合同\\\",\\\"tiptopDegree\\\":\\\"本科\\\",\\\"specialty\\\":\\\"信息管理与信息系统\\\",\\\"school\\\":\\\"三峡大学\\\",\\\"beginDate\\\":\\\"2020-12-31\\\",\\\"workState\\\":\\\"在职\\\",\\\"workID\\\":\\\"00001063\\\",\\\"contractTerm\\\":2.0,\\\"conversionTime\\\":\\\"2021-12-31\\\",\\\"beginContract\\\":\\\"2020-12-31\\\",\\\"endContract\\\":\\\"2022-12-31\\\",\\\"salaryWithBonus\\\":0}]\"', 'POST', 'http://localhost:8080', '127.0.0.1', 'Windows 10', 'Chrome 8', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.138 Safari/537.36', '/per/emp/', '2020-05-13 04:04:15', 3);
INSERT INTO `accessLog` VALUES (6, 'org.dev.hrm.controller.per.EmployeeInfoController', 'getEmployeeInfo()', 'FORM', '{\"size\":\"10\",\"name\":\"\",\"page\":\"1\"}', 'GET', 'http://localhost:8080', '127.0.0.1', 'Windows 10', 'Chrome 8', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.138 Safari/537.36', '/per/emp/', '2020-05-13 04:04:15', 3);
INSERT INTO `accessLog` VALUES (7, 'org.dev.hrm.controller.per.EmployeeInfoController', 'getAllPositions()', 'FORM', '\"[]\"', 'GET', 'http://localhost:8080', '127.0.0.1', 'Windows 10', 'Chrome 8', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.138 Safari/537.36', '/per/emp/positions', '2020-05-13 04:04:20', 3);
INSERT INTO `accessLog` VALUES (8, 'org.dev.hrm.controller.per.EmployeeInfoController', 'updateEmployee()', 'application/json;charset=UTF-8', '\"[{\\\"id\\\":2558,\\\"name\\\":\\\"员工\\\",\\\"gender\\\":\\\"男\\\",\\\"birthday\\\":\\\"2002-02-01\\\",\\\"idCard\\\":\\\"202020202002022222\\\",\\\"wedlock\\\":\\\"已婚\\\",\\\"nationId\\\":1,\\\"nativePlace\\\":\\\"湖北\\\",\\\"politicId\\\":1,\\\"email\\\":\\\"1610940520@qq.com\\\",\\\"phone\\\":\\\"1776543210\\\",\\\"address\\\":\\\"湖北省武汉市\\\",\\\"departmentId\\\":1,\\\"jobLevelId\\\":1,\\\"posId\\\":1,\\\"engageForm\\\":\\\"劳动合同\\\",\\\"tiptopDegree\\\":\\\"本科\\\",\\\"specialty\\\":\\\"信息管理与信息系统\\\",\\\"school\\\":\\\"三峡大学\\\",\\\"beginDate\\\":\\\"2020-12-30\\\",\\\"workState\\\":\\\"在职\\\",\\\"workID\\\":\\\"00001063\\\",\\\"contractTerm\\\":2.0,\\\"conversionTime\\\":\\\"2021-12-30\\\",\\\"beginContract\\\":\\\"2020-12-30\\\",\\\"endContract\\\":\\\"2022-12-30\\\",\\\"nation\\\":{\\\"id\\\":1,\\\"name\\\":\\\"汉族\\\"},\\\"politicsstatus\\\":{\\\"id\\\":1,\\\"name\\\":\\\"中共党员\\\"},\\\"department\\\":{\\\"id\\\":1,\\\"name\\\":\\\"董事会\\\",\\\"children\\\":[]},\\\"jobLevel\\\":{\\\"id\\\":1,\\\"name\\\":\\\"教授\\\"},\\\"position\\\":{\\\"id\\\":1,\\\"name\\\":\\\"董事长\\\"},\\\"salaryWithBonus\\\":0}]\"', 'PUT', 'http://localhost:8080', '127.0.0.1', 'Windows 10', 'Chrome 8', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.138 Safari/537.36', '/per/emp/', '2020-05-13 04:04:20', 3);
INSERT INTO `accessLog` VALUES (9, 'org.dev.hrm.controller.per.EmployeeInfoController', 'getEmployeeInfo()', 'FORM', '{\"size\":\"10\",\"name\":\"\",\"page\":\"1\"}', 'GET', 'http://localhost:8080', '127.0.0.1', 'Windows 10', 'Chrome 8', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.138 Safari/537.36', '/per/emp/', '2020-05-13 04:04:21', 3);
INSERT INTO `accessLog` VALUES (10, 'org.dev.hrm.controller.per.EmployeeInfoController', 'delEmpByPrimaryKey()', 'FORM', '\"[\\\"2558\\\"]\"', 'DELETE', 'http://localhost:8080', '127.0.0.1', 'Windows 10', 'Chrome 8', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.138 Safari/537.36', '/per/emp/2558', '2020-05-13 04:04:23', 3);
INSERT INTO `accessLog` VALUES (11, 'org.dev.hrm.controller.per.EmployeeInfoController', 'getEmployeeInfo()', 'FORM', '{\"size\":\"10\",\"name\":\"\",\"page\":\"1\"}', 'GET', 'http://localhost:8080', '127.0.0.1', 'Windows 10', 'Chrome 8', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.138 Safari/537.36', '/per/emp/', '2020-05-13 04:04:24', 3);
INSERT INTO `accessLog` VALUES (12, 'org.dev.hrm.controller.per.EmployeeTransferController', 'getEmployeeTransferInfo()', 'FORM', '{\"size\":\"10\",\"name\":\"\",\"page\":\"1\"}', 'GET', 'http://localhost:8080', '127.0.0.1', 'Windows 10', 'Chrome 8', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.138 Safari/537.36', '/per/transfer/', '2020-05-13 04:04:24', 3);
INSERT INTO `accessLog` VALUES (13, 'org.dev.hrm.controller.per.EmployeeTransferController', 'getEmployeeTransferInfo()', 'FORM', '{\"size\":\"10\",\"name\":\"\",\"page\":\"1\"}', 'GET', 'http://localhost:8080', '127.0.0.1', 'Windows 10', 'Chrome 8', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.138 Safari/537.36', '/per/transfer/', '2020-05-13 04:04:37', 3);
INSERT INTO `accessLog` VALUES (14, 'org.dev.hrm.controller.per.EmployeeTransferController', 'commitTransfer()', 'FORM', '\"[33]\"', 'POST', 'http://localhost:8080', '127.0.0.1', 'Windows 10', 'Chrome 8', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.138 Safari/537.36', '/per/transfer/commit/33', '2020-05-13 04:04:40', 3);
INSERT INTO `accessLog` VALUES (15, 'org.dev.hrm.controller.per.EmployeeTransferController', 'getEmployeeTransferInfo()', 'FORM', '{\"size\":\"10\",\"name\":\"\",\"page\":\"1\"}', 'GET', 'http://localhost:8080', '127.0.0.1', 'Windows 10', 'Chrome 8', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.138 Safari/537.36', '/per/transfer/', '2020-05-13 04:04:41', 3);
INSERT INTO `accessLog` VALUES (16, 'org.dev.hrm.controller.per.EmployeeTransferController', 'commitTransfer()', 'FORM', '\"[34]\"', 'POST', 'http://localhost:8080', '127.0.0.1', 'Windows 10', 'Chrome 8', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.138 Safari/537.36', '/per/transfer/commit/34', '2020-05-13 04:04:43', 3);
INSERT INTO `accessLog` VALUES (17, 'org.dev.hrm.controller.per.EmployeeTransferController', 'getEmployeeTransferInfo()', 'FORM', '{\"size\":\"10\",\"name\":\"\",\"page\":\"1\"}', 'GET', 'http://localhost:8080', '127.0.0.1', 'Windows 10', 'Chrome 8', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.138 Safari/537.36', '/per/transfer/', '2020-05-13 04:04:43', 3);
INSERT INTO `accessLog` VALUES (18, 'org.dev.hrm.controller.per.EmployeeInfoController', 'getEmployeeInfo()', 'FORM', '{\"size\":\"10\",\"name\":\"\",\"page\":\"1\"}', 'GET', 'http://localhost:8080', '127.0.0.1', 'Windows 10', 'Chrome 8', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.138 Safari/537.36', '/per/emp/', '2020-05-13 04:04:44', 3);
INSERT INTO `accessLog` VALUES (19, 'org.dev.hrm.controller.per.EmployeeInfoController', 'getAllPositions()', 'FORM', '\"[]\"', 'GET', 'http://localhost:8080', '127.0.0.1', 'Windows 10', 'Chrome 8', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.138 Safari/537.36', '/per/emp/positions', '2020-05-13 04:04:45', 3);
INSERT INTO `accessLog` VALUES (20, 'org.dev.hrm.controller.per.EmployeeTransferController', 'getEmployeeTransferInfo()', 'FORM', '{\"size\":\"10\",\"name\":\"\",\"page\":\"1\"}', 'GET', 'http://localhost:8080', '127.0.0.1', 'Windows 10', 'Chrome 8', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.138 Safari/537.36', '/per/transfer/', '2020-05-13 04:04:46', 3);
INSERT INTO `accessLog` VALUES (21, 'org.dev.hrm.controller.per.EmployeeTrainController', 'getTrainingInfo()', 'FORM', '{\"size\":\"10\",\"page\":\"1\"}', 'GET', 'http://localhost:8080', '127.0.0.1', 'Windows 10', 'Chrome 8', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.138 Safari/537.36', '/per/train/', '2020-05-13 04:04:47', 3);
INSERT INTO `accessLog` VALUES (22, 'org.dev.hrm.controller.dep.DepartmentController', 'getAllDepartmentsByParentId()', 'FORM', '\"[]\"', 'GET', 'http://localhost:8080', '127.0.0.1', 'Windows 10', 'Chrome 8', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.138 Safari/537.36', '/dep/', '2020-05-13 04:04:49', 3);
INSERT INTO `accessLog` VALUES (23, 'org.dev.hrm.controller.dep.DepartmentController', 'addDep()', 'application/json;charset=UTF-8', '\"[{\\\"name\\\":\\\"123123\\\",\\\"parentId\\\":1,\\\"children\\\":[]}]\"', 'POST', 'http://localhost:8080', '127.0.0.1', 'Windows 10', 'Chrome 8', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.138 Safari/537.36', '/dep/', '2020-05-13 04:04:53', 3);
INSERT INTO `accessLog` VALUES (24, 'org.dev.hrm.controller.dep.DepartmentController', 'addDep()', 'application/json;charset=UTF-8', '\"[{\\\"name\\\":\\\"123123\\\",\\\"parentId\\\":21,\\\"children\\\":[]}]\"', 'POST', 'http://localhost:8080', '127.0.0.1', 'Windows 10', 'Chrome 8', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.138 Safari/537.36', '/dep/', '2020-05-13 04:04:56', 3);
INSERT INTO `accessLog` VALUES (25, 'org.dev.hrm.controller.dep.DepartmentController', 'deleteDepById()', 'FORM', '\"[22]\"', 'DELETE', 'http://localhost:8080', '127.0.0.1', 'Windows 10', 'Chrome 8', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.138 Safari/537.36', '/dep/22', '2020-05-13 04:04:59', 3);
INSERT INTO `accessLog` VALUES (26, 'org.dev.hrm.controller.dep.DepartmentController', 'deleteDepById()', 'FORM', '\"[21]\"', 'DELETE', 'http://localhost:8080', '127.0.0.1', 'Windows 10', 'Chrome 8', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.138 Safari/537.36', '/dep/21', '2020-05-13 04:05:02', 3);
INSERT INTO `accessLog` VALUES (27, 'org.dev.hrm.controller.dep.DepartmentController', 'getAllDepartmentsByParentId()', 'FORM', '\"[]\"', 'GET', 'http://localhost:8080', '127.0.0.1', 'Windows 10', 'Chrome 8', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.138 Safari/537.36', '/dep/', '2020-05-13 04:05:33', 3);
INSERT INTO `accessLog` VALUES (28, 'org.dev.hrm.controller.dep.DepartmentController', 'getAllDepartmentsByParentId()', 'FORM', '\"[]\"', 'GET', 'http://localhost:8080', '127.0.0.1', 'Windows 10', 'Chrome 8', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.138 Safari/537.36', '/dep/', '2020-05-13 04:05:34', 3);

-- ----------------------------
-- Table structure for adjustsalary
-- ----------------------------
DROP TABLE IF EXISTS `adjustsalary`;
CREATE TABLE `adjustsalary`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `eid` int(11) NULL DEFAULT NULL,
  `asDate` date NULL DEFAULT NULL COMMENT '调薪日期',
  `amount` int(11) NULL DEFAULT NULL COMMENT '调前额度',
  `reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '调薪原因',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `pid`(`eid`) USING BTREE,
  CONSTRAINT `adjustsalary_ibfk_1` FOREIGN KEY (`eid`) REFERENCES `employee` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of adjustsalary
-- ----------------------------
INSERT INTO `adjustsalary` VALUES (9, 1931, '2020-05-12', 10000, '原因', '无');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  `parentId` int(11) NULL DEFAULT NULL,
  `depPath` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `enabled` tinyint(1) NULL DEFAULT 1,
  `isParent` tinyint(1) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 AVG_ROW_LENGTH = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (1, '董事会', -1, '1', 1, 1);
INSERT INTO `department` VALUES (3, '总经理', 1, '.1.3', 1, 1);
INSERT INTO `department` VALUES (5, '人事部', 3, '.1.3.5', 1, 1);
INSERT INTO `department` VALUES (7, '财务部', 3, '.1.3.7', 1, 0);
INSERT INTO `department` VALUES (11, '运维部', 3, '.1.3.11', 1, 0);
INSERT INTO `department` VALUES (13, '培训专员', 5, '.1.3.5.13', 1, 0);
INSERT INTO `department` VALUES (15, '研发部', 3, '.1.3.15', 1, 0);

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '员工编号',
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工姓名',
  `gender` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `birthday` date NULL DEFAULT NULL COMMENT '出生日期',
  `idCard` char(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号',
  `wedlock` enum('已婚','未婚','离异') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '婚姻状况',
  `nationId` int(8) NULL DEFAULT NULL COMMENT '民族',
  `nativePlace` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '籍贯',
  `politicId` int(8) NULL DEFAULT NULL COMMENT '政治面貌',
  `email` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话号码',
  `address` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系地址',
  `departmentId` int(11) NULL DEFAULT NULL COMMENT '所属部门',
  `jobLevelId` int(11) NULL DEFAULT NULL COMMENT '职称ID',
  `posId` int(11) NULL DEFAULT NULL COMMENT '职位ID',
  `engageForm` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '聘用形式',
  `tiptopDegree` enum('博士','硕士','本科','大专','高中','初中','小学','其他') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最高学历',
  `specialty` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属专业',
  `school` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '毕业院校',
  `beginDate` date NULL DEFAULT NULL COMMENT '入职日期',
  `workState` enum('在职','离职','实习','试用') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '在职' COMMENT '在职状态',
  `workID` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工号',
  `contractTerm` double NULL DEFAULT NULL COMMENT '合同期限',
  `conversionTime` date NULL DEFAULT NULL COMMENT '转正日期',
  `notWorkDate` date NULL DEFAULT NULL COMMENT '离职日期',
  `beginContract` date NULL DEFAULT NULL COMMENT '合同起始日期',
  `endContract` date NULL DEFAULT NULL COMMENT '合同终止日期',
  `workAge` int(11) NULL DEFAULT NULL COMMENT '工龄',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `departmentId`(`departmentId`) USING BTREE,
  INDEX `jobId`(`jobLevelId`) USING BTREE,
  INDEX `dutyId`(`posId`) USING BTREE,
  INDEX `nationId`(`nationId`) USING BTREE,
  INDEX `politicId`(`politicId`) USING BTREE,
  INDEX `workID_key`(`workID`) USING BTREE,
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`departmentId`) REFERENCES `department` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `employee_ibfk_2` FOREIGN KEY (`jobLevelId`) REFERENCES `joblevel` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `employee_ibfk_3` FOREIGN KEY (`posId`) REFERENCES `position` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `employee_ibfk_4` FOREIGN KEY (`nationId`) REFERENCES `nation` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `employee_ibfk_5` FOREIGN KEY (`politicId`) REFERENCES `politicsstatus` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2559 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (1931, '王多鱼', '男', '1970-01-27', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 1, 1, 1, '劳动合同', '本科', '信息管理与信息系统', '纽约大学', '1997-12-25', '在职', '00000001', 2, '2097-12-25', NULL, '1997-12-25', '2099-12-25', NULL);
INSERT INTO `employee` VALUES (1932, '王少鱼', '男', '1970-01-26', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 13, 2, 2, '劳动合同', '本科', '信息管理与信息系统', '纽约大学', '1997-12-24', '在职', '00000002', 2, '2097-12-24', NULL, '1997-12-24', '2099-12-24', NULL);
INSERT INTO `employee` VALUES (1933, '王大鱼', '男', '1970-01-27', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 3, 2, 2, '劳动合同', '本科', '信息管理与信息系统', '纽约大学', '1997-12-25', '在职', '00000003', 2, '2097-12-25', NULL, '1997-12-25', '2099-12-25', NULL);
INSERT INTO `employee` VALUES (1934, '王小鱼', '男', '1970-01-28', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 3, 2, 2, '劳动合同', '本科', '信息管理与信息系统', '纽约大学', '1997-12-26', '在职', '00000004', 2, '2097-12-26', NULL, '1997-12-26', '2099-12-26', NULL);
INSERT INTO `employee` VALUES (1940, '培训员工', '男', '2002-01-29', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 13, 6, 37, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-27', '在职', '00000005', 2, '2021-12-27', NULL, '2020-12-27', '2022-12-27', NULL);
INSERT INTO `employee` VALUES (1941, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000006', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (1942, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000007', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (1943, '研发员工', '男', '2002-01-31', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学123', '2020-12-29', '在职', '00000008', 2, '2021-12-29', NULL, '2020-12-29', '2022-12-29', NULL);
INSERT INTO `employee` VALUES (1944, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000009', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (1945, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000010', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (1946, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000011', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (1947, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000012', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2018, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000013', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2019, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000014', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2020, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000015', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2021, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000016', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2022, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000017', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2023, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000018', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2024, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000019', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2025, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000020', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2026, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000021', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2027, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000022', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2028, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000023', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2029, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000024', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2030, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000025', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2031, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000026', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2032, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000027', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2033, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000028', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2034, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000029', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2035, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000030', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2036, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000031', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2037, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000032', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2038, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000033', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2039, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000034', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2040, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000035', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2041, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000036', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2042, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000037', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2043, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000038', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2044, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000039', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2045, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000040', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2046, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000041', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2047, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000042', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2048, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000043', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2049, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000044', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2050, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000045', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2051, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000046', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2052, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000047', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2053, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000048', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2054, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000049', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2055, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000050', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2056, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000051', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2057, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000052', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2058, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000053', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2059, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000054', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2060, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000055', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2061, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000056', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2062, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000057', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2063, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000058', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2064, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000059', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2065, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000060', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2066, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000061', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2067, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000113', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2068, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000114', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2069, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000115', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2070, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000116', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2071, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000117', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2072, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000118', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2073, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000119', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2074, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000120', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2075, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000121', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2076, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000122', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2077, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000123', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2078, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000124', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2079, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000125', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2080, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000126', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2081, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000127', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2082, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000128', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2083, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000129', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2084, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000130', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2085, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000131', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2086, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000132', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2087, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000133', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2088, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000134', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2089, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000135', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2090, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000136', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2091, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000137', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2092, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000138', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2093, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000139', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2094, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000140', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2095, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000141', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2096, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000142', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2097, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000143', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2098, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000144', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2099, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000145', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2100, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000146', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2101, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000147', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2102, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000148', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2103, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000149', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2104, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000150', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2105, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000151', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2106, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000152', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2107, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000153', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2108, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000154', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2109, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000155', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2110, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000156', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2111, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000157', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2112, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000158', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2113, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000159', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2114, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000160', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2115, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000161', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2116, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000213', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2117, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000214', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2118, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000215', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2119, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000216', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2120, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000217', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2121, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000218', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2122, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000219', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2123, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000220', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2124, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000221', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2125, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000222', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2126, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000223', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2127, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000224', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2128, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000225', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2129, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000226', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2130, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000227', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2131, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000228', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2132, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000229', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2133, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000230', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2134, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000231', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2135, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000232', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2136, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000233', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2137, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000234', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2138, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000235', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2139, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000236', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2140, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000237', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2141, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000238', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2142, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000239', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2143, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000240', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2144, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000241', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2145, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000242', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2146, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000243', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2147, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000244', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2148, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000245', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2149, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000246', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2150, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000247', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2151, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000248', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2152, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000249', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2153, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000250', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2154, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000251', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2155, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000252', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2156, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000253', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2157, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000254', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2158, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000255', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2159, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000256', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2160, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000257', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2161, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000258', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2162, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000259', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2163, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000260', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2164, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000261', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2165, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000313', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2166, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000314', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2167, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000315', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2168, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000316', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2169, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000317', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2170, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000318', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2171, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000319', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2172, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000320', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2173, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000321', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2174, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000322', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2175, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000323', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2176, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000324', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2177, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000325', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2178, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000326', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2179, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000327', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2180, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000328', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2181, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000329', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2182, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000330', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2183, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000331', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2184, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000332', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2185, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000333', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2186, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000334', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2187, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000335', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2188, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000336', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2189, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000337', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2190, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000338', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2191, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000339', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2192, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000340', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2193, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000341', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2194, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000342', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2195, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000343', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2196, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000344', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2197, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000345', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2198, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000346', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2199, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000347', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2200, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000348', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2201, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000349', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2202, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000350', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2203, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000351', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2204, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000352', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2205, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000353', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2206, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000354', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2207, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000355', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2208, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000356', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2209, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000357', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2210, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000358', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2211, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000359', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2212, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000360', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2213, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000361', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2214, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000413', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2215, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000414', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2216, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000415', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2217, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000416', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2218, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000417', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2219, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000418', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2220, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000419', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2221, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000420', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2222, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000421', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2223, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000422', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2224, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000423', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2225, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000424', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2226, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000425', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2227, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000426', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2228, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000427', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2229, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000428', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2230, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000429', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2231, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000430', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2232, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000431', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2233, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000432', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2234, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000433', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2235, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000434', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2236, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000435', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2237, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000436', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2238, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000437', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2239, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000438', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2240, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000439', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2241, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000440', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2242, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000441', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2243, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000442', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2244, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000443', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2245, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000444', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2246, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000445', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2247, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000446', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2248, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000447', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2249, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000448', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2250, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000449', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2251, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000450', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2252, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000451', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2253, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000452', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2254, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000453', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2255, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000454', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2256, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000455', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2257, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000456', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2258, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000457', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2259, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000458', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2260, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000459', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2261, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000460', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2262, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000461', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2263, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000513', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2264, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000514', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2265, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000515', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2266, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000516', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2267, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000517', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2268, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000518', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2269, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000519', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2270, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000520', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2271, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000521', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2272, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000522', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2273, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000523', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2274, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000524', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2275, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000525', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2276, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000526', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2277, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000527', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2278, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000528', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2279, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000529', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2280, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000530', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2281, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000531', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2282, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000532', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2283, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000533', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2284, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000534', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2285, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000535', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2286, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000536', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2287, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000537', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2288, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000538', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2289, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000539', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2290, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000540', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2291, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000541', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2292, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000542', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2293, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000543', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2294, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000544', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2295, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000545', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2296, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000546', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2297, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000547', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2298, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000548', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2299, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000549', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2300, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000550', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2301, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000551', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2302, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000552', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2303, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000553', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2304, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000554', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2305, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000555', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2306, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000556', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2307, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000557', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2308, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000558', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2309, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000559', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2310, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000560', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2311, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000561', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2312, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000613', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2313, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000614', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2314, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000615', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2315, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000616', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2316, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000617', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2317, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000618', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2318, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000619', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2319, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000620', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2320, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000621', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2321, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000622', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2322, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000623', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2323, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000624', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2324, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000625', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2325, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000626', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2326, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000627', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2327, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000628', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2328, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000629', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2329, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000630', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2330, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000631', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2331, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000632', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2332, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000633', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2333, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000634', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2334, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000635', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2335, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000636', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2336, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000637', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2337, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000638', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2338, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000639', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2339, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000640', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2340, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000641', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2341, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000642', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2342, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000643', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2343, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000644', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2344, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000645', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2345, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000646', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2346, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000647', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2347, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000648', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2348, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000649', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2349, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000650', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2350, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000651', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2351, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000652', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2352, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000653', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2353, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000654', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2354, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000655', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2355, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000656', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2356, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000657', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2357, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000658', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2358, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000659', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2359, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000660', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2360, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000661', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2361, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000713', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2362, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000714', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2363, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000715', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2364, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000716', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2365, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000717', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2366, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000718', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2367, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000719', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2368, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000720', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2369, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000721', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2370, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000722', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2371, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000723', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2372, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000724', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2373, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000725', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2374, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000726', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2375, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000727', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2376, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000728', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2377, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000729', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2378, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000730', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2379, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000731', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2380, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000732', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2381, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000733', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2382, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000734', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2383, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000735', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2384, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000736', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2385, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000737', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2386, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000738', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2387, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000739', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2388, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000740', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2389, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000741', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2390, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000742', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2391, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000743', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2392, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000744', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2393, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000745', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2394, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000746', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2395, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000747', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2396, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000748', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2397, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000749', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2398, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000750', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2399, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000751', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2400, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000752', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2401, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000753', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2402, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000754', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2403, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000755', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2404, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000756', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2405, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000757', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2406, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000758', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2407, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000759', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2408, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000760', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2409, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000761', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2410, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000813', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2411, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000814', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2412, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000815', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2413, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000816', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2414, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000817', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2415, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000818', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2416, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000819', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2417, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000820', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2418, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000821', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2419, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000822', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2420, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000823', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2421, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000824', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2422, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000825', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2423, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000826', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2424, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000827', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2425, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000828', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2426, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000829', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2427, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000830', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2428, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000831', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2429, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000832', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2430, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000833', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2431, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000834', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2432, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000835', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2433, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000836', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2434, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000837', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2435, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000838', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2436, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000839', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2437, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000840', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2438, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000841', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2439, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000842', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2440, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000843', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2441, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000844', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2442, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000845', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2443, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000846', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2444, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000847', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2445, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000848', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2446, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000849', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2447, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000850', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2448, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000851', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2449, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000852', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2450, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000853', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2451, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000854', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2452, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000855', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2453, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000856', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2454, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000857', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2455, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000858', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2456, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000859', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2457, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000860', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2458, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000861', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2459, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000913', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2460, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000914', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2461, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000915', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2462, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000916', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2463, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000917', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2464, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000918', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2465, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000919', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2466, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000920', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2467, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000921', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2468, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000922', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2469, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000923', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2470, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000924', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2471, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000925', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2472, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000926', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2473, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000927', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2474, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000928', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2475, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000929', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2476, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000930', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2477, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000931', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2478, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000932', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2479, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000933', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2480, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000934', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2481, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000935', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2482, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000936', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2483, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000937', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2484, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000938', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2485, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000939', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2486, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000940', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2487, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000941', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2488, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000942', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2489, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000943', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2490, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000944', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2491, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000945', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2492, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000946', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2493, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000947', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2494, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000948', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2495, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000949', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2496, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000950', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2497, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000951', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2498, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000952', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2499, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000953', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2500, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000954', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2501, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000955', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2502, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000956', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2503, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000957', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2504, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000958', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2505, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000959', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2506, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00000960', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2508, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00001013', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2509, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00001014', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2510, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00001015', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2511, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00001016', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2512, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00001017', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2513, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00001018', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2514, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00001019', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2516, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00001021', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2517, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00001022', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2518, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00001023', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2519, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00001024', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2520, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00001025', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2521, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00001026', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2523, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00001028', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2524, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00001029', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2525, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00001030', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2526, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00001031', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2527, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00001032', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2528, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00001033', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2529, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00001034', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2530, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00001035', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2531, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00001036', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2532, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00001037', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2533, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00001038', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2534, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00001039', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2535, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00001040', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2536, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 5, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00001041', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2537, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00001042', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2538, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00001043', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2539, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00001044', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2540, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00001045', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2541, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00001046', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2542, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00001047', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2544, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00001049', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2545, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00001050', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2546, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00001051', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2547, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00001052', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2548, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00001053', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2549, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00001054', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2551, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 4, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00001056', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2552, '研发员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00001057', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2553, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 5, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00001058', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2554, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 4, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00001059', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2555, '运维员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 3, '1610940520@qq.com', '1776543210', '湖北省武汉市', 11, 3, 34, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00001060', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2556, '财务员工', '男', '2002-02-01', '202020202002022222', '已婚', 1, '湖北', 1, '1610940520@qq.com', '1776543210', '湖北省武汉市', 7, 6, 38, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-30', '在职', '00001061', 2, '2021-12-30', NULL, '2020-12-30', '2022-12-30', NULL);
INSERT INTO `employee` VALUES (2557, 'DCY', '男', '2002-01-30', '202020202002022222', '已婚', 1, '湖北', 1, '1764033289@qq.com', '1776543210', '湖北省武汉市', 15, 3, 33, '劳动合同', '本科', '信息管理与信息系统', '三峡大学', '2020-12-28', '在职', '00001062', 2, '2021-12-28', NULL, '2020-12-28', '2022-12-28', NULL);

-- ----------------------------
-- Table structure for employeetrain
-- ----------------------------
DROP TABLE IF EXISTS `employeetrain`;
CREATE TABLE `employeetrain`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `eid` int(11) NULL DEFAULT NULL COMMENT '员工编号',
  `trainDate` datetime(0) NULL DEFAULT NULL COMMENT '培训日期',
  `trainContent` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '培训内容',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `pid`(`eid`) USING BTREE,
  CONSTRAINT `employeetrain_ibfk_1` FOREIGN KEY (`eid`) REFERENCES `employee` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employeetrain
-- ----------------------------
INSERT INTO `employeetrain` VALUES (32, 1931, '2020-04-29 11:00:00', 'CEO培训', '大会议室');

-- ----------------------------
-- Table structure for employeetransfer
-- ----------------------------
DROP TABLE IF EXISTS `employeetransfer`;
CREATE TABLE `employeetransfer`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `eid` int(11) NULL DEFAULT NULL COMMENT '员工ID',
  `afterDepId` int(11) NULL DEFAULT NULL COMMENT '调动后部门',
  `afterJobId` int(11) NULL DEFAULT NULL COMMENT '调动后职位',
  `removeDate` timestamp(0) NULL DEFAULT NULL COMMENT '调动日期',
  `reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '调动原因',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
  `afterLevelId` int(11) NULL DEFAULT NULL COMMENT '调动后的职称',
  `finished` tinyint(1) NULL DEFAULT 0 COMMENT '是否已经生效',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `pid`(`eid`) USING BTREE,
  INDEX `employeeremove_ibfk_2`(`afterDepId`) USING BTREE,
  INDEX `employeeremove_ibfk_3`(`afterJobId`) USING BTREE,
  INDEX `employeetransfer_ibfk_4`(`afterLevelId`) USING BTREE,
  CONSTRAINT `employeetransfer_ibfk_1` FOREIGN KEY (`eid`) REFERENCES `employee` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `employeetransfer_ibfk_2` FOREIGN KEY (`afterDepId`) REFERENCES `department` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `employeetransfer_ibfk_3` FOREIGN KEY (`afterJobId`) REFERENCES `position` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `employeetransfer_ibfk_4` FOREIGN KEY (`afterLevelId`) REFERENCES `joblevel` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employeetransfer
-- ----------------------------
INSERT INTO `employeetransfer` VALUES (33, 1931, 1, 38, '2020-04-26 11:00:00', '1231', '123', 1, 1);
INSERT INTO `employeetransfer` VALUES (34, 1931, 1, 1, '2020-04-30 11:00:00', '123', '123', 1, 1);

-- ----------------------------
-- Table structure for empsalary
-- ----------------------------
DROP TABLE IF EXISTS `empsalary`;
CREATE TABLE `empsalary`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `eid` int(11) NULL DEFAULT NULL,
  `sid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `eid`(`eid`) USING BTREE,
  INDEX `empsalary_ibfk_2`(`sid`) USING BTREE,
  CONSTRAINT `empsalary_ibfk_1` FOREIGN KEY (`eid`) REFERENCES `employee` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `empsalary_ibfk_2` FOREIGN KEY (`sid`) REFERENCES `salary` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 5166 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of empsalary
-- ----------------------------
INSERT INTO `empsalary` VALUES (4611, 1947, 18);
INSERT INTO `empsalary` VALUES (4612, 2024, 18);
INSERT INTO `empsalary` VALUES (4613, 2031, 18);
INSERT INTO `empsalary` VALUES (4614, 2038, 18);
INSERT INTO `empsalary` VALUES (4615, 2045, 18);
INSERT INTO `empsalary` VALUES (4616, 2052, 18);
INSERT INTO `empsalary` VALUES (4617, 2059, 18);
INSERT INTO `empsalary` VALUES (4618, 2066, 18);
INSERT INTO `empsalary` VALUES (4619, 2073, 18);
INSERT INTO `empsalary` VALUES (4620, 2080, 18);
INSERT INTO `empsalary` VALUES (4621, 2087, 18);
INSERT INTO `empsalary` VALUES (4622, 2094, 18);
INSERT INTO `empsalary` VALUES (4623, 2101, 18);
INSERT INTO `empsalary` VALUES (4624, 2108, 18);
INSERT INTO `empsalary` VALUES (4625, 2115, 18);
INSERT INTO `empsalary` VALUES (4626, 2122, 18);
INSERT INTO `empsalary` VALUES (4627, 2129, 18);
INSERT INTO `empsalary` VALUES (4628, 2136, 18);
INSERT INTO `empsalary` VALUES (4629, 2143, 18);
INSERT INTO `empsalary` VALUES (4630, 2150, 18);
INSERT INTO `empsalary` VALUES (4631, 2157, 18);
INSERT INTO `empsalary` VALUES (4632, 2164, 18);
INSERT INTO `empsalary` VALUES (4633, 2171, 18);
INSERT INTO `empsalary` VALUES (4634, 2178, 18);
INSERT INTO `empsalary` VALUES (4635, 2185, 18);
INSERT INTO `empsalary` VALUES (4636, 2192, 18);
INSERT INTO `empsalary` VALUES (4637, 2199, 18);
INSERT INTO `empsalary` VALUES (4638, 2206, 18);
INSERT INTO `empsalary` VALUES (4639, 2213, 18);
INSERT INTO `empsalary` VALUES (4640, 2220, 18);
INSERT INTO `empsalary` VALUES (4641, 2227, 18);
INSERT INTO `empsalary` VALUES (4642, 2234, 18);
INSERT INTO `empsalary` VALUES (4643, 2241, 18);
INSERT INTO `empsalary` VALUES (4644, 2248, 18);
INSERT INTO `empsalary` VALUES (4645, 2255, 18);
INSERT INTO `empsalary` VALUES (4646, 2262, 18);
INSERT INTO `empsalary` VALUES (4647, 2269, 18);
INSERT INTO `empsalary` VALUES (4648, 2276, 18);
INSERT INTO `empsalary` VALUES (4649, 2283, 18);
INSERT INTO `empsalary` VALUES (4650, 2290, 18);
INSERT INTO `empsalary` VALUES (4651, 2297, 18);
INSERT INTO `empsalary` VALUES (4652, 2304, 18);
INSERT INTO `empsalary` VALUES (4653, 2311, 18);
INSERT INTO `empsalary` VALUES (4654, 2318, 18);
INSERT INTO `empsalary` VALUES (4655, 2325, 18);
INSERT INTO `empsalary` VALUES (4656, 2332, 18);
INSERT INTO `empsalary` VALUES (4657, 2339, 18);
INSERT INTO `empsalary` VALUES (4658, 2346, 18);
INSERT INTO `empsalary` VALUES (4659, 2353, 18);
INSERT INTO `empsalary` VALUES (4660, 2360, 18);
INSERT INTO `empsalary` VALUES (4661, 2367, 18);
INSERT INTO `empsalary` VALUES (4662, 2374, 18);
INSERT INTO `empsalary` VALUES (4663, 2381, 18);
INSERT INTO `empsalary` VALUES (4664, 2388, 18);
INSERT INTO `empsalary` VALUES (4665, 2395, 18);
INSERT INTO `empsalary` VALUES (4666, 2402, 18);
INSERT INTO `empsalary` VALUES (4667, 2409, 18);
INSERT INTO `empsalary` VALUES (4668, 2416, 18);
INSERT INTO `empsalary` VALUES (4669, 2423, 18);
INSERT INTO `empsalary` VALUES (4670, 2430, 18);
INSERT INTO `empsalary` VALUES (4671, 2437, 18);
INSERT INTO `empsalary` VALUES (4672, 2444, 18);
INSERT INTO `empsalary` VALUES (4673, 2451, 18);
INSERT INTO `empsalary` VALUES (4674, 2458, 18);
INSERT INTO `empsalary` VALUES (4675, 2465, 18);
INSERT INTO `empsalary` VALUES (4676, 2472, 18);
INSERT INTO `empsalary` VALUES (4677, 2479, 18);
INSERT INTO `empsalary` VALUES (4678, 2486, 18);
INSERT INTO `empsalary` VALUES (4679, 2493, 18);
INSERT INTO `empsalary` VALUES (4680, 2500, 18);
INSERT INTO `empsalary` VALUES (4682, 2514, 18);
INSERT INTO `empsalary` VALUES (4683, 2521, 18);
INSERT INTO `empsalary` VALUES (4684, 2528, 18);
INSERT INTO `empsalary` VALUES (4685, 2535, 18);
INSERT INTO `empsalary` VALUES (4686, 2542, 18);
INSERT INTO `empsalary` VALUES (4687, 2549, 18);
INSERT INTO `empsalary` VALUES (4688, 2556, 18);
INSERT INTO `empsalary` VALUES (4689, 1944, 19);
INSERT INTO `empsalary` VALUES (4690, 1945, 19);
INSERT INTO `empsalary` VALUES (4691, 1946, 19);
INSERT INTO `empsalary` VALUES (4692, 2021, 19);
INSERT INTO `empsalary` VALUES (4693, 2022, 19);
INSERT INTO `empsalary` VALUES (4694, 2023, 19);
INSERT INTO `empsalary` VALUES (4695, 2028, 19);
INSERT INTO `empsalary` VALUES (4696, 2029, 19);
INSERT INTO `empsalary` VALUES (4697, 2030, 19);
INSERT INTO `empsalary` VALUES (4698, 2035, 19);
INSERT INTO `empsalary` VALUES (4699, 2036, 19);
INSERT INTO `empsalary` VALUES (4700, 2037, 19);
INSERT INTO `empsalary` VALUES (4701, 2042, 19);
INSERT INTO `empsalary` VALUES (4702, 2043, 19);
INSERT INTO `empsalary` VALUES (4703, 2044, 19);
INSERT INTO `empsalary` VALUES (4704, 2049, 19);
INSERT INTO `empsalary` VALUES (4705, 2050, 19);
INSERT INTO `empsalary` VALUES (4706, 2051, 19);
INSERT INTO `empsalary` VALUES (4707, 2056, 19);
INSERT INTO `empsalary` VALUES (4708, 2057, 19);
INSERT INTO `empsalary` VALUES (4709, 2058, 19);
INSERT INTO `empsalary` VALUES (4710, 2063, 19);
INSERT INTO `empsalary` VALUES (4711, 2064, 19);
INSERT INTO `empsalary` VALUES (4712, 2065, 19);
INSERT INTO `empsalary` VALUES (4713, 2070, 19);
INSERT INTO `empsalary` VALUES (4714, 2071, 19);
INSERT INTO `empsalary` VALUES (4715, 2072, 19);
INSERT INTO `empsalary` VALUES (4716, 2077, 19);
INSERT INTO `empsalary` VALUES (4717, 2078, 19);
INSERT INTO `empsalary` VALUES (4718, 2079, 19);
INSERT INTO `empsalary` VALUES (4719, 2084, 19);
INSERT INTO `empsalary` VALUES (4720, 2085, 19);
INSERT INTO `empsalary` VALUES (4721, 2086, 19);
INSERT INTO `empsalary` VALUES (4722, 2091, 19);
INSERT INTO `empsalary` VALUES (4723, 2092, 19);
INSERT INTO `empsalary` VALUES (4724, 2093, 19);
INSERT INTO `empsalary` VALUES (4725, 2098, 19);
INSERT INTO `empsalary` VALUES (4726, 2099, 19);
INSERT INTO `empsalary` VALUES (4727, 2100, 19);
INSERT INTO `empsalary` VALUES (4728, 2105, 19);
INSERT INTO `empsalary` VALUES (4729, 2106, 19);
INSERT INTO `empsalary` VALUES (4730, 2107, 19);
INSERT INTO `empsalary` VALUES (4731, 2112, 19);
INSERT INTO `empsalary` VALUES (4732, 2113, 19);
INSERT INTO `empsalary` VALUES (4733, 2114, 19);
INSERT INTO `empsalary` VALUES (4734, 2119, 19);
INSERT INTO `empsalary` VALUES (4735, 2120, 19);
INSERT INTO `empsalary` VALUES (4736, 2121, 19);
INSERT INTO `empsalary` VALUES (4737, 2126, 19);
INSERT INTO `empsalary` VALUES (4738, 2127, 19);
INSERT INTO `empsalary` VALUES (4739, 2128, 19);
INSERT INTO `empsalary` VALUES (4740, 2133, 19);
INSERT INTO `empsalary` VALUES (4741, 2134, 19);
INSERT INTO `empsalary` VALUES (4742, 2135, 19);
INSERT INTO `empsalary` VALUES (4743, 2140, 19);
INSERT INTO `empsalary` VALUES (4744, 2141, 19);
INSERT INTO `empsalary` VALUES (4745, 2142, 19);
INSERT INTO `empsalary` VALUES (4746, 2147, 19);
INSERT INTO `empsalary` VALUES (4747, 2148, 19);
INSERT INTO `empsalary` VALUES (4748, 2149, 19);
INSERT INTO `empsalary` VALUES (4749, 2154, 19);
INSERT INTO `empsalary` VALUES (4750, 2155, 19);
INSERT INTO `empsalary` VALUES (4751, 2156, 19);
INSERT INTO `empsalary` VALUES (4752, 2161, 19);
INSERT INTO `empsalary` VALUES (4753, 2162, 19);
INSERT INTO `empsalary` VALUES (4754, 2163, 19);
INSERT INTO `empsalary` VALUES (4755, 2168, 19);
INSERT INTO `empsalary` VALUES (4756, 2169, 19);
INSERT INTO `empsalary` VALUES (4757, 2170, 19);
INSERT INTO `empsalary` VALUES (4758, 2175, 19);
INSERT INTO `empsalary` VALUES (4759, 2176, 19);
INSERT INTO `empsalary` VALUES (4760, 2177, 19);
INSERT INTO `empsalary` VALUES (4761, 2182, 19);
INSERT INTO `empsalary` VALUES (4762, 2183, 19);
INSERT INTO `empsalary` VALUES (4763, 2184, 19);
INSERT INTO `empsalary` VALUES (4764, 2189, 19);
INSERT INTO `empsalary` VALUES (4765, 2190, 19);
INSERT INTO `empsalary` VALUES (4766, 2191, 19);
INSERT INTO `empsalary` VALUES (4767, 2196, 19);
INSERT INTO `empsalary` VALUES (4768, 2197, 19);
INSERT INTO `empsalary` VALUES (4769, 2198, 19);
INSERT INTO `empsalary` VALUES (4770, 2203, 19);
INSERT INTO `empsalary` VALUES (4771, 2204, 19);
INSERT INTO `empsalary` VALUES (4772, 2205, 19);
INSERT INTO `empsalary` VALUES (4773, 2210, 19);
INSERT INTO `empsalary` VALUES (4774, 2211, 19);
INSERT INTO `empsalary` VALUES (4775, 2212, 19);
INSERT INTO `empsalary` VALUES (4776, 2217, 19);
INSERT INTO `empsalary` VALUES (4777, 2218, 19);
INSERT INTO `empsalary` VALUES (4778, 2219, 19);
INSERT INTO `empsalary` VALUES (4779, 2224, 19);
INSERT INTO `empsalary` VALUES (4780, 2225, 19);
INSERT INTO `empsalary` VALUES (4781, 2226, 19);
INSERT INTO `empsalary` VALUES (4782, 2231, 19);
INSERT INTO `empsalary` VALUES (4783, 2232, 19);
INSERT INTO `empsalary` VALUES (4784, 2233, 19);
INSERT INTO `empsalary` VALUES (4785, 2238, 19);
INSERT INTO `empsalary` VALUES (4786, 2239, 19);
INSERT INTO `empsalary` VALUES (4787, 2240, 19);
INSERT INTO `empsalary` VALUES (4788, 2245, 19);
INSERT INTO `empsalary` VALUES (4789, 2246, 19);
INSERT INTO `empsalary` VALUES (4790, 2247, 19);
INSERT INTO `empsalary` VALUES (4791, 2252, 19);
INSERT INTO `empsalary` VALUES (4792, 2253, 19);
INSERT INTO `empsalary` VALUES (4793, 2254, 19);
INSERT INTO `empsalary` VALUES (4794, 2259, 19);
INSERT INTO `empsalary` VALUES (4795, 2260, 19);
INSERT INTO `empsalary` VALUES (4796, 2261, 19);
INSERT INTO `empsalary` VALUES (4797, 2266, 19);
INSERT INTO `empsalary` VALUES (4798, 2267, 19);
INSERT INTO `empsalary` VALUES (4799, 2268, 19);
INSERT INTO `empsalary` VALUES (4800, 2273, 19);
INSERT INTO `empsalary` VALUES (4801, 2274, 19);
INSERT INTO `empsalary` VALUES (4802, 2275, 19);
INSERT INTO `empsalary` VALUES (4803, 2280, 19);
INSERT INTO `empsalary` VALUES (4804, 2281, 19);
INSERT INTO `empsalary` VALUES (4805, 2282, 19);
INSERT INTO `empsalary` VALUES (4806, 2287, 19);
INSERT INTO `empsalary` VALUES (4807, 2288, 19);
INSERT INTO `empsalary` VALUES (4808, 2289, 19);
INSERT INTO `empsalary` VALUES (4809, 2294, 19);
INSERT INTO `empsalary` VALUES (4810, 2295, 19);
INSERT INTO `empsalary` VALUES (4811, 2296, 19);
INSERT INTO `empsalary` VALUES (4812, 2301, 19);
INSERT INTO `empsalary` VALUES (4813, 2302, 19);
INSERT INTO `empsalary` VALUES (4814, 2303, 19);
INSERT INTO `empsalary` VALUES (4815, 2308, 19);
INSERT INTO `empsalary` VALUES (4816, 2309, 19);
INSERT INTO `empsalary` VALUES (4817, 2310, 19);
INSERT INTO `empsalary` VALUES (4818, 2315, 19);
INSERT INTO `empsalary` VALUES (4819, 2316, 19);
INSERT INTO `empsalary` VALUES (4820, 2317, 19);
INSERT INTO `empsalary` VALUES (4821, 2322, 19);
INSERT INTO `empsalary` VALUES (4822, 2323, 19);
INSERT INTO `empsalary` VALUES (4823, 2324, 19);
INSERT INTO `empsalary` VALUES (4824, 2329, 19);
INSERT INTO `empsalary` VALUES (4825, 2330, 19);
INSERT INTO `empsalary` VALUES (4826, 2331, 19);
INSERT INTO `empsalary` VALUES (4827, 2336, 19);
INSERT INTO `empsalary` VALUES (4828, 2337, 19);
INSERT INTO `empsalary` VALUES (4829, 2338, 19);
INSERT INTO `empsalary` VALUES (4830, 2343, 19);
INSERT INTO `empsalary` VALUES (4831, 2344, 19);
INSERT INTO `empsalary` VALUES (4832, 2345, 19);
INSERT INTO `empsalary` VALUES (4833, 2350, 19);
INSERT INTO `empsalary` VALUES (4834, 2351, 19);
INSERT INTO `empsalary` VALUES (4835, 2352, 19);
INSERT INTO `empsalary` VALUES (4836, 2357, 19);
INSERT INTO `empsalary` VALUES (4837, 2358, 19);
INSERT INTO `empsalary` VALUES (4838, 2359, 19);
INSERT INTO `empsalary` VALUES (4839, 2364, 19);
INSERT INTO `empsalary` VALUES (4840, 2365, 19);
INSERT INTO `empsalary` VALUES (4841, 2366, 19);
INSERT INTO `empsalary` VALUES (4842, 2371, 19);
INSERT INTO `empsalary` VALUES (4843, 2372, 19);
INSERT INTO `empsalary` VALUES (4844, 2373, 19);
INSERT INTO `empsalary` VALUES (4845, 2378, 19);
INSERT INTO `empsalary` VALUES (4846, 2379, 19);
INSERT INTO `empsalary` VALUES (4847, 2380, 19);
INSERT INTO `empsalary` VALUES (4848, 2385, 19);
INSERT INTO `empsalary` VALUES (4849, 2386, 19);
INSERT INTO `empsalary` VALUES (4850, 2387, 19);
INSERT INTO `empsalary` VALUES (4851, 2392, 19);
INSERT INTO `empsalary` VALUES (4852, 2393, 19);
INSERT INTO `empsalary` VALUES (4853, 2394, 19);
INSERT INTO `empsalary` VALUES (4854, 2399, 19);
INSERT INTO `empsalary` VALUES (4855, 2400, 19);
INSERT INTO `empsalary` VALUES (4856, 2401, 19);
INSERT INTO `empsalary` VALUES (4857, 2406, 19);
INSERT INTO `empsalary` VALUES (4858, 2407, 19);
INSERT INTO `empsalary` VALUES (4859, 2408, 19);
INSERT INTO `empsalary` VALUES (4860, 2413, 19);
INSERT INTO `empsalary` VALUES (4861, 2414, 19);
INSERT INTO `empsalary` VALUES (4862, 2415, 19);
INSERT INTO `empsalary` VALUES (4863, 2420, 19);
INSERT INTO `empsalary` VALUES (4864, 2421, 19);
INSERT INTO `empsalary` VALUES (4865, 2422, 19);
INSERT INTO `empsalary` VALUES (4866, 2427, 19);
INSERT INTO `empsalary` VALUES (4867, 2428, 19);
INSERT INTO `empsalary` VALUES (4868, 2429, 19);
INSERT INTO `empsalary` VALUES (4869, 2434, 19);
INSERT INTO `empsalary` VALUES (4870, 2435, 19);
INSERT INTO `empsalary` VALUES (4871, 2436, 19);
INSERT INTO `empsalary` VALUES (4872, 2441, 19);
INSERT INTO `empsalary` VALUES (4873, 2442, 19);
INSERT INTO `empsalary` VALUES (4874, 2443, 19);
INSERT INTO `empsalary` VALUES (4875, 2448, 19);
INSERT INTO `empsalary` VALUES (4876, 2449, 19);
INSERT INTO `empsalary` VALUES (4877, 2450, 19);
INSERT INTO `empsalary` VALUES (4878, 2455, 19);
INSERT INTO `empsalary` VALUES (4879, 2456, 19);
INSERT INTO `empsalary` VALUES (4880, 2457, 19);
INSERT INTO `empsalary` VALUES (4881, 2462, 19);
INSERT INTO `empsalary` VALUES (4882, 2463, 19);
INSERT INTO `empsalary` VALUES (4883, 2464, 19);
INSERT INTO `empsalary` VALUES (4884, 2469, 19);
INSERT INTO `empsalary` VALUES (4885, 2470, 19);
INSERT INTO `empsalary` VALUES (4886, 2471, 19);
INSERT INTO `empsalary` VALUES (4887, 2476, 19);
INSERT INTO `empsalary` VALUES (4888, 2477, 19);
INSERT INTO `empsalary` VALUES (4889, 2478, 19);
INSERT INTO `empsalary` VALUES (4890, 2483, 19);
INSERT INTO `empsalary` VALUES (4891, 2484, 19);
INSERT INTO `empsalary` VALUES (4892, 2485, 19);
INSERT INTO `empsalary` VALUES (4893, 2490, 19);
INSERT INTO `empsalary` VALUES (4894, 2491, 19);
INSERT INTO `empsalary` VALUES (4895, 2492, 19);
INSERT INTO `empsalary` VALUES (4896, 2497, 19);
INSERT INTO `empsalary` VALUES (4897, 2498, 19);
INSERT INTO `empsalary` VALUES (4898, 2499, 19);
INSERT INTO `empsalary` VALUES (4899, 2504, 19);
INSERT INTO `empsalary` VALUES (4900, 2505, 19);
INSERT INTO `empsalary` VALUES (4901, 2506, 19);
INSERT INTO `empsalary` VALUES (4902, 2511, 19);
INSERT INTO `empsalary` VALUES (4903, 2512, 19);
INSERT INTO `empsalary` VALUES (4904, 2513, 19);
INSERT INTO `empsalary` VALUES (4905, 2518, 19);
INSERT INTO `empsalary` VALUES (4906, 2519, 19);
INSERT INTO `empsalary` VALUES (4907, 2520, 19);
INSERT INTO `empsalary` VALUES (4908, 2525, 19);
INSERT INTO `empsalary` VALUES (4909, 2526, 19);
INSERT INTO `empsalary` VALUES (4910, 2527, 19);
INSERT INTO `empsalary` VALUES (4911, 2532, 19);
INSERT INTO `empsalary` VALUES (4912, 2533, 19);
INSERT INTO `empsalary` VALUES (4913, 2534, 19);
INSERT INTO `empsalary` VALUES (4914, 2539, 19);
INSERT INTO `empsalary` VALUES (4915, 2540, 19);
INSERT INTO `empsalary` VALUES (4916, 2541, 19);
INSERT INTO `empsalary` VALUES (4917, 2546, 19);
INSERT INTO `empsalary` VALUES (4918, 2547, 19);
INSERT INTO `empsalary` VALUES (4919, 2548, 19);
INSERT INTO `empsalary` VALUES (4920, 2553, 19);
INSERT INTO `empsalary` VALUES (4921, 2554, 19);
INSERT INTO `empsalary` VALUES (4922, 2555, 19);
INSERT INTO `empsalary` VALUES (4924, 1941, 20);
INSERT INTO `empsalary` VALUES (4925, 1942, 20);
INSERT INTO `empsalary` VALUES (4926, 1943, 20);
INSERT INTO `empsalary` VALUES (4927, 2018, 20);
INSERT INTO `empsalary` VALUES (4928, 2019, 20);
INSERT INTO `empsalary` VALUES (4929, 2020, 20);
INSERT INTO `empsalary` VALUES (4930, 2025, 20);
INSERT INTO `empsalary` VALUES (4931, 2026, 20);
INSERT INTO `empsalary` VALUES (4932, 2027, 20);
INSERT INTO `empsalary` VALUES (4933, 2032, 20);
INSERT INTO `empsalary` VALUES (4934, 2033, 20);
INSERT INTO `empsalary` VALUES (4935, 2034, 20);
INSERT INTO `empsalary` VALUES (4936, 2039, 20);
INSERT INTO `empsalary` VALUES (4937, 2040, 20);
INSERT INTO `empsalary` VALUES (4938, 2041, 20);
INSERT INTO `empsalary` VALUES (4939, 2046, 20);
INSERT INTO `empsalary` VALUES (4940, 2047, 20);
INSERT INTO `empsalary` VALUES (4941, 2048, 20);
INSERT INTO `empsalary` VALUES (4942, 2053, 20);
INSERT INTO `empsalary` VALUES (4943, 2054, 20);
INSERT INTO `empsalary` VALUES (4944, 2055, 20);
INSERT INTO `empsalary` VALUES (4945, 2060, 20);
INSERT INTO `empsalary` VALUES (4946, 2061, 20);
INSERT INTO `empsalary` VALUES (4947, 2062, 20);
INSERT INTO `empsalary` VALUES (4948, 2067, 20);
INSERT INTO `empsalary` VALUES (4949, 2068, 20);
INSERT INTO `empsalary` VALUES (4950, 2069, 20);
INSERT INTO `empsalary` VALUES (4951, 2074, 20);
INSERT INTO `empsalary` VALUES (4952, 2075, 20);
INSERT INTO `empsalary` VALUES (4953, 2076, 20);
INSERT INTO `empsalary` VALUES (4954, 2081, 20);
INSERT INTO `empsalary` VALUES (4955, 2082, 20);
INSERT INTO `empsalary` VALUES (4956, 2083, 20);
INSERT INTO `empsalary` VALUES (4957, 2088, 20);
INSERT INTO `empsalary` VALUES (4958, 2089, 20);
INSERT INTO `empsalary` VALUES (4959, 2090, 20);
INSERT INTO `empsalary` VALUES (4960, 2095, 20);
INSERT INTO `empsalary` VALUES (4961, 2096, 20);
INSERT INTO `empsalary` VALUES (4962, 2097, 20);
INSERT INTO `empsalary` VALUES (4963, 2102, 20);
INSERT INTO `empsalary` VALUES (4964, 2103, 20);
INSERT INTO `empsalary` VALUES (4965, 2104, 20);
INSERT INTO `empsalary` VALUES (4966, 2109, 20);
INSERT INTO `empsalary` VALUES (4967, 2110, 20);
INSERT INTO `empsalary` VALUES (4968, 2111, 20);
INSERT INTO `empsalary` VALUES (4969, 2116, 20);
INSERT INTO `empsalary` VALUES (4970, 2117, 20);
INSERT INTO `empsalary` VALUES (4971, 2118, 20);
INSERT INTO `empsalary` VALUES (4972, 2123, 20);
INSERT INTO `empsalary` VALUES (4973, 2124, 20);
INSERT INTO `empsalary` VALUES (4974, 2125, 20);
INSERT INTO `empsalary` VALUES (4975, 2130, 20);
INSERT INTO `empsalary` VALUES (4976, 2131, 20);
INSERT INTO `empsalary` VALUES (4977, 2132, 20);
INSERT INTO `empsalary` VALUES (4978, 2137, 20);
INSERT INTO `empsalary` VALUES (4979, 2138, 20);
INSERT INTO `empsalary` VALUES (4980, 2139, 20);
INSERT INTO `empsalary` VALUES (4981, 2144, 20);
INSERT INTO `empsalary` VALUES (4982, 2145, 20);
INSERT INTO `empsalary` VALUES (4983, 2146, 20);
INSERT INTO `empsalary` VALUES (4984, 2151, 20);
INSERT INTO `empsalary` VALUES (4985, 2152, 20);
INSERT INTO `empsalary` VALUES (4986, 2153, 20);
INSERT INTO `empsalary` VALUES (4987, 2158, 20);
INSERT INTO `empsalary` VALUES (4988, 2159, 20);
INSERT INTO `empsalary` VALUES (4989, 2160, 20);
INSERT INTO `empsalary` VALUES (4990, 2165, 20);
INSERT INTO `empsalary` VALUES (4991, 2166, 20);
INSERT INTO `empsalary` VALUES (4992, 2167, 20);
INSERT INTO `empsalary` VALUES (4993, 2172, 20);
INSERT INTO `empsalary` VALUES (4994, 2173, 20);
INSERT INTO `empsalary` VALUES (4995, 2174, 20);
INSERT INTO `empsalary` VALUES (4996, 2179, 20);
INSERT INTO `empsalary` VALUES (4997, 2180, 20);
INSERT INTO `empsalary` VALUES (4998, 2181, 20);
INSERT INTO `empsalary` VALUES (4999, 2186, 20);
INSERT INTO `empsalary` VALUES (5000, 2187, 20);
INSERT INTO `empsalary` VALUES (5001, 2188, 20);
INSERT INTO `empsalary` VALUES (5002, 2193, 20);
INSERT INTO `empsalary` VALUES (5003, 2194, 20);
INSERT INTO `empsalary` VALUES (5004, 2195, 20);
INSERT INTO `empsalary` VALUES (5005, 2200, 20);
INSERT INTO `empsalary` VALUES (5006, 2201, 20);
INSERT INTO `empsalary` VALUES (5007, 2202, 20);
INSERT INTO `empsalary` VALUES (5008, 2207, 20);
INSERT INTO `empsalary` VALUES (5009, 2208, 20);
INSERT INTO `empsalary` VALUES (5010, 2209, 20);
INSERT INTO `empsalary` VALUES (5011, 2214, 20);
INSERT INTO `empsalary` VALUES (5012, 2215, 20);
INSERT INTO `empsalary` VALUES (5013, 2216, 20);
INSERT INTO `empsalary` VALUES (5014, 2221, 20);
INSERT INTO `empsalary` VALUES (5015, 2222, 20);
INSERT INTO `empsalary` VALUES (5016, 2223, 20);
INSERT INTO `empsalary` VALUES (5017, 2228, 20);
INSERT INTO `empsalary` VALUES (5018, 2229, 20);
INSERT INTO `empsalary` VALUES (5019, 2230, 20);
INSERT INTO `empsalary` VALUES (5020, 2235, 20);
INSERT INTO `empsalary` VALUES (5021, 2236, 20);
INSERT INTO `empsalary` VALUES (5022, 2237, 20);
INSERT INTO `empsalary` VALUES (5023, 2242, 20);
INSERT INTO `empsalary` VALUES (5024, 2243, 20);
INSERT INTO `empsalary` VALUES (5025, 2244, 20);
INSERT INTO `empsalary` VALUES (5026, 2249, 20);
INSERT INTO `empsalary` VALUES (5027, 2250, 20);
INSERT INTO `empsalary` VALUES (5028, 2251, 20);
INSERT INTO `empsalary` VALUES (5029, 2256, 20);
INSERT INTO `empsalary` VALUES (5030, 2257, 20);
INSERT INTO `empsalary` VALUES (5031, 2258, 20);
INSERT INTO `empsalary` VALUES (5032, 2263, 20);
INSERT INTO `empsalary` VALUES (5033, 2264, 20);
INSERT INTO `empsalary` VALUES (5034, 2265, 20);
INSERT INTO `empsalary` VALUES (5035, 2270, 20);
INSERT INTO `empsalary` VALUES (5036, 2271, 20);
INSERT INTO `empsalary` VALUES (5037, 2272, 20);
INSERT INTO `empsalary` VALUES (5038, 2277, 20);
INSERT INTO `empsalary` VALUES (5039, 2278, 20);
INSERT INTO `empsalary` VALUES (5040, 2279, 20);
INSERT INTO `empsalary` VALUES (5041, 2284, 20);
INSERT INTO `empsalary` VALUES (5042, 2285, 20);
INSERT INTO `empsalary` VALUES (5043, 2286, 20);
INSERT INTO `empsalary` VALUES (5044, 2291, 20);
INSERT INTO `empsalary` VALUES (5045, 2292, 20);
INSERT INTO `empsalary` VALUES (5046, 2293, 20);
INSERT INTO `empsalary` VALUES (5047, 2298, 20);
INSERT INTO `empsalary` VALUES (5048, 2299, 20);
INSERT INTO `empsalary` VALUES (5049, 2300, 20);
INSERT INTO `empsalary` VALUES (5050, 2305, 20);
INSERT INTO `empsalary` VALUES (5051, 2306, 20);
INSERT INTO `empsalary` VALUES (5052, 2307, 20);
INSERT INTO `empsalary` VALUES (5053, 2312, 20);
INSERT INTO `empsalary` VALUES (5054, 2313, 20);
INSERT INTO `empsalary` VALUES (5055, 2314, 20);
INSERT INTO `empsalary` VALUES (5056, 2319, 20);
INSERT INTO `empsalary` VALUES (5057, 2320, 20);
INSERT INTO `empsalary` VALUES (5058, 2321, 20);
INSERT INTO `empsalary` VALUES (5059, 2326, 20);
INSERT INTO `empsalary` VALUES (5060, 2327, 20);
INSERT INTO `empsalary` VALUES (5061, 2328, 20);
INSERT INTO `empsalary` VALUES (5062, 2333, 20);
INSERT INTO `empsalary` VALUES (5063, 2334, 20);
INSERT INTO `empsalary` VALUES (5064, 2335, 20);
INSERT INTO `empsalary` VALUES (5065, 2340, 20);
INSERT INTO `empsalary` VALUES (5066, 2341, 20);
INSERT INTO `empsalary` VALUES (5067, 2342, 20);
INSERT INTO `empsalary` VALUES (5068, 2347, 20);
INSERT INTO `empsalary` VALUES (5069, 2348, 20);
INSERT INTO `empsalary` VALUES (5070, 2349, 20);
INSERT INTO `empsalary` VALUES (5071, 2354, 20);
INSERT INTO `empsalary` VALUES (5072, 2355, 20);
INSERT INTO `empsalary` VALUES (5073, 2356, 20);
INSERT INTO `empsalary` VALUES (5074, 2361, 20);
INSERT INTO `empsalary` VALUES (5075, 2362, 20);
INSERT INTO `empsalary` VALUES (5076, 2363, 20);
INSERT INTO `empsalary` VALUES (5077, 2368, 20);
INSERT INTO `empsalary` VALUES (5078, 2369, 20);
INSERT INTO `empsalary` VALUES (5079, 2370, 20);
INSERT INTO `empsalary` VALUES (5080, 2375, 20);
INSERT INTO `empsalary` VALUES (5081, 2376, 20);
INSERT INTO `empsalary` VALUES (5082, 2377, 20);
INSERT INTO `empsalary` VALUES (5083, 2382, 20);
INSERT INTO `empsalary` VALUES (5084, 2383, 20);
INSERT INTO `empsalary` VALUES (5085, 2384, 20);
INSERT INTO `empsalary` VALUES (5086, 2389, 20);
INSERT INTO `empsalary` VALUES (5087, 2390, 20);
INSERT INTO `empsalary` VALUES (5088, 2391, 20);
INSERT INTO `empsalary` VALUES (5089, 2396, 20);
INSERT INTO `empsalary` VALUES (5090, 2397, 20);
INSERT INTO `empsalary` VALUES (5091, 2398, 20);
INSERT INTO `empsalary` VALUES (5092, 2403, 20);
INSERT INTO `empsalary` VALUES (5093, 2404, 20);
INSERT INTO `empsalary` VALUES (5094, 2405, 20);
INSERT INTO `empsalary` VALUES (5095, 2410, 20);
INSERT INTO `empsalary` VALUES (5096, 2411, 20);
INSERT INTO `empsalary` VALUES (5097, 2412, 20);
INSERT INTO `empsalary` VALUES (5098, 2417, 20);
INSERT INTO `empsalary` VALUES (5099, 2418, 20);
INSERT INTO `empsalary` VALUES (5100, 2419, 20);
INSERT INTO `empsalary` VALUES (5101, 2424, 20);
INSERT INTO `empsalary` VALUES (5102, 2425, 20);
INSERT INTO `empsalary` VALUES (5103, 2426, 20);
INSERT INTO `empsalary` VALUES (5104, 2431, 20);
INSERT INTO `empsalary` VALUES (5105, 2432, 20);
INSERT INTO `empsalary` VALUES (5106, 2433, 20);
INSERT INTO `empsalary` VALUES (5107, 2438, 20);
INSERT INTO `empsalary` VALUES (5108, 2439, 20);
INSERT INTO `empsalary` VALUES (5109, 2440, 20);
INSERT INTO `empsalary` VALUES (5110, 2445, 20);
INSERT INTO `empsalary` VALUES (5111, 2446, 20);
INSERT INTO `empsalary` VALUES (5112, 2447, 20);
INSERT INTO `empsalary` VALUES (5113, 2452, 20);
INSERT INTO `empsalary` VALUES (5114, 2453, 20);
INSERT INTO `empsalary` VALUES (5115, 2454, 20);
INSERT INTO `empsalary` VALUES (5116, 2459, 20);
INSERT INTO `empsalary` VALUES (5117, 2460, 20);
INSERT INTO `empsalary` VALUES (5118, 2461, 20);
INSERT INTO `empsalary` VALUES (5119, 2466, 20);
INSERT INTO `empsalary` VALUES (5120, 2467, 20);
INSERT INTO `empsalary` VALUES (5121, 2468, 20);
INSERT INTO `empsalary` VALUES (5122, 2473, 20);
INSERT INTO `empsalary` VALUES (5123, 2474, 20);
INSERT INTO `empsalary` VALUES (5124, 2475, 20);
INSERT INTO `empsalary` VALUES (5125, 2480, 20);
INSERT INTO `empsalary` VALUES (5126, 2481, 20);
INSERT INTO `empsalary` VALUES (5127, 2482, 20);
INSERT INTO `empsalary` VALUES (5128, 2487, 20);
INSERT INTO `empsalary` VALUES (5129, 2488, 20);
INSERT INTO `empsalary` VALUES (5130, 2489, 20);
INSERT INTO `empsalary` VALUES (5131, 2494, 20);
INSERT INTO `empsalary` VALUES (5132, 2495, 20);
INSERT INTO `empsalary` VALUES (5133, 2496, 20);
INSERT INTO `empsalary` VALUES (5134, 2501, 20);
INSERT INTO `empsalary` VALUES (5135, 2502, 20);
INSERT INTO `empsalary` VALUES (5136, 2503, 20);
INSERT INTO `empsalary` VALUES (5137, 2508, 20);
INSERT INTO `empsalary` VALUES (5138, 2509, 20);
INSERT INTO `empsalary` VALUES (5139, 2510, 20);
INSERT INTO `empsalary` VALUES (5141, 2516, 20);
INSERT INTO `empsalary` VALUES (5142, 2517, 20);
INSERT INTO `empsalary` VALUES (5144, 2523, 20);
INSERT INTO `empsalary` VALUES (5145, 2524, 20);
INSERT INTO `empsalary` VALUES (5146, 2529, 20);
INSERT INTO `empsalary` VALUES (5147, 2530, 20);
INSERT INTO `empsalary` VALUES (5148, 2531, 20);
INSERT INTO `empsalary` VALUES (5149, 2536, 20);
INSERT INTO `empsalary` VALUES (5150, 2537, 20);
INSERT INTO `empsalary` VALUES (5151, 2538, 20);
INSERT INTO `empsalary` VALUES (5153, 2544, 20);
INSERT INTO `empsalary` VALUES (5154, 2545, 20);
INSERT INTO `empsalary` VALUES (5156, 2551, 20);
INSERT INTO `empsalary` VALUES (5157, 2552, 20);
INSERT INTO `empsalary` VALUES (5160, 1932, 16);
INSERT INTO `empsalary` VALUES (5161, 1933, 16);
INSERT INTO `empsalary` VALUES (5162, 1934, 16);
INSERT INTO `empsalary` VALUES (5164, 1940, 21);
INSERT INTO `empsalary` VALUES (5165, 1931, 15);

-- ----------------------------
-- Table structure for hr
-- ----------------------------
DROP TABLE IF EXISTS `hr`;
CREATE TABLE `hr`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'hrID',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '请完善信息' COMMENT '姓名',
  `phone` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '请完善信息' COMMENT '手机号码',
  `telephone` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '请完善信息' COMMENT '住宅电话',
  `address` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '请完善信息' COMMENT '联系地址',
  `enabled` tinyint(1) NULL DEFAULT 1 COMMENT '是否启用',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `userface` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png' COMMENT '头像',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '请完善信息' COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hr
-- ----------------------------
INSERT INTO `hr` VALUES (3, '系统管理员', '1388888888', '1388888888', '湖北武汉', 1, 'admin', '$2a$10$IoOKIqNWToyil7KQsETcR./PP9BqZ3wcP1GwJhjfwFY2VZUEj3jMG', 'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png', '系统管理员');
INSERT INTO `hr` VALUES (10, '卢本伟', '15877776567', '021-7777777', '住在你心里', 1, 'test', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', 'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png', '哦吼');
INSERT INTO `hr` VALUES (11, 'ljx', '15871653387', '无', '湖北省宜昌市', 1, 'ljx', '$2a$10$yXDcYoj.FR4ulbz6uKyV1.fc22yHT4KtRfKuP50OryfwDHBTXSj3G', 'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png', '请完善信息');

-- ----------------------------
-- Table structure for hr_role
-- ----------------------------
DROP TABLE IF EXISTS `hr_role`;
CREATE TABLE `hr_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hrid` int(11) NULL DEFAULT NULL,
  `rid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `rid`(`rid`) USING BTREE,
  INDEX `hr_role_ibfk_1`(`hrid`) USING BTREE,
  CONSTRAINT `hr_role_ibfk_1` FOREIGN KEY (`hrid`) REFERENCES `hr` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `hr_role_ibfk_2` FOREIGN KEY (`rid`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 178 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hr_role
-- ----------------------------
INSERT INTO `hr_role` VALUES (1, 3, 6);
INSERT INTO `hr_role` VALUES (173, 10, 2);
INSERT INTO `hr_role` VALUES (174, 11, 2);
INSERT INTO `hr_role` VALUES (175, 11, 1);
INSERT INTO `hr_role` VALUES (176, 11, 7);
INSERT INTO `hr_role` VALUES (177, 11, 8);

-- ----------------------------
-- Table structure for joblevel
-- ----------------------------
DROP TABLE IF EXISTS `joblevel`;
CREATE TABLE `joblevel`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职称名称',
  `titleLevel` enum('正高级','副高级','中级','初级') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createDate` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `enabled` tinyint(1) NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 AVG_ROW_LENGTH = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of joblevel
-- ----------------------------
INSERT INTO `joblevel` VALUES (1, '教授', '正高级', '2020-04-11 16:53:51', 1);
INSERT INTO `joblevel` VALUES (2, '副教授', '正高级', '2020-04-12 20:12:47', 1);
INSERT INTO `joblevel` VALUES (3, '高级工程师', '副高级', '2020-04-12 20:50:42', 1);
INSERT INTO `joblevel` VALUES (4, '中级工程师', '中级', '2020-04-12 20:51:01', 1);
INSERT INTO `joblevel` VALUES (5, '初级工程师', '初级', '2020-04-12 20:51:13', 1);
INSERT INTO `joblevel` VALUES (6, '正式员工', '初级', '2020-04-12 20:51:24', 1);

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `path` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `component` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `iconCls` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `keepAlive` tinyint(1) NULL DEFAULT NULL,
  `requireAuth` tinyint(1) NULL DEFAULT NULL COMMENT '是否需要登录才可以访问',
  `parentId` int(11) NULL DEFAULT NULL,
  `enabled` tinyint(1) NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `parentId`(`parentId`) USING BTREE,
  CONSTRAINT `menu_ibfk_1` FOREIGN KEY (`parentId`) REFERENCES `menu` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, '/', '', NULL, '所有', NULL, NULL, NULL, NULL, 1);
INSERT INTO `menu` VALUES (2, '/', '/home', 'Home', '人事管理', 'el-icon-user-solid', NULL, 1, 1, 1);
INSERT INTO `menu` VALUES (3, '/', '/home', 'Home', '部门管理', 'el-icon-notebook-1', NULL, 1, 1, 1);
INSERT INTO `menu` VALUES (4, '/', '/home', 'Home', '薪资管理', 'el-icon-coin', NULL, 1, 1, 1);
INSERT INTO `menu` VALUES (5, '/', '/home', 'Home', '统计管理', 'el-icon-s-data', NULL, 1, 1, 1);
INSERT INTO `menu` VALUES (6, '/', '/home', 'Home', '系统管理', 'el-icon-setting', NULL, 1, 1, 1);
INSERT INTO `menu` VALUES (7, '/per/emp/**', '/per/emp', 'PerEmp', '员工资料', NULL, NULL, 1, 2, 1);
INSERT INTO `menu` VALUES (8, '/per/transfer/**', '/per/transfer', 'PerMv', '员工调动', NULL, NULL, 1, 2, 1);
INSERT INTO `menu` VALUES (9, '/sys/pos/**', '/per/pos', 'SysPosition', '职位管理', NULL, NULL, 1, 6, 1);
INSERT INTO `menu` VALUES (10, '/sys/joblevel/**', '/sys/joblevel', 'SysJobLevel', '职称管理', NULL, NULL, 1, 6, 1);
INSERT INTO `menu` VALUES (11, '/per/train/**', '/per/train', 'PerTrain', '员工培训', NULL, NULL, 1, 2, 1);
INSERT INTO `menu` VALUES (12, '/dep/info/**', '/dep/info', 'DepInfo', '部门员工信息', NULL, NULL, 1, 3, 1);
INSERT INTO `menu` VALUES (13, '/per/emp/**', '/dep/manage', 'DepManage', '部门管理', NULL, NULL, 1, 3, 1);
INSERT INTO `menu` VALUES (14, '/sal/sob/**', '/sal/sob', 'SalSob', '工资账套管理', NULL, NULL, 1, 4, 1);
INSERT INTO `menu` VALUES (15, '/sal/sobcfg/**', '/sal/sobcfg', 'SalSobCfg', '员工账套设置', NULL, NULL, 1, 4, 1);
INSERT INTO `menu` VALUES (16, '/sal/table/**', '/sal/table', 'SalTable', '部门工资表', NULL, NULL, 1, 4, 1);
INSERT INTO `menu` VALUES (17, '/sal/adjust/**', '/sal/adjust', 'SalAdjust', '员工奖惩', NULL, NULL, 1, 4, 1);
INSERT INTO `menu` VALUES (23, '/sys/nf/**', '/sys/nf', 'SysNotice', '通知发布管理', NULL, NULL, 1, 6, 1);
INSERT INTO `menu` VALUES (26, '/sys/hr/**', '/sys/hr', 'SysHr', '用户角色管理', NULL, NULL, 1, 6, 1);
INSERT INTO `menu` VALUES (29, '/sys/permiss/**', '/sys/permiss', 'SysPermission', '角色资源管理', NULL, NULL, 1, 6, 1);
INSERT INTO `menu` VALUES (30, '/sys/cache/**', '/sys/cache', 'SysCache', '系统工具', NULL, NULL, 1, 6, 1);
INSERT INTO `menu` VALUES (31, '/sys/access/**', '/sys/access', 'SysAccess', 'HR操作日志', NULL, NULL, 1, 6, 1);

-- ----------------------------
-- Table structure for menu_role
-- ----------------------------
DROP TABLE IF EXISTS `menu_role`;
CREATE TABLE `menu_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mid` int(11) NULL DEFAULT NULL,
  `rid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `mid`(`mid`) USING BTREE,
  INDEX `rid`(`rid`) USING BTREE,
  CONSTRAINT `menu_role_ibfk_1` FOREIGN KEY (`mid`) REFERENCES `menu` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `menu_role_ibfk_2` FOREIGN KEY (`rid`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 765 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu_role
-- ----------------------------
INSERT INTO `menu_role` VALUES (728, 7, 2);
INSERT INTO `menu_role` VALUES (729, 8, 2);
INSERT INTO `menu_role` VALUES (730, 11, 2);
INSERT INTO `menu_role` VALUES (731, 7, 7);
INSERT INTO `menu_role` VALUES (732, 11, 7);
INSERT INTO `menu_role` VALUES (739, 7, 8);
INSERT INTO `menu_role` VALUES (740, 11, 8);
INSERT INTO `menu_role` VALUES (741, 12, 8);
INSERT INTO `menu_role` VALUES (742, 14, 8);
INSERT INTO `menu_role` VALUES (743, 15, 8);
INSERT INTO `menu_role` VALUES (744, 16, 8);
INSERT INTO `menu_role` VALUES (745, 17, 8);
INSERT INTO `menu_role` VALUES (746, 7, 6);
INSERT INTO `menu_role` VALUES (747, 8, 6);
INSERT INTO `menu_role` VALUES (748, 11, 6);
INSERT INTO `menu_role` VALUES (749, 12, 6);
INSERT INTO `menu_role` VALUES (750, 13, 6);
INSERT INTO `menu_role` VALUES (751, 14, 6);
INSERT INTO `menu_role` VALUES (752, 15, 6);
INSERT INTO `menu_role` VALUES (753, 16, 6);
INSERT INTO `menu_role` VALUES (754, 17, 6);
INSERT INTO `menu_role` VALUES (755, 9, 6);
INSERT INTO `menu_role` VALUES (756, 10, 6);
INSERT INTO `menu_role` VALUES (757, 23, 6);
INSERT INTO `menu_role` VALUES (758, 26, 6);
INSERT INTO `menu_role` VALUES (759, 29, 6);
INSERT INTO `menu_role` VALUES (760, 30, 6);
INSERT INTO `menu_role` VALUES (761, 31, 6);
INSERT INTO `menu_role` VALUES (762, 7, 1);
INSERT INTO `menu_role` VALUES (763, 12, 1);
INSERT INTO `menu_role` VALUES (764, 13, 1);

-- ----------------------------
-- Table structure for msgcontent
-- ----------------------------
DROP TABLE IF EXISTS `msgcontent`;
CREATE TABLE `msgcontent`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `message` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createDate` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of msgcontent
-- ----------------------------

-- ----------------------------
-- Table structure for nation
-- ----------------------------
DROP TABLE IF EXISTS `nation`;
CREATE TABLE `nation`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 57 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nation
-- ----------------------------
INSERT INTO `nation` VALUES (1, '汉族');
INSERT INTO `nation` VALUES (2, '蒙古族');
INSERT INTO `nation` VALUES (3, '回族');
INSERT INTO `nation` VALUES (4, '藏族');
INSERT INTO `nation` VALUES (5, '维吾尔族');
INSERT INTO `nation` VALUES (6, '苗族');
INSERT INTO `nation` VALUES (7, '彝族');
INSERT INTO `nation` VALUES (8, '壮族');
INSERT INTO `nation` VALUES (9, '布依族');
INSERT INTO `nation` VALUES (10, '朝鲜族');
INSERT INTO `nation` VALUES (11, '满族');
INSERT INTO `nation` VALUES (12, '侗族');
INSERT INTO `nation` VALUES (13, '瑶族');
INSERT INTO `nation` VALUES (14, '白族');
INSERT INTO `nation` VALUES (15, '土家族');
INSERT INTO `nation` VALUES (16, '哈尼族');
INSERT INTO `nation` VALUES (17, '哈萨克族');
INSERT INTO `nation` VALUES (18, '傣族');
INSERT INTO `nation` VALUES (19, '黎族');
INSERT INTO `nation` VALUES (20, '傈僳族');
INSERT INTO `nation` VALUES (21, '佤族');
INSERT INTO `nation` VALUES (22, '畲族');
INSERT INTO `nation` VALUES (23, '高山族');
INSERT INTO `nation` VALUES (24, '拉祜族');
INSERT INTO `nation` VALUES (25, '水族');
INSERT INTO `nation` VALUES (26, '东乡族');
INSERT INTO `nation` VALUES (27, '纳西族');
INSERT INTO `nation` VALUES (28, '景颇族');
INSERT INTO `nation` VALUES (29, '柯尔克孜族');
INSERT INTO `nation` VALUES (30, '土族');
INSERT INTO `nation` VALUES (31, '达斡尔族');
INSERT INTO `nation` VALUES (32, '仫佬族');
INSERT INTO `nation` VALUES (33, '羌族');
INSERT INTO `nation` VALUES (34, '布朗族');
INSERT INTO `nation` VALUES (35, '撒拉族');
INSERT INTO `nation` VALUES (36, '毛难族');
INSERT INTO `nation` VALUES (37, '仡佬族');
INSERT INTO `nation` VALUES (38, '锡伯族');
INSERT INTO `nation` VALUES (39, '阿昌族');
INSERT INTO `nation` VALUES (40, '普米族');
INSERT INTO `nation` VALUES (41, '塔吉克族');
INSERT INTO `nation` VALUES (42, '怒族');
INSERT INTO `nation` VALUES (43, '乌孜别克族');
INSERT INTO `nation` VALUES (44, '俄罗斯族');
INSERT INTO `nation` VALUES (45, '鄂温克族');
INSERT INTO `nation` VALUES (46, '崩龙族');
INSERT INTO `nation` VALUES (47, '保安族');
INSERT INTO `nation` VALUES (48, '裕固族');
INSERT INTO `nation` VALUES (49, '京族');
INSERT INTO `nation` VALUES (50, '塔塔尔族');
INSERT INTO `nation` VALUES (51, '独龙族');
INSERT INTO `nation` VALUES (52, '鄂伦春族');
INSERT INTO `nation` VALUES (53, '赫哲族');
INSERT INTO `nation` VALUES (54, '门巴族');
INSERT INTO `nation` VALUES (55, '珞巴族');
INSERT INTO `nation` VALUES (56, '基诺族');

-- ----------------------------
-- Table structure for politicsstatus
-- ----------------------------
DROP TABLE IF EXISTS `politicsstatus`;
CREATE TABLE `politicsstatus`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of politicsstatus
-- ----------------------------
INSERT INTO `politicsstatus` VALUES (1, '中共党员');
INSERT INTO `politicsstatus` VALUES (2, '中共预备党员');
INSERT INTO `politicsstatus` VALUES (3, '共青团员');
INSERT INTO `politicsstatus` VALUES (4, '民革党员');
INSERT INTO `politicsstatus` VALUES (5, '民盟盟员');
INSERT INTO `politicsstatus` VALUES (6, '民建会员');
INSERT INTO `politicsstatus` VALUES (7, '民进会员');
INSERT INTO `politicsstatus` VALUES (8, '农工党党员');
INSERT INTO `politicsstatus` VALUES (9, '致公党党员');
INSERT INTO `politicsstatus` VALUES (10, '九三学社社员');
INSERT INTO `politicsstatus` VALUES (11, '台盟盟员');
INSERT INTO `politicsstatus` VALUES (12, '无党派民主人士');
INSERT INTO `politicsstatus` VALUES (13, '普通公民');

-- ----------------------------
-- Table structure for position
-- ----------------------------
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职位',
  `createDate` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `enabled` tinyint(1) NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 40 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of position
-- ----------------------------
INSERT INTO `position` VALUES (1, '董事长', '2020-04-11 11:00:00', 1);
INSERT INTO `position` VALUES (2, '总经理', '2020-04-12 20:12:58', 1);
INSERT INTO `position` VALUES (29, '技术总监', '2020-04-12 21:13:42', 1);
INSERT INTO `position` VALUES (30, '运营总监', '2020-04-12 21:13:48', 1);
INSERT INTO `position` VALUES (31, '市场总监', '2020-04-12 00:00:00', 1);
INSERT INTO `position` VALUES (33, '研发工程师', '2020-04-12 10:00:00', 1);
INSERT INTO `position` VALUES (34, '运维工程师', '2020-04-12 16:11:41', 1);
INSERT INTO `position` VALUES (36, 'Java研发经理', '2020-04-12 00:00:00', 1);
INSERT INTO `position` VALUES (37, '培训专员', '2020-04-12 20:34:55', 1);
INSERT INTO `position` VALUES (38, '财务专员', '2020-04-12 21:03:33', 1);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nameZh` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 'ROLE_manager', '部门经理');
INSERT INTO `role` VALUES (2, 'ROLE_personnel', '人事专员');
INSERT INTO `role` VALUES (6, 'ROLE_admin', '系统管理员');
INSERT INTO `role` VALUES (7, 'ROLE_training', '培训专员');
INSERT INTO `role` VALUES (8, 'ROLE_financial ', '财务专员');

-- ----------------------------
-- Table structure for salary
-- ----------------------------
DROP TABLE IF EXISTS `salary`;
CREATE TABLE `salary`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `basicSalary` int(11) NULL DEFAULT NULL COMMENT '基本工资',
  `bonus` int(11) NULL DEFAULT NULL COMMENT '奖金',
  `lunchSalary` int(11) NULL DEFAULT NULL COMMENT '午餐补助',
  `trafficSalary` int(11) NULL DEFAULT NULL COMMENT '交通补助',
  `allSalary` int(11) NULL DEFAULT 0 COMMENT '应发工资',
  `pensionBase` int(11) NULL DEFAULT NULL COMMENT '养老金基数',
  `pensionPer` float NULL DEFAULT NULL COMMENT '养老金比率',
  `createDate` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '启用时间',
  `medicalBase` int(11) NULL DEFAULT NULL COMMENT '医疗基数',
  `medicalPer` float NULL DEFAULT NULL COMMENT '医疗保险比率',
  `accumulationFundBase` int(11) NULL DEFAULT NULL COMMENT '公积金基数',
  `accumulationFundPer` float NULL DEFAULT NULL COMMENT '公积金比率',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of salary
-- ----------------------------
INSERT INTO `salary` VALUES (15, 40000, 0, 1000, 1000, 30000, 4000, 0.07, '2020-04-12 21:47:16', 4000, 0.07, 4000, 0.07, '董事会账套');
INSERT INTO `salary` VALUES (16, 20000, 0, 800, 800, 0, 3000, 0.07, '2020-04-12 21:47:22', 3000, 0.07, 3000, 0.07, '总经理账套');
INSERT INTO `salary` VALUES (17, 7000, 0, 500, 500, 0, 1500, 0.07, '2020-04-12 21:47:25', 1500, 0.07, 1500, 0.07, '人事部账套');
INSERT INTO `salary` VALUES (18, 7000, 0, 500, 500, 0, 1500, 0.07, '2020-04-12 21:47:28', 1500, 0.07, 1500, 0.07, '财务部账套');
INSERT INTO `salary` VALUES (19, 7000, 0, 500, 500, 0, 1500, 0.07, '2020-04-12 21:47:31', 1500, 0.07, 1500, 0.07, '运维部账套');
INSERT INTO `salary` VALUES (20, 7000, 0, 500, 500, 0, 1500, 0.07, '2020-04-12 21:47:35', 1500, 0.07, 1500, 0.07, '研发部账套');
INSERT INTO `salary` VALUES (21, 7000, 0, 500, 500, 0, 1500, 0.07, '2020-04-12 21:47:50', 1500, 0.07, 1500, 0.07, '培训专员部账套');

-- ----------------------------
-- Table structure for sysmsg
-- ----------------------------
DROP TABLE IF EXISTS `sysmsg`;
CREATE TABLE `sysmsg`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mid` int(11) NULL DEFAULT NULL COMMENT '消息id',
  `type` int(11) NULL DEFAULT 0 COMMENT '0表示群发消息',
  `hrid` int(11) NULL DEFAULT NULL COMMENT '这条消息是给谁的',
  `state` int(11) NULL DEFAULT 0 COMMENT '0 未读 1 已读',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `hrid`(`hrid`) USING BTREE,
  INDEX `sysmsg_ibfk_1`(`mid`) USING BTREE,
  CONSTRAINT `sysmsg_ibfk_1` FOREIGN KEY (`mid`) REFERENCES `msgcontent` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `sysmsg_ibfk_2` FOREIGN KEY (`hrid`) REFERENCES `hr` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sysmsg
-- ----------------------------

-- ----------------------------
-- Procedure structure for addDep
-- ----------------------------
DROP PROCEDURE IF EXISTS `addDep`;
delimiter ;;
CREATE PROCEDURE `addDep`(in depName varchar(32),in parentId int,in enabled boolean,out result int,out result2 int)
begin
  declare did int;
	declare t_error INTEGER DEFAULT 0;
  declare pDepPath varchar(64);
	START TRANSACTION;
  insert into department set name=depName,parentId=parentId,enabled=enabled;
  select row_count() into result;
  select last_insert_id() into did;
  set result2=did;
  select depPath into pDepPath from department where id=parentId;
  update department set depPath=concat(pDepPath,'.',did) where id=did;
  update department set isParent=true where id=parentId;
	IF t_error <> 0
    THEN
        SET result = -1;
        ROLLBACK;
    ELSE
        COMMIT;
    END IF;
end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for AddEmpSal
-- ----------------------------
DROP PROCEDURE IF EXISTS `AddEmpSal`;
delimiter ;;
CREATE PROCEDURE `AddEmpSal`()
BEGIN
DECLARE LhId BIGINT;
declare stop int default 0;
DECLARE cur CURSOR FOR (SELECT id from employee);
/*
定义游标的结束,当遍历完成时，将stop设置为null
这里也可以写成 DECLARE CONTINUE HANDLER FOR NOT FOUND SET stop = null;
*/ 
declare CONTINUE HANDLER FOR SQLSTATE '02000' SET stop = null;
/*开游标*/
OPEN cur;
/*游标向下走一步，将查询出来的两个值付给定义的两个变量*/
FETCH cur INTO LhId;
/* 循环体 */
WHILE ( stop is not null) DO
/*更新数据表*/
IF(LhId%7=2||LhId%7=3||LhId%7=4) THEN
REPLACE INTO empsalary (eid, sid)VALUES (LhId, 20);
ELSEif (LhId%7=5||LhId%7=6||LhId%7=0) THEN
REPLACE INTO empsalary (eid, sid)VALUES (LhId, 19);
ELSEif (LhId%7=1) THEN
REPLACE INTO empsalary (eid, sid)VALUES (LhId, 18);
END IF;
/*游标向下走一步*/
FETCH cur INTO LhId;
END WHILE;
/*关闭游标*/
CLOSE cur;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for commitEmpTransfer
-- ----------------------------
DROP PROCEDURE IF EXISTS `commitEmpTransfer`;
delimiter ;;
CREATE PROCEDURE `commitEmpTransfer`(IN did int, OUT result int)
begin
    --    生效员工调动步骤
-- 入参 调动表id
-- 取得该id的调动记录
-- 得到 employeeId--eid 调动后的职位--afterJobId  调动后的部门id--afterDepId 调动后的职称ID--afterLevelId
-- 更新员工的各个字段
    declare v_eid int;
    declare v_afterDepId int;
    declare v_afterJobId int;
    declare v_afterLevelId int;
    declare v_rowCount int;
    START TRANSACTION;
--   得到记录的字段值
    select eid, afterDepId, afterJobId, afterLevelId
    into v_eid,v_afterDepId,v_afterJobId,v_afterLevelId
    from employeetransfer
    where id = did and finished = false;
--   强制更新指定员工的所有的字段
-- select v_eid;
-- select did;
-- select v_afterDepId;
-- select v_afterJobId;
-- select v_afterLevelId;

    update employee
    set jobLevelId=v_afterLevelId,
        departmentId=v_afterDepId,
        posId=v_afterJobId
    where id = v_eid;
--     ROW_COUNT()可以返回前一个SQL进行UPDATE，DELETE，INSERT操作所影响的行数
    select row_count() into v_rowCount;
-- 		select v_rowCount;
    if v_rowCount = 1 
			then
			set result = 1;		
		-- 更新finished 为true
		 UPDATE employeetransfer set finished = true WHERE id=did;
					COMMIT;
		else
					set result = -1;
					ROLLBACK;
    end if;
end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for deleteDep
-- ----------------------------
DROP PROCEDURE IF EXISTS `deleteDep`;
delimiter ;;
CREATE PROCEDURE `deleteDep`(in did int, out result int)
begin
    declare ecount int;
    declare t_error INTEGER DEFAULT 0;
    declare pid int;
    declare pcount int;
    declare a int;
		START TRANSACTION;
    select count(*) into a from department where id = did and isParent = false;
    if a = 0 then
        set result = -2;
    else
        select count(*) into ecount from employee where departmentId = did;
        if ecount > 0 then
            set result = -1;
        else
            select parentId into pid from department where id = did;
            delete from department where id = did and isParent = false;
            select row_count() into result;
            select count(*) into pcount from department where parentId = pid;
            if pcount = 0 then
                update department set isParent= false where id = pid;
            end if;
        end if;
    end if;
    IF t_error <> 0
    THEN
        SET result = -1;
        ROLLBACK;
    ELSE
        COMMIT;
    END IF;
end
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
