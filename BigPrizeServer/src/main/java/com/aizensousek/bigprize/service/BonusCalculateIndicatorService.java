package com.aizensousek.bigprize.service;

import com.aizensousek.bigprize.entity.BonusCalculateIndicator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (BonusCalculateIndicator)表服务接口
 *
 * @author aizensousek
 * @since 2022-06-21 14:00:28
 */
@SuppressWarnings("unused")
public interface BonusCalculateIndicatorService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BonusCalculateIndicator queryById(String id);

    /**
     * 分页查询
     *
     * @param bonusCalculateIndicator 筛选条件
     * @param pageRequest             分页对象
     * @return 查询结果
     */
    Page<BonusCalculateIndicator> queryByPage(BonusCalculateIndicator bonusCalculateIndicator, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param bonusCalculateIndicator 实例对象
     * @return 实例对象
     */
    BonusCalculateIndicator insert(BonusCalculateIndicator bonusCalculateIndicator);

    /**
     * 修改数据
     *
     * @param bonusCalculateIndicator 实例对象
     * @return 实例对象
     */
    BonusCalculateIndicator update(BonusCalculateIndicator bonusCalculateIndicator);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}