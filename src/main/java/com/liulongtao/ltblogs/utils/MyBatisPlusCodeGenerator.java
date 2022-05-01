package com.liulongtao.ltblogs.utils;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;

import java.util.Collections;

/**
 * MyBatis-Plus生成代码插件启动栏
 */
public class MyBatisPlusCodeGenerator {

    // 设置数据库的内容
    public final static String URL = "jdbc:mariadb://localhost:3306/ltblog?characterEncoding=utf-8" +
            "&useSSL=false&serverTimezone=GMT%2B8?useMysqlMetadata=true";
    public final static String USERNAME = "longtao";
    public final static String PASSWORD = "abcd1234";

    public static void main(String[] args) {
        String sourceDir = System.getProperty("user.dir");

        FastAutoGenerator.create(URL, USERNAME, PASSWORD)
                // 全局设置
                .globalConfig(builder -> {
                    builder.author("longtao") // 设置作者
//                            .enableSwagger() // 开启 swagger 模式
                            .commentDate("yyyy-MM-dd hh:mm:ss")   //注释日期
                            .dateType(DateType.ONLY_DATE)   //定义生成的实体类中日期的类型 TIME_PACK=LocalDateTime;ONLY_DATE=Date;
                            .fileOverride() // 覆盖已生成文件
                            .disableOpenDir()   //禁止打开输出目录，默认打开
                            .outputDir(sourceDir + "/src/main/java"); // 指定输出目录
                })
                // 包配置
                .packageConfig(builder -> {
                    builder.parent("com.liulongtao") // 设置父包名
                            .moduleName("ltblogs") // 设置父包模块名
                            .entity("entity")  //Mapper XML 包名
                            .service("service") //Service 包名
                            .serviceImpl("serviceImpl") // ***ServiceImpl 包名
                            .mapper("mapper") //Mapper 包名
                            .xml("mapper") //Mapper XML 包名
                            .controller("controller")
                            .other("utils") //自定义文件包名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, sourceDir + "/src/main/resources/mapper")); // //配置 **Mapper.xml 路径信息：项目的 resources 目录的 Mapper 目录下
                })
                // 策略设置
                .strategyConfig(builder -> {
                    builder.addInclude("user", "article", "category", "tags", "comment", "friend_site") // 设置需要生成的表名
                            .addTablePrefix("t_", "c_")// 设置过滤表前缀

                            //4.1、Mapper策略配置
                            .mapperBuilder()
                            .superClass(BaseMapper.class)   //设置父类
                            .formatMapperFileName("%sMapper")   //格式化 mapper 文件名称
                            .enableMapperAnnotation()       //开启 @Mapper 注解
                            .formatXmlFileName("%sXml") //格式化 Xml 文件名称

                            //4.2、service 策略配置
                            .serviceBuilder()
                            .formatServiceFileName("%sService") //格式化 service 接口文件名称，%s进行匹配表名，如 UserService
                            .formatServiceImplFileName("%sServiceImpl") //格式化 service 实现类文件名称，%s进行匹配表名，如 UserServiceImpl

                            //4.3、实体类策略配置
                            .entityBuilder()
                            .enableLombok() //开启 Lombok
                            .disableSerialVersionUID()  //不实现 Serializable 接口，不生产 SerialVersionUID
                            .logicDeleteColumnName("deleted")   //逻辑删除字段名
                            .naming(NamingStrategy.underline_to_camel)  //数据库表映射到实体的命名策略：下划线转驼峰命
                            .columnNaming(NamingStrategy.underline_to_camel)    //数据库表字段映射到实体的命名策略：下划线转驼峰命
//                            .addTableFills(
//                                    new Column("create_time", FieldFill.INSERT),
//                                    new Column("modify_time", FieldFill.INSERT_UPDATE)
//                            )   //添加表字段填充，"create_time"字段自动填充为插入时间，"modify_time"字段自动填充为插入修改时间
                            .enableTableFieldAnnotation()       // 开启生成实体时生成字段注解

                            //4.4、Controller策略配置
                            .controllerBuilder()
                            .formatFileName("%sController") //格式化 Controller 类文件名称，%s进行匹配表名，如 UserController
                            .enableRestStyle();  //开启生成 @RestController 控制器
                })
                .templateEngine(new VelocityTemplateEngine())
                .execute();

    }
}
