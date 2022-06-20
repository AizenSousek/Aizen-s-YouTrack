package com.aizensousek.bigprize.dao;

import com.aizensousek.bigprize.entity.BonusLadder;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (BonusLadder)表数据库访问层
 *
 * @author aizensousek
 * @since 2022-06-22 11:03:19
 */
 @SuppressWarnings("unused")
public interface BonusLadderDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BonusLadder queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param bonusLadder 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<BonusLadder> queryAllByLimit(BonusLadder bonusLadder, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param bonusLadder 查询条件
     * @return 总行数
     */
    long count(BonusLadder bonusLadder);

    /**
     * 新增数据
     *
     * @param bonusLadder 实例对象
     * @return 影响行数
     */
    int insert(BonusLadder bonusLadder);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<BonusLadder> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<BonusLadder> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<BonusLadder> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<BonusLadder> entities);

    /**
     * 修改数据
     *
     * @param bonusLadder 实例对象
     * @return 影响行数
     */
    int update(BonusLadder bonusLadder);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}