package com.aizensousek.bigprize.service.impl;

import com.aizensousek.bigprize.entity.BonusModel;
import com.aizensousek.bigprize.dao.BonusModelDao;
import com.aizensousek.bigprize.service.BonusModelService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (BonusModel)表服务实现类
 *
 * @author aizensousek
 * @since 2022-06-21 14:00:27
 */
@Service("bonusModelService")
@SuppressWarnings("unused")
public class BonusModelServiceImpl implements BonusModelService {
    @Resource
    private BonusModelDao bonusModelDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public BonusModel queryById(String id) {
        return this.bonusModelDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param bonusModel  筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<BonusModel> queryByPage(BonusModel bonusModel, PageRequest pageRequest) {
        long total = this.bonusModelDao.count(bonusModel);
        return new PageImpl<>(this.bonusModelDao.queryAllByLimit(bonusModel, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param bonusModel 实例对象
     * @return 实例对象
     */
    @Override
    public BonusModel insert(BonusModel bonusModel) {
        this.bonusModelDao.insert(bonusModel);
        return bonusModel;
    }

    /**
     * 修改数据
     *
     * @param bonusModel 实例对象
     * @return 实例对象
     */
    @Override
    public BonusModel update(BonusModel bonusModel) {
        this.bonusModelDao.update(bonusModel);
        return this.queryById(bonusModel.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.bonusModelDao.deleteById(id) > 0;
    }
}