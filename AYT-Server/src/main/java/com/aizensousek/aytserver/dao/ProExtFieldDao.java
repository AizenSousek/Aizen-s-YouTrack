package com.aizensousek.aytserver.dao;

import com.aizensousek.aytserver.entity.ProExtField;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 项目自定义字段信息表(ProExtField)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-01 14:40:17
 */
public interface ProExtFieldDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ProExtField queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param proExtField 查询条件
     * @param pageable    分页对象
     * @return 对象列表
     */
    List<ProExtField> queryAllByLimit(ProExtField proExtField, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param proExtField 查询条件
     * @return 总行数
     */
    long count(ProExtField proExtField);

    /**
     * 新增数据
     *
     * @param proExtField 实例对象
     * @return 影响行数
     */
    int insert(ProExtField proExtField);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ProExtField> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ProExtField> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ProExtField> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<ProExtField> entities);

    /**
     * 修改数据
     *
     * @param proExtField 实例对象
     * @return 影响行数
     */
    int update(ProExtField proExtField);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}