package com.aizensousek.aytserver.api;

import com.aizensousek.aytserver.constants.CommonConstants;
import com.aizensousek.aytserver.entity.SysProject;
import com.aizensousek.aytserver.service.SysProjectService;
import com.aizensousek.aytserver.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * 项目信息操作API
 *
 * @author aizensousek
 * @since 创建于2022/6/1 15:40
 **/
@RestController
@RequestMapping("pro")
@SuppressWarnings("unused")
public class ProjectResource {

    private final SysProjectService projectService;

    @Autowired
    public ProjectResource(SysProjectService projectService) {
        this.projectService = projectService;
    }

    /**
     * 创建项目
     *
     * @param project 项目
     * @return {@link SysProject}
     */
    @PostMapping("create")
    @PreAuthorize("hasRole('ADMIN')")
    public SysProject createProject(@RequestBody SysProject project) {
        // 单独生成项目ID
        String id = UUIDUtils.getUUIDString();
        project.setId(id);
        return projectService.insert(project);
    }

    /**
     * 更新项目
     *
     * @param project 项目
     * @return {@link SysProject}
     */
    @PostMapping("update")
    public SysProject updateProject(@RequestBody SysProject project) {
        return projectService.update(project);
    }

    /**
     * 按名称查询项目
     *
     * @param name 名字
     * @return {@link SysProject}
     */
    @GetMapping("getByName")
    public SysProject queryProjectByName(@RequestParam("name") String name) {
        SysProject project = new SysProject();
        project.setName(name);
        Page<SysProject> dataList = projectService.queryByPage(project, PageRequest.ofSize(1));
        return dataList.get().findFirst().orElse(null);
    }


    /**
     * 查询项目所有者
     *
     * @param ownerId 所有者id
     * @return {@link SysProject}
     */
    @GetMapping("getByOwner")
    public SysProject queryProjectByOwner(@RequestParam("owner") String ownerId) {
        SysProject project = new SysProject();
        project.setOwnerId(ownerId);
        Page<SysProject> dataList = projectService.queryByPage(project, PageRequest.ofSize(1));
        return dataList.get().findFirst().orElse(null);
    }

    /**
     * 查询模板项目
     *
     * @return {@link Page}<{@link SysProject}>
     */
    @GetMapping("getTplPros")
    public Page<SysProject> queryTemplateProjects() {
        SysProject project = new SysProject();
        project.setBeTemplate(CommonConstants.PROJECT_BE_TEMPLATE_TRUE);
        return projectService.queryByPage(project, PageRequest.ofSize(1));
    }

}