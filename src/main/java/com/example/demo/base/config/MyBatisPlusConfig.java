package com.example.demo.base.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.wtkj.assist.base.utils.WebTool;
import com.wtkj.assist.entity.AskRecord;
import com.wtkj.assist.entity.InquestRecord;
import com.wtkj.assist.entity.SceneRecord;
import com.wtkj.assist.entity.SysUser;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.time.LocalDateTime;

/**
 * @Description MyBatis-Plus组件配置
 * @Author lzy
 * @Date 2022/6/16 16:42
 * @Version
 **/
@Configuration
@EnableTransactionManagement
public class MyBatisPlusConfig implements MetaObjectHandler {


    /**
     * MyBatis-Plus分页插件配置
     * @return
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor();
        // 设置数据库类型
        paginationInnerInterceptor.setDbType(DbType.MYSQL);
        // 设置溢出总页数后是否进行处理(默认false-不处理)
        paginationInnerInterceptor.setOverflow(true);
        //注释下面的可能出现获取不到总数的效果
        interceptor.addInnerInterceptor(paginationInnerInterceptor);
        return interceptor;
    }


    /**
     * mybatis-plus SQL执行效率插件【生产环境可以关闭】
     */
//    @Bean
//    public PerformanceInterceptor performanceInterceptor() {
//        return new PerformanceInterceptor();
//    }
//
//
//
    // 插入自动填充
    @Override
    public void insertFill(MetaObject metaObject) {
        Long userId = null;
        String fullName = "系统";
        String deptCode = null;
        Long deptId = null;
        String userPosition = null;
        SysUser currentUser = WebTool.getCurrentUser();
        if (currentUser != null) {
            userId = currentUser.getUserId();
            fullName = currentUser.getFullName();
            deptCode = currentUser.getDeptCode();
            deptId = currentUser.getDeptId();
            userPosition = currentUser.getPosition();
        }
        this.strictInsertFill(metaObject, "createUserId", Long.class, userId);
        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "createUserName", String.class, fullName);
        this.strictInsertFill(metaObject, "updateUserId", Long.class, userId);
        this.strictInsertFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "updateUserName", String.class, fullName);
    }


    // 更新自动填充
    @Override
    public void updateFill(MetaObject metaObject) {
        Long userId = null;
        String fullName = "系统";
        SysUser currentUser = WebTool.getCurrentUser();
        if (currentUser != null) {
            userId = currentUser.getUserId();
            fullName = currentUser.getFullName();
        }
         //该种方法只能对值为空的属性值进行自动填充
        this.strictUpdateFill(metaObject, "updateUserId", Long.class, userId);
        this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
        this.strictUpdateFill(metaObject, "updateUser", String.class, fullName);


    }
}
