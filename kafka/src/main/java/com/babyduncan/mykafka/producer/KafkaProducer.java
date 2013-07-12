package com.babyduncan.mykafka.producer;

import java.util.List;

/**
 * @author: guohaozhao babyduncan@qq.com
 * @since: 13-4-15 16:01
 */
public interface KafkaProducer<K, V> {
    /**
     * ����Ϣϵͳ��send���� һ��������������������һ�������ݡ�
     *
     * @param topic
     * @param data
     */
    public void send(String topic, V data);

    /**
     * ����Ϣϵͳ��send���� һ�������������������Ͷ��������ݡ�
     *
     * @param topic
     * @param datas
     */
    public void send(String topic, List<V> datas);

    /**
     * ����Ϣϵͳ��send���� һ�������ָ����һ�����������Ͷ��������ݡ�
     *
     * @param topic
     * @param key
     * @param datas
     */
    public void send(String topic, K key, List<V> datas);

}
