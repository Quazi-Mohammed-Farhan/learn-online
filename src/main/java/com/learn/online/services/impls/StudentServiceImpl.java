package com.learn.online.services.impls;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.online.beans.CourseEntity;
import com.learn.online.beans.CourseOrderEntity;
import com.learn.online.beans.StudentEntity;
import com.learn.online.daos.CourseEntityDao;
import com.learn.online.daos.StudentEntityDao;
import com.learn.online.dtos.StudentDto;
import com.learn.online.enums.ErrorMessagesEnum;
import com.learn.online.exceptions.StudentServiceException;
import com.learn.online.services.StudentService;
import com.learn.online.utils.CustomUtils;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentEntityDao studentEntityDao;
	
	@Autowired
	private CourseEntityDao courseEntityDao;
	
	@Override
	public StudentDto findByEmail(String email) {
		return CustomUtils.convertToStudentDto(studentEntityDao.findByEmail(email)
				.orElseThrow(()-> new StudentServiceException(ErrorMessagesEnum.REQUESTED_STUDENT_NOT_FOUND.getMessage())));
	}

	@Override
	public StudentDto signupStudent(StudentDto studentDto) {
		return CustomUtils.convertToStudentDto(studentEntityDao.save(CustomUtils.convertToStudentEntity(studentDto)));
	}

	@Override
	public StudentDto updateStudent(StudentDto studentDto) {
		return CustomUtils.convertToStudentDto(studentEntityDao.updateStudent(
				CustomUtils.convertToStudentEntity(studentDto)).orElseThrow(
				()-> new StudentServiceException(
					ErrorMessagesEnum.REQUESTED_STUDENT_NOT_FOUND.getMessage())));
	}


	@Override 
	public StudentDto purchaseCourses(String email, List<String> courseKeys) {
		
		 StudentEntity studentEntity = studentEntityDao.findByEmail(email).orElseThrow(()-> 
		 	new StudentServiceException(ErrorMessagesEnum.REQUESTED_STUDENT_NOT_FOUND.getMessage()));
		 
		 List<CourseEntity> courseEntityList = courseEntityDao.findCoursesByKey(courseKeys)
				.orElseThrow(()-> new StudentServiceException(ErrorMessagesEnum.REQUESTED_COURSES_NOT_FOUND_FOR_PURCHASE.getMessage()));
		 
		 studentEntity.addCourseOrders(CustomUtils.courseEnityListToCourseOrderEntityList(courseEntityList));
		return CustomUtils.convertToStudentDto(studentEntityDao.save(studentEntity));
	}

	@Override
	public StudentDto cancellPurchasedCourses(String email, List<String> courseKeys) {
		
		 StudentEntity studentEntity = studentEntityDao.findByEmail(email).orElseThrow(()-> 
		 	new StudentServiceException(ErrorMessagesEnum.REQUESTED_STUDENT_NOT_FOUND.getMessage()));
		
		LocalDate currentDate = LocalDate.now();
		
		List<CourseOrderEntity> courseToBeDeletedList = new ArrayList<>();
		List<String> coursesExceeds30DaysList = new ArrayList<String>();
		List<String> coursesNotExistList = new ArrayList<String>();
		
		
		List<CourseOrderEntity> courseOrdEntityList = studentEntity.getCourseOrders();
		
		if(courseOrdEntityList.isEmpty()) {
			throw new StudentServiceException(ErrorMessagesEnum.EMPTY_COURSES_LIST.getMessage());
		} 
		
		courseKeys.forEach(key->{
			
			boolean found = false;
			CourseOrderEntity courseOrdEntity = null;
			
			for(CourseOrderEntity tempCourseOrdEntity : courseOrdEntityList) {
				
				if(tempCourseOrdEntity.getCourseOrderKey().equals(key)) {
					courseOrdEntity = tempCourseOrdEntity;
					found = true;
					break;
				}
			}
				
			if(found) {
				if(ChronoUnit.DAYS.between(courseOrdEntity.getCreationDate(), currentDate) <= 30) {
					courseToBeDeletedList.add(courseOrdEntity);
				} else {
					coursesExceeds30DaysList.add(courseOrdEntity.getCourse().getCourseName());
				}
			} else {
				coursesNotExistList.add(key);
			}
			
		});
		
		
		if(!coursesNotExistList.isEmpty()) {
			throw new StudentServiceException(ErrorMessagesEnum.REQUESTED_COURSES_NOT_FOUND_FOR_DELETE.getMessage());
		} else if(!coursesExceeds30DaysList.isEmpty()) {
			throw new StudentServiceException(ErrorMessagesEnum.COURSES_EXCEED_30DAYS_CAN_NOT_BE_DELETED.getMessage());
		} else {
			studentEntity.removeCourseOrders(courseToBeDeletedList);
			
			studentEntityDao.saveAndFlush(studentEntity);
		}
		
		return CustomUtils.convertToStudentDto(studentEntity);
		
	}	
}
