package com.aizensousek.bigprize.dao;

import com.aizensousek.bigprize.entity.BonusCalculateIndicator;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (BonusCalculateIndicator)表数据库访问层
 *
 * @author aizensousek
 * @since 2022-06-20 15:29:58
 */
@SuppressWarnings("unused")
public interface BonusCalculateIndicatorDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BonusCalculateIndicator queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param bonusCalculateIndicator 查询条件
     * @param pageable                分页对象
     * @return 对象列表
     */
    List<BonusCalculateIndicator> queryAllByLimit(BonusCalculateIndicator bonusCalculateIndicator, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param bonusCalculateIndicator 查询条件
     * @return 总行数
     */
    long count(BonusCalculateIndicator bonusCalculateIndicator);

    /**
     * 新增数据
     *
     * @param bonusCalculateIndicator 实例对象
     * @return 影响行数
     */
    int insert(BonusCalculateIndicator bonusCalculateIndicator);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<BonusCalculateIndicator> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<BonusCalculateIndicator> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<BonusCalculateIndicator> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<BonusCalculateIndicator> entities);

    /**
     * 修改数据
     *
     * @param bonusCalculateIndicator 实例对象
     * @return 影响行数
     */
    int update(BonusCalculateIndicator bonusCalculateIndicator);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}