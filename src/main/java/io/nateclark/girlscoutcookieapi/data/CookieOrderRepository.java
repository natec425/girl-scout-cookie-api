package io.nateclark.girlscoutcookieapi.data;

import io.nateclark.girlscoutcookieapi.domain.CookieOrder;

public interface CookieOrderRepository {
    Iterable<CookieOrder> findAll();

    CookieOrder findById(Integer id);

    CookieOrder save(CookieOrder cookieOrder);

    void delete(Integer id);
}