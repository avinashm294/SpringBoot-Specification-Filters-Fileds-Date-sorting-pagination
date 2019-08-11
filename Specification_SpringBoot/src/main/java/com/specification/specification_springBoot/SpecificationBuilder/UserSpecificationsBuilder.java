package com.specification.specification_springBoot.SpecificationBuilder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.annotations.SortNatural;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.specification.specification_springBoot.Model.Car;
import com.specification.specification_springBoot.Specification.CarFilterSpecification;
import com.specification.specification_springBoot.Utils.SearchCriteria;

@Component
public class UserSpecificationsBuilder {

    private final List<SearchCriteria> params;
    private final List<SearchCriteria> params2;

    public UserSpecificationsBuilder() {
        params = new ArrayList<SearchCriteria>();
        params2 = new ArrayList<SearchCriteria>();
    }

    public UserSpecificationsBuilder with(String key, String operation, Object value) {
        params.add(new SearchCriteria(key, operation, value));
        return this;
    }

    public Specification<Car> build() {
        if (params.size() == 0) {
            return null;
        }

        int x = params.size();
        int y = params.size();

        for (int i = 0; i < x; i++) {

            String keyString = params.get(0).getKey();
            params2.add(params.get(0));
            params.remove(0);
            x = x - 1;

            for (int j = 0; j < x; j++) {
                if (params.get(j).getKey().equalsIgnoreCase(keyString)) {
                    params2.add(params.get(j));
                    params.remove(j);
                    x = x - 1;
                }

            }
            i = i - 1;

        }

        List<Specification> specs = params2.stream()
            .map(CarFilterSpecification::new)
            .collect(Collectors.toList());

        System.err.println("------------" + params2);

        Specification result = specs.get(0);

        for (int i = 1; i < params2.size(); i++) {

            if (params2.get(i - 1).getKey().equalsIgnoreCase(params2.get(i).getKey())) {
                result = Specification.where(result)
                    .or(specs.get(i));

            } else {
               result = Specification.where(result)
                    .and(specs.get(i));
            }

        }
        return result;
    }
}
