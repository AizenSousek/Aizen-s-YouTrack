package com.aizensousek.aytserver.service.impl;

import com.aizensousek.aytserver.dao.SysDictDao;
import com.aizensousek.aytserver.entity.SysDict;
import com.aizensousek.aytserver.service.SysDictService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (SysDict)表服务实现类
 *
 * @author aizensousek
 * @since 2022-06-01 16:27:53
 */
@Service("sysDictService")
@SuppressWarnings("unused")
public class SysDictServiceImpl implements SysDictService {
    @Resource
    private SysDictDao sysDictDao;

    /**
     * 通过ID查询单条数据
     *
     * @param keyId 主键
     * @return 实例对象
     */
    @Override
    public SysDict queryById(String keyId) {
        return this.sysDictDao.queryById(keyId);
    }

    /**
     * 分页查询
     *
     * @param sysDict     筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<SysDict> queryByPage(SysDict sysDict, PageRequest pageRequest) {
        long total = this.sysDictDao.count(sysDict);
        return new PageImpl<>(this.sysDictDao.queryAllByLimit(sysDict, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param sysDict 实例对象
     * @return 实例对象
     */
    @Override
    public SysDict insert(SysDict sysDict) {
        this.sysDictDao.insert(sysDict);
        return sysDict;
    }

    /**
     * 修改数据
     *
     * @param sysDict 实例对象
     * @return 实例对象
     */
    @Override
    public SysDict update(SysDict sysDict) {
        this.sysDictDao.update(sysDict);
        return this.queryById(sysDict.getKeyId());
    }

    /**
     * 通过主键删除数据
     *
     * @param keyId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String keyId) {
        return this.sysDictDao.deleteById(keyId) > 0;
    }
}