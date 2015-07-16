package com.lprclient.core;

/**     
 * @Description:
 * @author: kuku713@qq.com    
 * @date: 2015年6月19日 下午4:53:07  
 * @version V1.0    
 */
public class LPRConstant {
	
	public static final String NA = "N/A";
	public static final String BLANK = "   ";

	public static final String K_USERNAME  = "userName";
	public static final String K_PASSWORD  = "password";
	public static final String K_ISLOGIN   = "isLogin";
	public static final String K_CONTENT   = "content";
	public static final String K_ADMINUSER = "adminUser";
	
	public static final int ADMIN_USER_ROLE_DEFAULT_ID = 3;
	public static final int[] ADMIN_USER_ROLE_BASE_ID = {1, 2};
	
	public static final int ADMIN_USER_ROLE_STATUS_NORMAL = 1;
	public static final int ADMIN_USER_ROLE_STATUS_DELETE = 2;
	
	public static final String ISLOGIN_YES = "true";
	public static final String ISLOGIN_NO  = "false";
	
	public static final int ADMIN_USER_STATUS_NORMAL = 0;
	public static final int ADMIN_USER_STATUS_CANCEL = 1;
	public static final String ADMIN_USER_STATUS_NORMAL_DESC = "正常";
	public static final String ADMIN_USER_STATUS_CANCEL_DESC = "暂停";
	public static final String ADMIN_USER_STATUS_OTHER_DESC  = "异常";
	
	public static final int PAGE_SIZE = 20;
	
	public static final String COPYRIGHT_DESC = "Copyright © 2015 All rights reserved.";
	
	public static final int ACTION_SUCCESS = 1; // 事务操作成功
	public static final int ACTION_FAIL    = 0; // 事务操作失败
	public static final String ACTION_SUCCESS_DESC = "成功";
	public static final String ACTION_FAIL_DESC    = "失败";
	
	public static final String PROPERTY_FILE_NAME = "admin.properties";
	public static final String PROPERTY_ATTR_LABPATH = "labpath";
	public static final String PROPERTY_ATTR_USERNAME = "username";
	public static final String PROPERTY_ATTR_PASSWORD = "password";
	
	public static final String ACTION_TYPE_LOGIN           = "登录";
	public static final String ACTION_TYEP_LOGOUT          = "退出";
	public static final String ACTION_TYPE_REGIST          = "注册";
	public static final String ACTION_TYPE_FORGOT_PASSWORD = "忘记密码";
	public static final String ACTION_TYPE_MODIFY_PASSWORD = "修改密码";
	public static final String ACTION_TYPE_RESET_PASSWORD  = "重置密码";
	public static final String ACTION_TYPE_MODIFY_USER     = "修改管理员";
	public static final String ACTION_TYPE_DELETE_USER     = "删除管理员";
	public static final String ACTION_TYPE_MODIFY_PERM     = "修改权限";
	
	public static final int CONTENT_LEVEL_MAIN = 1; // 一级菜单
	public static final int CONTENT_LEVEL_SUB  = 2; // 二级菜单
	
	public static final int ROLE_PERM_YES = 1; // 有权限 
	public static final int ROLE_PERM_NO  = 0; // 无权限
	
	public static final int LOGIN_FRAME_SIZE_WIDTH   = 400;
	public static final int LOGIN_FRAME_SIZE_HEIGHT  = 300;
	public static final int LOGIN_FRAME_LABEL_WIDTH  = 120;
	public static final int LOGIN_FRAME_LABEL_HEIGHT = 20;
	
	public static final int REGIST_FRAME_SIZE_WIDTH = 400;
	public static final int REGIST_FRAME_SIZE_HEIGHT = 300;
	public static final int REGIST_FRAME_LABEL_HEIGHT = 20;
	public static final int REGIST_PANEL_BEGIN_X = 00;
	public static final int REGIST_PANEL_BEGIN_Y = 70;
	public static final int REGIST_PANEL_WIDTH   = 400;
	public static final int REGIST_PANEL_HEIGHT  = 150;
	public static final int REGIST_PANEL_BUTTON_BEGIN_X = 140;
	public static final int REGIST_PANEL_BUTTON_BEGIN_Y = 240;
	public static final int REGIST_PANEL_BUTTON_WIDTH = 70;
	public static final int REGIST_PANEL_BUTTON_HEIGHT = 20;
	public static final int REGIST_PANEL_BUTTON_INTERVAL = 10;
	
