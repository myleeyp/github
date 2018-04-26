drop database if exists HRS;
create database HRS default charset utf8;
use HRS;
/*
MySQL Backup
Source Server Version: 5.7.17
Source Database: hr
Date: 2017/8/8 17:03:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
--  Table structure for `tbdept`
-- ----------------------------
DROP TABLE IF EXISTS `tbdept`;
CREATE TABLE `tbdept` (
  `deptno` tinyint(4) NOT NULL,
  `dname` varchar(10) NOT NULL,
  `dloc` varchar(20) NOT NULL,
  PRIMARY KEY (`deptno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tbemp`
-- ----------------------------
DROP TABLE IF EXISTS `tbemp`;
CREATE TABLE `tbemp` (
  `empno` int(11) NOT NULL,
  `ename` varchar(20) NOT NULL,
  `job` varchar(20) NOT NULL,
  `mgr` int(11) DEFAULT NULL,
  `sal` int(11) NOT NULL,
  `dno` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`empno`),
  KEY `fk_dno` (`dno`),
  CONSTRAINT `fk_dno` FOREIGN KEY (`dno`) REFERENCES `tbdept` (`deptno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records 
-- ----------------------------
INSERT INTO `tbdept` VALUES ('10','会计部','北京'), ('20','研发部','成都'), ('30','销售部','重庆'), ('40','运维部','深圳');
INSERT INTO `tbemp` VALUES ('1359','胡一刀','销售员','3344','1800','30'), ('2056','乔峰','分析师','7800','5000','20'), ('3088','李莫愁','设计师','2056','3500','20'), ('3211','张无忌','程序员','2056','3200','20'), ('3233','丘处机','程序员','2056','3400','20'), ('3244','欧阳锋','程序员','3088','3200','20'), ('3251','张翠山','程序员','2056','4000','20'), ('3344','黄蓉','销售主管','7800','3000','30'), ('3577','杨过','会计','5566','2200','10'), ('4466','苗人凤','销售员','3344','2500','30'), ('5234','郭靖','出纳','5566','2000','10'), ('5566','宋远桥','会计师','7800','4000','10'), ('7800','张三丰','总裁',NULL,'9000','20'), ('9527','王大锤','程序员','2056','3000','20');
