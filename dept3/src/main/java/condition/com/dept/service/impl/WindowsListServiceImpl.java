package condition.com.dept.service.impl;

import condition.com.dept.service.ListService;

/**
 * @author WH1707008
 * @date 2018/7/19 15:18
 * Description:
 */
public class WindowsListServiceImpl implements ListService {
    @Override
    public String showListCmd() {
        return "dir";
    }
}
