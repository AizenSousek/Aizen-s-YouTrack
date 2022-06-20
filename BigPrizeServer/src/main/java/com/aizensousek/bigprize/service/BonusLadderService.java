package com.aizensousek.bigprize.service;

import com.aizensousek.bigprize.entity.BonusLadder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (BonusLadder)表服务接口
 *
 * @author aizensousek
 * @since 2022-06-22 11:03:19
 */
 @SuppressWarnings("unused")
public interface BonusLadderService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BonusLadder queryById(String id);

    /**
     * 分页查询
     *
     * @param bonusLadder 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<BonusLadder> queryByPage(BonusLadder bonusLadder, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param bonusLadder 实例对象
     * @return 实例对象
     */
    BonusLadder insert(BonusLadder bonusLadder);

    /**
     * 修改数据
     *
     * @param bonusLadder 实例对象
     * @return 实例对象
     */
    BonusLadder update(BonusLadder bonusLadder);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}