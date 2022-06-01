package com.aizensousek.aytserver.service.impl;

import com.aizensousek.aytserver.dao.ProFieldItemDataDao;
import com.aizensousek.aytserver.entity.ProFieldItemData;
import com.aizensousek.aytserver.service.ProFieldItemDataService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 项目自定义字段数据表(ProFieldItemData)表服务实现类
 *
 * @author makejava
 * @since 2022-06-01 14:40:18
 */
@Service("proFieldItemDataService")
public class ProFieldItemDataServiceImpl implements ProFieldItemDataService {
    @Resource
    private ProFieldItemDataDao proFieldItemDataDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ProFieldItemData queryById(String id) {
        return this.proFieldItemDataDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param proFieldItemData 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<ProFieldItemData> queryByPage(ProFieldItemData proFieldItemData, PageRequest pageRequest) {
        long total = this.proFieldItemDataDao.count(proFieldItemData);
        return new PageImpl<>(this.proFieldItemDataDao.queryAllByLimit(proFieldItemData, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param proFieldItemData 实例对象
     * @return 实例对象
     */
    @Override
    public ProFieldItemData insert(ProFieldItemData proFieldItemData) {
        this.proFieldItemDataDao.insert(proFieldItemData);
        return proFieldItemData;
    }

    /**
     * 修改数据
     *
     * @param proFieldItemData 实例对象
     * @return 实例对象
     */
    @Override
    public ProFieldItemData update(ProFieldItemData proFieldItemData) {
        this.proFieldItemDataDao.update(proFieldItemData);
        return this.queryById(proFieldItemData.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.proFieldItemDataDao.deleteById(id) > 0;
    }
}