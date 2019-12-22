package com.capgemini.hotelmanagementsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.hotelmanagementsystem.beans.AdminEmployeeUserBean;
import com.capgemini.hotelmanagementsystem.beans.EmployeeInformationBean;
import com.capgemini.hotelmanagementsystem.beans.HotelInformationBean;
import com.capgemini.hotelmanagementsystem.beans.RoomInformationBean;
import com.capgemini.hotelmanagementsystem.exception.HotelManagementSystemException;

@Repository
public class AdminOperationsDaoImpl implements AdminOperationsDao {

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	@Override
	public HotelInformationBean addHotel(HotelInformationBean hotelBean) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			if (licenseNumberPresent(hotelBean.getLicenseNumber()) == false) {
				transaction.begin();
				entityManager.persist(hotelBean);
				transaction.commit();
			} else {
				System.out.println("Hotel already exists");
			}
		} catch (Exception e) {
			// throw new HotelManagementSystemException("Hotel already exists");
		}
		return hotelBean;
	}

	@Override
	public List<HotelInformationBean> getHotelList() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from HotelInformationBean";
		Query query = entityManager.createQuery(jpql);
		List<HotelInformationBean> hotelList = null;
		try {
			hotelList = query.getResultList();
		} catch (Exception e) {
			throw new HotelManagementSystemException("Hotel list not found");
		}
		return hotelList;
	}

	@Override
	public boolean updateHotelInformation(HotelInformationBean hotelBean) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		HotelInformationBean existingHotelInformation = entityManager.find(HotelInformationBean.class,
				hotelBean.getHotelId());
		boolean isUpdated = false;
		if (existingHotelInformation != null) {
			String name = hotelBean.getHotelName();
			if (name != null) {
				existingHotelInformation.setHotelName(name);
			}
			String licenseNumber = hotelBean.getLicenseNumber();
			if (licenseNumberPresent(licenseNumber) == false) {
				if (licenseNumber != null) {
					existingHotelInformation.setLicenseNumber(licenseNumber);
				}
			}
			String address = hotelBean.getAddress();
			if (address != null) {
				existingHotelInformation.setAddress(address);
			}
			String contactNumber = hotelBean.getContactNumber();
			if (contactNumber != null) {
				existingHotelInformation.setContactNumber(contactNumber);
			}
			String imgUrl = hotelBean.getImgUrl();
			if (imgUrl != null) {
				existingHotelInformation.setImgUrl(imgUrl);
			}

		}
		try {
			transaction.begin();
			entityManager.persist(existingHotelInformation);
			transaction.commit();
			isUpdated = true;
		} catch (Exception e) {
			throw new HotelManagementSystemException("Hotel information can't be updated");
		}
		entityManager.close();
		return isUpdated;
	}

	@Override
	public boolean deleteHotelInformation(int hotelId) {
		boolean isDeleted = false;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		String jpql = "delete from HotelInformationBean where hotelId = : hotelId";
		try {
			Query query = entityManager.createQuery(jpql);
			query.setParameter("hotelId", hotelId);
			transaction.begin();
			int result = query.executeUpdate();
			transaction.commit();
			if (result > 0) {
				isDeleted = true;
			} else {
				isDeleted = false;
			}
		} catch (Exception e) {
			throw new HotelManagementSystemException("Hotel can't be deleted");
		}
		return isDeleted;
	}

	@Override
	public boolean licenseNumberPresent(String licenseNumber) {
		boolean isPresent = false;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from HotelInformationBean";
		try {
			Query query = entityManager.createQuery(jpql);
			List<HotelInformationBean> hotelList = query.getResultList();
			for (HotelInformationBean hotelbean : hotelList) {
				if (hotelbean.getLicenseNumber().equals(licenseNumber)) {
					System.out.println("Hotel license already present");
					isPresent = true;
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new HotelManagementSystemException("...........");
		}
		return isPresent;
	}

	@Override
	public RoomInformationBean addRoom(RoomInformationBean roomBean) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		String jpql = "from HotelInformationBean where licenseNumber =: hotelLicense";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("hotelLicense", roomBean.getHotelLicense());
		HotelInformationBean hotelInformation = (HotelInformationBean) query.getSingleResult();
		roomBean.setHotelId(hotelInformation.getHotelId());
		try {
			transaction.begin();
			entityManager.persist(roomBean);
			transaction.commit();
		} catch (Exception e) {
			throw new HotelManagementSystemException("Room can't be added");
		}
		return roomBean;
	}

	@Override
	public boolean deleteRoomInformation(int roomId) {
		boolean isDeleted = false;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		String jpql = "delete from RoomInformationBean where roomId =: roomId";
		try {
			Query query = entityManager.createQuery(jpql);
			query.setParameter("roomId", roomId);
			transaction.begin();
			int result = query.executeUpdate();
			if (result > 0) {
				transaction.commit();
				isDeleted = true;
			}
		} catch (Exception e) {
			throw new HotelManagementSystemException("Hotel id not found");
		}
		return isDeleted;
	}

	@Override
	public List<RoomInformationBean> getRoomList() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from RoomInformationBean";
		List<RoomInformationBean> roomList = null;
		try {
			Query query = entityManager.createQuery(jpql);
			roomList = query.getResultList();
		} catch (Exception e) {
			throw new HotelManagementSystemException("Room list not found");
		}
		return roomList;

	}

	@Override
	public boolean updateRoomInformation(RoomInformationBean roomBean) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		RoomInformationBean existingRoomInformation = entityManager.find(RoomInformationBean.class,
				roomBean.getHotelId());
		boolean isUpdated = false;
		if (existingRoomInformation != null) {
			String name = roomBean.getHotelName();
			if (name != null) {
				existingRoomInformation.setHotelName(name);
			}
			String licenseNumber = roomBean.getHotelLicense();
			if (licenseNumberPresent(licenseNumber) == false) {
				if (licenseNumber != null) {
					existingRoomInformation.setHotelLicense(licenseNumber);
				}
			}
			int roomCount = roomBean.getRoomCount();
			if (roomCount != 0) {
				existingRoomInformation.setRoomCount(roomCount);
			}
			String roomType = roomBean.getRoomType();
			if (roomType != null) {
				existingRoomInformation.setRoomType(roomType);
			}
			String roomCapacity = roomBean.getRoomCapacity();
			if (roomCapacity != null) {
				existingRoomInformation.setRoomCapacity(roomCapacity);
			}
			int amount = roomBean.getAmount();
			if (amount != 0) {
				existingRoomInformation.setAmount(amount);
			}
			String status = roomBean.getStatus();
			if (status != null) {
				existingRoomInformation.setStatus(status);
			}
			try {
				transaction.begin();
				entityManager.persist(existingRoomInformation);
				transaction.commit();
				isUpdated = true;
			} catch (Exception e) {
				throw new HotelManagementSystemException("Room information can't be updated");
			}
			entityManager.close();
		}
		return isUpdated;
	}

	@Override
	public EmployeeInformationBean addEmployee(EmployeeInformationBean employeeBean) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		String jpql = "from HotelInformationBean where licenseNumber =: licenseNumber";
		Query query = entityManager.createQuery(jpql);
		HotelInformationBean hotelInformation = (HotelInformationBean) query.getSingleResult();
		employeeBean.setHotelId(hotelInformation.getHotelId());
		try {
			transaction.begin();
			entityManager.persist(employeeBean);
			transaction.commit();
		} catch (Exception e) {
			throw new HotelManagementSystemException("Employee already exists");
		}
		AdminEmployeeUserBean employeeInformation = new AdminEmployeeUserBean();
		employeeInformation.setEmail(employeeBean.getEmail());
		employeeInformation.setName(employeeBean.getName());
		employeeInformation.setPassword(employeeBean.getPassword());
		employeeInformation.setType("employee");
		try {
			transaction.begin();
			entityManager.persist(employeeInformation);
			transaction.commit();
		} catch (Exception e) {
			throw new HotelManagementSystemException("Employee can't be added");
		}
		return employeeBean;
	}

	@Override
	public List<EmployeeInformationBean> getEmployeeList() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from EmployeeInformationBean";
		Query query = entityManager.createQuery(jpql);
		List<EmployeeInformationBean> employeeList = null;
		try {
			employeeList = query.getResultList();
		} catch (Exception e) {
			throw new HotelManagementSystemException("Employee list not found");
		}
		return employeeList;
	}

	@Override
	public boolean deleteEmployeeInformation(int employeeId) {
		boolean isDeleted = false;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		String jpql = "delete from EmployeeInformationBean where employeeId = : employeeId";
		try {
			Query query = entityManager.createQuery(jpql);
			query.setParameter("employeeId", employeeId);
			transaction.begin();
			int result = query.executeUpdate();
			transaction.commit();
			if (result > 0) {
				isDeleted = true;
			} else {
				isDeleted = false;
			}
		} catch (Exception e) {
			throw new HotelManagementSystemException("Employee can't be deleted");
		}
		return isDeleted;
	}

	@Override
	public boolean updateEmployeeInformation(EmployeeInformationBean employeeBean) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		EmployeeInformationBean existingEmployeeInformation = entityManager.find(EmployeeInformationBean.class,
				employeeBean.getEmployeeId());
		boolean isUpdated = false;
		if (existingEmployeeInformation != null) {
			String name = employeeBean.getHotelName();
			if (name != null) {
				existingEmployeeInformation.setHotelName(name);
			}
			String licenseNumber = employeeBean.getHotelLicense();
			if (licenseNumberPresent(licenseNumber) == false) {
				if (licenseNumber != null) {
					existingEmployeeInformation.setHotelLicense(licenseNumber);
				}
			}
			String email = employeeBean.getEmail();
			if (email != null) {
				existingEmployeeInformation.setEmail(email);
			}
			String password = employeeBean.getPassword();
			if (password != null) {
				existingEmployeeInformation.setPassword(password);
			}
			String employeeName = employeeBean.getName();
			if(employeeName != null) {
				existingEmployeeInformation.setName(name);
			}
		}
		try {
			transaction.begin();
			entityManager.persist(existingEmployeeInformation);
			transaction.commit();
			isUpdated = true;
		} catch (Exception e) {
			throw new HotelManagementSystemException("Employee information can't be updated");
		}
		entityManager.close();
		return isUpdated;
	}
}