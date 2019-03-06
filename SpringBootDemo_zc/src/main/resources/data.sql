DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` varchar(36) NOT NULL COMMENT '����ID��������ID',
  `username` varchar(32) DEFAULT NULL COMMENT '��¼�˺�',
  `password` varchar(32) DEFAULT NULL COMMENT '����',
  `nickname` varchar(50) DEFAULT NULL COMMENT 'ע�������ַ',
  `age` int(11) DEFAULT NULL COMMENT '����',
  `sex` int(11) DEFAULT '0' COMMENT '�Ա�0���ܣ�1���ԣ�2Ů��',
  `job` int(11) DEFAULT NULL COMMENT '����',
  `face_image` varchar(20) DEFAULT NULL COMMENT 'ͷ��',
  `province` varchar(20) DEFAULT NULL COMMENT 'ʡ',
  `city` varchar(20) DEFAULT NULL COMMENT '��',
  `district` varchar(20) DEFAULT NULL COMMENT '��',
  `address` varchar(100) DEFAULT NULL COMMENT '��ַ',
  `auth_salt` varchar(50) DEFAULT NULL COMMENT '��֤',
  `last_login_ip` varchar(100) DEFAULT NULL COMMENT '��¼IP',
  `last_login_time` datetime DEFAULT NULL COMMENT '����¼ʱ��',
  `is_delete` int(11) DEFAULT NULL COMMENT '�Ƿ�ɾ��',
  `regist_time` datetime DEFAULT NULL COMMENT '����ʱ��',
  `user_uuid` varchar(36) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='�û���';