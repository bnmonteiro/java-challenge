package com.java.challenge.service;

import com.java.challenge.model.Package;
import com.java.challenge.model.PrizeDraw;
import com.java.challenge.model.PrizeDrawRequest;
import com.java.challenge.model.PrizeDrawResponse;
import com.java.challenge.repository.PackageRepository;
import com.java.challenge.repository.PrizeDrawRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
public class PrizeDrawService {

    private final PrizeDrawRepository repository;

    private final PackageRepository packageRepository;

    @Autowired
    public PrizeDrawService(PrizeDrawRepository repository, PackageRepository packageRepository) {
        this.repository = repository;
        this.packageRepository = packageRepository;
    }

    public PrizeDrawResponse doPrizeDraw(PrizeDrawRequest request) throws Exception {

        String orderedPackage = request.getOrderedPackage();
        Optional<Package> packOp = packageRepository.findByName(orderedPackage);
        if (!packOp.isPresent()){
            throw new IllegalArgumentException("Invalid argument: orderedPackage");
        }

        boolean eligibleToWin;
        boolean wonFreePrints;

        Optional<PrizeDraw> prizeOp = repository.findByPackName(orderedPackage);

        eligibleToWin = isEligibleToWin(prizeOp);

        if(eligibleToWin){

            wonFreePrints = isWinner();

            if(prizeOp.isPresent()){

                prizeOp.get().setLastPrize(LocalDateTime.now());
                repository.save(prizeOp.get());

            } else {

                repository.save(PrizeDraw.builder()
                        .pack(packOp.get())
                        .lastPrize(LocalDateTime.now())
                        .build());

            }

        } else {
            wonFreePrints = false;
        }

        return PrizeDrawResponse.builder()
                .orderedPackage(orderedPackage)
                .eligibleToWin(eligibleToWin)
                .wonFreePrints(wonFreePrints)
                .build();

    }

    private boolean isWinner() {

        return new Random().nextBoolean();

    }

    private boolean isEligibleToWin(Optional<PrizeDraw> prizeOp) {

        if (!prizeOp.isPresent()) {

            return true;

        } else {

            LocalDateTime now = LocalDateTime.now();
            LocalDateTime lastPrize = prizeOp.get().getLastPrize();

            Duration duration = Duration.between(lastPrize, now);
            boolean hasMoreThan60MinutesDifference = duration.toMinutes() > 60;
            if(hasMoreThan60MinutesDifference){
                return true;
            } else {
                return false;
            }

        }

    }

}
