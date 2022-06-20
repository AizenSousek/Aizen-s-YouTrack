package com.aizensousek.aytserver.api;

import com.aizensousek.aytserver.entity.IssueItem;
import com.aizensousek.aytserver.service.IssueItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/**
 * 问题信息管理API
 *
 * @author aizensousek
 * @since 创建于2022/6/1 16:22
 **/
@SuppressWarnings("unused")
@RestController
@RequestMapping("issue")
public class IssueResource {

    private IssueItemService issueItemService;

    @Autowired
    public void setIssueItemService(IssueItemService issueItemService) {
        this.issueItemService = issueItemService;
    }

    /**
     * 创建问题
     *
     * @param issue 问题
     * @return {@link IssueItem}
     */
    @PostMapping("create")
    public IssueItem createIssue(@RequestBody IssueItem issue) {
        return issueItemService.insert(issue);
    }

    /**
     * 更新问题
     *
     * @param issue 问题
     * @return {@link IssueItem}
     */
    @PostMapping("update")
    public IssueItem updateIssue(@RequestBody IssueItem issue) {
        return issueItemService.update(issue);
    }

    /**
     * 通过id查询问题
     *
     * @param id id
     * @return {@link IssueItem}
     */
    @GetMapping("queryIssueById")
    public IssueItem queryIssueById(@RequestParam("id") String id) {
        return issueItemService.queryById(id);
    }

    /**
     * 根据标题查询问题数据
     *
     * @param title 名字
     * @return {@link Page}<{@link IssueItem}>
     */
    @GetMapping("queryIssueByTitle")
    public Page<IssueItem> queryIssueByTitle(@RequestParam("title") String title) {
        IssueItem issue = new IssueItem();
        issue.setTitle(title);
        return issueItemService.queryByPage(issue, PageRequest.ofSize(1));
    }

    /**
     * 通过标题查询问题列表
     *
     * @param title 名字
     * @param page  页面
     * @param size  大小
     * @return {@link Page}<{@link IssueItem}>
     */
    @GetMapping("queryIssueListByTitle")
    public Page<IssueItem> queryIssueListByTitle(@RequestParam("title") String title,
                                                 @RequestParam("page") int page,
                                                 @RequestParam("size") int size) {
        IssueItem issue = new IssueItem();
        issue.setTitle(title);
        return issueItemService.queryByPage(issue, PageRequest.of(page, size));
    }


}