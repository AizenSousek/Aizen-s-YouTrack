package com.aizensousek.bigprize.service.impl;

import com.aizensousek.bigprize.entity.BonusCalculateIndicator;
import com.aizensousek.bigprize.dao.BonusCalculateIndicatorDao;
import com.aizensousek.bigprize.service.BonusCalculateIndicatorService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (BonusCalculateIndicator)表服务实现类
 *
 * @author aizensousek
 * @since 2022-06-20 15:29:59
 */
@Service("bonusCalculateIndicatorService")
@SuppressWarnings("unused")
public class BonusCalculateIndicatorServiceImpl implements BonusCalculateIndicatorService {
    @Resource
    private BonusCalculateIndicatorDao bonusCalculateIndicatorDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public BonusCalculateIndicator queryById(String id) {
        return this.bonusCalculateIndicatorDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param bonusCalculateIndicator 筛选条件
     * @param pageRequest             分页对象
     * @return 查询结果
     */
    @Override
    public Page<BonusCalculateIndicator> queryByPage(BonusCalculateIndicator bonusCalculateIndicator, PageRequest pageRequest) {
        long total = this.bonusCalculateIndicatorDao.count(bonusCalculateIndicator);
        return new PageImpl<>(this.bonusCalculateIndicatorDao.queryAllByLimit(bonusCalculateIndicator, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param bonusCalculateIndicator 实例对象
     * @return 实例对象
     */
    @Override
    public BonusCalculateIndicator insert(BonusCalculateIndicator bonusCalculateIndicator) {
        this.bonusCalculateIndicatorDao.insert(bonusCalculateIndicator);
        return bonusCalculateIndicator;
    }

    /**
     * 修改数据
     *
     * @param bonusCalculateIndicator 实例对象
     * @return 实例对象
     */
    @Override
    public BonusCalculateIndicator update(BonusCalculateIndicator bonusCalculateIndicator) {
        this.bonusCalculateIndicatorDao.update(bonusCalculateIndicator);
        return this.queryById(bonusCalculateIndicator.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.bonusCalculateIndicatorDao.deleteById(id) > 0;
    }
}