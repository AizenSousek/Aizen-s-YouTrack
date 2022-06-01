package com.aizensousek.aytserver.controller;

import com.aizensousek.aytserver.entity.SysProject;
import com.aizensousek.aytserver.service.SysProjectService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 项目基本信息表(SysProject)表控制层
 *
 * @author makejava
 * @since 2022-06-01 14:40:20
 */
@RestController
@RequestMapping("sysProject")
public class SysProjectController {
    /**
     * 服务对象
     */
    @Resource
    private SysProjectService sysProjectService;

    /**
     * 分页查询
     *
     * @param sysProject  筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<SysProject>> queryByPage(SysProject sysProject, PageRequest pageRequest) {
        return ResponseEntity.ok(this.sysProjectService.queryByPage(sysProject, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<SysProject> queryById(@PathVariable("id") String id) {
        return ResponseEntity.ok(this.sysProjectService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param sysProject 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<SysProject> add(SysProject sysProject) {
        return ResponseEntity.ok(this.sysProjectService.insert(sysProject));
    }

    /**
     * 编辑数据
     *
     * @param sysProject 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<SysProject> edit(SysProject sysProject) {
        return ResponseEntity.ok(this.sysProjectService.update(sysProject));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.sysProjectService.deleteById(id));
    }

}