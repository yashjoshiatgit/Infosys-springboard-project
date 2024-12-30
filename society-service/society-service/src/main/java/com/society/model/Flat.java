package com.society.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.CompoundIndex;

@Data
@Document(collection = "flats")
@CompoundIndex(name = "society_block_number",
        def = "{'societyId': 1, 'block': 1, 'number': 1}", unique = true)
public class Flat {
    @Id
    private String id;

    private String number;
    private String block;
    private String societyId;
    private FlatStatus status = FlatStatus.VACANT;
    private FlatType type;
    private String currentResidentId;
}

