/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : 127.0.0.1
 Source Database       : chzu_college_talent

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : utf-8

 Date: 03/22/2019 02:06:23 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `ct_admin`
-- ----------------------------
DROP TABLE IF EXISTS `ct_admin`;
CREATE TABLE `ct_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `ct_admin`
-- ----------------------------
BEGIN;
INSERT INTO `ct_admin` VALUES ('1', 'jone', 'e10adc3949ba59abbe56e057f20f883e', '2019-02-13 17:00:50', '2019-02-13 17:00:50');
COMMIT;

-- ----------------------------
--  Table structure for `ct_answer`
-- ----------------------------
DROP TABLE IF EXISTS `ct_answer`;
CREATE TABLE `ct_answer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `answer_id` int(11) NOT NULL,
  `answer_type` varchar(255) NOT NULL,
  `answer_name` varchar(255) NOT NULL,
  `qn_id` int(11) NOT NULL,
  `subject_num` int(11) NOT NULL,
  `subject_content` varchar(255) NOT NULL,
  `answer` varchar(255) NOT NULL,
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `ct_company`
-- ----------------------------
DROP TABLE IF EXISTS `ct_company`;
CREATE TABLE `ct_company` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '公司名称',
  `password` varchar(255) NOT NULL,
  `contact` varchar(255) NOT NULL COMMENT '联系人',
  `address` varchar(255) NOT NULL COMMENT '联系地址',
  `phone` varchar(255) NOT NULL COMMENT '联系电话',
  `email` varchar(255) NOT NULL COMMENT '邮箱地址',
  `service_trade` varchar(255) NOT NULL COMMENT '服务行业',
  `del_flag` int(11) NOT NULL DEFAULT '0' COMMENT '删除标记',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `ct_company`
-- ----------------------------
BEGIN;
INSERT INTO `ct_company` VALUES ('1', '合肥埃瑞克电子商务有限公司', 'e10adc3949ba59abbe56e057f20f883e', '霍礼福', '合肥市蜀山区湖光路1299号电商园', '13035030390', 'kf@eruik.com', '电子商务平台运营', '0', '2019-02-14 00:31:16', '2019-02-14 00:31:16'), ('2', 'test公司', '12345678', 'test', 'address', '111111', 'huolifu@eruik.com', '测试服务', '0', '2019-03-01 13:21:50', '2019-03-01 15:00:18');
COMMIT;

-- ----------------------------
--  Table structure for `ct_questionnaires`
-- ----------------------------
DROP TABLE IF EXISTS `ct_questionnaires`;
CREATE TABLE `ct_questionnaires` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL DEFAULT '学生',
  `end_time` datetime NOT NULL,
  `del_flag` int(11) NOT NULL DEFAULT '0',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `ct_questionnaires`
-- ----------------------------
BEGIN;
INSERT INTO `ct_questionnaires` VALUES ('1', '本科专业培养目标达成度调查', '学生', '2019-07-31 09:49:34', '0', '2019-02-14 09:49:42', '2019-02-14 09:51:01'), ('2', '专业人才培养目标认同度调查', '企业', '2019-07-31 09:51:47', '0', '2019-02-14 09:51:54', '2019-02-14 09:51:54'), ('3', 'test', '学生', '2019-03-29 11:00:00', '0', '2019-03-01 16:48:13', '2019-03-01 16:48:13'), ('4', 'test公司', '企业', '2019-03-29 11:00:00', '0', '2019-03-01 16:51:39', '2019-03-01 16:51:39'), ('5', 'test公司', '企业', '2019-03-08 10:00:00', '0', '2019-03-01 16:52:10', '2019-03-01 16:52:10');
COMMIT;

-- ----------------------------
--  Table structure for `ct_students`
-- ----------------------------
DROP TABLE IF EXISTS `ct_students`;
CREATE TABLE `ct_students` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `sex` varchar(255) NOT NULL,
  `grade` varchar(255) NOT NULL COMMENT '年级',
  `major` varchar(255) NOT NULL COMMENT '专业',
  `employment` int(11) NOT NULL DEFAULT '0' COMMENT '就业标识：0/未就业，1/已就业',
  `employment_company` varchar(255) NOT NULL DEFAULT '' COMMENT '就业单位',
  `employment_city` varchar(255) NOT NULL DEFAULT '',
  `phone` varchar(255) NOT NULL,
  `wechat` varchar(255) NOT NULL DEFAULT '',
  `qq` varchar(255) NOT NULL DEFAULT '',
  `email` varchar(255) NOT NULL,
  `del_flag` int(11) NOT NULL DEFAULT '0' COMMENT '删除标记',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `ct_students`
