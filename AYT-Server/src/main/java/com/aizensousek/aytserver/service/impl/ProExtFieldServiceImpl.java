package com.aizensousek.aytserver.service.impl;

import com.aizensousek.aytserver.dao.ProExtFieldDao;
import com.aizensousek.aytserver.entity.ProExtField;
import com.aizensousek.aytserver.service.ProExtFieldService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 项目自定义字段信息表(ProExtField)表服务实现类
 *
 * @author makejava
 * @since 2022-06-01 14:40:18
 */
@Service("proExtFieldService")
public class ProExtFieldServiceImpl implements ProExtFieldService {
    @Resource
    private ProExtFieldDao proExtFieldDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ProExtField queryById(String id) {
        return this.proExtFieldDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param proExtField 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<ProExtField> queryByPage(ProExtField proExtField, PageRequest pageRequest) {
        long total = this.proExtFieldDao.count(proExtField);
        return new PageImpl<>(this.proExtFieldDao.queryAllByLimit(proExtField, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param proExtField 实例对象
     * @return 实例对象
     */
    @Override
    public ProExtField insert(ProExtField proExtField) {
        this.proExtFieldDao.insert(proExtField);
        return proExtField;
    }

    /**
     * 修改数据
     *
     * @param proExtField 实例对象
     * @return 实例对象
     */
    @Override
    public ProExtField update(ProExtField proExtField) {
        this.proExtFieldDao.update(proExtField);
        return this.queryById(proExtField.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.proExtFieldDao.deleteById(id) > 0;
    }
}