package com.aizensousek.aytserver.controller;

import com.aizensousek.aytserver.entity.SysDictItem;
import com.aizensousek.aytserver.service.SysDictItemService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (SysDictItem)表控制层
 *
 * @author makejava
 * @since 2022-06-01 14:40:19
 */
@RestController
@RequestMapping("sysDictItem")
public class SysDictItemController {
    /**
     * 服务对象
     */
    @Resource
    private SysDictItemService sysDictItemService;

    /**
     * 分页查询
     *
     * @param sysDictItem 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<SysDictItem>> queryByPage(SysDictItem sysDictItem, PageRequest pageRequest) {
        return ResponseEntity.ok(this.sysDictItemService.queryByPage(sysDictItem, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<SysDictItem> queryById(@PathVariable("id") String id) {
        return ResponseEntity.ok(this.sysDictItemService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param sysDictItem 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<SysDictItem> add(SysDictItem sysDictItem) {
        return ResponseEntity.ok(this.sysDictItemService.insert(sysDictItem));
    }

    /**
     * 编辑数据
     *
     * @param sysDictItem 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<SysDictItem> edit(SysDictItem sysDictItem) {
        return ResponseEntity.ok(this.sysDictItemService.update(sysDictItem));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.sysDictItemService.deleteById(id));
    }

}