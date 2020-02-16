package cn.web1992.mybatiss.utils;

import org.apache.commons.codec.digest.DigestUtils;

import java.nio.charset.StandardCharsets;

/**
 * @author web1992
 * @date 2020/2/16  15:17
 * hash 工具
 */
public final class SHA1Utils {

    private SHA1Utils() {
    }

    public static String hash(String srt) {
        String sha1 = srt;
        sha1 = DigestUtils.sha1Hex(srt.getBytes(StandardCharsets.UTF_8));
        return sha1;

    }


}
