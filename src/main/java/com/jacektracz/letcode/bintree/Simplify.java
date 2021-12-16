package com.jacektracz.letcode.bintree;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Simplify {

    private RepositoryB repositoryB = new RepositoryB();

    public Simplify() {
    }

    public void update(LocalDate prodDate) {
        Optional<List<B>> bs = getB(prodDate);

        if (bs.isPresent()) {
            processUpdate(bs.get(), prodDate);
        } else {
            System.out.println("Not found for production date: " + prodDate);
        }
    }

    private void processUpdate(List<B> bList, LocalDate prodDate) {
        Optional<Number> versionFromRepository = Optional.ofNullable(repositoryB.getCurrentVersionForProdDate(prodDate));

        if(!versionFromRepository.isPresent()) {
        	return;
        }
        
        if (rerunIsAllowed(prodDate) && versionFromRepository.isPresent()) {
            BiFunction<B,Number,B> provider = (b,v) ->  doSomething(b,v);
            
            List<B> toUpdate = bList.stream().
            		map(b -> doSomething(b,versionFromRepository.get()))
            		.collect(Collectors.toList());

            System.out.println("Updating " + toUpdate.size() + " records in table.");
            System.out.println("DEBUG: " + toUpdate.toString());
            repositoryB.saveAll(toUpdate);
            repositoryB.flush();
        } else {
            System.out.println("No data available for production date: " + prodDate + " - No updates required.");
        }
    }

    private B doSomething(B b, Number versionFromRepository) {
    	B outData = null;
    	int version = versionFromRepository.intValue();
        if (b.getVersion() == versionFromRepository.intValue()) {
            int i = 2;
            boolean isPrime = true;
            for (; i < b.getPayload(); i++) {
                if (b.payload % i == 0) {
                    isPrime = false;
                }
            }
            if (isPrime && b.getPayload() != 1) {
                outData = new B(version + 1, b.payload);
            }
        }
        return outData;
    }
    
    private Optional<List<B>> getB(LocalDate prodDate) {
        System.out.println("Load B. ProdDate: " + prodDate);
        return repositoryB.getB(prodDate);
    }

    private boolean rerunIsAllowed(LocalDate prodDate) {
        if (repositoryB.hasRecordsAfterProdDate(prodDate) <= 0) {
            System.out.println("Cannot process");
            return false;
        } else {
            return true;
        }
    }

    public class B {
        private int version;
        private int payload;

        private B(int version, int payload) {
            this.version = version;
            this.payload = payload;
        }

        public int getVersion() {
            return version;
        }

        public void setVersion(int version) {
            this.version = version;
        }

        public int getPayload() {
            return payload;
        }

        public void setPayload(int payload) {
            this.payload = payload;
        }
    }

    class RepositoryB {

        Map<LocalDate, List<B>> database = new HashMap<>(3);
        {
            List<B> list = new ArrayList<>();
            list.add(new B(2, 1));
            list.add(new B(2, 2));
            list.add(new B(2, 3));
            list.add(new B(1, 4));
            list.add(new B(2, 5));
            list.add(new B(2, 6));
            list.add(new B(2, 7));
            database.put(LocalDate.of(2021, 10, 20), list);
        }

        public Integer getCurrentVersionForProdDate(LocalDate prodDate) {
//return newest version for date
            return 2;
        }

        public Optional<List<B>> getB(LocalDate prodDate) {
            return Optional.of(database.get(prodDate));
        }

        public int hasRecordsAfterProdDate(LocalDate prodDate) {
            return database.get(prodDate).size();
        }

        public void saveAll(List<B> toUpdate) {
//nop
            System.out.println("Saving " + toUpdate.size() + " to table.");
        }

        public void flush() {
//nop
        }
    }

    public static void main(String[] args) {
        new Simplify().update(LocalDate.of(2021, 10, 20));
    }
}