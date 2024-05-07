package com.factory.warehouse.service;

import com.factory.warehouse.dto.DealRequest;
import com.factory.warehouse.dto.DealResponse;
import com.factory.warehouse.model.Deal;
import com.factory.warehouse.repository.DealRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.List;

import static org.hibernate.query.sqm.tree.SqmNode.log;

@Service
@RequiredArgsConstructor
public class DealService {

    private DealRepository dealRepository;


    public DealResponse getDealByUinqueId (Long uniqueId) {
        log.info("Fetching deal by id: {}");
        Deal deal = dealRepository.findByUniqueId(uniqueId);
        return mapToDealResponse(deal);
    }

    public List<DealResponse> getAllDeals(){
      List<Deal> deals = dealRepository.findAll();
      return deals.stream().map(this::mapToDealResponse).toList();
    }

    @Transactional(noRollbackFor = Exception.class)
    public void createDeal(@Valid DealRequest dealRequest) throws Exception{
        if (!dealRequest.isValid()) {
            throw new IllegalArgumentException("Deal is not valid");
        }
        try {
            Deal deal = Deal.builder()
                    .fromCurrencyISOCode(dealRequest.getFromCurrencyISOCode())
                    .toCurrencyISOCode(dealRequest.getToCurrencyISOCode())
                    .timestamp(dealRequest.getTimestamp())
                    .amount(dealRequest.getAmount())
                    .build();
            dealRepository.save(deal);
            log.info("Creating new deal");

        } catch (Exception e) {
            throw new Exception("Error saving deal", e);
        }
    }

   @Transactional(noRollbackFor = Exception.class)
    public DealResponse updateDeal(Long uniqueId, DealRequest dealRequest) throws  Exception{

        if (!dealRequest.isValid()) {
            throw new IllegalArgumentException("Deal is not valid");
        }
        try {
            log.info("Updating deal with id: {}");
            Deal existingDeal = dealRepository.findByUniqueId(uniqueId);

            existingDeal.setFromCurrencyISOCode(dealRequest.getFromCurrencyISOCode());
            existingDeal.setToCurrencyISOCode(dealRequest.getToCurrencyISOCode());
            existingDeal.setTimestamp(dealRequest.getTimestamp());
            existingDeal.setAmount(dealRequest.getAmount());

            return mapToDealResponse(dealRepository.save(existingDeal));
        }catch (Exception e) {
           throw new Exception("Error updating deal", e);
        }
    }

    public void deleteDeal(Long uniqueId) {
        log.info("Deleting deal with id: {}");
        dealRepository.deleteById(uniqueId);
    }

    private DealResponse mapToDealResponse(Deal deal) {

        return DealResponse.builder()
                .uniqueId(deal.getUniqueId())
                .fromCurrencyISOCode(deal.getFromCurrencyISOCode())
                .toCurrencyISOCode(deal.getToCurrencyISOCode())
                .timestamp(deal.getTimestamp())
                .amount(deal.getAmount())
                .build();
    }


}