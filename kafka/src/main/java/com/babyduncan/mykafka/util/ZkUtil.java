package com.babyduncan.mykafka.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 *
 * @author: guohaozhao
 * @since: 13-4-17 14:20
 */
public final class ZkUtil {

    private static final Logger logger = Logger.getLogger(ZkUtil.class);

    private static final String zkIp = "localhost:2181%s";

    //��������zk��ַ
    private static final String defaultRootPath = "/talent/kafka";
    //���Ի���zk��ַ
    private static final String defaultTestingRootPath = "/testing/kafka";
    //���ϻ���zk��ַ
    private static final String defaultOnlineRootPath = "/kafka";

    /**
     * ����zookeeper����·��������kafka��zk.connect
     *
     * @param path
     * @return
     */
    private static String genZkConnectStr(String path) {
        if (StringUtils.isBlank(path)) {
            return String.format(zkIp, defaultOnlineRootPath);
        } else {
            return String.format(zkIp, path);
        }
    }

    public static String getRootPath() {
        SystemConfig sc = SystemConfig.getInstance();
//        String rootPath = sc.getString("zookeeper.rootpath", null);
//        if (rootPath != null) {
//            return genZkConnectStr(rootPath);
//        }
        if (sc.getBoolean("config.product", false)) {
            return genZkConnectStr(defaultOnlineRootPath);
        }
        if (sc.getBoolean("config.testing", false)) {
            return genZkConnectStr(defaultTestingRootPath);
        }
        return genZkConnectStr(defaultRootPath);
    }

}
