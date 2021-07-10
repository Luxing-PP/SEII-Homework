
-- ----------------------------
-- Table structure for rent_course
-- ----------------------------
DROP TABLE IF EXISTS `course_rent`;
CREATE TABLE `course_rent`(
                                  `id`  BIGINT NOT NULL AUTO_INCREMENT,
                                  `course_id` BIGINT NOT NULL,
                                  `student_id` BIGINT NOT NULL,
                                  `start_time` datetime(0) NULL DEFAULT NULL,
                                  `end_time`   datetime(0) NULL DEFAULT NULL,
                                  PRIMARY KEY (`id`) USING BTREE
)ENGINE = InnoDB  CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for vip
-- ----------------------------
DROP TABLE IF EXISTS `vip`;
CREATE TABLE `vip`(
                                  `id`  BIGINT NOT NULL AUTO_INCREMENT,
                                  `student_id` BIGINT NOT NULL UNIQUE ,
                                  `start_time` datetime(0) NULL DEFAULT NULL,
                                  `end_time`   datetime(0) NULL DEFAULT NULL,
                                  PRIMARY KEY (`id`) USING BTREE
)ENGINE = InnoDB  CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;
