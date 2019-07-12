package com.taxi.dao;

import java.util.List;

import com.taxi.model.Riders;

public interface RidersDAO {
 List<Riders> getAllRiders();
 Riders getRider(Long id);
 void saveRider(Riders rider);
 void updateRider(Riders rider);
 void deleteRider(Riders rider);
}
