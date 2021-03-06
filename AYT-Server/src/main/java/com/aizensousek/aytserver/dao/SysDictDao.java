package com.aizensousek.aytserver.dao;

import com.aizensousek.aytserver.entity.SysDict;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (SysDict)表数据库访问层
 *
 * @author aizensousek
 * @since 2022-06-01 16:27:53
 */
@SuppressWarnings("unused")
public interface SysDictDao {

    /**
     * 通过ID查询单条数据
     *
     * @param keyId 主键
     * @return 实例对象
     */
    SysDict queryById(String keyId);

    /**
     * 查询指定行数据
     *
     * @param sysDict  查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<SysDict> queryAllByLimit(SysDict sysDict, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param sysDict 查询条件
     * @return 总行数
     */
    long count(SysDict sysDict);

    /**
     * 新增数据
     *
     * @param sysDict 实例对象
     * @return 影响行数
     */
    int insert(SysDict sysDict);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysDict> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SysDict> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysDict> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<SysDict> entities);

    /**
     * 修改数据
     *
     * @param sysDict 实例对象
     * @return 影响行数
     */
    int update(SysDict sysDict);

    /**
     * 通过主键删除数据
     *
     * @param keyId 主键
     * @return 影响行数
     */
    int deleteById(String keyId);

}