package com.aizensousek.aytserver.controller;

import com.aizensousek.aytserver.entity.UserExt;
import com.aizensousek.aytserver.service.UserExtService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户扩展字段表(UserExt)表控制层
 *
 * @author makejava
 * @since 2022-06-01 14:40:20
 */
@RestController
@RequestMapping("userExt")
public class UserExtController {
    /**
     * 服务对象
     */
    @Resource
    private UserExtService userExtService;

    /**
     * 分页查询
     *
     * @param userExt     筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<UserExt>> queryByPage(UserExt userExt, PageRequest pageRequest) {
        return ResponseEntity.ok(this.userExtService.queryByPage(userExt, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<UserExt> queryById(@PathVariable("id") String id) {
        return ResponseEntity.ok(this.userExtService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param userExt 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<UserExt> add(UserExt userExt) {
        return ResponseEntity.ok(this.userExtService.insert(userExt));
    }

    /**
     * 编辑数据
     *
     * @param userExt 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<UserExt> edit(UserExt userExt) {
        return ResponseEntity.ok(this.userExtService.update(userExt));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.userExtService.deleteById(id));
    }

}