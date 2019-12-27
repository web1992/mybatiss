package cn.web1992.mybatiss;

import org.mybatis.spring.annotation.MapperScan;

/**
 * @author web1992
 * @date 2019/12/27  14:17
 */
public class MainTest {
    public static void main(String[] args) {
        // 包名 + 类名
        // output is: org.mybatis.spring.annotation.MapperScan
        System.out.println(MapperScan.class.getName());
    }
}
