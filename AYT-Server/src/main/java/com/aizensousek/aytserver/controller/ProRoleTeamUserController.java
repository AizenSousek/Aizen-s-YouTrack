package com.aizensousek.aytserver.controller;

import com.aizensousek.aytserver.entity.ProRoleTeamUser;
import com.aizensousek.aytserver.service.ProRoleTeamUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 项目团队信息表(ProRoleTeamUser)表控制层
 *
 * @author makejava
 * @since 2022-06-01 14:40:18
 */
@RestController
@RequestMapping("proRoleTeamUser")
public class ProRoleTeamUserController {
    /**
     * 服务对象
     */
    @Resource
    private ProRoleTeamUserService proRoleTeamUserService;

    /**
     * 分页查询
     *
     * @param proRoleTeamUser 筛选条件
     * @param pageRequest     分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<ProRoleTeamUser>> queryByPage(ProRoleTeamUser proRoleTeamUser, PageRequest pageRequest) {
        return ResponseEntity.ok(this.proRoleTeamUserService.queryByPage(proRoleTeamUser, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<ProRoleTeamUser> queryById(@PathVariable("id") String id) {
        return ResponseEntity.ok(this.proRoleTeamUserService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param proRoleTeamUser 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<ProRoleTeamUser> add(ProRoleTeamUser proRoleTeamUser) {
        return ResponseEntity.ok(this.proRoleTeamUserService.insert(proRoleTeamUser));
    }

    /**
     * 编辑数据
     *
     * @param proRoleTeamUser 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<ProRoleTeamUser> edit(ProRoleTeamUser proRoleTeamUser) {
        return ResponseEntity.ok(this.proRoleTeamUserService.update(proRoleTeamUser));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.proRoleTeamUserService.deleteById(id));
    }

}