-- ----------------------------
BEGIN;
INSERT INTO `ct_students` VALUES ('1', '霍礼福', 'e10adc3949ba59abbe56e057f20f883e', '男', '2013', '计算机科学与技术', '1', '合肥埃瑞克电子商务有限公司', '合肥', '13035030390', 'BaalHuo', '1301297909', 'huolifu@eruik.com', '0', '2019-02-14 00:28:00', '2019-03-01 15:00:41'), ('2', 'test', 'e10adc3949ba59abbe56e057f20f883e', '男', '2013级', '即可', '1', 'test', 'test', '111111', '1wechat', '11qq', 'huolifu@eruik.com', '0', '2019-02-28 22:21:46', '2019-03-01 15:00:33');
COMMIT;

-- ----------------------------
--  Table structure for `ct_subject`
-- ----------------------------
DROP TABLE IF EXISTS `ct_subject`;
CREATE TABLE `ct_subject` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `qn_id` int(11) NOT NULL COMMENT '所属问券id',
  `num` int(11) NOT NULL COMMENT '题号',
  `content` varchar(255) NOT NULL COMMENT '题目内容',
  `type` varchar(255) NOT NULL DEFAULT '单选' COMMENT '题目类型：单选/多选/填写',
  `option` varchar(255) NOT NULL DEFAULT '{}' COMMENT '选项内容',
  `del_flag` int(11) NOT NULL DEFAULT '0',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `ct_subject`
-- ----------------------------
BEGIN;
INSERT INTO `ct_subject` VALUES ('1', '1', '1', '您所在的单位名称', '填写', '{}', '0', '2019-02-14 09:53:12', '2019-02-14 09:53:39'), ('2', '1', '2', '您所在单位的性质', '单选', '{\"A\":\"国企单位\",\"B\":\"事业单位\",\"C\":\"私企单位\",\"D\":\"其他\"}', '0', '2019-02-14 10:09:44', '2019-02-14 10:37:08'), ('3', '1', '3', '您所在单位所属行业', '单选', '{\"A\":\"研发\",\"B\":\"生产\",\"C\":\"教育\",\"D\":\"服务业\",\"E\":\"其他\"}', '0', '2019-02-14 10:38:41', '2019-02-14 10:38:41'), ('4', '1', '4', '您的工作领域', '单选', '{\"A\":\"测控技术\",\"B\":\"电子信息\",\"C\":\"服务管理\",\"D\":\"其他\"}', '0', '2019-02-14 10:40:00', '2019-02-14 10:40:00'), ('5', '1', '5', '您在单位的工作性质', '单选', '{\"A\":\"研发\",\"B\":\"管理\",\"C\":\"生产\",\"D\":\"其他\"}', '0', '2019-02-14 10:40:50', '2019-02-14 10:40:50'), ('6', '1', '6', '您单位的规模', '单选', '{\"A\":\"1万人以上\",\"B\":\"5千～1万人\",\"C\":\"1千～5千人\",\"D\":\"5百～1千人\",\"E\":\"5百人以下\"}', '0', '2019-02-14 10:42:49', '2019-02-14 10:42:49'), ('7', '1', '7', '您对目前职业现状的满意度', '单选', '{\"A\":\"非常满意\",\"B\":\"满意\",\"C\":\"比较满意\",\"D\":\"一般满意\",\"E\":\"不满意\"}', '0', '2019-02-14 10:44:22', '2019-02-14 10:44:22'), ('8', '1', '8', '您认为我校的培养目标定位是否合理', '单选', '{\"A\":\"偏高\",\"B\":\"合理\",\"C\":\"比较合理\",\"D\":\"不合理\",\"E\":\"不好说\"}', '0', '2019-02-14 10:45:10', '2019-02-14 10:45:43'), ('9', '1', '9', '您认为我校的培养目标是否反映了您毕业后5年左右的能力和成就', '单选', '{\"A\":\"很好反映\",\"B\":\"较好反映\",\"C\":\"一般反映\",\"D\":\"没有反映\",\"E\":\"不好说\"}', '0', '2019-02-14 10:47:27', '2019-02-14 10:48:48'), ('10', '1', '10', '您认为我校的培养目标是否适应了我国社会经济发展的需求', '单选', '{\"A\":\"很好适应\",\"B\":\"较好适应\",\"C\":\"一般适应\",\"D\":\"没有适应\",\"E\":\"不好说\"}', '0', '2019-02-14 10:48:43', '2019-02-14 10:49:39'), ('11', '2', '1', '您所在的单位名称', '填写', '{}', '0', '2019-02-14 12:16:34', '2019-02-14 12:16:34');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
