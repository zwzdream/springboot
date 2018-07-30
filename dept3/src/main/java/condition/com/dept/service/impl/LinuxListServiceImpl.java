package condition.com.dept.service.impl;

import condition.com.dept.service.ListService;

/**
 * @author WH1707008
 * @date 2018/7/19 15:18
 * Description:
 */
public class LinuxListServiceImpl implements ListService {
    @Override
    public String showListCmd() {
        return "ls";
    }
}