	public static final int MAIN_FRAME_SIZE_WIDTH         = 1200;
	public static final int MAIN_FRAME_SIZE_HEIGHT        = 800;
	public static final int MAIN_FRAME_HEAD_PANEL_X       = 0;
	public static final int MAIN_FRAME_HEAD_PANEL_Y       = 0;
	public static final int MAIN_FRAME_HEAD_PANEL_WIDTH   = MAIN_FRAME_SIZE_WIDTH;
	public static final int MAIN_FRAME_HEAD_PANEL_HEIGHT  = 50;
	public static final int MAIN_FRAME_LEFT_PANEL_X       = 0;
	public static final int MAIN_FRAME_LEFT_PANEL_Y       = MAIN_FRAME_HEAD_PANEL_HEIGHT;
	public static final int MAIN_FRAME_LEFT_PANEL_WIDTH   = 200;
	public static final int MAIN_FRAME_LEFT_PANEL_HEIGHT  = 700;
	public static final int MAIN_FRAME_RIGHT_PANEL_X      = MAIN_FRAME_LEFT_PANEL_WIDTH;
	public static final int MAIN_FRAME_RIGHT_PANEL_Y      = MAIN_FRAME_HEAD_PANEL_HEIGHT;
	public static final int MAIN_FRAME_RIGHT_PANEL_WIDTH  = MAIN_FRAME_SIZE_WIDTH - MAIN_FRAME_LEFT_PANEL_WIDTH;
	public static final int MAIN_FRAME_RIGHT_PANEL_HEIGHT = MAIN_FRAME_LEFT_PANEL_HEIGHT;
	public static final int MAIN_FRAME_FOOT_PANEL_X       = 0;
	public static final int MAIN_FRAME_FOOT_PANEL_Y       = MAIN_FRAME_HEAD_PANEL_HEIGHT + MAIN_FRAME_LEFT_PANEL_HEIGHT;
	public static final int MAIN_FRAME_FOOT_PANEL_WIDTH   = MAIN_FRAME_SIZE_WIDTH;
	public static final int MAIN_FRAME_FOOT_PANEL_HEIGHT  = MAIN_FRAME_SIZE_HEIGHT - MAIN_FRAME_HEAD_PANEL_HEIGHT - MAIN_FRAME_LEFT_PANEL_HEIGHT;
	
	public static final int LEFT_PANEL_CONTENT_BEGIN_X    = 0;
	public static final int LEFT_PANEL_CONTENT_BEGIN_Y    = 0;
	public static final int LEFT_PANEL_CONTENT_WIDTH      = 0;
	public static final int LEFT_PANEL_CONTENT_HEIGHT     = 0;
	public static final int LEFT_PANEL_SUB_CONTENT_HEIGHT = 0;
	
	public static final int RIGHT_PANEL_NAV_BEGIN_X       = 20;
	public static final int RIGHT_PANEL_NAV_BEGIN_Y       = 10;
	public static final int RIGHT_PANEL_NAV_WIDTH         = 200;
	public static final int RIGHT_PANEL_NAV_HEIGHT        = 20;
	
	public static final int HEAD_PANEL_TIMER_BEGIN_X      = 900;
	public static final int HEAD_PANEL_TIMER_BEGIN_Y	     = 20;
	public static final int HEAD_PANEL_TIMER_WIDTH        = 280;
	public static final int HEAD_PANEL_TIMER_HEIGHT       = 20;
	
	public static final int HEAD_PANEL_USER_BEGIN_X       = 10;
	public static final int HEAD_PANEL_USER_BEGIN_Y       = 20;
	public static final int HEAD_PANEL_USER_WIDTH         = 200;
	public static final int HEAD_PANEL_USER_HEIGHT        = 20;
	
	public static final int HEAD_PANEL_LOGOUT_BEGIN_X	 = 220;
	public static final int HEAD_PANEL_LOGOUT_BEGIN_Y     = HEAD_PANEL_USER_BEGIN_Y;
	public static final int HEAD_PANEL_LOGOUT_WIDTH       = 30;
	public static final int HEAD_PANEL_LOGOUT_HEIGHT	     = HEAD_PANEL_USER_HEIGHT;
	
	public static final int FOOT_PANEL_COPY_BEGIN_X	     = 20;
	public static final int FOOT_PANEL_COPY_BEGIN_Y       = MAIN_FRAME_FOOT_PANEL_Y + 4;
	public static final int FOOT_PANEL_COPY_WIDTH         = 500;
	public static final int FOOT_PANEL_COPY_HEIGHT        = 15;
	
	public static final int USER_INFO_PANEL_BEGIN_X = 200;
	public static final int USER_INFO_PANEL_BEGIN_Y = 100;
	public static final int USER_INFO_PANEL_WIDTH   = 550;
	public static final int USER_INFO_PANEL_HEIGHT  = 580;
	public static final int USER_INFO_LABEL_EACH    = 25;
	
