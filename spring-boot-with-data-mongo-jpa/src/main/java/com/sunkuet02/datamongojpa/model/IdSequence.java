package com.sunkuet02.datamongojpa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by sun on 8/17/17.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "customIdSequence")
public class IdSequence {
    @Id
    private String id;

    private long sequence;

}
