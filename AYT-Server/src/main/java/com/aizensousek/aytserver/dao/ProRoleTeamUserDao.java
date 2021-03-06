package com.aizensousek.aytserver.dao;

import com.aizensousek.aytserver.entity.ProRoleTeamUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 项目团队信息表(ProRoleTeamUser)表数据库访问层
 *
 * @author aizensousek
 * @since 2022-06-01 16:27:52
 */
@SuppressWarnings("unused")
public interface ProRoleTeamUserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ProRoleTeamUser queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param proRoleTeamUser 查询条件
     * @param pageable        分页对象
     * @return 对象列表
     */
    List<ProRoleTeamUser> queryAllByLimit(ProRoleTeamUser proRoleTeamUser, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param proRoleTeamUser 查询条件
     * @return 总行数
     */
    long count(ProRoleTeamUser proRoleTeamUser);

    /**
     * 新增数据
     *
     * @param proRoleTeamUser 实例对象
     * @return 影响行数
     */
    int insert(ProRoleTeamUser proRoleTeamUser);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ProRoleTeamUser> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ProRoleTeamUser> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ProRoleTeamUser> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<ProRoleTeamUser> entities);

    /**
     * 修改数据
     *
     * @param proRoleTeamUser 实例对象
     * @return 影响行数
     */
    int update(ProRoleTeamUser proRoleTeamUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}