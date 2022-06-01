package com.aizensousek.aytserver.dao;

import com.aizensousek.aytserver.entity.IssueTag;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 问题标记信息表(IssueTag)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-01 14:40:17
 */
public interface IssueTagDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    IssueTag queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param issueTag 查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<IssueTag> queryAllByLimit(IssueTag issueTag, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param issueTag 查询条件
     * @return 总行数
     */
    long count(IssueTag issueTag);

    /**
     * 新增数据
     *
     * @param issueTag 实例对象
     * @return 影响行数
     */
    int insert(IssueTag issueTag);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<IssueTag> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<IssueTag> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<IssueTag> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<IssueTag> entities);

    /**
     * 修改数据
     *
     * @param issueTag 实例对象
     * @return 影响行数
     */
    int update(IssueTag issueTag);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}