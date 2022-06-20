package com.aizensousek.bigprize.service;

import com.aizensousek.bigprize.entity.BonusModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (BonusModel)表服务接口
 *
 * @author aizensousek
 * @since 2022-06-20 15:29:59
 */
@SuppressWarnings("unused")
public interface BonusModelService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BonusModel queryById(String id);

    /**
     * 分页查询
     *
     * @param bonusModel  筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<BonusModel> queryByPage(BonusModel bonusModel, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param bonusModel 实例对象
     * @return 实例对象
     */
    BonusModel insert(BonusModel bonusModel);

    /**
     * 修改数据
     *
     * @param bonusModel 实例对象
     * @return 实例对象
     */
    BonusModel update(BonusModel bonusModel);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}