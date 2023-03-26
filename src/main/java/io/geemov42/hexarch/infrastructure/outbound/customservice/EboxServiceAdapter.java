package io.geemov42.hexarch.infrastructure.outbound.customservice;

import io.geemov42.hexarch.domain.business.todo.outbound.EboxService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EboxServiceAdapter implements EboxService {

    @Override
    public int countNumberOfAvailableMessage(String ssin) {
        return 10_000;
    }
}
