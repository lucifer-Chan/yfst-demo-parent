package com.yfst.demo.feature;

import com.yfst.base.framework.util.PojoUtil;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * pojoUtil
 *
 * @author: Lucifer.Chan
 * @date: 2025/8/21 11:07
 */
public class PojoUtilTest {

    public static void main(String[] args) {

        testCreateEntity();
        Dto param = fromClient();
        Entity entity = new Entity();
        BeanUtils.copyProperties(param, entity);
//        System.out.println(entity);
    }


    private static void testCreateEntity() {
        Dto param = fromClient();
        System.out.println("param:" + param);

        Entity entity = PojoUtil.newInstance(param, Entity.class);
        System.out.println("entity:" + entity);
    }


    /**
     * 前端传入
     * @return
     */
    private static Dto fromClient(){
        Dto dto = new Dto();
        dto.setDate(new Date());
        dto.setName("test");
        dto.setComments(new ArrayList<>(Arrays.asList("hello", "world")));
        return dto;
    }

    /**
     * 前端dto
     */
    @Data
    private static class Dto {

        private String name;

        private Date date;

        private List<String> comments;
    }

    @Data
    private static class Entity {

        private Long id;

        private String name;

        private Date date;
    }




}
