package com.hami.bookseller.service;

import com.hami.bookseller.model.PurchaseHistory;
import com.hami.bookseller.repository.projection.IPurchaseItem;

import java.util.List;

public interface IPurchaseHistoryService {
    PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory);

    List<IPurchaseItem> findPurchaseItemsOfUser(Long userId);
}
