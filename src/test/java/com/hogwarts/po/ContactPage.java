package com.hogwarts.po;

import com.hogwarts.po.contact.Member;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.util.List;

public class ContactPage extends BasePage{

    private static String CONTACT_MANA_ID = "com.tencent.wework:id/i6i";

    private static String MEMBER_ADD_ID = "com.tencent.wework:id/e30";

    private static String ADD_MEMBER_MANUAL = "com.tencent.wework:id/cox";

    private static String NAME_XPATH = "//*[@resource-id='com.tencent.wework:id/b4t'][@text='必填']";

    private static String PTHONE_ID = "com.tencent.wework:id/fow";

    private static String DEPARTMENT_XPATH = "//*[@resource-id='com.tencent.wework:id/b5m'][@text='设置部门']";

    private static String DEPARTMENT_HX_XPATH = "//*@text='火星测试部']";

    private static String DEPARTMENT_101_XPATH = "//*[@text='硬糖101']";

    private static String DEPARTMENT_CONFIRM_ID = "com.tencent.wework:id/gsh";

    private static String MEMBER_SAVE_ID = "com.tencent.wework:id/i6k";

    public ContactPage() {
    }

    public ContactPage(AndroidDriver driver) {
        super(driver);
    }


    /**
     * 支持批量添加成员
     * @param members
     */
    public void addMember(List<Member> members){

        //点击管理通讯录
        click(By.id(CONTACT_MANA_ID));

        //点击添加成员
        click(By.id(MEMBER_ADD_ID));

        for (Member member:members) {

            //点击手动输入添加
            click(By.id(ADD_MEMBER_MANUAL));
            //填入信息
            sendKeys(By.xpath(NAME_XPATH),member.getName());//输入姓名
            sendKeys(By.id(PTHONE_ID),member.getPhone());//手机号
            click(By.xpath(DEPARTMENT_XPATH));//点击设置部门
            click(By.xpath(DEPARTMENT_HX_XPATH));//选择一级部门
            click(By.xpath(DEPARTMENT_101_XPATH));//选择二级部门
            click(By.id(DEPARTMENT_CONFIRM_ID));//确定所选部门

            //保存成员信息
            click(By.id(MEMBER_SAVE_ID));
        }
    }




    public void search(List<Member> members) {

    }
}
