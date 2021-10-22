package org.muguang;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class Generator {

    public static void main(String[] args) {

        String projectPath = args[0];
        String appName = args[1];
        String moduleName = args[2];
        String dbUrl = args[3];
        String dbUser = args[4];
        String dbPwd = args[5];
        String[] tableNames = args[6].split(",");

        AutoGenerator mpg = new AutoGenerator();
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("muguang");
        gc.setOpen(false);
        gc.setSwagger2(true);
        gc.setFileOverride(false);
        gc.setIdType(IdType.ASSIGN_ID);
        gc.setDateType(DateType.ONLY_DATE);
        gc.setServiceName("%sService");
        mpg.setGlobalConfig(gc);

        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(dbUrl);
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername(dbUser);
        dsc.setPassword(dbPwd);
        mpg.setDataSource(dsc);

        PackageConfig pc = new PackageConfig();
        pc.setParent("org.muguang." + appName);
        pc.setModuleName(moduleName);
        pc.setEntity("entity");
        pc.setMapper("dao");
        pc.setService("service");
        pc.setController("controller");
        pc.setXml("mapper");
        mpg.setPackageInfo(pc);

        StrategyConfig strategy = new StrategyConfig();
        strategy.setInclude(tableNames);
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);

        mpg.execute();
    }

}
