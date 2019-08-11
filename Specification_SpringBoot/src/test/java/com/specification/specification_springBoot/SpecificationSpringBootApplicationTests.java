/*package com.specification.specification_springBoot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import com.specification.specification_springBoot.Model.Car;

import com.specification.specification_springBoot.Repository.CarRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpecificationSpringBootApplicationTests {

	@Autowired
	private CarRepository repository;

	@Test
	public void whenFindByPublicationDate_thenArticles1And2Returned() throws ParseException {
		List<Car> result = repository.findAllByPublicationDate(new SimpleDateFormat("yyyy-MM-dd").parse("2012-02-11"));
		System.err.println("Result====" + result);
		// assertEquals(2, result.size());
//        assertTrue(result.stream()
//          .map(Car::getId)
//          .allMatch(id -> Arrays.asList(1, 2).contains(id)));
	}

//	@Test
//	public void whenFindByPublicationTimeBetween_thenArticles2And3Returned() throws ParseException {
//		List<Car> result = repository.findAllByPublicationTimeBetween(new SimpleDateFormat("HH:mm").parse("12:00"),
//				new SimpleDateFormat("HH:mm").parse("16:30"));
//
//		assertEquals(2, result.size());
//		assertTrue(result.stream().map(Car::getId).allMatch(id -> Arrays.asList(2, 3).contains(id)));
//	}
//
//	@Test
//	public void givenArticlesWhenFindWithCreationDateThenArticles2And3Returned() throws ParseException {
//		List<Car> result = repository
//				.findAllWithCreationDateTimeBefore(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2017-12-15 10:00"));
//
//		assertEquals(1, result.size());
//		assertTrue(result.stream().map(Car::getId).allMatch(id -> Arrays.asList(2, 3).contains(id)));
//	}

}
*/