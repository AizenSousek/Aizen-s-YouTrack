package com.aizensousek.aytserver.controller;

import com.aizensousek.aytserver.entity.SysDict;
import com.aizensousek.aytserver.service.SysDictService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (SysDict)表控制层
 *
 * @author makejava
 * @since 2022-06-01 14:40:19
 */
@RestController
@RequestMapping("sysDict")
public class SysDictController {
    /**
     * 服务对象
     */
    @Resource
    private SysDictService sysDictService;

    /**
     * 分页查询
     *
     * @param sysDict     筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<SysDict>> queryByPage(SysDict sysDict, PageRequest pageRequest) {
        return ResponseEntity.ok(this.sysDictService.queryByPage(sysDict, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<SysDict> queryById(@PathVariable("id") String id) {
        return ResponseEntity.ok(this.sysDictService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param sysDict 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<SysDict> add(SysDict sysDict) {
        return ResponseEntity.ok(this.sysDictService.insert(sysDict));
    }

    /**
     * 编辑数据
     *
     * @param sysDict 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<SysDict> edit(SysDict sysDict) {
        return ResponseEntity.ok(this.sysDictService.update(sysDict));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.sysDictService.deleteById(id));
    }

}