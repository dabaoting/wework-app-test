package com.hogwarts;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.hogwarts.po.ContactPage;
import com.hogwarts.po.HomePage;
import com.hogwarts.po.contact.Member;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.util.List;
import java.util.stream.Stream;


/**
 * 通讯录测试
 */
public class ContactTest extends HomePage {

    private static HomePage homePage ;

    private static ContactPage contactPage;

    private static String MEMBERS_YAML = "src/test/resources/members.yaml";

    @BeforeAll
    static void init(){

        //进入企业微信app主页面
        homePage = new HomePage();

        //进入通讯录页面
        contactPage = homePage.clickContact();

    }

    @ParameterizedTest
    @MethodSource("membersData")
    void addMember(List<Member> members){

        //新增成员
        contactPage.addMember(members);

        //验证
//        contactPage.search(members);


    }

    /**
     * 成员信息参数
     * @return
     * @throws Exception
     */
    static Stream<List<Member>> membersData() throws Exception {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        TypeReference typeReference = new TypeReference<List<Member>>() {};
        List<Member> members = (List<Member>)mapper.readValue(new File(MEMBERS_YAML), typeReference);
        return Stream.of(members);
    }

}
