package com.sunkuet02.datamongojpa.dao;

import com.sunkuet02.datamongojpa.model.IdSequence;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

/**
 * Created by sun on 8/17/17.
 */

@Repository
public class AutoGenSequenceDaoImpls implements AutoGenSequenceDao {

    private final static Logger logger = Logger.getLogger(AutoGenSequenceDaoImpls.class);
    @Autowired
    private MongoOperations operations;

    @Override
    public long getNextSequenceId(String sequenceName) {
        Query query = new Query(Criteria.where("_id").is(sequenceName));
        Update update = new Update().inc("sequence", 1);

        FindAndModifyOptions options = new FindAndModifyOptions().returnNew(true).upsert(true);

        IdSequence idSequence = operations.findAndModify(query, update, options, IdSequence.class);

        logger.info("Generated Id is : " + idSequence.getSequence());
        return idSequence.getSequence();
    }
}
