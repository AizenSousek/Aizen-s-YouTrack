package com.aizensousek.bigprize.service;

import com.aizensousek.bigprize.entity.BonusInputSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (BonusInputSource)表服务接口
 *
 * @author aizensousek
 * @since 2022-06-21 14:00:28
 */
@SuppressWarnings("unused")
public interface BonusInputSourceService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BonusInputSource queryById(String id);

    /**
     * 分页查询
     *
     * @param bonusInputSource 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<BonusInputSource> queryByPage(BonusInputSource bonusInputSource, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param bonusInputSource 实例对象
     * @return 实例对象
     */
    BonusInputSource insert(BonusInputSource bonusInputSource);

    /**
     * 修改数据
     *
     * @param bonusInputSource 实例对象
     * @return 实例对象
     */
    BonusInputSource update(BonusInputSource bonusInputSource);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}