	/** 表格常量 **/
	public static final int TABLE_HEAD_HEIGHT = 30;
	public static final int TABLE_CELL_HEIGHT = 25;
	public static final int TABLE_SELECT_COL_WIDTH = 70;
	public static final int TABLE_WIDTH       = 815;
	public static final int SCROLLPAN_BEGIN_X = 20;
	public static final int SCROLLPAN_BEGIN_Y = 70;
	public static final int SCROLLPAN_WIDTH   = 950;
	public static final int SCROLLPAN_HEIGHT_MAX = 580;

	/** 表格按钮相关 **/
	public static final int TABLE_BUTTON_BEGIN_X = 700;
	public static final int TABLE_BUTTON_BEGIN_Y = 40;
	public static final int TABLE_BUTTON_WIDTH   = 60;
	public static final int TABLE_BUTTON_HEIGHT  = 20;
	public static final int TABLE_BUTTON_FLOAT   = 70;
	
	/** 页码相关常量 **/
	public static final int PAGE_TYPE_FIRST = 1;
	public static final int PAGE_TYPE_PRE   = 2;
	public static final int PAGE_TYPE_NEXT  = 3;
	public static final int PAGE_TYPE_LAST  = 4;
	public static final String PAGE_TYPE_FIRST_DESC = "首页";
	public static final String PAGE_TYPE_PRE_DESC   = "上一页";
	public static final String PAGE_TYPE_NEXT_DESC  = "下一页";
	public static final String PAGE_TYPE_LAST_DESC  = "尾页";
	public static final int PAGE_INFO_LABEL_BEGIN_X  = 20;
	public static final int PAGE_INFO_LABEL_WIDTH    = 200;
	public static final int PAGE_INFO_LABEL_HEIGHT   = 25;
	public static final int PAGE_PANEL_BEGIN_X      = 780;
	public static final int PAGE_PANEL_WIDTH        = 200;
	public static final int PAGE_PANEL_HEIGHT       = 30;
	public static final int PAGE_LABEL_PANEL_BEGIN_X = 400;
	public static final int PAGE_LABEL_PANEL_WIDTH   = 200;
	public static final int PAGE_LABEL_PANEL_HEIGHT  = 30;
	
	/** 子页面相关 **/
	public static final int SUB_VIEW_TYPE_ADD    = 1;
	public static final int SUB_VIEW_TYPE_EDIT   = 2;
	public static final int SUB_VIEW_TYPE_DETAIL = 3;
	public static final String SUB_VIEW_TYPE_ADD_DESC    = "新增";
	public static final String SUB_VIEW_TYPE_EDIT_DESC   = "编辑";
	public static final String SUB_VIEW_TYPE_DETAIL_DESC = "查看";
	public static final int SUB_PANEL_BEGIN_X = 200;
	public static final int SUB_PANEL_BEGIN_Y = 70;
	public static final int SUB_PANEL_WIDTH   = 550;
	public static final int SUB_PANEL_HEIGHT_MAX = 580;
	public static final int SUB_LABEL_BEGIN_X = 380;
	public static final int SUB_LABEL_BEGIN_Y = 90;
	public static final int SUB_LABEL_WIDTH   = 130;
	public static final int SUB_LABEL_HEIGHT  = 20;
	public static final int SUB_LABEL_FLOAT   = 30;
	public static final int SUB_LABEL_EACH    = 25;
	public static final int SUB_INPUT_BEGIN_X = SUB_LABEL_BEGIN_X + SUB_LABEL_WIDTH + 10;
	public static final int SUB_INPUT_BEGIN_Y = SUB_LABEL_BEGIN_Y;
	public static final int SUB_INPUT_WIDTH   = SUB_LABEL_WIDTH;
	public static final int SUB_INPUT_HEIGHT  = SUB_LABEL_HEIGHT;
	public static final int SUB_INPUT_FLOAT   = SUB_LABEL_FLOAT;
	public static final int SUB_NEED_LAB_BEGIN_X = SUB_INPUT_BEGIN_X + SUB_INPUT_WIDTH;
	public static final int SUB_NEED_LAB_WIDTH   = 20;
	public static final int SUB_NEED_LAB_HEIGHT  = SUB_INPUT_HEIGHT;
	public static final int SUB_BUTTON_BACK_BEGIN_X = SUB_PANEL_BEGIN_X + 160;
	public static final int SUB_BUTTON_WIDTH        = 60;
	public static final int SUB_BUTTON_HEIGHT       = 20;
	
}
