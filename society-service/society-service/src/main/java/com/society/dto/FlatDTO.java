package com.society.dto;

import lombok.Data;
import com.society.model.FlatStatus;
import com.society.model.FlatType;

@Data
public class FlatDTO {
    private String id;
    private String number;
    private String block;
    private String societyId;
    private FlatStatus status;
    private FlatType type;
    private String currentResidentId;
}
