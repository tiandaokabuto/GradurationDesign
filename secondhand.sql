/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : secondhand

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-05-29 14:24:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for adminuser
-- ----------------------------
DROP TABLE IF EXISTS `adminuser`;
CREATE TABLE `adminuser` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `adminusername` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of adminuser
-- ----------------------------
INSERT INTO `adminuser` VALUES ('1', 'wujunjie', '13059228762');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(255) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '闲置数码', null);
INSERT INTO `category` VALUES ('2', '同城代步', null);
INSERT INTO `category` VALUES ('3', '电器日用', null);
INSERT INTO `category` VALUES ('4', '图书教材', null);
INSERT INTO `category` VALUES ('5', '闲置衣物', null);
INSERT INTO `category` VALUES ('6', '运动棋牌', null);
INSERT INTO `category` VALUES ('7', '饰品物件', null);

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `gid` int(11) NOT NULL AUTO_INCREMENT,
  `gname` varchar(255) DEFAULT NULL,
  `newprice` decimal(10,2) DEFAULT NULL,
  `oldprice` decimal(10,2) DEFAULT NULL,
  `gdescription` varchar(255) DEFAULT NULL,
  `state` tinyint(255) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  `starttime` datetime DEFAULT NULL,
  `endtime` datetime DEFAULT NULL,
  `flashtime` datetime DEFAULT NULL,
  `salestate` tinyint(4) DEFAULT NULL,
  `buytime` datetime DEFAULT NULL,
  `uploadstate` tinyint(4) DEFAULT NULL,
  `gcondition` varchar(255) DEFAULT NULL,
  `salereason` varchar(255) DEFAULT NULL,
  `buyway` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`gid`),
  KEY `uid` (`uid`),
  KEY `cid` (`cid`),
  CONSTRAINT `goods_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `goods_ibfk_2` FOREIGN KEY (`cid`) REFERENCES `category` (`cid`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', 'wiiu （非ps4xboxswitch）', '1500.00', '2000.00', 'wiiu32g 双破 没Ben 外接移动硬盘120g，考满游戏，本人比较爱惜，机子9新 没时间玩了出掉 好用一个wii手柄 8gstf卡', '1', '1', '1', '2018-05-03 10:54:10', null, '2018-05-03 10:54:10', '0', '2015-05-09 10:15:40', '1', '非全新', '台城', '实体店');
INSERT INTO `goods` VALUES ('2', 'PSP2000', '300.00', null, '老玩意PSP2000银色9新，内存卡8G索尼专用内存卡，里面已经装好了几个游戏，有战神，合金装备，其生前夜3（完美中文版），海豹突击队游戏到手就玩。成色也还行非战斗成色。有充电器', '1', '1', '1', '2018-05-03 10:59:05', null, '2018-05-03 10:59:05', '0', '2011-05-09 10:15:33', '1', '9成新', '台城', '实体店');
INSERT INTO `goods` VALUES ('3', '#iPhone#妹子自用一台苹果x急转国行64g黑色配件齐全三网通', '3300.00', '8000.00', '妹子个人转让一部苹果iPhonex，机子没毛病99新买了两个月，现在碰到急事着急转让，无拆无修无磕碰，功能一切完好，有看上的联系本交易支持自提、当面交易', '1', '1', '1', '2018-05-04 11:25:57', null, '2018-05-04 11:25:57', '1', '2014-05-09 10:15:23', '1', '非全新', '台城', '');
INSERT INTO `goods` VALUES ('4', 'PS3正版游戏 日版 日文 无尽传说1 TOX Tales of Xillia', '100.00', null, 'PS3正版游戏 日版 日文 无尽传说1 TOX Tales of Xillia', '1', '1', '1', '2018-05-04 11:28:49', '2018-05-04 17:50:01', '2018-05-04 11:28:49', '1', '2016-05-09 10:15:47', '1', '', '台城', '');
INSERT INTO `goods` VALUES ('5', 'E.X.Troopers 终极军团 终极兵团 PS3', '90.00', '100.00', 'PS3，日版游戏。箱说全，发顺丰。', '1', '1', '1', '2018-05-04 11:30:01', '2018-05-04 17:49:12', '2018-05-04 11:30:01', '0', '2017-05-09 10:15:52', '1', '非全新', '台城', '实体店');
INSERT INTO `goods` VALUES ('6', 'XBOX 360E版！1T内置硬盘，双无线手柄，带体感', '2000.00', '2800.00', 'XBOX 360E版！1T内置硬盘，双无线手柄，带体感，机器贴膜，机身手柄保持洁净！只想到了这么多先写到这吧！有意者请留言咨询！同城自提！', '1', '1', '1', '2018-05-16 17:24:12', '2018-05-04 17:51:02', '2018-05-04 17:25:28', '1', '2017-12-09 10:15:58', '1', '非全新', '台城', '实体店');
INSERT INTO `goods` VALUES ('7', '[转卖]【双11全球狂欢节】【双11】Vans/范斯秋季蓝色', '130.00', '182.00', '孩子买来后开春只穿过两次，9.9新哦！很帅气的款式，蓝色男孩的最爱颜色很正。', '1', '6', '5', '2018-05-15 22:10:11', null, '2018-05-15 22:10:11', '0', null, '1', '9成新', '台城', '天猫');
INSERT INTO `goods` VALUES ('8', '飞利浦电动牙刷头philip HX6014HX6013HX6011HX6023HX6053', '19.80', '25.00', '飞利浦声波标准牙刷头HX6014(四支装)注:默认两盒包邮，如需一盒或多盒的请联系本人改价。', '1', '6', '3', '2018-05-15 22:17:33', null, '2018-05-15 22:17:33', '0', null, '1', '', '台城', '');
INSERT INTO `goods` VALUES ('9', '[转卖]韩国女包定型小药箱包包化妆盒复古风精致手提包单肩斜挎', '35.00', null, '超级好看的包包，背起来很有质感，只背过几次跟全新没两样，包包太多，35包邮出', '1', '1', '5', '2018-05-22 12:35:40', null, '2018-05-22 12:35:40', '1', null, '1', '9成新', '台城', '淘宝');
INSERT INTO `goods` VALUES ('10', '巴拉男童西装（有吊牌，全新）160/80', '120.00', null, '有意者私聊（卖出不退换）包邮', '1', '1', '5', '2018-05-22 12:39:21', null, '2018-05-22 12:39:21', '1', null, '1', '9成', '四九', '巴西');
INSERT INTO `goods` VALUES ('11', '#新鲜事#国标红木家具实木椅子茶台椅电脑椅办公椅通用椅', '850.00', null, '厂内做有鸡翅木‘刺猬紫檀‘小叶红檀木材。产品有茶桌，沙发，电视柜，餐桌等系列', '1', '1', '3', '2018-05-22 12:48:07', null, '2018-05-22 12:48:07', '1', null, '1', '', '斗山', '');
INSERT INTO `goods` VALUES ('12', 'LEGO乐高Friends系列好朋友系列41320二手', '300.00', '500.00', '今年7月新品，购买自马来西亚乐高乐园，心湖城酸奶冰激凌店，适合6-12岁孩子，二手包邮', '1', '1', '6', '2018-05-22 12:51:17', null, '2018-05-22 12:51:17', '1', null, '1', '8成新', '四九', '实体店');
INSERT INTO `goods` VALUES ('13', '娇韵诗V脸精华全新', '900.00', null, '两盒全新～囤货用不完出货～哈尔滨自提，不包邮。一个用过几次保证用量90%，两支价格900，', '1', '6', '7', '2018-05-22 13:08:01', null, '2018-05-22 13:08:01', '0', null, '1', '全新', '台城', '');
INSERT INTO `goods` VALUES ('20', '全新美国ALLIANCE沙滩自行车', '900.00', '2600.00', 'ALLIANCE全7档变速宽胎雪地沙滩自行车，可山地，前后减震，大黄蜂黄，颜色很靓丽，全新！原价1600，是公司赠送的，适合男士骑行，很帅气！！！喜欢私信我！同城自提！', '1', '6', '2', '2018-05-22 20:29:28', null, '2018-05-22 20:29:28', '1', null, '0', '全新', '台城', '公司赠送');

-- ----------------------------
-- Table structure for img
-- ----------------------------
DROP TABLE IF EXISTS `img`;
CREATE TABLE `img` (
  `imgid` int(11) NOT NULL AUTO_INCREMENT,
  `imgurl` varchar(255) DEFAULT NULL,
  `gid` int(11) DEFAULT NULL,
  PRIMARY KEY (`imgid`),
  KEY `gid` (`gid`),
  CONSTRAINT `gid` FOREIGN KEY (`gid`) REFERENCES `goods` (`gid`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of img
-- ----------------------------
INSERT INTO `img` VALUES ('1', '430456e0-88dd-4351-b6cd-bf2c9078d42d.jpg', '1');
INSERT INTO `img` VALUES ('2', '9ae9fbf9-64a9-443a-9b6f-70e3a4d2d185.jpg', '1');
INSERT INTO `img` VALUES ('3', '0cb4955c-1d5e-4f13-a5b7-8d33c797ed80.jpg', '1');
INSERT INTO `img` VALUES ('4', 'd4a6efb4-216b-4c1b-a1c2-82a22669ab45.jpg', '2');
INSERT INTO `img` VALUES ('5', 'cb9ab2cb-d512-446d-8f02-7611068cbbba.jpg', '2');
INSERT INTO `img` VALUES ('6', '78168164-8c00-41cf-8c42-938d483c7d79.jpg', '2');
INSERT INTO `img` VALUES ('7', '569cf8b2-fc94-4254-a863-020ea3a0b59e.jpg', '3');
INSERT INTO `img` VALUES ('8', '56da059a-53a9-4561-bcaf-ef8de3285451.jpg', '3');
INSERT INTO `img` VALUES ('9', 'bfb54514-175d-4c35-b564-2db8263f08bb.jpg', '4');
INSERT INTO `img` VALUES ('10', 'b1e41983-0ef4-4548-ad06-d3e7ecf9f510.jpg', '4');
INSERT INTO `img` VALUES ('11', '9f04c517-75f3-4b54-b7eb-77cc6fec70f0.jpg', '5');
INSERT INTO `img` VALUES ('12', 'bb96e546-d11f-40bd-b525-8e1a8e695732.jpg', '5');
INSERT INTO `img` VALUES ('13', 'c393af90-bf98-4798-9ec6-90295ec6d5b7.jpg', '6');
INSERT INTO `img` VALUES ('14', 'f7a704d2-40c8-4cdd-9fd9-76d24eec7e55.jpg', '6');
INSERT INTO `img` VALUES ('15', '1116104e-0aac-48f3-ba17-109921821523.jpg', '6');
INSERT INTO `img` VALUES ('16', '644aa939-9d90-4d11-84b9-b832d49f7a05.jpg', '7');
INSERT INTO `img` VALUES ('17', '6e4ef9b9-318a-40b5-8cea-0a2c9997c54b.jpg', '8');
INSERT INTO `img` VALUES ('18', 'a46f7ca1-4290-4091-b62e-0c31b7706e00.jpg', '8');
INSERT INTO `img` VALUES ('19', '08b83130-b549-4c4f-92a5-fb5cad78e781.jpg', '9');
INSERT INTO `img` VALUES ('20', '5fad230e-8f41-4d01-8c46-145689ef9d83.jpg', '10');
INSERT INTO `img` VALUES ('21', '297f98a1-f88a-4124-a6ac-25c10699f24c.jpg', '10');
INSERT INTO `img` VALUES ('22', 'bc92803d-c7ff-4e09-895c-5452ac1f4cf9.jpg', '10');
INSERT INTO `img` VALUES ('23', 'e20233e0-3079-40b4-aa34-8344937f2cb2.jpg', '11');
INSERT INTO `img` VALUES ('24', '64eff93f-e637-4b57-8592-146c69205583.jpg', '11');
INSERT INTO `img` VALUES ('25', 'e5af2291-135d-49d9-9734-85ae001e5375.jpg', '12');
INSERT INTO `img` VALUES ('26', 'f5805abe-ce2b-49a0-a103-deabdc19a63d.jpg', '12');
INSERT INTO `img` VALUES ('27', '8cb0206d-7b05-442a-9a27-7c9ae3679e76.jpg', '12');
INSERT INTO `img` VALUES ('28', '54f99938-f245-4615-80c9-1db1addf34b0.jpg', '13');
INSERT INTO `img` VALUES ('29', 'a292dd0b-d451-4fde-a44f-3517a91c9202.jpg', '13');
INSERT INTO `img` VALUES ('30', 'b8098253-7c6a-49f1-b17f-0592d5ea4430.jpg', '13');
INSERT INTO `img` VALUES ('31', '7d1fda79-8231-4457-8522-b095d3a655db.jpg', '20');
INSERT INTO `img` VALUES ('32', 'a7888ca9-bb2b-457e-9228-53134a385b16.jpg', '20');
INSERT INTO `img` VALUES ('33', 'd488ee91-c992-4a40-9bff-b90fd4605ece.jpg', '20');

-- ----------------------------
-- Table structure for orderitem
-- ----------------------------
DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem` (
  `iid` int(11) NOT NULL AUTO_INCREMENT,
  `subtotal` decimal(10,0) DEFAULT NULL,
  `gid` int(11) DEFAULT NULL,
  `oid` varchar(255) DEFAULT NULL,
  `itemstate` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`iid`),
  KEY `gid` (`gid`),
  KEY `oid` (`oid`),
  CONSTRAINT `orderitem_ibfk_1` FOREIGN KEY (`gid`) REFERENCES `goods` (`gid`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `orderitem_ibfk_2` FOREIGN KEY (`oid`) REFERENCES `orders` (`oid`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderitem
-- ----------------------------
INSERT INTO `orderitem` VALUES ('3', '300', '2', '80B7EBA03B8543478ED3DB472F22AA5F', '0');
INSERT INTO `orderitem` VALUES ('4', '90', '5', '80B7EBA03B8543478ED3DB472F22AA5F', '0');
INSERT INTO `orderitem` VALUES ('5', '20', '8', '80B7EBA03B8543478ED3DB472F22AA5F', '0');
INSERT INTO `orderitem` VALUES ('6', '130', '7', '80B7EBA03B8543478ED3DB472F22AA5F', '0');
INSERT INTO `orderitem` VALUES ('7', '1500', '1', '4A01F082B1DF4C86A2C648B78E21FAEF', '0');
INSERT INTO `orderitem` VALUES ('8', '900', '13', 'B7383585B52744ADA6D75C9813E4CF55', '1');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `oid` varchar(255) NOT NULL,
  `otime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `total` decimal(10,0) DEFAULT NULL,
  `state` smallint(1) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  PRIMARY KEY (`oid`),
  KEY `uid` (`uid`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('4A01F082B1DF4C86A2C648B78E21FAEF', '2018-05-16 16:59:00', '1500', '3', 'aaa', '6');
INSERT INTO `orders` VALUES ('80B7EBA03B8543478ED3DB472F22AA5F', '2018-05-21 20:25:00', '540', '3', 'aaaaaa', '10');
INSERT INTO `orders` VALUES ('B7383585B52744ADA6D75C9813E4CF55', '2018-05-27 21:03:34', '900', '1', 'aaa', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `qq` varchar(255) DEFAULT NULL,
  `wechat` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `sta` tinyint(4) DEFAULT NULL,
  `code` char(100) DEFAULT NULL,
  `usestate` tinyint(4) DEFAULT NULL,
  `registdate` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `logindate` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'wjj', '123456', '591775790@qq.com', '13059228762', '591775790', 'tiandaokabuto', '啦啦', '1', 'C0360F322AF548969FD5B7B7395B3590', '1', '2018-05-22 22:44:28', '2018-05-27 21:00:23');
INSERT INTO `user` VALUES ('2', 'asd', '55', 'aaaaa', null, '', '', '', '0', 'D0FCC181C3FF45CC826ED3BBFA046CC0', '1', '2018-05-22 22:44:55', '2018-05-22 22:44:55');
INSERT INTO `user` VALUES ('3', 'abc', 'cba', 's', 'fffffff', 'aaaaaa', 'ddddddd', 'gggg', '1', null, '1', '2018-05-08 19:58:56', '2018-05-16 17:00:29');
INSERT INTO `user` VALUES ('5', 's', '591775790', 'w_jun_jie@sina.com', null, null, null, null, '0', '94D4D8734FDE4FA2824A9508E04281FE', '1', '2018-05-08 19:58:56', '2018-05-08 19:58:56');
INSERT INTO `user` VALUES ('6', 'jjw', '591775790', 'w_jun_jie@sina.cn', '', '591775790', '', '', '1', '84F492BE226840CFB6873D11484AF5D2', '1', '2018-05-24 15:31:50', '2018-05-24 15:31:50');
INSERT INTO `user` VALUES ('8', 'qwe', '123456', '', null, null, null, null, '0', 'F9466300A99F42FBB91563DD108E234D', '1', '2018-05-08 19:58:59', '2018-05-08 19:58:59');
INSERT INTO `user` VALUES ('10', 'kabuto', '591775790', 'kabuto0113@163.com', null, null, null, null, '1', 'D9E4334D63334D61BFC2EC8383FC95BF', '1', '2018-05-08 20:29:48', '2018-05-16 16:57:35');
