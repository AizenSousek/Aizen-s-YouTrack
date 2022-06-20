package com.aizensousek.bigprize.api;

import com.aizensousek.bigprize.entity.UserExt;
import com.aizensousek.bigprize.service.UserExtService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/**
 * 用户自定义字段信息API
 *
 * @author aizensousek
 * @since 创建于2022/6/1 17:06
 **/
@RestController
@RequestMapping("userExtField")
public class UserExtFieldResource {

    private UserExtService userExtService;

    public void setUserExtService(UserExtService userExtService) {
        this.userExtService = userExtService;
    }

    /**
     * 创建用户额外字段
     *
     * @param ext ext
     * @return {@link UserExt}
     */
    @PostMapping("createUserExternField")
    public UserExt createUserExtraField(@RequestBody UserExt ext) {
        return userExtService.insert(ext);
    }

    /**
     * 更新用户额外字段
     *
     * @param ext ext
     * @return {@link UserExt}
     */
    @PostMapping("updateUserExtraField")
    public UserExt updateUserExtraField(@RequestBody UserExt ext) {
        return userExtService.update(ext);
    }

    /**
     * 查询用户额外字段通过id
     *
     * @param id id
     * @return {@link UserExt}
     */
    @GetMapping("queryUserExtraFieldById")
    public UserExt queryUserExtraFieldById(@RequestParam("id") String id) {
        return userExtService.queryById(id);
    }

    @GetMapping("queryUserExtFieldList")
    public Page<UserExt> queryUserExtraFieldList(@RequestParam("page") int page, @RequestParam("size") int size) {
        return userExtService.queryByPage(null, PageRequest.of(page, size));
    }

    @PostMapping("deleteUserExtraFieldById")
    public boolean deleteUserExtraFieldById(@RequestBody UserExt ext) {
        return userExtService.deleteById(ext.getId());
    }
}