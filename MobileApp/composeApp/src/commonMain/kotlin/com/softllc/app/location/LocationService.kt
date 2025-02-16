package com.softllc.location

import kotlinx.coroutines.flow.Flow

interface LocationService {
    fun requestLocationUpdates(): Flow<LocationLatLng?>
    fun requestCurrentLocation(): Flow<LocationLatLng?>
}