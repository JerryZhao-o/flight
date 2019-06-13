package com.software.Dao;

import com.software.Domain.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight,String> {

    @Query(nativeQuery = true, value = "SELECT * FROM Flight WHERE Flight.source =:source AND Flight.destination =:destination " +
            "AND Flight.departuredate =:departuredate")
    List<Flight> findBySourceAndDestinationAndDeparturedate(String source, String destination, String departuredate);



    @Query(nativeQuery = true, value = "SELECT * FROM Flight WHERE Flight.source =:source AND Flight.destination =:destination " +
            "AND Flight.departuredate =:departuredate AND Flight.companyid =:companyid")
    List<Flight> findALLBySourceAndDestinationAndDeparturedateAndCompanyid(String source, String destination, String departuredate, Integer companyid);




    @Query(nativeQuery = true, value = "SELECT * FROM Flight WHERE Flight.companyid =:companyid")
    List<Flight> findFlightByCompanyid(Integer companyid);



//    @Query("SELECT U.* FROM AUTH_USER U ,AUTH_ROLE_USER RU WHERE U.id = RU.user_id AND RU.role_id = :roleId")
//    List<Flight> findFlightBy(@Param("roleId") Long roleId);


//    //找到该用户已训练后的图片
//    @Query(nativeQuery =true,value = "select * from trainpic where trainpicid in " +
//            "(select t.trainpicid from train,trainpic t,uuser where train.userid=uuser.userid " +
//            "and train.trainpicid=t.trainpicid and train.userid=:id)")
//    List<Trainpic> findtrainedpic(Integer id);
}
