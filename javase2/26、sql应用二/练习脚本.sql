/*
SQLyog Community v13.1.7 (64 bit)
MySQL - 8.0.26 : Database - gecdb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`gecdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `gecdb`;

/*Table structure for table `t_department` */

DROP TABLE IF EXISTS `t_department`;

CREATE TABLE `t_department` (
  `did` int NOT NULL AUTO_INCREMENT COMMENT '部门编号',
  `dname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '员工名称',
  `description` varchar(200) DEFAULT NULL COMMENT '员工简介',
  PRIMARY KEY (`did`),
  UNIQUE KEY `dname` (`dname`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `t_department` */
insert  into `t_department`(`did`,`dname`,`description`) 
values (1,'研发部','负责研发工作'),
(2,'人事部','负责人事管理工作'),
(3,'市场部','负责市场推广工作'),
(4,'财务部','负责财务管理工作'),
(5,'后勤部','负责后勤保障工作'),
(6,'测试部','负责测试工作');

/*Table structure for table `t_employee` */

DROP TABLE IF EXISTS `t_employee`;

CREATE TABLE `t_employee` (
  `eid` int NOT NULL AUTO_INCREMENT COMMENT '员工编号',
  `ename` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '员工姓名',
  `salary` double NOT NULL COMMENT '薪资',
  `commission_pct` decimal(3,2) DEFAULT NULL COMMENT '奖金比例',
  `birthday` date NOT NULL COMMENT '出生日期',
  `gender` enum('男','女') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '男' COMMENT '性别',
  `tel` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '手机号码',
  `email` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '邮箱',
  `address` varchar(150) DEFAULT NULL COMMENT '地址',
  `work_place` set('广州市','深圳','上海','武汉') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '广州市' COMMENT '工作地点',
  `hiredate` date NOT NULL COMMENT '入职日期',
  `job_id` int DEFAULT NULL COMMENT '职位编号',
  `mid` int DEFAULT NULL COMMENT '领导编号',
  `did` int DEFAULT NULL COMMENT '部门编号',
  PRIMARY KEY (`eid`),
  KEY `job_id` (`job_id`),
  KEY `did` (`did`),
  KEY `mid` (`mid`),
  CONSTRAINT `t_employee_ibfk_1` FOREIGN KEY (`job_id`) REFERENCES `t_job` (`jid`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `t_employee_ibfk_2` FOREIGN KEY (`did`) REFERENCES `t_department` (`did`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `t_employee_ibfk_3` FOREIGN KEY (`mid`) REFERENCES `t_employee` (`eid`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `t_employee` */

insert  into `t_employee`(`eid`,`ename`,`salary`,`commission_pct`,`birthday`,`gender`,`tel`,`email`,`address`,`work_place`,`hiredate`,`job_id`,`mid`,`did`) 
values (1,'孙加一',28000,'0.65','1980-10-08','男','13789098765','shl@163.com','白庙村西街','广州市,深圳','2011-07-28',1,1,1),
(2,'何关',7001,'0.10','1984-08-03','男','13456732145','hj@163.com','半截塔存','深圳,上海','2015-07-03',2,1,1),
(3,'邓的',8000,NULL,'1985-04-09','男','18678973456','dcy666@163.com','宏福苑','广州市,深圳,上海,武汉','2014-07-01',3,7,1),
(4,'黄给',9456,NULL,'1986-09-07','女','13609876789','hxm@163.com','白庙村东街','深圳,上海,武汉','2015-08-08',8,22,3),
(5,'陈工',8567,NULL,'1978-08-02','男','13409876545','ch888@163.com','回龙观','广州市,深圳,上海','2015-01-01',3,7,1),
(6,'韩了',12000,NULL,'1985-04-03','男','18945678986','hgn@163.com','龙泽','深圳,上海','2015-02-02',3,2,1),
(7,'贾子',15700,'0.24','1982-08-02','男','15490876789','jby@163.com','霍营','广州市,武汉','2015-03-03',2,1,1),
(8,'李民的',9000,'0.40','1983-03-02','女','13587689098','lc@163.com','东三旗','深圳,上海,武汉','2015-01-06',4,1,1),
(9,'李工',7897,NULL,'1984-09-01','男','13467676789','lyf@163.com','西山旗','武汉','2015-04-01',3,7,1),
(10,'陆八',8789,NULL,'1989-04-02','男','13689876789','lf@163.com','天通苑一区','广州市','2014-09-03',2,1,1),
(11,'黄母',15678,NULL,'1983-05-07','女','13787876565','hbr@163.com','立水桥','深圳','2014-04-04',4,1,1),
(12,'孙红梅',9000,NULL,'1986-04-02','女','13576234554','shm@163.com','立城苑','上海','2014-02-08',3,7,1),
(13,'李冰冰',18760,NULL,'1987-04-09','女','13790909887','lbb@163.com','王府温馨公寓','广州市','2015-06-07',3,2,1),
(14,'谢吉娜',18978,'0.25','1990-01-01','女','13234543245','xjn@163.com','园中园','上海,武汉','2015-09-05',5,14,2),
(15,'董吉祥',8978,NULL,'1987-05-05','男','13876544333','djx@163.com','小辛庄','广州市,上海','2015-08-04',6,14,2),
(16,'彭超越',9878,NULL,'1988-03-06','男','18264578930','pcy@163.com','西二旗','深圳,武汉','2015-03-06',8,22,3),
(17,'李诗雨',9000,NULL,'1990-08-09','女','18567899098','lsy@163.com','清河','广州市,深圳,武汉','2013-06-09',8,22,3),
(18,'舒淇格',16788,'0.10','1978-09-04','女','18654565634','sqg@163.com','名流花园','广州市,深圳,武汉','2013-04-05',9,18,4),
(19,'周旭飞',7876,NULL,'1988-06-13','女','13589893434','sxf@163.com','小汤山','广州市,深圳','2014-04-07',10,18,4),
(20,'章嘉怡',15099,'0.10','1989-12-11','女','15634238979','zjy@163.com','望都家园','广州市','2015-08-04',11,20,5),
(21,'白露',9787,NULL,'1989-09-04','女','18909876789','bl@163.com','西湖新村','上海','2014-06-05',12,20,5),
(22,'刘烨',13099,'0.32','1990-11-09','男','18890980989','ly@163.com','多彩公寓','广州市,上海','2016-08-09',7,22,3),
(23,'陈纲',13090,NULL,'1990-02-04','男','18712345632','cg@163.com','天通苑二区','深圳','2016-05-09',3,2,1),
(24,'吉日格勒',10289,NULL,'1990-04-01','男','17290876543','jrgl@163.com','北苑','广州市','2017-02-06',12,20,5),
(25,'额日古那',9087,NULL,'1989-08-01','女','18709675645','ergn@163.com','望京','广州市,上海','2017-09-01',3,2,1),
(26,'李红',5000,NULL,'1995-02-15','女','15985759663','lihong@163.com','冠雅苑','广州市','2021-09-01',NULL,NULL,NULL),
(27,'周洲',8000,NULL,'1990-01-01','男','13574528569','zhouzhou@163.com','冠华苑','广州市,深圳','2020-08-15',3,2,NULL);



/*Table structure for table `t_job` */

DROP TABLE IF EXISTS `t_job`;

CREATE TABLE `t_job` (
  `jid` int NOT NULL AUTO_INCREMENT COMMENT '职位编号',
  `jname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '职位名称',
  `description` varchar(200) DEFAULT NULL COMMENT '职位简介',
  PRIMARY KEY (`jid`),
  UNIQUE KEY `jname` (`jname`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


/*Data for the table `t_job` */

insert  into `t_job`(`jid`,`jname`,`description`) 
values (1,'技术总监','负责技术指导工作'),
(2,'项目经理','负责项目管理工作'),
(3,'程序员','负责开发工作'),
(4,'测试员','负责测试工作'),
(5,'人事主管','负责人事管理管理'),
(6,'人事专员','负责人事招聘工作'),
(7,'运营主管','负责市场运营管理工作'),
(8,'市场员','负责市场推广工作'),
(9,'财务主管','负责财务工作'),
(10,'出纳','负责出纳工作'),
(11,'后勤主管','负责后勤管理工作'),
(12,'网络管理员','负责网络管理');


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
