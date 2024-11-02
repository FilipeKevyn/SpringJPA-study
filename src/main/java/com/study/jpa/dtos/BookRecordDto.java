package com.study.jpa.dtos;

import java.util.Set;
import java.util.UUID;

public record BookRecordDto(String title, UUID publisherid, Set<UUID> authorsIds, String reviewComent) {
}
