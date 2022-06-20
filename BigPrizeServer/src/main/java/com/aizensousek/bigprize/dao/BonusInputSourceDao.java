package com.aizensousek.bigprize.dao;

import com.aizensousek.bigprize.entity.BonusInputSource;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (BonusInputSource)表数据库访问层
 *
 * @author aizensousek
 * @since 2022-06-20 15:29:59
 */
@SuppressWarnings("unused")
public interface BonusInputSourceDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BonusInputSource queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param bonusInputSource 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<BonusInputSource> queryAllByLimit(BonusInputSource bonusInputSource, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param bonusInputSource 查询条件
     * @return 总行数
     */
    long count(BonusInputSource bonusInputSource);

    /**
     * 新增数据
     *
     * @param bonusInputSource 实例对象
     * @return 影响行数
     */
    int insert(BonusInputSource bonusInputSource);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<BonusInputSource> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<BonusInputSource> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<BonusInputSource> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<BonusInputSource> entities);

    /**
     * 修改数据
     *
     * @param bonusInputSource 实例对象
     * @return 影响行数
     */
    int update(BonusInputSource bonusInputSource);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}