package com.aizensousek.aytserver.controller;

import com.aizensousek.aytserver.entity.ProFieldItemData;
import com.aizensousek.aytserver.service.ProFieldItemDataService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 项目自定义字段数据表(ProFieldItemData)表控制层
 *
 * @author makejava
 * @since 2022-06-01 14:40:18
 */
@RestController
@RequestMapping("proFieldItemData")
public class ProFieldItemDataController {
    /**
     * 服务对象
     */
    @Resource
    private ProFieldItemDataService proFieldItemDataService;

    /**
     * 分页查询
     *
     * @param proFieldItemData 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<ProFieldItemData>> queryByPage(ProFieldItemData proFieldItemData, PageRequest pageRequest) {
        return ResponseEntity.ok(this.proFieldItemDataService.queryByPage(proFieldItemData, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<ProFieldItemData> queryById(@PathVariable("id") String id) {
        return ResponseEntity.ok(this.proFieldItemDataService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param proFieldItemData 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<ProFieldItemData> add(ProFieldItemData proFieldItemData) {
        return ResponseEntity.ok(this.proFieldItemDataService.insert(proFieldItemData));
    }

    /**
     * 编辑数据
     *
     * @param proFieldItemData 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<ProFieldItemData> edit(ProFieldItemData proFieldItemData) {
        return ResponseEntity.ok(this.proFieldItemDataService.update(proFieldItemData));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.proFieldItemDataService.deleteById(id));
    }

}