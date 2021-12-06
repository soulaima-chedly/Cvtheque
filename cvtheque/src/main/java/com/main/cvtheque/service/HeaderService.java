package com.main.cvtheque.service;

import com.main.cvtheque.model.Header;

public interface HeaderService {

    Header createHeader(Long cvId, Header header);
}
