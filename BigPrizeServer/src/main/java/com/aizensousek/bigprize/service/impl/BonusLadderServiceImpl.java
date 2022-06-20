package com.aizensousek.bigprize.service.impl;

import com.aizensousek.bigprize.entity.BonusLadder;
import com.aizensousek.bigprize.dao.BonusLadderDao;
import com.aizensousek.bigprize.service.BonusLadderService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (BonusLadder)表服务实现类
 *
 * @author aizensousek
 * @since 2022-06-20 15:29:59
 */
@Service("bonusLadderService")
@SuppressWarnings("unused")
public class BonusLadderServiceImpl implements BonusLadderService {
    @Resource
    private BonusLadderDao bonusLadderDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public BonusLadder queryById(String id) {
        return this.bonusLadderDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param bonusLadder 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<BonusLadder> queryByPage(BonusLadder bonusLadder, PageRequest pageRequest) {
        long total = this.bonusLadderDao.count(bonusLadder);
        return new PageImpl<>(this.bonusLadderDao.queryAllByLimit(bonusLadder, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param bonusLadder 实例对象
     * @return 实例对象
     */
    @Override
    public BonusLadder insert(BonusLadder bonusLadder) {
        this.bonusLadderDao.insert(bonusLadder);
        return bonusLadder;
    }

    /**
     * 修改数据
     *
     * @param bonusLadder 实例对象
     * @return 实例对象
     */
    @Override
    public BonusLadder update(BonusLadder bonusLadder) {
        this.bonusLadderDao.update(bonusLadder);
        return this.queryById(bonusLadder.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.bonusLadderDao.deleteById(id) > 0;
    }
}