package com.aizensousek.aytserver.service.impl;

import com.aizensousek.aytserver.dao.SysDictItemDao;
import com.aizensousek.aytserver.entity.SysDictItem;
import com.aizensousek.aytserver.service.SysDictItemService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (SysDictItem)表服务实现类
 *
 * @author makejava
 * @since 2022-06-01 14:40:20
 */
@Service("sysDictItemService")
public class SysDictItemServiceImpl implements SysDictItemService {
    @Resource
    private SysDictItemDao sysDictItemDao;

    /**
     * 通过ID查询单条数据
     *
     * @param keyId 主键
     * @return 实例对象
     */
    @Override
    public SysDictItem queryById(String keyId) {
        return this.sysDictItemDao.queryById(keyId);
    }

    /**
     * 分页查询
     *
     * @param sysDictItem 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<SysDictItem> queryByPage(SysDictItem sysDictItem, PageRequest pageRequest) {
        long total = this.sysDictItemDao.count(sysDictItem);
        return new PageImpl<>(this.sysDictItemDao.queryAllByLimit(sysDictItem, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param sysDictItem 实例对象
     * @return 实例对象
     */
    @Override
    public SysDictItem insert(SysDictItem sysDictItem) {
        this.sysDictItemDao.insert(sysDictItem);
        return sysDictItem;
    }

    /**
     * 修改数据
     *
     * @param sysDictItem 实例对象
     * @return 实例对象
     */
    @Override
    public SysDictItem update(SysDictItem sysDictItem) {
        this.sysDictItemDao.update(sysDictItem);
        return this.queryById(sysDictItem.getKeyId());
    }

    /**
     * 通过主键删除数据
     *
     * @param keyId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String keyId) {
        return this.sysDictItemDao.deleteById(keyId) > 0;
    }
}