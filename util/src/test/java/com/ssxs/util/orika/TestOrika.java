package com.ssxs.util.orika;

import com.ssxs.util.common.OrikaUtil;
import com.ssxs.util.domain.UserModel;
import com.ssxs.util.domain.UserModelDto;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2017/11/27 9:47
 * modifyTime:
 * modifyBy:
 */
@Slf4j
public class TestOrika {

    @Test
    public void testOrikaCopy() {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(UserModel.class, UserModelDto.class)
                .field("account", "account")
                .field("nickName", "nickName")
                .byDefault()
                .register();

        UserModel userModel = new UserModel();
        userModel.setAccount("phil");
        userModel.setNickName("菲尔");
        userModel.setCreatedTime(LocalDateTime.now());

        MapperFacade mapper = mapperFactory.getMapperFacade();

        UserModelDto userModelDto = mapper.map(userModel, UserModelDto.class);
        log.info("userModelDto:{}", userModelDto);
    }

    @Test
    public void testOrikaCopy2() {
        UserModel userModel = new UserModel();
        userModel.setAccount("phil");
        userModel.setNickName("菲尔");
        userModel.setCreatedTime(LocalDateTime.now());
        log.info("map1:{}", map1(userModel));
    }

    /**
     * 相同属性的复制
     *
     * @param userModel
     * @return
     */
    public static UserModelDto map1(UserModel userModel) {
        //since filed name is same, so no need to register
        MapperFactory factory = new DefaultMapperFactory.Builder().build();
        UserModelDto userModelDto = new UserModelDto();
        //userModelDto = factory.getMapperFacade(UserModel.class, UserModelDto.class).map(userModel);
        factory.getMapperFacade().map(userModel, userModelDto);
        return userModelDto;
    }

    @Test
    public void testOrikaCopy3() {
        UserModel userModel = new UserModel();
        userModel.setAccount("phil");
        userModel.setNickName("菲尔");
        userModel.setCreatedTime(LocalDateTime.now());
        UserModelDto userModelDto = OrikaUtil.copyAtoB(userModel, UserModelDto.class);
        log.info("map3:{}", userModelDto);
    }

    @Test
    public void testOrikaCopy4() {
        List<UserModel> userModelList = new ArrayList<>();
        UserModel userModel = new UserModel();
        userModel.setAccount("phil");
        userModel.setNickName("菲尔");
        userModel.setCreatedTime(LocalDateTime.now());
        userModelList.add(userModel);

        UserModel userModel2 = new UserModel();
        userModel2.setAccount("phil2");
        userModel2.setNickName("菲尔2");
        userModel2.setCreatedTime(LocalDateTime.now());
        userModelList.add(userModel2);

        List<UserModelDto> userModelDtoList = OrikaUtil.copyAlistToBlist(userModelList, UserModelDto.class);
        log.info("map4:{}", userModelDtoList);
    }

    @Test
    public void testOrikaCopy5() {
        List<UserModel> userModelList = new ArrayList<>();
        UserModel userModel = new UserModel();
        userModel.setAccount("phil");
        userModel.setNickName("菲尔");
        userModel.setCreatedTime(LocalDateTime.now());
        userModelList.add(userModel);

        UserModel userModel2 = new UserModel();
        userModel2.setAccount("phil2");
        userModel2.setNickName("菲尔2");
        userModel2.setCreatedTime(LocalDateTime.now());
        userModelList.add(userModel2);

        UserModel userModel3 = new UserModel();
        userModel3.setAccount("phil3");
        userModel3.setNickName("菲尔3");
        userModel3.setCreatedTime(LocalDateTime.now());
        userModelList.add(userModel3);

        List<UserModelDto> userModelDtoList = OrikaUtil.copyAlistToBlist(userModelList, UserModelDto.class);
        log.info("map5:{}", userModelDtoList);
    }

}
