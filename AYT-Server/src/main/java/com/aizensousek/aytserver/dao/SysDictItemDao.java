package com.aizensousek.aytserver.dao;

import com.aizensousek.aytserver.entity.SysDictItem;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (SysDictItem)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-01 14:40:19
 */
public interface SysDictItemDao {

    /**
     * 通过ID查询单条数据
     *
     * @param keyId 主键
     * @return 实例对象
     */
    SysDictItem queryById(String keyId);

    /**
     * 查询指定行数据
     *
     * @param sysDictItem 查询条件
     * @param pageable    分页对象
     * @return 对象列表
     */
    List<SysDictItem> queryAllByLimit(SysDictItem sysDictItem, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param sysDictItem 查询条件
     * @return 总行数
     */
    long count(SysDictItem sysDictItem);

    /**
     * 新增数据
     *
     * @param sysDictItem 实例对象
     * @return 影响行数
     */
    int insert(SysDictItem sysDictItem);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysDictItem> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SysDictItem> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysDictItem> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<SysDictItem> entities);

    /**
     * 修改数据
     *
     * @param sysDictItem 实例对象
     * @return 影响行数
     */
    int update(SysDictItem sysDictItem);

    /**
     * 通过主键删除数据
     *
     * @param keyId 主键
     * @return 影响行数
     */
    int deleteById(String keyId);

}