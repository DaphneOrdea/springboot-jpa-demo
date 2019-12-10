package com.phantom.jpa.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : phantom
 * @desc :  德鲁伊连接池配置
 * @create : 2019/11/18 14:30
 */
@Configuration
//数据库文件读取
@PropertySource(value = "classpath:/config/db.properties")
public class DruidDataSourceConfig {

    @Value("${driver}")
    private String driver;
    @Value("${url}")
    private String url;
    @Value("${name}")
    private String userName;
    @Value("${password}")
    private String password;
    @Value("${maxActive}")
    private Integer maxActive;
    @Value("${minIdle}")
    private Integer minIdle;
    @Value("${initialSize}")
    private Integer initialSize;
    @Value("${maxWait}")
    private Integer maxWait;
    @Value("${timeBetweenEvictionRunsMillis}")
    private Integer timeBetweenEvictionRunsMillis;
    @Value("${minEvictableIdleTimeMillis}")
    private Integer minEvictableIdleTimeMillis;
    @Value("${loginUserName}")
    private String loginUserName;
    @Value("${loginPassword}")
    private String loginPassword;
    @Value("${exclusion}")
    private String exclusion;
    @Value("${filters}")
    private String filters;
    @Value("${resetEnable}")
    private String resetEnable = "false";
    @Value("${enabled}")
    private Boolean enabled = true;

    @Bean("druidDataSource")
    @Primary
    public DataSource druidDataSource(){
        //指定druid连接池
        DruidDataSource druidDataSource = new DruidDataSource();
        //数据库连接信息
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(userName);
        druidDataSource.setPassword(password);
        druidDataSource.setDriverClassName(driver);
        //最大并发连接数
        druidDataSource.setMaxActive(maxActive);
        //最小连接数
        druidDataSource.setMinIdle(minIdle);
        //初始化连接数量
        druidDataSource.setInitialSize(initialSize);
        //等待超时时间 : 6 秒
        druidDataSource.setMaxWait(maxWait);
        //配置间隔多久才进行一次检测,检测需要关闭的空闲连接，单位毫秒
        druidDataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        //配置一个连接在池中最小生存的时间，单位是毫秒
        druidDataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        try {
            //配置默认拦截
            druidDataSource.setFilters(filters);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return druidDataSource;
    }
    /**
     * 注册控制器，druid的监控
     * 访问 localhost:8080/druid/index.html可访问控制台
     * @return
     */
    @Bean
    public ServletRegistrationBean<StatViewServlet> druidServlet() {
        ServletRegistrationBean<StatViewServlet> reg = new ServletRegistrationBean<>();
        reg.setServlet(new StatViewServlet());
        //启用监控页面
        reg.setEnabled(true);
        //配置监控url
        reg.addUrlMappings("/druid/*");
        //设置控制台管理用户
        reg.addInitParameter("loginUserName", loginUserName);
        reg.addInitParameter("loginPassword", loginPassword);
        //是否可以重置数据
        reg.addInitParameter("resetEnable",resetEnable);
        return reg;
    }

    /**
     * 注册过滤器 druid的过滤
     * @return
     */
    @Bean
    public FilterRegistrationBean<WebStatFilter> filterRegistrationBean() {
        FilterRegistrationBean<WebStatFilter> frb = new FilterRegistrationBean<>();
        frb.setFilter(new WebStatFilter());
        //启用过滤
        frb.setEnabled(enabled);
        Map<String, String> initParams = new HashMap<>();
        //忽略过滤的形式
        initParams.put("exclusion",exclusion );
        frb.setInitParameters(initParams);
        //设置过滤器过滤路径
        frb.addUrlPatterns("/*");
        return frb;
    }

}
