package com.aizensousek.aytserver.controller;

import com.aizensousek.aytserver.entity.ProTeamRole;
import com.aizensousek.aytserver.service.ProTeamRoleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 项目角色信息表(ProTeamRole)表控制层
 *
 * @author makejava
 * @since 2022-06-01 14:40:18
 */
@RestController
@RequestMapping("proTeamRole")
public class ProTeamRoleController {
    /**
     * 服务对象
     */
    @Resource
    private ProTeamRoleService proTeamRoleService;

    /**
     * 分页查询
     *
     * @param proTeamRole 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<ProTeamRole>> queryByPage(ProTeamRole proTeamRole, PageRequest pageRequest) {
        return ResponseEntity.ok(this.proTeamRoleService.queryByPage(proTeamRole, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<ProTeamRole> queryById(@PathVariable("id") String id) {
        return ResponseEntity.ok(this.proTeamRoleService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param proTeamRole 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<ProTeamRole> add(ProTeamRole proTeamRole) {
        return ResponseEntity.ok(this.proTeamRoleService.insert(proTeamRole));
    }

    /**
     * 编辑数据
     *
     * @param proTeamRole 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<ProTeamRole> edit(ProTeamRole proTeamRole) {
        return ResponseEntity.ok(this.proTeamRoleService.update(proTeamRole));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.proTeamRoleService.deleteById(id));
    }

}