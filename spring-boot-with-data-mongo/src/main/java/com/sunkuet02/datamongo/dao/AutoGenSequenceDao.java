package com.sunkuet02.datamongo.dao;

/**
 * Created by sun on 8/17/17.
 */
public interface AutoGenSequenceDao {
    long getNextSequenceId(String sequenceName);
}
