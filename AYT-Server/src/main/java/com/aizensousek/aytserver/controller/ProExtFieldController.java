package com.aizensousek.aytserver.controller;

import com.aizensousek.aytserver.entity.ProExtField;
import com.aizensousek.aytserver.service.ProExtFieldService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 项目自定义字段信息表(ProExtField)表控制层
 *
 * @author makejava
 * @since 2022-06-01 14:40:17
 */
@RestController
@RequestMapping("proExtField")
public class ProExtFieldController {
    /**
     * 服务对象
     */
    @Resource
    private ProExtFieldService proExtFieldService;

    /**
     * 分页查询
     *
     * @param proExtField 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<ProExtField>> queryByPage(ProExtField proExtField, PageRequest pageRequest) {
        return ResponseEntity.ok(this.proExtFieldService.queryByPage(proExtField, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<ProExtField> queryById(@PathVariable("id") String id) {
        return ResponseEntity.ok(this.proExtFieldService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param proExtField 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<ProExtField> add(ProExtField proExtField) {
        return ResponseEntity.ok(this.proExtFieldService.insert(proExtField));
    }

    /**
     * 编辑数据
     *
     * @param proExtField 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<ProExtField> edit(ProExtField proExtField) {
        return ResponseEntity.ok(this.proExtFieldService.update(proExtField));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.proExtFieldService.deleteById(id));
    }

}