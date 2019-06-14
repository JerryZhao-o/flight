package com.software.Dao;

import com.software.Domain.Flight;
import com.software.Domain.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat,Integer>{

//    @Query("SELECT U.* FROM Flight , WHERE U.id = RU.user_id AND RU.role_id = :roleId")
//    List<Seat> findFlightBy(@Param("roleId") Long roleId);


    @Query(nativeQuery =true,value = "select * from seat where flightid in "+
            "(select flightid from flight where companyid =:companyid)" )
    List<Seat> findSeatByCompanyid(Integer companyid);

    @Query(nativeQuery =true,value = "select * from seat where flightid in "+
            "(select flightid from flight where companyid =:companyid) AND seatlevel = '头等舱'" )
    List<Seat> findSeat1ByCompanyid(Integer companyid);

    @Query(nativeQuery =true,value = "select * from seat where flightid in "+
            "(select flightid from flight where companyid =:companyid) AND seatlevel = '普通舱'" )
    List<Seat> findSeat2ByCompanyid(Integer companyid);

    @Query(nativeQuery =true,value = "select * from seat where flightid in "+
            "(select flightid from flight where companyid =:companyid) AND seatlevel = '经济舱'" )
    List<Seat> findSeat3ByCompanyid(Integer companyid);


    @Query(nativeQuery =true,value = "select * from seat where flightid =:flightid and seatlevel =:seatlevel and isempty = 'true'")
    List<Seat> findSeatByFlightidAndSeatlevel(String flightid, String seatlevel);


}
