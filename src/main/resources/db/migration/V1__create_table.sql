
###################### 创建表格 ################################
# 1. 创建USER数据表
CREATE TABLE  IF NOT EXISTS `user`(
    `id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '用户id',
    `username` VARCHAR (20) NOT NULL UNIQUE KEY COMMENT '用户名',
    `nickname` VARCHAR (20) DEFAULT NULL COMMENT '昵称',
    `password` VARCHAR (20) NOT NULL COMMENT '密码',
    `email` VARCHAR (50)  NULL COMMENT '邮箱',
    `phone` VARCHAR (20)  NULL COMMENT '联系方式',
    `login_ip` VARCHAR (50)  NULL COMMENT '最后登录ip地址',
    `login_date` DATETIME NULL COMMENT '最后登录时间',
    `created_time` DATETIME NULL COMMENT '创建时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

# 2. 创建article表
CREATE TABLE IF NOT EXISTS `article` (
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '文章id',
    `title` VARCHAR (50) NOT NULL COMMENT '文章标题',
    `title_img_path` VARCHAR (100) NULL COMMENT '标题图片地址',
    `user_id` INT NOT NULL COMMENT '作者',
    `content` TEXT NULL COMMENT '文章内容',
    `show`  TINYINT(1) NOT NULL DEFAULT 1 COMMENT '是否显示该文章',
    `draft` TINYINT(1) NULL DEFAULT 1 COMMENT '是否为草稿',
    `created_time` DATETIME NULL COMMENT '文章创建时间',
    `update_time` DATETIME NULL COMMENT '文章修改时间',
    `show_comment` TINYINT(1) DEFAULT 1 COMMENT '是否默认显示该文章的评论',
    CONSTRAINT fk_article_user FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

# 3. 创建分类表
CREATE TABLE IF NOT EXISTS `category`(
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '分类id',
    `name` VARCHAR (30) NOT NULL COMMENT '类名',
    `description` VARCHAR (200) NULL COMMENT '分类描述'
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

# 4. 创建标签表
CREATE TABLE IF NOT EXISTS `tags` (
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '标签id',
    `name` VARCHAR (30) NOT NULL COMMENT '标签名',
    `description` VARCHAR (200) NULL COMMENT '标签描述'
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

# 5. 评论表
CREATE TABLE IF NOT EXISTS `comment`(
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '评论id',
    `article_id` INT NOT NULL COMMENT '文章id',
    `parent_id` INT NULL COMMENT '上级评论',
    `nickname` VARCHAR (20) NOT NULL COMMENT '评论用户名',
    `email` VARCHAR (50) NOT NULL COMMENT '评论用户的邮箱',
    `content` VARCHAR (500) NULL COMMENT '评论的内容',
    `create_time` DATETIME NULL COMMENT '评论的时间',
    `show` TINYINT(1) DEFAULT 1 COMMENT '是否显示该评论',
    CONSTRAINT fk_article_comment FOREIGN KEY (`article_id`) REFERENCES article(`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

# 6. 外站表
CREATE TABLE IF NOT EXISTS `friend_site`(
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '友站id',
    `name` VARCHAR (50) NULL COMMENT '友站的名称',
    `url` VARCHAR (50) NULL COMMENT '友站的url',
    `show` TINYINT(1)  DEFAULT 1 COMMENT '是否显示友站',
    `img_path` VARCHAR (100) NULL COMMENT '友站的图标',
    `description` VARCHAR (200) NULL COMMENT '友站描述'
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

######################## 创建外联表 ##############################
# 7. 文章 与 标签 外联表
CREATE TABLE IF NOT EXISTS `c_article_tag`(
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '文章与标签外联表id',
    `article_id` INT NOT NULL COMMENT '文章id',
    `tags_id` INT NOT NULL COMMENT '标签id',
    CONSTRAINT fk_article_id FOREIGN KEY (`article_id`) REFERENCES article(`id`),
    CONSTRAINT fk_tags_id FOREIGN  KEY (`tags_id`) REFERENCES tags(`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


