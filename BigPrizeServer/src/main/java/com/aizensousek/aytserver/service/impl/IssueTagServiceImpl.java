package com.aizensousek.aytserver.service.impl;

import com.aizensousek.aytserver.dao.IssueTagDao;
import com.aizensousek.aytserver.entity.IssueTag;
import com.aizensousek.aytserver.service.IssueTagService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 问题标记信息表(IssueTag)表服务实现类
 *
 * @author aizensousek
 * @since 2022-06-01 16:27:52
 */
@Service("issueTagService")
@SuppressWarnings("unused")
public class IssueTagServiceImpl implements IssueTagService {
    @Resource
    private IssueTagDao issueTagDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public IssueTag queryById(String id) {
        return this.issueTagDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param issueTag    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<IssueTag> queryByPage(IssueTag issueTag, PageRequest pageRequest) {
        long total = this.issueTagDao.count(issueTag);
        return new PageImpl<>(this.issueTagDao.queryAllByLimit(issueTag, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param issueTag 实例对象
     * @return 实例对象
     */
    @Override
    public IssueTag insert(IssueTag issueTag) {
        this.issueTagDao.insert(issueTag);
        return issueTag;
    }

    /**
     * 修改数据
     *
     * @param issueTag 实例对象
     * @return 实例对象
     */
    @Override
    public IssueTag update(IssueTag issueTag) {
        this.issueTagDao.update(issueTag);
        return this.queryById(issueTag.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.issueTagDao.deleteById(id) > 0;
    }
}