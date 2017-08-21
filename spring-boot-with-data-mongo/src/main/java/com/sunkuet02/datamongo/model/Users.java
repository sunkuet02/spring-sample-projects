package com.sunkuet02.datamongo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Created by sun on 8/16/17.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
public class Users implements Serializable {
    @Id
    private Long id;

    private String username;

}
