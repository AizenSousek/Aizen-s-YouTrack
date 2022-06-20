package com.aizensousek.bigprize.service.impl;

import com.aizensousek.bigprize.entity.BonusInputSource;
import com.aizensousek.bigprize.dao.BonusInputSourceDao;
import com.aizensousek.bigprize.service.BonusInputSourceService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (BonusInputSource)表服务实现类
 *
 * @author aizensousek
 * @since 2022-06-21 14:00:28
 */
@Service("bonusInputSourceService")
@SuppressWarnings("unused")
public class BonusInputSourceServiceImpl implements BonusInputSourceService {
    @Resource
    private BonusInputSourceDao bonusInputSourceDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public BonusInputSource queryById(String id) {
        return this.bonusInputSourceDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param bonusInputSource 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<BonusInputSource> queryByPage(BonusInputSource bonusInputSource, PageRequest pageRequest) {
        long total = this.bonusInputSourceDao.count(bonusInputSource);
        return new PageImpl<>(this.bonusInputSourceDao.queryAllByLimit(bonusInputSource, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param bonusInputSource 实例对象
     * @return 实例对象
     */
    @Override
    public BonusInputSource insert(BonusInputSource bonusInputSource) {
        this.bonusInputSourceDao.insert(bonusInputSource);
        return bonusInputSource;
    }

    /**
     * 修改数据
     *
     * @param bonusInputSource 实例对象
     * @return 实例对象
     */
    @Override
    public BonusInputSource update(BonusInputSource bonusInputSource) {
        this.bonusInputSourceDao.update(bonusInputSource);
        return this.queryById(bonusInputSource.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.bonusInputSourceDao.deleteById(id) > 0;
    }
}