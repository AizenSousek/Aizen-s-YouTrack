package com.aizensousek.aytserver.controller;

import com.aizensousek.aytserver.entity.IssueItem;
import com.aizensousek.aytserver.service.IssueItemService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 问题信息表(IssueItem)表控制层
 *
 * @author makejava
 * @since 2022-06-01 14:37:53
 */
@RestController
@RequestMapping("issueItem")
public class IssueItemController {
    /**
     * 服务对象
     */
    @Resource
    private IssueItemService issueItemService;

    /**
     * 分页查询
     *
     * @param issueItem   筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<IssueItem>> queryByPage(IssueItem issueItem, PageRequest pageRequest) {
        return ResponseEntity.ok(this.issueItemService.queryByPage(issueItem, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<IssueItem> queryById(@PathVariable("id") String id) {
        return ResponseEntity.ok(this.issueItemService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param issueItem 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<IssueItem> add(IssueItem issueItem) {
        return ResponseEntity.ok(this.issueItemService.insert(issueItem));
    }

    /**
     * 编辑数据
     *
     * @param issueItem 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<IssueItem> edit(IssueItem issueItem) {
        return ResponseEntity.ok(this.issueItemService.update(issueItem));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.issueItemService.deleteById(id));
    }

}