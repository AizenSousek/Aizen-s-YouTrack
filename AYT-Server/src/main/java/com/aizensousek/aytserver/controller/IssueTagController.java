package com.aizensousek.aytserver.controller;

import com.aizensousek.aytserver.entity.IssueTag;
import com.aizensousek.aytserver.service.IssueTagService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 问题标记信息表(IssueTag)表控制层
 *
 * @author makejava
 * @since 2022-06-01 14:40:17
 */
@RestController
@RequestMapping("issueTag")
public class IssueTagController {
    /**
     * 服务对象
     */
    @Resource
    private IssueTagService issueTagService;

    /**
     * 分页查询
     *
     * @param issueTag    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<IssueTag>> queryByPage(IssueTag issueTag, PageRequest pageRequest) {
        return ResponseEntity.ok(this.issueTagService.queryByPage(issueTag, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<IssueTag> queryById(@PathVariable("id") String id) {
        return ResponseEntity.ok(this.issueTagService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param issueTag 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<IssueTag> add(IssueTag issueTag) {
        return ResponseEntity.ok(this.issueTagService.insert(issueTag));
    }

    /**
     * 编辑数据
     *
     * @param issueTag 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<IssueTag> edit(IssueTag issueTag) {
        return ResponseEntity.ok(this.issueTagService.update(issueTag));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.issueTagService.deleteById(id));
    }

}